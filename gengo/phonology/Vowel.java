package gengo.phonology;

/* Contains all possible vowel phonemes with their features, occurrence in UPSID, and IPA symbols */
public class Vowel extends Phoneme {	
	private final Height height;
	private final Backness backness;
	private final Roundedness roundedness;
	private final Length length;
	private final boolean nasalized;

	public Vowel(int occurence, String symbol, Feature... features) {
		super(occurence, symbol, features);
		
		Height height = Height.OPEN;
		Backness backness = Backness.FRONT;
		Roundedness roundedness = Roundedness.UNROUNDED;
		Length length = Length.SHORT;
		boolean nasalized = false;
		
		for (Feature feature : features) {
			Class<? extends Feature> type = feature.getClass();
			
			if (type == Height.class)
				height = (Height) feature;
			else if (type == Backness.class)
				backness = (Backness) feature;
			else if (type == Roundedness.class)
				roundedness = (Roundedness) feature;
			else if (type == Length.class)
				length = (Length) feature;
			else if (feature == Nasalization.NASAL)
				nasalized = true;
		}
		
		this.height = height;
		this.backness = backness;
		this.roundedness = roundedness;
		this.length = length;
		this.nasalized = nasalized;
		
		IPA.VOWELS.add(this);
	}

	// Getters
	public Height height() { return height; }
	public Backness backness() { return backness; }
	public Roundedness roundedness() { return roundedness; }
	public Length length() { return length; }
	public boolean nasalized() { return nasalized; }

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

	// How far the mouth is opened
	public static enum Height implements Feature {
		CLOSE("Close"), NEAR_CLOSE("Near-close"), CLOSE_MID("Close-mid"), MID("Mid"), OPEN_MID("Open-mid"), NEAR_OPEN("Near-open"), OPEN("Open");

		private final String name;

		private Height(String name) {
			this.name = name;
		}
	}

	// How far back the tongue is placed
	public static enum Backness implements Feature {
		FRONT("Front"), NEAR_FRONT("Near-front"), CENTRAL("Central"), NEAR_BACK("Near-back"), BACK("Back");

		private final String name;

		private Backness(String name) {
			this.name = name;
		}
	}

	// Whether or not the vowel is rounded - may include compressed rounding
	public static enum Roundedness implements Feature {
		UNROUNDED("Unrounded"), ROUNDED("Rounded");

		private final String name;

		private Roundedness(String name) {
			this.name = name;
		}
	}

	// How long a vowel is held - default is short
	public static enum Length implements Feature {
		EXTRA_SHORT("Extra-short"), SHORT("Short"), LONG("Long"), HALF_LONG("Half-long"), OVERLONG("Overlong");

		private final String name;

		private Length(String name) {
			this.name = name;
		}
	}

	// Whether or not a vowel is released nasally - may include partial nasalization
	public static enum Nasalization implements Feature {
		ORAL("Oral"), NASAL("Nasal");

		private final String name;

		private Nasalization(String name) {
			this.name = name;
		}
	}
}
