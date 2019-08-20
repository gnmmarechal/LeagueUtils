package leagueutils;

import javax.swing.LookAndFeel;

public class Constants {
	
	public final static String apiKey = "RGAPI-6085fb61-3923-4f4b-ba11-a6dc89571676";
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
