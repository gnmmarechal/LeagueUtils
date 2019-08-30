package leagueutils.lol.game;

import java.util.List;
import java.util.Map;

public class MatchFrame {
	private long timestamp;
	private Map<String, ParticipantFrame> participantFrames;
	private List<MatchEvent> eventList;
	
	public MatchFrame(long timestamp, Map<String, ParticipantFrame> participantFrames, List<MatchEvent> eventList)
	{
		this.timestamp = timestamp;
		this.participantFrames = participantFrames;
		this.eventList = eventList;
	}
	
	public long getTimestamp()
	{
		return timestamp;
	}
	
	public Map<String, ParticipantFrame> getParticipantFrames()
	{
		return this.participantFrames;
	}
	
	public List<MatchEvent> getEventList()
	{
		return eventList;
	}
}
