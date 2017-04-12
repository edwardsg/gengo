package lang.phonology;

import lang.Data;

/* Contains all possible vowel phonemes with their features, occurrence in UPSID, and IPA symbols */
public enum Vowel {
	CLOSE_FRONT_UR				(Height.CLOSE, Backness.FRONT, Roundedness.UNROUNDED, 393, "i"),									// UPSID   i
	OPEN_CENTRAL_UR				(Height.OPEN, Backness.CENTRAL, Roundedness.UNROUNDED, 392, "a"),											// a
	CLOSE_BACK_RD				(Height.CLOSE, Backness.BACK, Roundedness.ROUNDED, 369, "u"),												// u
	OPEN_MID_FRONT_UR			(Height.OPEN_MID, Backness.FRONT, Roundedness.UNROUNDED, 186, "\u025B"),									// E
	MID_BACK_RD					(Height.MID, Backness.BACK, Roundedness.ROUNDED, 181, "o"),													// "o	*
	MID_FRONT_UR				(Height.MID, Backness.FRONT, Roundedness.UNROUNDED, 169, "e"),												// "e	*
	OPEN_MID_BACK_RD			(Height.OPEN_MID, Backness.BACK, Roundedness.ROUNDED, 162, "\u0254"),										// O
//	CLOSE_MID_BACK_RD			(Height.CLOSE_MID, Backness.BACK, Roundedness.ROUNDED, 131, "o"),											// o
//	CLOSE_MID_FRONT_UR			(Height.CLOSE_MID, Backness.FRONT, Roundedness.UNROUNDED, 124, "e"), 										// e
	N_OPEN_CENTRAL_UR			(Vowel.NASALIZED, Height.OPEN, Backness.CENTRAL, Roundedness.UNROUNDED, 83, "a\u0303"), 					// a~
	N_CLOSE_FRONT_UR			(Vowel.NASALIZED, Height.CLOSE, Backness.FRONT, Roundedness.UNROUNDED, 82, "i\u0303"),						// i~
	MID_CENTRAL_UR				(Height.MID, Backness.CENTRAL, Roundedness.UNROUNDED, 76, "\u0259"), 										// "@
	NEAR_CLOSE_NEAR_FRONT_UR	(Height.NEAR_CLOSE, Backness.NEAR_FRONT, Roundedness.UNROUNDED, 74, "\u026A"), 								// I
	N_CLOSE_BACK_RD				(Vowel.NASALIZED, Height.CLOSE, Backness.BACK, Roundedness.ROUNDED, 74, "u\u0303"), 						// u~
	NEAR_CLOSE_NEAR_BACK_RD		(Height.NEAR_CLOSE, Backness.NEAR_BACK, Roundedness.ROUNDED, 66, "\u028A"), 								// U
	CLOSE_CENTRAL_UR			(Height.CLOSE, Backness.CENTRAL, Roundedness.UNROUNDED, 61, "\u0268"), 										// i_
	CLOSE_BACK_UR				(Height.CLOSE, Backness.BACK, Roundedness.UNROUNDED, 41, "\u026F"), 										// uu
	L_CLOSE_FRONT_UR			(Length.LONG, Height.CLOSE, Backness.FRONT, Roundedness.UNROUNDED, 40, "i\u02D0"), 							// i:
	NEAR_OPEN_FRONT_UR			(Height.NEAR_OPEN, Backness.FRONT, Roundedness.UNROUNDED, 39, "\u00E6"), 									// aa
	L_CLOSE_BACK_RD				(Length.LONG, Height.CLOSE, Backness.BACK, Roundedness.ROUNDED, 36, "u\u02D0"), 							// u:
	N_MID_BACK_RD				(Vowel.NASALIZED, Height.MID, Backness.BACK, Roundedness.ROUNDED, 35, "o\u0303"), 							// "o~	*
	N_OPEN_MID_FRONT_UR			(Vowel.NASALIZED, Height.OPEN_MID, Backness.FRONT, Roundedness.UNROUNDED, 35, "\u025B\u0303"), 				// E~
	L_OPEN_CENTRAL_UR			(Length.LONG, Height.OPEN, Backness.CENTRAL, Roundedness.UNROUNDED, 34, "a\u02D0"), 						// a:
	N_MID_FRONT_UR				(Vowel.NASALIZED, Height.MID, Backness.FRONT, Roundedness.UNROUNDED, 33, "e\u0303"), 						// "e~	*
	N_OPEN_MID_BACK_RD			(Vowel.NASALIZED, Height.OPEN_MID, Backness.BACK, Roundedness.ROUNDED, 32, "\u0254\u0303"), 				// O~
//	N_CLOSE_MID_BACK_RD			(Vowel.NASALIZED, Height.CLOSE_MID, Backness.BACK, Roundedness.ROUNDED, 27, "o\u0303"), 					// o~
//	OPEN_FRONT_UR				(Height.OPEN, Backness.FRONT, Roundedness.UNROUNDED, 26, "a"), 												// a+
	OPEN_BACK_UR				(Height.OPEN, Backness.BACK, Roundedness.UNROUNDED, 25, "\u0251"), 											// a_
//	L_CLOSE_MID_BACK_RD			(Length.LONG, Height.CLOSE_MID, Backness.BACK, Roundedness.ROUNDED, 24, "o\u02D0"), 						// o:
	CLOSE_FRONT_RD				(Height.CLOSE, Backness.FRONT, Roundedness.ROUNDED, 24, "y"), 												// y
//	L_CLOSE_MID_FRONT_UR		(Length.LONG, Height.CLOSE_MID, Backness.FRONT, Roundedness.UNROUNDED, 21, "e\u02D0"), 						// e:
	CLOSE_MID_CENTRAL_UR		(Height.CLOSE_MID, Backness.CENTRAL, Roundedness.UNROUNDED, 20, "\u0258"), 									// @
	OPEN_BACK_RD				(Height.OPEN, Backness.BACK, Roundedness.ROUNDED, 19, "\u0252"), 											// a_)
//	CLOSE_MID_FRONT_UR			(Height.CLOSE_MID, Backness.FRONT, Roundedness.UNROUNDED, 124, "e"), 										// ai
//	CLOSE_MID_FRONT_UR			(Height.CLOSE_MID, Backness.FRONT, Roundedness.UNROUNDED, 124, "e"), 										// au
//	N_CLOSE_MID_FRONT_UR		(Vowel.NASALIZED, Height.CLOSE_MID, Backness.FRONT, Roundedness.UNROUNDED, 18, "e\u0303"), 					// e~
	OPEN_MID_CENTRAL_UR			(Height.CLOSE_MID, Backness.CENTRAL, Roundedness.UNROUNDED, 15, "\u025C"), 									// 3
	NEAR_OPEN_CETNRAL_UR		(Height.NEAR_OPEN, Backness.CENTRAL, Roundedness.UNROUNDED, 14, "\u0250"), 									// 4
	L_OPEN_MID_FRONT_UR			(Length.LONG, Height.OPEN_MID, Backness.FRONT, Roundedness.UNROUNDED, 14, "\u025B\u02D0"), 					// E:
	N_MID_CENTRAL_UR			(Vowel.NASALIZED, Height.MID, Backness.CENTRAL, Roundedness.UNROUNDED, 12, "\u0259\u0303"), 				// "@~
	L_MID_BACK_RD				(Length.LONG, Height.MID, Backness.BACK, Roundedness.ROUNDED, 12, "o\u02D0"), 								// "o:	*
	CLOSE_MID_BACK_UR			(Height.CLOSE_MID, Backness.BACK, Roundedness.UNROUNDED, 12, "\u0264"), 									// o(
	CLOSE_MID_FRONT_RD			(Height.CLOSE_MID, Backness.FRONT, Roundedness.ROUNDED, 12, "\u00F8"), 										// o/
	L_MID_FRONT_UR				(Length.LONG, Height.MID, Backness.FRONT, Roundedness.UNROUNDED, 11, "e\u02D0"),			 				// "e:	*
	N_CLOSE_CENTRAL_UR			(Vowel.NASALIZED, Height.CLOSE, Backness.CENTRAL, Roundedness.UNROUNDED, 11, "\u0268\u0303"), 				// i_~
	N_NEAR_CLOSE_NEAR_FRONT_UR	(Vowel.NASALIZED, Height.NEAR_CLOSE, Backness.NEAR_FRONT, Roundedness.UNROUNDED, 10, "\u026A\u0303"),		// I~
	OPEN_MID_BACK_UR			(Height.OPEN_MID, Backness.BACK, Roundedness.UNROUNDED, 10, "\u028C"), 										// ^
	N_NEAR_OPEN_FRONT_UR		(Vowel.NASALIZED, Height.NEAR_OPEN, Backness.FRONT, Roundedness.UNROUNDED, 10, "\u00E6\u0303"), 			// aa~
	N_NEAR_CLOSE_NEAR_BACK_RD	(Vowel.NASALIZED, Height.NEAR_CLOSE, Backness.NEAR_BACK, Roundedness.ROUNDED, 9, "\u028A\u0303"), 			// U~
//	MID_BACK_UR					(Height.MID, Backness.BACK, Roundedness.UNROUNDED, 8, "\u0264"), 											// "o(	*
	OPEN_MID_FRONT_RD			(Height.OPEN_MID, Backness.FRONT, Roundedness.ROUNDED, 8, "\u0153"), 										// E)
	L_OPEN_MID_BACK_RD			(Length.LONG, Height.OPEN_MID, Backness.BACK, Roundedness.ROUNDED, 8, "\u0254\u02D0"), 						// O:
	L_OPEN_BACK_UR				(Length.LONG, Height.OPEN, Backness.BACK, Roundedness.UNROUNDED, 8, "\u0251\u02D0"), 						// a_:
	L_NEAR_OPEN_FRONT_UR		(Length.LONG, Height.NEAR_OPEN, Backness.FRONT, Roundedness.UNROUNDED, 8, "\u00E6\u02D0"), 					// aa:
	LN_CLOSE_FRONT_UR			(Length.LONG, Vowel.NASALIZED, Height.CLOSE, Backness.FRONT, Roundedness.UNROUNDED, 8, "i\u0303\u02D0"), 	// i~:
//	CLOSE_MID_FRONT_UR			(Height.CLOSE_MID, Backness.FRONT, Roundedness.UNROUNDED, 124, "e"), 										// ui
	LN_OPEN_CENTRAL_UR			(Length.LONG, Vowel.NASALIZED, Height.OPEN, Backness.CENTRAL, Roundedness.UNROUNDED, 7, "a\u0303\u02D0"),	// a~:
//	CLOSE_MID_FRONT_UR			(Height.CLOSE_MID, Backness.FRONT, Roundedness.UNROUNDED, 124, "e"), 										// ei
	N_CLOSE_BACK_UR				(Vowel.NASALIZED, Height.CLOSE, Backness.BACK, Roundedness.UNROUNDED, 7, "\u026F\u0303"), 					// uu~
	LN_CLOSE_BACK_RD			(Length.LONG, Vowel.NASALIZED, Height.CLOSE, Backness.BACK, Roundedness.ROUNDED, 7, "u\u0303\u02D0"), 		// u~:
//	CLOSE_MID_FRONT_UR			(Height.CLOSE_MID, Backness.FRONT, Roundedness.UNROUNDED, 124, "e"), 										// Oi
	N_OPEN_BACK_UR				(Vowel.NASALIZED, Height.OPEN, Backness.BACK, Roundedness.UNROUNDED, 6, "\u0251\u0303"), 					// a_~
//	CLOSE_MID_FRONT_UR			(Height.CLOSE_MID, Backness.FRONT, Roundedness.UNROUNDED, 124, "e"), 										// ie
//	CLOSE_MID_FRONT_UR			(Height.CLOSE_MID, Backness.FRONT, Roundedness.UNROUNDED, 124, "e"), 										// oi
	CLOSE_CENTRAL_RD			(Height.CLOSE, Backness.CENTRAL, Roundedness.ROUNDED, 6, "\u0289"), 										// u+
	MID_CENTRAL_RD				(Height.MID, Backness.CENTRAL, Roundedness.ROUNDED, 5, "\u0275"); 											// "@)	*
//	L_OPEN_FRONT_UR				(Length.LONG, Height.OPEN, Backness.FRONT, Roundedness.UNROUNDED, 5, "a\u02D0"), 							// a+:
//	N_OPEN_FRONT_UR				(Vowel.NASALIZED, Height.OPEN, Backness.FRONT, Roundedness.UNROUNDED, 5, "a\u0303"); 						// a+~
//	CLOSE_MID_FRONT_UR			(Height.CLOSE_MID, Backness.FRONT, Roundedness.UNROUNDED, 124, "e"), 										// ah
//	CLOSE_MID_FRONT_UR			(Height.CLOSE_MID, Backness.FRONT, Roundedness.UNROUNDED, 124, "e"), 										// eh
//	CLOSE_MID_FRONT_UR			(Height.CLOSE_MID, Backness.FRONT, Roundedness.UNROUNDED, 124, "e"), 										// ia
//	CLOSE_MID_FRONT_UR			(Height.CLOSE_MID, Backness.FRONT, Roundedness.UNROUNDED, 124, "e"), 										// ih
//	CLOSE_MID_FRONT_UR			(Height.CLOSE_MID, Backness.FRONT, Roundedness.UNROUNDED, 124, "e"), 										// oh
//	CLOSE_MID_FRONT_UR			(Height.CLOSE_MID, Backness.FRONT, Roundedness.UNROUNDED, 124, "e"), 										// ou
//	CLOSE_MID_FRONT_UR			(Height.CLOSE_MID, Backness.FRONT, Roundedness.UNROUNDED, 124, "e"), 										// u@
//	CLOSE_MID_FRONT_UR			(Height.CLOSE_MID, Backness.FRONT, Roundedness.UNROUNDED, 124, "e"); 										// uh

