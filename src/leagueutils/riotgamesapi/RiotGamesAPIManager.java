package leagueutils.riotgamesapi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import external.HttpUtility;


public class RiotGamesAPIManager {
	private String apiKey;
	private APIRegion defaultRequestRegion;
	private ChampionManager championManager;
	
	private static final String summonerNameRegex = "^[0-9\\\\p{L} _\\\\.]+$";
	
	private static final String basicChampionInfoLocation = "https://raw.communitydragon.org/latest/plugins/rcp-be-lol-game-data/global/default/v1/champion-summary.json";
	private static final String detailedChampionInfoLocation = "https://raw.communitydragon.org/latest/plugins/rcp-be-lol-game-data/global/default/v1/champions";
	
	public RiotGamesAPIManager(String apiKey)
	{
		this(apiKey, APIRegion.EUW1);
	}
	
	public RiotGamesAPIManager(String apiKey, APIRegion defaultRegion)
	{
		this.apiKey = apiKey;
		this.defaultRequestRegion = defaultRegion;
		this.championManager = new ChampionManager();
	}
	
	public static String getAPIBaseURL(APIRegion region)
	{
		String ret = "";
		
		switch(region)
		{
		
		case BR1:
			ret = "https://br1.api.riotgames.com";
			break;
		case EUN1:
			ret = "https://eun1.api.riotgames.com";
			break;
		case EUW1:
			ret = "https://euw1.api.riotgames.com";
			break;
		case JP1:
			ret = "https://jp1.api.riotgames.com";
			break;
		case KR:
			ret = "https://kr.api.riotgames.com";
			break;
		case LA1:
			ret = "https://la1.api.riotgames.com";
			break;
		case LA2:
			ret = "https://la2.api.riotgames.com";
			break;	
		case NA1:
			ret = "https://na1.api.riotgames.com";
			break;
		case OC1:
			ret = "https://oc1.api.riotgames.com";
			break;
		case TR1:
			ret = "https://tr1.api.riotgames.com";
			break;
		case RU:
			ret = "https://ru.api.riotgames.com";
			break;
		case PBE1:
			ret = "https://pbe1.api.riotgames.com";
			break;
		}
		return ret;
	}
	
	public Summoner getSummoner(String username)
	{
		
		return this.getSummoner(username, defaultRequestRegion);
	}
	
	public Summoner getSummoner(String username, APIRegion region)
	{
		username = username.replace(" ", "%20");
		int iconId = 0;
		String sumName = "";
		long level = 0;
		String puuid = "";
		String id = "";
		String accountId = "";
		long revisionDate = 0;
		if (username.matches(summonerNameRegex) || true) // The regex doesn't work
		{
			String jsonResponse = this.callURL(getAPIBaseURL(region) + "/lol/summoner/v4/summoners/by-name/" + username + "?api_key=" + apiKey);
			if (jsonResponse.equals("{}"))
				return null;
			//System.out.println("RESP: " + jsonResponse);
			
			JSONParser parser = new JSONParser();
			
			try
			{
				JSONObject obj = (JSONObject)parser.parse(jsonResponse);
				iconId = java.lang.Math.toIntExact((long)obj.get("profileIconId"));
				sumName = (String)obj.get("name");
				level = (long)obj.get("summonerLevel");
				puuid = (String)obj.get("puuid");
				id = (String)obj.get("id");
				accountId = (String)obj.get("accountId");
				revisionDate = (long)obj.get("revisionDate");
				
			}
			catch (Exception e)
			{

				
				/*try
				{
					JSONObject obj = (JSONObject)parser.parse(jsonResponse);
					if (((String)((JSONObject)obj.get("status")).get("status_code")).equals("403"))
					{
						System.out.println("HURRA");
					}
				}
				catch (Exception ex)
				{
					//ex.printStackTrace();
				}*/
				e.printStackTrace();
			}
			
			return new Summoner(iconId, sumName, puuid, id, accountId, level, revisionDate, region);
			
		}
		else
			System.out.println("Username not valid");
		
		return null;
	}

	public List<ChampionMastery> getMasteryData(Summoner summ)
	{
		return getMasteryData(summ.getId(), summ.getRegion());
	}
	
