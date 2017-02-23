package lang.phonology;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lang.Data;

/* Contains phonological information for a language, including phonemes and syllable structure */
public class Phonology {
	// Local data for phonology generation; taken from real-world data but can be changed for specific results
	private int cMin = Data.MIN_CONSONANT_INVENTORY;
	private int cMax = Data.MAX_CONSONANT_INVENTORY;
	private int[] cInvs = Data.CONSONANT_INVENTORIES;
	private int[] cWeights = Data.CONSONANT_INVENTORY_FREQUENCIES;
	
	private int vMin = Data.MIN_VOWEL_INVENTORY;
	private int vMax = Data.MAX_VOWEL_INVENTORY;
	
	private double rMin = Data.MIN_CONSONANT_VOWEL_RATIO;
	private double rMax = Data.MAX_CONSONANT_VOWEL_RATIO;
	private double[] rValues = Data.CONSONANT_VOWEL_RATIOS;
	private int[] rWeights = Data.CONSONANT_VOWEL_RATIO_FREQUENCIES;
	
	private Random random;
	
	private int consonantInventory;
	private int vowelInventory;
	
	private List<Consonant> consonants;
	private List<Vowel> vowels;
	
	private SyllableStructure syllableStructure;
	
	// Basic constructor taking random number generator from Language class
	public Phonology(Random random) {
		this.random = random;
		
		consonants = new ArrayList<Consonant>();
		vowels = new ArrayList<Vowel>();
		
		createNewPhonology();
	}
	
	private void createNewPhonology() {
		choosePhonemes();
		
		syllableStructure = new SyllableStructure(consonants, vowels, random);
	}
	
	private void choosePhonemes() {
		chooseConsonantInventory();
		chooseVowelInventory();
		
		chooseConsonants();
		chooseVowels();
	}
	
	// Test method to show every consonant and vowel in system
	public void getAllPhonemes() {
		consonantInventory = Consonant.values().length;
		consonants = new ArrayList<Consonant>();
		for (Consonant consonant : Consonant.values())
			consonants.add(consonant);
		
		vowelInventory = Vowel.values().length;
		vowels = new ArrayList<Vowel>();
		for (Vowel vowel : Vowel.values())
			vowels.add(vowel);
	}
	
	// Generate number of consonant phonemes based on possible ranges
	private void chooseConsonantInventory() {
		int i = Data.chooseIndexByWeights(cWeights, random);
		
		// Choose random number within chosen range, bottom clamped to minimum, top range up to maximum value
		consonantInventory = Math.max(cMin, random.nextInt((i == cInvs.length - 1 ? cMax : cInvs[i + 1]) - cInvs[i]) + cInvs[i]);
	}
	
	// Generate number of vowel phonemes based on number of consonants and typical consonant to vowel ratios
	private void chooseVowelInventory() {
		int i = Data.chooseIndexByWeights(rWeights, random);
		
		// Choose random ratio in chosen range, clamp to min, divide into consonant inventory, clamp min and max
		vowelInventory = (int) Math.min(vMax,
				Math.max(vMin, Math.round(consonantInventory / Math.max(rMin,
						(random.nextDouble() * ((i == rValues.length - 1 ? rMax : rValues[i + 1]) - rValues[i])
								+ rValues[i])))));
	}
	
	// Pick number of consonants from Consonant enum equal to consonant inventory
	private void chooseConsonants() {
		List<Consonant> allConsonants = new ArrayList<Consonant>();
		
		int totalRange = 0;
		for (Consonant consonant : Consonant.values()) {
			allConsonants.add(consonant);
			totalRange += consonant.weight();
		}
		
		while (consonants.size() < consonantInventory) {
			int dart = random.nextInt(totalRange);
			
			int searchRange = allConsonants.get(0).weight();
			int i;
			for (i = 0; searchRange < dart && i < allConsonants.size() - 1; ++i)
				searchRange += allConsonants.get(0).weight();
			
			consonants.add(allConsonants.get(i));
			totalRange -= allConsonants.get(i).weight();
			allConsonants.remove(i);
		}
	}
	
	// Pick number of vowels from Vowel enum equal to vowel inventory
	private void chooseVowels() {
		List<Vowel> allVowels = new ArrayList<Vowel>();
		
		int totalRange = 0;
		for (Vowel vowel : Vowel.values()) {
			allVowels.add(vowel);
			totalRange += vowel.weight();
		}
		
		while (vowels.size() < vowelInventory) {
			int dart = random.nextInt(totalRange);
			
			int searchRange = allVowels.get(0).weight();
			int i;
			for (i = 0; searchRange < dart && i < allVowels.size() - 1; ++i)
				searchRange += allVowels.get(0).weight();
			
			vowels.add(allVowels.get(i));
			totalRange -= allVowels.get(i).weight();
			allVowels.remove(i);
		}
	}
	
	// Getters
	public int consonantInventory() { return consonantInventory; }
	public int vowelInventory() { return vowelInventory; }
	public List<Consonant> consonants() { return consonants; }
	public List<Vowel> vowels() { return vowels; }
	public SyllableStructure syllableStructure() { return syllableStructure; }
}
