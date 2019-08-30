package leagueutils;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.LookAndFeel;

public class Constants {
	
	public final static String apiKey = getApiKey("key.txt");
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

	
	public static String getApiKey(String fileName)
	{
		List<String> strList = null;
		try {
			strList = Files.readAllLines(Paths.get(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return strList.get(0);
	}
}
