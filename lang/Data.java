 package lang;

import java.util.Random;

import lang.phonology.Consonant;

/* Contains general linguistic statistics and methods */
public class Data {
	// Number of languages in UPSID
	public static final int LANGUAGE_SAMPLE_SIZE = 451;
	
	/* Statistics from the World Atlas of Language Structures wals.info */
	
	// Phonemes
	public static final int MIN_CONSONANT_INVENTORY = 6;
	public static final int MAX_CONSONANT_INVENTORY = 122;
	public static final int[] CONSONANT_INVENTORIES = { MIN_CONSONANT_INVENTORY, 14, 18, 25, 33 };
	public static final int[] CONSONANT_INVENTORY_FREQUENCIES = { 89, 122, 201, 94, 57 };
	
	public static final int MIN_VOWEL_INVENTORY = 2;
	public static final int MAX_VOWEL_INVENTORY = 31;
	
	public static final double MIN_CONSONANT_VOWEL_RATIO = 1.11;
	public static final double MAX_CONSONANT_VOWEL_RATIO = 29;
	public static final double[] CONSONANT_VOWEL_RATIOS = { MIN_CONSONANT_VOWEL_RATIO, 2.0, 2.75, 4.5, 6.5 };
	public static final int[] CONSONANT_VOWEL_RATIO_FREQUENCIES = { 58, 101, 234, 102, 69 };
	
	/* Consonants */
	
	// Consonant groupings
	public static final int[] VOICING_CONTRAST_WEIGHTS = { 182, 189, 38, 158 };
	public static final int[] PLOSIVE_SYSTEM_WEIGHTS = { 242, 255, 33, 34, 3 };
	public static final Consonant[] BASIC_PLOSIVE_SYSTEM = { Consonant.VL_BILABIAL_STOP,
			Consonant.VL_ALVEOLAR_STOP, Consonant.VL_VELAR_STOP, Consonant.VD_BILABIAL_STOP,
			Consonant.VD_ALVEOLAR_STOP, Consonant.VD_VELAR_STOP };
	
	public static final int[] UVULAR_WEIGHTS = { 470, 38, 11, 48 };
	public static final int[] GLOTTALIZED_WEIGHTS = { 409, 58, 55, 4, 14, 20, 4, 3 };
	public static final int[] LATERAL_WEIGHTS = { 95, 388, 29, 47, 8 };
	
	public static final int[] COMMON_ABSENCE_WEIGHTS = { 503, 4, 48, 10, 1, 1 };
	public static final int[] UNCOMMON_WEIGHTS = { 449, 9, 45, 21, 40, 1, 2 };
	
	// Consonant categories - by manner of articulation
	public static final Consonant[] NASALS = { Consonant.VD_BILABIAL_NASAL, Consonant.VD_ALVEOLAR_NASAL,
			Consonant.VD_RETROFLEX_NASAL, Consonant.VD_VELAR_NASAL };
	
	public static final Consonant[] STOPS = { Consonant.VL_BILABIAL_STOP, Consonant.VD_BILABIAL_STOP,
			Consonant.VL_ALVEOLAR_STOP, Consonant.VD_ALVEOLAR_STOP, Consonant.VL_RETROFLEX_STOP,
			Consonant.VD_RETROFLEX_STOP, Consonant.VL_PALATAL_STOP, Consonant.VD_PALATAL_STOP,
			Consonant.VL_VELAR_STOP, Consonant.VD_VELAR_STOP, Consonant.VL_UVULAR_STOP, Consonant.VD_UVULAR_STOP };
	
	public static final Consonant[] FRICATIVES = { Consonant.VL_ALVEOLAR_SIB_FRICATIVE,
			Consonant.VD_ALVEOLAR_SIB_FRICATIVE, Consonant.VD_PALATO_ALVEOLAR_SIB_FRICATIVE,
			Consonant.VL_RETROFLEX_SIB_FRICATIVE, Consonant.VD_RETROFLEX_SIB_FRICATIVE,
			Consonant.VL_ALVEOLO_PALATAL_SIB_FRICATIVE, Consonant.VD_ALVEOLO_PALATAL_SIB_FRICATIVE,
			Consonant.VL_BILABIAL_FRICATIVE, Consonant.VD_BILABIAL_FRICATIVE, Consonant.VL_LABIODENTAL_FRICATIVE,
			Consonant.VD_LABIODENTAL_FRICATIVE, Consonant.VD_DENTAL_FRICATIVE, Consonant.VL_DENTAL_FRICATIVE,
			Consonant.VL_ALVEOLO_PALATAL_SIB_FRICATIVE, Consonant.VD_PALATAL_FRICATIVE,
			Consonant.VL_VELAR_FRICATIVE, Consonant.VD_VELAR_FRICATIVE, Consonant.VL_UVULAR_FRICATIVE,
			Consonant.VD_UVULAR_FRICATIVE, Consonant.VL_PHARYNGEAL_FRICATIVE, Consonant.VD_PHARYNGEAL_FRICATIVE,
			Consonant.VL_GLOTTAL_FRICATIVE, Consonant.VD_GLOTTAL_FRICATIVE };
	
