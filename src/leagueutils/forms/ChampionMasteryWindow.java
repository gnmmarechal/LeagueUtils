package leagueutils.forms;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import external.ImageImplement;
import leagueutils.lol.game.Champion;
import leagueutils.lol.game.ChampionMastery;
import leagueutils.lol.game.Summoner;
import leagueutils.riotgamesapi.ChampionManager;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class ChampionMasteryWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7766181428895467469L;
	
	private JLabel summonerNameLabel;
	
	public ChampionMasteryWindow(Summoner s, ChampionManager champManager) throws MalformedURLException, IOException
	{
		super();
		this.setIconImage(s.getIcon());
		this.setTitle(s.getName());
		this.setLayout(new BorderLayout());
		this.summonerNameLabel = new JLabel("Summoner: " + s.getName() + " | Level " + s.getLevel() + " | Region: " + s.getRegion());
		JPanel panel = new JPanel();
		panel.setMinimumSize(new Dimension(500,100));
		panel.add(summonerNameLabel);
		this.add(panel, BorderLayout.NORTH);
		JPanel secondaryPanel = new JPanel();
		secondaryPanel.setLayout(new FlowLayout());
		List<ChampionMastery> orderedMasteryList = new ArrayList<ChampionMastery>();
	
		for (Champion c : champManager.getChampionList())
		{
			ChampionMastery cMastery = s.getMastery().stream().filter(champMastery -> champMastery.getChampionId() == c.getId()).findFirst().orElse(null);
			
			
			if (cMastery != null && cMastery.getChampionLevel() == 7)
			{
				orderedMasteryList.add(cMastery);
			}
			
			
		}
		
		orderedMasteryList.sort((o1, o2) -> Integer.valueOf(o2.getChampionPoints()).compareTo(Integer.valueOf(o1.getChampionPoints())));
		for (ChampionMastery cMastery : orderedMasteryList)
		{
			Champion c = champManager.getChampionList().stream().filter(champ -> champ.getId() == cMastery.getChampionId()).findFirst().orElse(null);
			System.out.println("[" + Thread.currentThread().getName() + "] :" + c);
			ImageImplement champIconPanel = new ImageImplement(c.getIcon());
			JPanel masteryPanel = new JPanel();
			
			masteryPanel.add(champIconPanel, BorderLayout.WEST);
			masteryPanel.add(new JLabel("Points: " + cMastery.getChampionPoints()), BorderLayout.EAST);
			secondaryPanel.add(masteryPanel);
		}
		this.add(secondaryPanel);
	
		this.setMinimumSize(panel.getMinimumSize());
		this.getContentPane().setPreferredSize(new Dimension(500, 300));
		this.pack();
		
		
	}

}
