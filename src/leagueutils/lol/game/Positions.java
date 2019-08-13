package leagueutils.lol.game;

public class Positions {
	public static Position getPositionSimple(Role r, Lane l)
	{
		Position p = Position.NONE;
		
		if (r == Role.SOLO && l == Lane.MID)
		{
			p = Position.MIDDLE;
		}
		else if (r == Role.SOLO && l == Lane.TOP)
		{
			p = Position.TOP;
		}
		else if (r == Role.NONE && l == Lane.JUNGLE)
		{
			p = Position.JUNGLE;
		}
		else if (r == Role.DUO_CARRY && l == Lane.BOTTOM)
		{
			p = Position.BOTTOM;
		}
		else if (r == Role.DUO_SUPPORT && l == Lane.BOTTOM)
		{
			p = Position.UTILITY;
		}
		return p;
	}
}