	public static final Consonant[] LATERALS = { Consonant.VL_ALVEOLAR_LAT_AFFRICATE,
			Consonant.VL_ALVEOLAR_LAT_FRICATIVE, Consonant.VD_ALVEOLAR_LAT_FRICATIVE,
			Consonant.VD_ALVEOLAR_LAT_APPROXIMANT, Consonant.VD_RETROFLEX_LAT_APPROXIMANT,
			Consonant.VD_PALATAL_LAT_APPROXIMANT, Consonant.VD_ALVEOLAR_LAT_FLAP,
			Consonant.VD_RETROFLEX_LAT_FLAP };
	public static final Consonant[] LATERAL_OBSTRUENTS = { Consonant.VL_ALVEOLAR_LAT_AFFRICATE,
			Consonant.VL_ALVEOLAR_LAT_FRICATIVE, Consonant.VD_ALVEOLAR_LAT_FRICATIVE };
	public static final Consonant[] LATERAL_OTHERS = { Consonant.VD_RETROFLEX_LAT_APPROXIMANT,
			Consonant.VD_PALATAL_LAT_APPROXIMANT, Consonant.VD_ALVEOLAR_LAT_FLAP,
			Consonant.VD_RETROFLEX_LAT_FLAP };
	
	// By place of articulation
	public static final Consonant[] BILABIALS = { Consonant.VD_BILABIAL_NASAL, Consonant.VL_BILABIAL_STOP,
			Consonant.BVD_BILABIAL_STOP, Consonant.VL_BILABIAL_FRICATIVE, Consonant.VD_BILABIAL_FRICATIVE };
	
	public static final Consonant[] UVULARS = { Consonant.VL_UVULAR_STOP, Consonant.VD_UVULAR_STOP,
			Consonant.VL_UVULAR_FRICATIVE, Consonant.VD_UVULAR_FRICATIVE };
	public static final Consonant[] UVULAR_STOPS = { Consonant.VL_UVULAR_STOP, Consonant.VD_UVULAR_STOP };
	public static final Consonant[] UVULAR_FRICATIVES = { Consonant.VL_UVULAR_FRICATIVE,
			Consonant.VD_UVULAR_FRICATIVE };
	
	// Other consonant categories
	public static final Consonant[] EJECTIVES = { Consonant.VL_BILABIAL_EJECTIVE_STOP,
			Consonant.VL_ALVEOLAR_EJECTIVE_STOP, Consonant.VL_PALATAL_EJECTIVE_STOP,
			Consonant.VL_VELAR_EJECTIVE_STOP, Consonant.VL_UVULAR_EJECTIVE_STOP,
			Consonant.VL_ALVEOLAR_EJECTIVE_SIB_AFFRICATE, Consonant.VL_ALVEOLAR_EJECTIVE_LAT_AFFRICATE,
			Consonant.VL_PALATO_ALVEOLAR_EJECTIVE_SIB_AFFRICATE };
	
	public static final Consonant[] IMPLOSIVES = { Consonant.VD_BILABIAL_IMPLOSIVE,
			Consonant.VD_ALVEOLAR_IMPLOSIVE, Consonant.VD_PALATAL_IMPLOSIVE, Consonant.VD_VELAR_IMPLOSIVE };
	
	/* Vowels */
	
	// Vowel groupings
	public static final int[] NASAL_CONTRAST_WEIGHTS = { 64, 180 };
	
	// Syllables
	public static final int[] SYLLABLE_COMPLEXITY_FREQUENCIES = { 61, 274, 151 };
	
	// Randomly choose an index from an array of integer weights
	public static int chooseIndexByWeights(Random random, int... weights) {
		// Create a range by adding all weights
		int totalRange = 0;
		for (int weight : weights)
			totalRange += weight;
		
		int dart = random.nextInt(totalRange);	// Pick random number within
													// total range
		
		// Determine in which sub range the dart landed, corresponding to the
		// index of that weight
		totalRange = weights[0];
		int i;
		for (i = 0; totalRange < dart && i < weights.length - 1; ++i)
			totalRange += weights[i + 1];
		
		return i;
	}
}
