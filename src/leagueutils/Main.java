package leagueutils;

import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.jtattoo.plaf.noire.NoireLookAndFeel;

import external.ImageImplement;
import leagueutils.forms.ChampionMasteryWindow;
import leagueutils.lol.game.Champion;
import leagueutils.lol.game.ChampionMastery;
import leagueutils.lol.game.DetailedChampion;
import leagueutils.lol.game.GameMap;
import leagueutils.lol.game.Summoner;
import leagueutils.riotgamesapi.RiotGamesAPIManager;
import leagueutils.riotgamesapi.SummonerMatch;

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
		
		//System.out.println(Constants.apiKey);
		rgapi = new RiotGamesAPIManager(Constants.apiKey);
		//rgapi.updateChampionInfo();
		rgapi.updateChampionInfoDetailed();
		//rgapi.saveState("testcfg.cfg");
		Summoner testSum = rgapi.getSummoner("gnmpolicemata");
		testSum.addMatches(rgapi.getRecentMatchHistory(rgapi.getSummoner("gnmpolicemata")));
		
		for (SummonerMatch match : testSum.getMatchList())
		{
			if (match.getMap() == GameMap.SummonersRift)
				System.out.println(match + " | " + rgapi.getChampionInfoFromId(match.getChampionId()));
		}
		(new Scanner(System.in)).nextLine();
		
		try {
			//UIManager.setLookAndFeel(new de.javasoft.synthetica.dark.SyntheticaDarkLookAndFeel());
			UIManager.setLookAndFeel(Constants.uiLookAndFeel);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		};
		
		List<Thread> threadList = new ArrayList<Thread>();
		String[] usernames = { "Alt F4444", "Zero F0X Given", "gnmpolicemata", "Ant Ma Desh", "GOD MARTINEX" };
		
		int i = 0;
		/*for (String u : usernames)
		{
			Thread a = new Thread(String.valueOf(++i)) {
				public void run()
				{
					Summoner s = rgapi.getSummoner(u);
					s = new Summoner(s, rgapi.getMasteryData(s), rgapi.getMasteryScore(s));
					System.out.println(s.getName());
					ChampionMasteryWindow masteryWindow = null;
					try {
						masteryWindow = new ChampionMasteryWindow(s, rgapi.getChampionManagerInstance());
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					masteryWindow.setVisible(true);
				}
			};
			threadList.add(a);
		}
		
		for (Thread t : threadList)
		{
			t.start();
		}*/

		
		
		

	}
}
