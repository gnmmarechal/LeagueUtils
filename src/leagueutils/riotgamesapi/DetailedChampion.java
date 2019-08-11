package leagueutils.riotgamesapi;

import java.util.Arrays;

public class DetailedChampion extends Champion{
	
	String title, shortBio;
	public DetailedChampion(String championName, long championId, String alias, String[] roles, String title, String shortBio) {
		super(championName, championId, alias, roles);
		this.title = title;
		this.shortBio = shortBio;
		
	}
	
	public DetailedChampion(Champion c)
	{
		super (c.getName(), c.getId(), c.getAlias(), c.getRoles());
		this.title = ""; 
		this.shortBio = "";
	}
	
	@Override
	public String toString()
	{
		return "Champion: " + this.getName() + " " + this.title + " | ID: " + this.getId() + " |  Roles: " + Arrays.toString(this.getRoles());
	}

}
