package leagueutils;

import java.awt.Dimension;
import java.awt.Image;
import java.util.List;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.JFrame;


import external.ImageImplement;
import leagueutils.forms.ChampionMasteryWindow;
import leagueutils.riotgamesapi.Champion;
import leagueutils.riotgamesapi.ChampionMastery;
import leagueutils.riotgamesapi.DetailedChampion;
import leagueutils.riotgamesapi.RiotGamesAPIManager;
import leagueutils.riotgamesapi.Summoner;

public class Main {
	
	private static RiotGamesAPIManager rgapi;
	
	public static void main(String[] args) throws MalformedURLException, IOException
	{
        /*String requestURL = "gnmpolicemata?api_key=RGAPI-7fb62940-abc6-4abe-97a7-e6ceed12b59e";
        try {
            HttpUtility.sendGetRequest(requestURL);
            String[] response = HttpUtility.readMultipleLinesRespone();
            System.out.println("Response Size: " + response.length);
            for (String line : response) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        HttpUtility.disconnect();*/
		
		/*RiotGamesAPIManager r = new RiotGamesAPIManager(Constants.apiKey);
		
		Summoner test = r.getSummoner("Oh Blyat");
		//Champion pyke = new Champion("Pyke", 555L);
		List<ChampionMastery> testA = r.getMasteryData(test);
		test.setMastery(testA, r.getMasteryScore(test));
		r.updateChampionInfo();
		r.updateChampionInfoDetailed();
		Champion aa = r.getNetworkChampionInfoDetailed(555);
		System.out.println("DetailedChamp Count: " + r.getChampionManagerInstance().getDetailedChampionCount());
		System.out.println("Champion is DetailedChamp: " + (aa instanceof DetailedChampion));
		System.out.println("CHAMP : " + (DetailedChampion) aa);
		System.out.println("Mastery Score: " + test.getMasteryScore());*/
		
		/*for (ChampionMastery mast : testA)
		{
			System.out.println("Champion: " + mast.getChampionId() + " | Points: " + mast.getChampionPoints());
		}*/
		
		/*if (test != null)
		{
			System.out.println("Icon ID: " + test.getIconId());
			Image icon = test.getIcon();
			ImageImplement a = new ImageImplement(icon);
			JFrame f = new JFrame("RG API: Region: " + test.getRegion() + " | " + test.getName() + " | Level: " + test.getLevel());
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.add(a);
			f.getContentPane().setPreferredSize(new Dimension(a.getHeight(), a.getWidth()));
			f.pack();
			//f.setSize(500,500);
			f.setVisible(true);	
		}*/
		
		rgapi = new RiotGamesAPIManager(Constants.apiKey);
		rgapi.updateChampionInfo();
		Summoner s = rgapi.getSummoner("gnmpolicemata");
		s = new Summoner(s, rgapi.getMasteryData(s), rgapi.getMasteryScore(s));
		System.out.println(s.getName());
		ChampionMasteryWindow masteryWindow = new ChampionMasteryWindow(s, rgapi.getChampionManagerInstance());
		masteryWindow.setVisible(true);
		
		
		

	}
}
