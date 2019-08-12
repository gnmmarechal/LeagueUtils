package leagueutils;

import javax.swing.LookAndFeel;

public class Constants {
	
	public final static String apiKey = "RGAPI-f2c8ec68-55ae-4652-8bc5-b93faae230ad";
	//public static LookAndFeel uiLookAndFeel = new com.jtattoo.plaf.noire.NoireLookAndFeel();
	public static LookAndFeel uiLookAndFeel = getSyntheticaDarkUiLookAndFeel();
	
	
	public static LookAndFeel getSyntheticaDarkUiLookAndFeel()
	{
		try 
		{
			
			return new de.javasoft.synthetica.dark.SyntheticaDarkLookAndFeel();
		} catch (Exception e)
		{
			
		}
		
		return new javax.swing.plaf.metal.MetalLookAndFeel();
	}

	
	
}
