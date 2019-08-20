package leagueutils.lol.game;

import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import leagueutils.lol.platform.PlatformRegion;
import leagueutils.riotgamesapi.SummonerMatch;

public class Summoner {
	private int iconId;
	private String name, puuid, id, accountId;
	private long level, revisionDate;
	private PlatformRegion region;
	private List<ChampionMastery> champMasteryData;
	private int masteryScore;
	private Image icon; // Maybe set it with the constructor?
	private Map<Long, SummonerMatch> sumMatches;
	private static final String baseSummonerIconURL = "https://raw.communitydragon.org/latest/plugins/rcp-be-lol-game-data/global/default/v1/profile-icons";

	public Summoner(int iconId, String name, String puuid, String id, String accountId, long level, long revisionDate, PlatformRegion region, List<ChampionMastery> champMasteryData, int masteryScore)
	{
		this(iconId, name, puuid, id, accountId, level, revisionDate, region);
		this.champMasteryData = champMasteryData;
		this.masteryScore = masteryScore;
	}
	
	public Summoner(Summoner s, List<ChampionMastery> champMasteryData, int masteryScore)
	{
		this(s.getIconId(), s.getName(), s.getPUUID(), s.getId(), s.getAccountId(), s.getLevel(), s.getRevisionDate(), s.getRegion(), champMasteryData, masteryScore);
	}
	public Summoner(int iconId, String name, String puuid, String id, String accountId, long level, long revisionDate, PlatformRegion region)
	{
		this.sumMatches = new HashMap<Long, SummonerMatch>();
		this.iconId = iconId;
		this.name = name;
		this.puuid = puuid;
		this.id = id;
		this.accountId = accountId;
		this.level = level;
		this.revisionDate = revisionDate;
		this.region = region;
		try
		{
			//this.icon = this.getIcon();
		}
		catch (Exception e)
		{
			
		}
	}
	
	public int getIconId()
	{
		return iconId;
	}
	
	public Image getIcon() throws MalformedURLException, IOException
	{	
		String fullUrl = baseSummonerIconURL + "/" + this.getIconId() + ".jpg";
		Image img = ImageIO.read(new URL(fullUrl));
		return img;
	}
	
	public String getName()
	{
		return name;
	}
	
	public PlatformRegion getRegion()
	{
		return this.region;
	}
	
	public String getPUUID()
	{
		return puuid;
	}
	
	public String getId()
	{
		return id;
	}
	
	public String getAccountId()
	{
		return accountId;
	}
	
	public long getLevel()
	{
		return level;
	}
	
	public long getRevisionDate()
	{
		return revisionDate;
	}
	
	public List<ChampionMastery> getMastery()
	{
		return champMasteryData;
	}
	
	public int getMasteryScore()
	{
		return masteryScore;
	}
	
	public void setMastery(List<ChampionMastery> champMasteryData, int masteryScore)
	{
		this.champMasteryData = champMasteryData;
		this.masteryScore = masteryScore;
	}
	
	public Map<Long, SummonerMatch> getMatches()
	{
		return sumMatches;
	}
	
	public void setMatches(Map<Long, SummonerMatch> sumMatches)
	{
		this.sumMatches = sumMatches;
	}
	
	public void addMatches(List<SummonerMatch> sumMatchList)
	{
		for (SummonerMatch sM : sumMatchList)
			this.addMatch(sM);
	}
	
	public void addMatch(SummonerMatch sM)
	{
		this.sumMatches.put(sM.getMatchId(), sM);
	}
	
	public List<SummonerMatch> getMatchList()
	{
		List<SummonerMatch> m = new ArrayList<SummonerMatch>();
		
		for (long key : this.sumMatches.keySet())
		{
			m.add(this.sumMatches.get(key));
		}
		m.sort((o1, o2) -> Long.valueOf(o2.getTimestamp()).compareTo(Long.valueOf(o1.getTimestamp())));
		return m;
	}
}