	// Named constant to make declarations clearer
	private static final boolean NASALIZED = true;
	
	private final Length length;
	private final boolean nasalized;
	private final Height height;
	private final Backness backness;
	private final Roundedness roundedness;
	private final int occurrence;
	private final double probability;
	private final String symbol;

	// Constructors for vowels with varying features - length and nasalization
	private Vowel(Height height, Backness backness, Roundedness roundedness, int occurrence, String symbol) {
		length = Length.SHORT;
		nasalized = false;
		this.height = height;
		this.backness = backness;
		this.roundedness = roundedness;
		this.occurrence = occurrence;
		probability = (double) occurrence / Data.LANGUAGE_SAMPLE_SIZE;
		this.symbol = symbol;
	}

	private Vowel(boolean nasalized, Height height, Backness backness, Roundedness roundedness, int occurrence, String symbol) {
		length = Length.SHORT;
		this.nasalized = nasalized;
		this.height = height;
		this.backness = backness;
		this.roundedness = roundedness;
		this.occurrence = occurrence;
		probability = (double) occurrence / Data.LANGUAGE_SAMPLE_SIZE;
		this.symbol = symbol;
	}

	private Vowel(Length length, Height height, Backness backness, Roundedness roundedness, int occurrence, String symbol) {
		this.length = length;
		this.nasalized = false;
		this.height = height;
		this.backness = backness;
		this.roundedness = roundedness;
		this.occurrence = occurrence;
		probability = (double) occurrence / Data.LANGUAGE_SAMPLE_SIZE;
		this.symbol = symbol;
	}

