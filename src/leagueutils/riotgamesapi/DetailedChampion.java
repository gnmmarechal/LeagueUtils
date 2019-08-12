package leagueutils.riotgamesapi;

import java.util.Arrays;

public class DetailedChampion extends Champion{
	
	private String title, shortBio;
	
	public static final String prefix = "--detChamp";
	
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
	
	public String getTitle()
	{
		return title;
	}
	
	public String getShortBio()
	{
		return shortBio;
	}
	
	@Override
	public String toString()
	{
		return "Champion: " + this.getName() + ", " + this.title + " | ID: " + this.getId() + " |  Roles: " + Arrays.toString(this.getRoles());
	}
	
	@Override
	public String toSaveState()
	{
		return prefix + this.getName() + separator + this.getAlias() + separator + this.getId() + separator + Arrays.toString(this.getRoles()) + separator + this.getTitle() + separator + this.getShortBio();
	}

}
