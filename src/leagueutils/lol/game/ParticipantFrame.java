package leagueutils.lol.game;


public class ParticipantFrame {
	private int totalGold, teamScore, participantId, level, currentGold, minionsKilled, dominionScore, xp, jungleMinionsKilled;
	private int[] position = new int[2];
	
	public ParticipantFrame(int totalGold, int teamScore, int participantId, int level, int currentGold, int minionsKilled, int dominionScore, int xp, int jungleMinionsKilled, int[] position)
	{
		this.totalGold = totalGold;
		this.teamScore = teamScore;
		this.participantId = participantId;
		this.level = level;
		this.currentGold = currentGold;
		this.minionsKilled = minionsKilled;
		this.dominionScore = dominionScore;
		this.xp = xp;
		this.jungleMinionsKilled = jungleMinionsKilled;
		
		if (position.length != 2)
			this.position = new int[]{ -1, -1 };
		
		this.position = position;
	}
	
	public int getTotalGold()
	{
		return this.totalGold;
	}
	
	public int getTeamScore()
	{
		return this.teamScore;
	}
	
	public int getParticipantId()
	{
		return this.participantId;
	}
	
	public int getLevel()
	{
		return this.level;
	}
	
	public int getCurrentGold()
	{
		return this.currentGold;
	}
	
	public int getMinionsKilled()
	{
		return this.minionsKilled;
	}
	
	public int getJungleMinionsKilled()
	{
		return this.jungleMinionsKilled;
	}
	public int getDominionScore()
	{
		return this.dominionScore;
	}
	
	public int getXp()
	{
		return this.xp;
	}
	
	public int[] getPosition()
	{
		return this.position;
	}
}