	private Vowel(Length length, boolean nasalized, Height height, Backness backness, Roundedness roundedness, int occurrence, String symbol) {
		this.length = length;
		this.nasalized = nasalized;
		this.height = height;
		this.backness = backness;
		this.roundedness = roundedness;
		this.occurrence = occurrence;
		probability = (double) occurrence / Data.LANGUAGE_SAMPLE_SIZE;
		this.symbol = symbol;
	}

	// Getters
	public Length length() { return length; }
	public boolean nasalized() { return nasalized; }
	public Height height() { return height; }
	public Backness backness() { return backness; }
	public Roundedness roundedness() { return roundedness; }
	public int weight() { return occurrence; }
	public double probability() { return probability; }
	public String symbol() { return symbol; }

	// Turns vowel into English name based on IPA standards
	public String toString() {
		// Basic name with height, backness, and roundedness
		String name = height.name + " " + backness.name.toLowerCase() + " " + roundedness.name.toLowerCase() + " vowel";
		
		// Add nasalization and length if present
		if (nasalized)
			name = "Nasalized " + name.toLowerCase();
		if (!length.equals(Length.SHORT))
			name = length.name + " " + name.toLowerCase();
		
		return name;
	}

	/* Vowel features - each value has a string name */
	
	// How long a vowel is held - default is short
	private static enum Length {
		EXTRA_SHORT("Extra-short"), SHORT("Short"), LONG("Long"), HALF_LONG("Half-long"), OVERLONG("Overlong");

		private final String name;

		private Length(String name) {
			this.name = name;
		}
	}

	// Whether or not a vowel is released nasally - may include partial nasalization
	private static enum Nasalization {
		ORAL("Oral"), NASAL("Nasal");

		private final String name;

		private Nasalization(String name) {
			this.name = name;
		}
	}

	// How far the mouth is opened
	private static enum Height {
		CLOSE("Close"), NEAR_CLOSE("Near-close"), CLOSE_MID("Close-mid"), MID("Mid"), OPEN_MID("Open-mid"), NEAR_OPEN("Near-open"), OPEN("Open");

		private final String name;

		private Height(String name) {
			this.name = name;
		}
	}

	// How far back the tongue is placed
	private static enum Backness {
		FRONT("Front"), NEAR_FRONT("Near-front"), CENTRAL("Central"), NEAR_BACK("Near-back"), BACK("Back");

		private final String name;

		private Backness(String name) {
			this.name = name;
		}
	}

	// Whether or not the vowel is rounded - may include compressed rounding
	private static enum Roundedness {
		UNROUNDED("Unrounded"), ROUNDED("Rounded");

		private final String name;

		private Roundedness(String name) {
			this.name = name;
		}
	}
}
