package leagueutils.lol.game;

public enum GameMap {
	CustomGame {
		@Override
		public String toString()
		{
			return "Custom Game";
		}
	},
	HowlingAbyss { 
		@Override
		public String toString()
		{
			return "Howling Abyss";
		}
	},
	SummonersRift {
		@Override
		public String toString()
		{
			return "Summoner's Rift";
		}		
	},
	TwistedTreeline {
		@Override
		public String toString()
		{
			return "Twisted Treeline";
		}
	},
	ButchersBridge {
		@Override
		public String toString()
		{
			return "Butcher's Bridge";
		}
	},
	CrystalScar {
		@Override
		public String toString()
		{
			return "Crystal Scar";
		}
	},
	CosmicRuins {
		@Override
		public String toString()
		{
			return "Cosmic Ruins";
		}
	},
	ValoranCityPark {
		@Override
		public String toString()
		{
			return "Valoran City Park";
		}
	},
	Overcharge,
	CrashSite {
		@Override
		public String toString()
		{
			return "Crash Site";
		}
	},
	Convergence,
	NexusBlitz{
		@Override
		public String toString()
		{
			return "Nexus Blitz";
		}
	}
}
