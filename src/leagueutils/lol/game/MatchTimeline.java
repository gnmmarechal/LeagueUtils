package leagueutils.lol.game;

import java.util.List;

public class MatchTimeline {
	private long frameInterval;
	private List<MatchFrame> frameList;
	
	public MatchTimeline(long frameInterval, List<MatchFrame> frameList)
	{
		this.frameInterval = frameInterval;
		this.frameList = frameList;
	}
	
	public long getFrameInterval()
	{
		return this.frameInterval;
	}
	
	public List<MatchFrame> getFrameList()
	{
		return this.frameList;
	}
	
}
