package leagueutils.riotgamesapi;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import leagueutils.lol.game.Champion;
import leagueutils.lol.game.DetailedChampion;

public class ChampionManager {
	private Map<Long, Champion> championMap;
	
	public ChampionManager()
	{
		championMap = new HashMap<Long, Champion>();
	}
	
	public boolean addChampion(Champion c)
	{
		if (championMap.containsKey(c.getId()))
		{
			return false;
		}
		else
		{
			championMap.put(c.getId(), c);
		}
		
		return true;
	}
	
	
	public boolean removeChampion(Champion c)
	{
		return this.removeChampion(c.getId());
	}
	
	public boolean removeChampion(long championId)
	{
		if (championMap.containsKey(championId))
		{
			championMap.remove(championId);
			return true;
		}
		
		return false;
	}
	
	public Champion getChampion(long championId)
	{
		return this.getChampionMap().get(championId);
	}
	
	public boolean contains(long championId)
	{
		return this.getChampionMap().containsKey(championId);
	}
	
	public boolean contains(Champion c)
	{
		return this.getChampionMap().containsValue(c);
	}
	
	private Map<Long, Champion> getChampionMap()
	{
		return championMap;
	}
	
	public List<Champion> getChampionList()
	{
		List<Champion> champList = new ArrayList<Champion>();
		for (Long key : this.getChampionMap().keySet())
		{
			champList.add(this.getChampionMap().get(key));
		}
		
		return champList;
	}
	
	public static boolean isDetailedChampion(Champion c)
	{
		try
		{
			DetailedChampion e = (DetailedChampion) c;
			return true;
		}
		catch (Exception ex)
		{
			
		}
		return false;
	}
	public int getDetailedChampionCount()
	{
		int i = 0;
		//System.out.println("Champ count: " + this.getChampionCount());
		for (Champion c : this.getChampionList())
		{
			if (isDetailedChampion(c))
				++i;
		}
		return i;
	}
	
	public int getChampionCount()
	{
		return this.getChampionMap().keySet().size();
	}

	public String getSaveState() {
		String finalRet = "";
		for (Champion c : this.getChampionList())
		{
			if (isDetailedChampion(c))
			{
				finalRet += ((DetailedChampion) c).toSaveState(); // this may be unnecessary because the object overrides the method
			}
			else
			{
				finalRet += c.toSaveState();
			}
		}
		return finalRet;
	}
}
