package gengo.phonology;

/* Contains all possible consonant phonemes with their features, UPSID occurrence, and IPA symbol */
public class Consonant extends Phoneme {
	private final boolean labialized;
	private final Voice voice;
	private final boolean aspirated;
	private final Place place;
	private final boolean ejective;
	private final Manner manner;
	
	public Consonant(int occurence, String symbol, Feature... features) {
		super(occurence, symbol, features);
		
		Voice voice = Voice.VOICELESS;
		Place place = Place.LINGUO_LABIAL;
		Manner manner = Manner.IMPLOSIVE;
		boolean labialized = false;
		boolean aspirated = false;
		boolean ejective = false;
		
		for (Feature feature : features) {
			Class<? extends Feature> type = feature.getClass();
			
			if (type == Voice.class)
				voice = (Voice) feature;
			else if (type == Place.class)
				place = (Place) feature;
			else if (type == Manner.class)
				manner = (Manner) feature;
			else if (feature == Labialization.LABIALIZED)
				labialized = true;
			else if (feature == Aspiration.ASPIRATED)
				aspirated = true;
			else if (feature == Ejectivity.EJECTIVE)
				ejective = true;
		}
		
		this.voice = voice;
		this.place = place;
		this.manner = manner;
		this.labialized = labialized;
		this.aspirated = aspirated;
		this.ejective = ejective;
		
		IPA.CONSONANTS.add(this);
	}
	
	// Turns consonant into English name based on IPA standards
	public String toString() {		
		// Basic name with voice, place, manner, and aspiration and ejective if present
		String name = voice.name + " " + (aspirated ? "aspirated " : "") + place.name.toLowerCase() + " " + (ejective ? "ejective " : "") +  manner.name.toLowerCase();
		
		// Add labialization if present
		if (labialized)
			name = "Labialized " + name.toLowerCase();
		
		return name;
	}
	
	// Getters
	public Voice voice() { return voice; }
	public boolean aspirated() { return aspirated; }
	public Place place() { return place; }
	public boolean ejective() { return ejective; }
	public Manner manner() { return manner; }
	
	/* Consonant features - each value has a string name */
	
	// Use of vocal cords during consonant's duration
	public static enum Voice implements Feature {
		VOICELESS("Voiceless"), VOICED("Voiced"), BREATHY("Breathy voiced");
		
		private final String name;
		
		private Voice(String name) {
			this.name = name;
		}
	}
	
	// Release of air along with consonant
	public static enum Aspiration  implements Feature {
		UNASPIRATED("Unaspirated"), ASPIRATED("Aspirated");
		
		private final String name;
		
		private Aspiration(String name) {
			this.name = name;
		}
	}
	
	// Glottal closure and release
	public static enum Ejectivity  implements Feature {
		EJECTIVE("Ejective");
		
		private final String name;
		
		private Ejectivity(String name) {
			this.name = name;
		}
	}
	
	// Rounding of lips
	public static enum Labialization  implements Feature {
		LABIALIZED("Labialized");
		
		private final String name;
		
		private Labialization(String name) {
			this.name = name;
		}
	}
	
	// Placement of release - either tongue or other part of vocal tract
	public static enum Place implements Feature {
		BILABIAL("Bilabial"), LABIO_VELAR("Labio-velar"), LABIODENTAL("Labiodental"), LINGUO_LABIAL("Linguo-labial"),
		DENTAL("Dental"), POSTALVEOLAR("Postalveolar"), ALVEOLAR("Alveolar"), PALATO_ALVEOLAR("Palato-alveolar"), RETROFLEX("Retroflex"),
		ALVEOLO_PALATAL("Alveolo-palatal"), PALATAL("Palatal"), VELAR("Velar"), UVULAR("Uvular"),
		PHARYNGEAL("Pharyngeal"), GLOTTAL("Glottal");
		
		private final String name;
		
		private Place(String name) {
			this.name = name;
		}
	}
	
	// Manner in which air is released
	public static enum Manner implements Feature {
		NASAL("Nasal"), STOP("Stop"), SIB_AFFRICATE("Sibilant affricate"), NONSIB_AFFRICATE("Non-sibilant affricate"),
		SIB_FRICATIVE("Sibilant fricative"), NONSIB_FRICATIVE("Non-sibilant fricative"), APPROXIMANT("Approximant"),
		FLAP("Flap"), TRILL("Trill"), LAT_AFFRICATE("Lateral affricate"), LAT_FRICATIVE("Lateral fricative"),
		LAT_APPROXIMANT("Lateral approximant"), LAT_FLAP("Lateral flap"), CLICK("Click"), IMPLOSIVE("Implosive");
		
		private final String name;
		
		private Manner(String name) {
			this.name = name;
		}
	}
}
