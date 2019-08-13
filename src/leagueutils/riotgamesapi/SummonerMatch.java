package leagueutils.riotgamesapi;

import leagueutils.lol.game.GameMap;
import leagueutils.lol.game.Lane;
import leagueutils.lol.game.Position;
import leagueutils.lol.game.Positions;
import leagueutils.lol.game.QueueType;
import leagueutils.lol.game.Role;
import leagueutils.lol.platform.PlatformRegion;

public class SummonerMatch {
	private Lane lane;
	private Role role;
	private long gameId, timestamp, championId;
	private GameMap gameMap;
	private QueueType queue;
	private int season, queueId;
	private PlatformRegion region;
	
	public SummonerMatch(Lane lane, long gameId, long championId, PlatformRegion region, long timestamp, int queue, Role role, int season)
	{
		this.lane = lane;
		this.gameId = gameId;
		this.championId = championId;
		this.region = region;
		this.timestamp = timestamp;
		this.queue = getQueueFromId(queue);
		this.gameMap = getMapFromId(queue);
		this.queueId = queue;
		this.role = role;
		this.season = season;
	}
	
	public Lane getLane()
	{
		return lane;
	}
	
	public QueueType getQueue()
	{
		return queue;
	}
	
	public int getSeason()
	{
		return season;
	}
	
	public long getMatchId()
	{
		return gameId;
	}
	
	public int getQueueId()
	{
		return queueId;
	}
	public long getChampionId()
	{
		return championId;
	}
	
	public Role getRole()
	{
		return role;
	}
	
	public Position getPosition()
	{
		return Positions.getPositionSimple(this.getRole(), this.getLane());
	}
	public PlatformRegion getRegion()
	{
		return region;
	}
	
	public long getTimestamp()
	{
		return timestamp;
	}
	
	public GameMap getMap()
	{
		return gameMap;
	}
	public static GameMap getMapFromId(int queueId) // to-do: add the deprecated things
	{
		switch(queueId)
		{
		case 0:
			return GameMap.CustomGame;
		case 1090:
		case 1100:
			return GameMap.Convergence;
		case 1030:
		case 1040:
		case 1050:
		case 1060:
		case 1070:
			return GameMap.CrashSite;
		case 1000:
			return GameMap.Overcharge;
		case 980:
		case 990:
			return GameMap.ValoranCityPark;
		case 610:
			return GameMap.CosmicRuins;
		case 317:
		case 910:
			return GameMap.CrystalScar;
		case 100:
			return GameMap.ButchersBridge;
		case 98:
		case 460:
		case 470:
		case 800:
		case 810:
		case 820:
			return GameMap.TwistedTreeline;
		case 72:
		case 73:
		case 78:
		case 450:
		case 920:
			return GameMap.HowlingAbyss;
		case 75:
		case 76:
		case 83:
		case 310:
		case 313:
		case 325:
		case 400:
		case 420:
		case 430:
		case 440:
		case 600:
		case 700:
		case 830:
		case 840:
		case 850:
		case 900:
		case 940:
		case 950:
		case 960:
		case 1010:
		case 1020:
		default:
			return GameMap.SummonersRift; // Not necessarily correct
		}
	}
	public static QueueType getQueueFromId(int queueId)
	{
		switch(queueId)
		{
		case 0:
			return QueueType.CustomGame;
		case 72:
			return QueueType.SnowdownShowdown1v1;
		case 73:
			return QueueType.SnowdownShowdown2v2;
		case 98:
		case 75:
			return QueueType.Hexakill6v6;
		case 78:
			return QueueType.OneForAllMirrorMode;
		case 83:
			return QueueType.CoopVsAIUltraRapidFire;
		case 100:
		case 450:
			return QueueType.AllRandomAllMid5v5;
		case 310:
			return QueueType.Nemesis;
		case 313:
			return QueueType.BlackMarketBrawlers;
		case 317:
			return QueueType.DefinitelyNotDominion;
		case 325:
			return QueueType.AllRandom;
		case 400:
			return QueueType.DraftPick5v5;
		case 420:
			return QueueType.RankedSolo5v5;
		case 430:
			return QueueType.BlindPick5v5;
		case 440:
			return QueueType.RankedFlex5v5;
		case 460:
			return QueueType.BlindPick3v3;
		case 470:
			return QueueType.RankedFlex3v3;
		case 600:
			return QueueType.BloodHuntAssassin;
		case 610:
			return QueueType.DarkStarSingularity;
		case 700:
			return QueueType.Clash;
		case 800:
		case 850:
			return QueueType.CoopVsAIIntermediateBots;
		case 810:
		case 830:
			return QueueType.CoopVsAIIntroBots;
		case 820:
		case 840:
			return QueueType.CoopVsAIBeginnerBots;
		case 900:
			return QueueType.AllRandomUltraRapidFire;
		case 910:
			return QueueType.Ascension;
		case 920:
			return QueueType.LegendOfThePoroKing;
		case 940:
			return QueueType.NexusSiege;
		case 950:
			return QueueType.DoomBotsVoting;
		case 960:
			return QueueType.DoomBotsStandard;
		case 980:
			return QueueType.StarGuardianInvasionNormal;
		case 990:
			return QueueType.StarGuardianInvasionOnslaught;
		case 1000:
			return QueueType.PROJECTHunters;
		case 1010:
			return QueueType.SnowAllRandomUltraRapidFire;
		case 1020:
			return QueueType.OneForAll;
		case 1030:
			return QueueType.OdysseyExtractionIntro;
		case 1040:
			return QueueType.OdysseyExtractionCadet;
		case 1050:
			return QueueType.OdysseyExtractionCrewmember;
		case 1060:
			return QueueType.OdysseyExtractionCaptain;
		case 1070:
			return QueueType.OdysseyExtractionOnslaught;
		case 1090:
			return QueueType.TeamfightTactics;
		case 1100:
			return QueueType.RankedTeamfightTactics;
		default:
			return null;
		}
	}

	@Override
	public String toString()
	{
		return "MATCH: Map: " + this.getMap() + " | Queue: " + this.getQueue() + " | Position: " + this.getPosition() + " | Champion ID: " + this.getChampionId();
	}
}
