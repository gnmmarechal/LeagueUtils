package leagueutils.forms;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import external.ImageImplement;
import leagueutils.riotgamesapi.Champion;
import leagueutils.riotgamesapi.ChampionManager;
import leagueutils.riotgamesapi.ChampionMastery;
import leagueutils.riotgamesapi.Summoner;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;

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
		secondaryPanel.setLayout(new GridLayout(1,2));
		
	
		for (Champion c : champManager.getChampionList())
		{
			ChampionMastery cMastery = s.getMastery().stream().filter(champMastery -> champMastery.getChampionId() == c.getId()).findFirst().orElse(null);
			
			if (cMastery != null && cMastery.getChampionLevel() == 7)
			{
				System.out.println(c);
				ImageImplement champIconPanel = new ImageImplement(c.getIcon());
				JPanel masteryPanel = new JPanel();
				
				masteryPanel.add(champIconPanel, BorderLayout.WEST);
				masteryPanel.add(new JLabel("Points: " + cMastery.getChampionPoints()), BorderLayout.EAST);
				secondaryPanel.add(masteryPanel);
			}
			
			
		}
		this.add(secondaryPanel);
	
		this.setMinimumSize(panel.getMinimumSize());
		this.getContentPane().setPreferredSize(new Dimension(500, 300));
		this.pack();
		
		
	}

}
