package leagueutils.lol.game;

public enum Position {
	MIDDLE {
		@Override
		public String toString()
		{
			return "Middle";
		}
	},
	TOP {
		@Override
		public String toString()
		{
			return "Top";
		}
	},
	JUNGLE {
		@Override
		public String toString()
		{
			return "Jungle";
		}
	},
	BOTTOM {
		@Override
		public String toString()
		{
			return "Bottom";
		}
	},
	UTILITY {
		@Override
		public String toString()
		{
			return "Support";
		}
	},
	NONE {
		@Override
		public String toString()
		{
			return "None";
		}
	}

}
