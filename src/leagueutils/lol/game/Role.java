package leagueutils.lol.game;

public enum Role {
	DUO_SUPPORT {
		@Override
		public String toString()
		{
			return "Support";
		}
	}, DUO_CARRY {
		@Override
		public String toString()
		{
			return "Carry";
		}
	}, DUO {
		@Override
		public String toString()
		{
			return "Duo";
		}
	}, NONE {
		@Override
		public String toString()
		{
			return "None";
		}
	}, SOLO {
		@Override
		public String toString()
		{
			return "Solo";
		}
	}
}
