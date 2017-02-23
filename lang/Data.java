package lang;

import java.util.Random;

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
	
	// Syllables
	public static final int[] SYLLABLE_COMPLEXITY_FREQUENCIES = { 61, 274, 151 };
	
	// Randomly choose an index from an array of integer weights 
	public static int chooseIndexByWeights(int[] weights, Random random) {
		// Create a range by adding all weights
		int totalRange = 0;
		for (int weight : weights)
			totalRange += weight;
		
		int dart = random.nextInt(totalRange);	// Pick random number within total range
		
		
		// Determine in which sub range the dart landed, corresponding to the index of that weight
		totalRange = weights[0];
		int i;
		for (i = 0; totalRange < dart && i < weights.length - 1; ++i)
			totalRange += weights[i];
		
		return i;
	}
	
	
}
