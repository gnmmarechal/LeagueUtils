package leagueutils.lol.game;

public enum QueueType {
	SnowdownShowdown1v1 {
		@Override
		public String toString()
		{
			return "1v1 Snowdown Showdown";
		}
	},
	SnowdownShowdown2v2 {
		@Override
		public String toString()
		{
			return "2v2 Snowdown Showdown";
		}
	},
	Hexakill6v6 {
		@Override
		public String toString()
		{
			return "6v6 Hexakill";
		}
	},
	UltraRapidFire {
		@Override
		public String toString()
		{
			return "Ultra Rapid Fire";
		}
	},
	OneForAllMirrorMode {
		@Override
		public String toString()
		{
			return "One For All: Mirror Mode";
		}
	},
	CoopVsAIUltraRapidFire {
		@Override
		public String toString()
		{
			return "Co-op vs. AI Ultra Rapid Fire";
		}
	},
	AllRandomAllMid5v5 {
		@Override
		public String toString()
		{
			return "5v5 All Random All Mid";
		}
	},
	Nemesis,
	BlackMarketBrawlers {
		@Override
		public String toString()
		{
			return "Black Market Brawlers";
		}
	},
	DefinitelyNotDominion {
		@Override
		public String toString()
		{
			return "Definitely Not Dominion";
		}
	},
	AllRandom {
		@Override
		public String toString()
		{
			return "All Random";
		}
	},
	DraftPick5v5 {
		@Override
		public String toString()
		{
			return "5v5 Draft Pick";
		}
	},
	RankedSolo5v5 {
		@Override
		public String toString()
		{
			return "5v5 Ranked Solo";
		}
	},
	BlindPick5v5 {
		@Override
		public String toString()
		{
			return "5v5 Blind Pick";
		}
	},
	RankedFlex5v5 {
		@Override
		public String toString()
		{
			return "5v5 Ranked Flex";
		}
	},
	BlindPick3v3 {
		@Override
		public String toString()
		{
			return "3v3 Blind Pick";
		}
	},
	RankedFlex3v3 {
		@Override
		public String toString()
		{
			return "3v3 Ranked Flex";
		}
	},
	BloodHuntAssassin {
		@Override
		public String toString()
		{
			return "Blood Hunt Assassin";
		}
	},
	DarkStarSingularity {
		@Override
		public String toString()
		{
			return "Dark Star: Singularity";
		}
	},
	Clash,
	CoopVsAIIntermediateBots {
		@Override
		public String toString()
		{
			return "Co-op vs. AI Intermediate Bots";
		}
	},
	CoopVsAIIntroBots {
		@Override
		public String toString()
		{
			return "Co-op vs. AI Intro Bots";
		}
	},
	CoopVsAIBeginnerBots {
		@Override
		public String toString()
		{
			return "Co-op vs. AI Beginner Bots";
		}
	},
	AllRandomUltraRapidFire {
		@Override
		public String toString()
		{
			return "All Random Ultra Rapid Fire";
		}
	},
	Ascension,
	LegendOfThePoroKing {
		@Override
		public String toString()
		{
			return "Legend of the Poro King";
		}
	},
	NexusSiege {
		@Override
		public String toString()
		{
			return "Nexus Siege";
		}
	},
	DoomBotsVoting {
		@Override
		public String toString()
		{
			return "Doom Bots Voting";
		}
	},
	DoomBotsStandard {
		@Override
		public String toString()
		{
			return "Doom Bots Standard";
		}
	},
	StarGuardianInvasionNormal {
		@Override
		public String toString()
		{
			return "Star Guardian Invasion: Normal";
		}
	},
	StarGuardianInvasionOnslaught {
		@Override
		public String toString()
		{
			return "Star Guardian Invasion: Onslaught";
		}
	},
	PROJECTHunters {
		@Override
		public String toString()
		{
			return "PROJECT: Hunters";
		}
	},
	SnowAllRandomUltraRapidFire {
		@Override
		public String toString()
		{
			return "Snow All Random Ultra Rapid Fire";
		}
	},
	OneForAll {
		@Override
		public String toString()
		{
			return "One For All";
		}
	},
	OdysseyExtractionIntro {
		@Override
		public String toString()
		{
			return "Odyssey Extraction: Intro";
		}
	},
	OdysseyExtractionCadet {
		@Override
		public String toString()
		{
			return "Odyssey Extraction: Cadet";
		}
	},
	OdysseyExtractionCrewmember {
		@Override
		public String toString()
		{
			return "Odyssey Extraction: Crewmember";
		}
	},
	OdysseyExtractionCaptain {
		@Override
		public String toString()
		{
			return "Odyssey Extraction: Captain";
		}
	},
	OdysseyExtractionOnslaught {
		@Override
		public String toString()
		{
			return "Odyssey Extraction: Onslaught";
		}
	},
	TeamfightTactics {
		@Override
		public String toString()
		{
			return "Teamfight Tactics";
		}
	},
	RankedTeamfightTactics {
		@Override
		public String toString()
		{
			return "Ranked Teamfight Tactics";
		}
	},
	NexusBlitz {
		@Override
		public String toString()
		{
			return "Nexus Blitz";
		}
	},
	CustomGame {
		@Override
		public String toString()
		{
			return "Custom Game";
		}
	}
}