	public List<ChampionMastery> getMasteryData(String summonerId, APIRegion region)
	{
		List<ChampionMastery> retList = new ArrayList<ChampionMastery>();
		String jsonResponse = this.callURL(getAPIBaseURL(region) + "/lol/champion-mastery/v4/champion-masteries/by-summoner/" + summonerId + "?api_key=" + apiKey);
		
		JSONParser parser = new JSONParser();
		
		try
		{
			JSONArray jArray = (JSONArray) parser.parse(jsonResponse);
			for (Object o : jArray)
			{
				JSONObject obj = (JSONObject) o;
				ChampionMastery m = new ChampionMastery((boolean)obj.get("chestGranted"), 
						java.lang.Math.toIntExact((long)obj.get("championLevel")), java.lang.Math.toIntExact((long)obj.get("championPoints")),
						(long)obj.get("championId"), (long)obj.get("championPointsUntilNextLevel"), (long)obj.get("lastPlayTime"), 
						java.lang.Math.toIntExact((long)obj.get("tokensEarned")), (long)obj.get("championPointsSinceLastLevel"), (String)obj.get("summonerId"));
				retList.add(m);
			}
		}
		catch (Exception e)
		{
			//e.printStackTrace();
		}
		
		return retList;
	}
	private String callURL(String url)
	{
		String[] response = {};
        try {
            HttpUtility.sendGetRequest(url);
            response = HttpUtility.readMultipleLinesResponse();
            // System.out.println("Response Size: " + response.length);
        } catch (IOException ex) {
            ex.printStackTrace();
        	System.err.println("Error calling URL.");
        	return "{}";
        }
        
        HttpUtility.disconnect();
        
        return response[0];
        
        
	}

	public int getMasteryScore(Summoner summoner) {
		
		return getMasteryScore(summoner.getId(), summoner.getRegion());
	}

	public int getMasteryScore(String summonerId, APIRegion region) {
		String response = this.callURL(getAPIBaseURL(region) + "/lol/champion-mastery/v4/scores/by-summoner/" + summonerId + "?api_key=" + apiKey);
		int ret = 0;
		try
		{
			ret = Integer.valueOf(response);
		}
		catch (Exception e)
		{
		}
		return ret;
	}
	
	
	public boolean updateChampionInfo()
	{
		String jsonResponse = this.callURL(basicChampionInfoLocation);
		championManager = new ChampionManager();
		JSONParser parser = new JSONParser();
		try
		{
			JSONArray jArray = (JSONArray) parser.parse(jsonResponse);
			for (Object o : jArray)
			{
				JSONObject obj = (JSONObject) o;
				JSONArray rolesJArray = (JSONArray) obj.get("roles");
				List<String> roles = new ArrayList<String>();
				
				for (Object item : rolesJArray)
				{
					roles.add((String) item);
				}
				
				String[] rolesArray = roles.toArray(new String[roles.size()]);
				
				Champion c = new Champion((String)obj.get("name"), (long)obj.get("id"), (String)obj.get("alias"), rolesArray);
				if (c.getId() != -1 && !championManager.contains(c.getId()))
					championManager.addChampion(c);
			}
			//System.out.println("CHAMP COUNT: " + championManager.getChampionCount());
		}
		catch (Exception e)
		{
			//e.printStackTrace();
		}
		
		return true;
	}
	
	public boolean updateChampionInfoDetailed()
	{
		if (!this.updateChampionInfo()) return false;
		
		for (Champion c : this.championManager.getChampionList())
		{
			DetailedChampion newChamp = this.getNetworkChampionInfoDetailed(c.getId());
			championManager.removeChampion(c.getId());
			championManager.addChampion(newChamp);
		}
		return true;
		
	}
	public DetailedChampion getNetworkChampionInfoDetailed(long id) {
		
		String jsonResponse = this.callURL(detailedChampionInfoLocation + "/" + id + ".json");
		JSONParser parser = new JSONParser();
		try
		{
			JSONObject obj = (JSONObject) parser.parse(jsonResponse);
			List<String> roles = new ArrayList<String>();
			JSONArray rolesJArray = (JSONArray) obj.get("roles");
			
			for (Object item : rolesJArray)
			{
				roles.add((String) item);
			}
			
			String[] rolesArray = roles.toArray(new String[roles.size()]);			
			DetailedChampion finalChamp = new DetailedChampion((String)obj.get("name"), (long)obj.get("id"), (String)obj.get("alias"), rolesArray, (String)obj.get("title"), (String)obj.get("shortBio"));
			return finalChamp;
		}
		catch (Exception e)
		{
			
		}
		return null;
	}

	public Champion getChampionInfoFromId(long championId)
	{
		return championManager.getChampion(championId);
	}
	
	public DetailedChampion getDetailedChampionInfoFromId(long championId)
	{
		if (championManager.contains(championId))
		{
			if (championManager.getChampion(championId) instanceof DetailedChampion)
			{
				return (DetailedChampion) championManager.getChampion(championId);
			}
			else
			{
				// Try to add it to the champion manager if it isn't Detailed
				DetailedChampion finalChamp = this.getNetworkChampionInfoDetailed(championId);
				championManager.removeChampion(championId);
				championManager.addChampion(finalChamp);
				return finalChamp;
			}
		}
		return null;
	}
	
	public ChampionManager getChampionManagerInstance()
	{
		return championManager;
	}
}
