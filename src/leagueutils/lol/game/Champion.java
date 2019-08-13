package leagueutils.lol.game;

import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class Champion {
	//private Image championIcon;
	private long championId;
	private String name;
	private String alias;
	private String[] roles;
	
	public static final String prefix = "--champ";
	public static final String separator = ";.-.;";
	
	private static final String baseChampionIconURL = "https://raw.communitydragon.org/latest/plugins/rcp-be-lol-game-data/global/default/v1/champion-icons";
	
	public Champion (String championName, long championId, String alias, String[] roles)
	{
		this.name = championName;
		this.championId = championId;
		this.alias = alias;
		this.roles = roles;
	}
	
	public Image getIcon() throws MalformedURLException, IOException
	{
		String retIconLocation = baseChampionIconURL + "/" + this.getId() + ".png";
		Image img = ImageIO.read(new URL(retIconLocation));
		return img;
	}
	
	public long getId()
	{
		return championId;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getAlias()
	{
		return alias;
	}
	
	public String[] getRoles()
	{
		return roles;
	}
	@Override
	public String toString()
	{
		return "Champion: " + name + " | ID: " + championId + " |  Roles: " + Arrays.toString(roles);
	}
	
	public String toSaveState()
	{
		return this.getName() + separator + this.getAlias() + separator + this.getId() + separator + Arrays.toString(this.getRoles());
	}
}
