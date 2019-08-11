package leagueutils.riotgamesapi;

public class ChampionMastery {
	
	private boolean chestGranted;
	private int championLevel, championPoints, tokensEarned;
	private String summonerId;
	private long championId, championPointsUntilNextLevel, championPointsSinceLastLevel, lastPlayTime;
	
	public ChampionMastery(boolean chestGranted, int championLevel, int championPoints, long championId, long championPointsUntilNextLevel, long lastPlayTime, int tokensEarned, long championPointsSinceLastLevel, String summonerId)
	{
		this.chestGranted = chestGranted;
		this.championLevel = championLevel;
		this.championPoints = championPoints;
		this.championId = championId;
		this.championPointsUntilNextLevel = championPointsUntilNextLevel;
		this.championPointsSinceLastLevel = championPointsSinceLastLevel;
		this.lastPlayTime = lastPlayTime;
		this.tokensEarned = tokensEarned;
		this.summonerId = summonerId;
	}

	public boolean isChestGranted() {
		return chestGranted;
	}

	public int getChampionLevel() {
		return championLevel;
	}

	public int getChampionPoints() {
		return championPoints;
	}

	public int getTokensEarned() {
		return tokensEarned;
	}

	public String getSummonerId() {
		return summonerId;
	}

	public long getChampionId() {
		return championId;
	}

	public long getChampionPointsUntilNextLevel() {
		return championPointsUntilNextLevel;
	}

	public long getChampionPointsSinceLastLevel() {
		return championPointsSinceLastLevel;
	}

	public long getLastPlayTime() {
		return lastPlayTime;
	}
}
