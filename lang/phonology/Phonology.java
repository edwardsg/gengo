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
	
	private List<ConsonantPhoneme> consonants;
	private List<VowelPhoneme> vowels;
	
	private SyllableStructure syllableStructure;
	
	// Basic constructor taking random number generator from Language class
	public Phonology(Random random) {
		this.random = random;
		
		consonants = new ArrayList<ConsonantPhoneme>();
		vowels = new ArrayList<VowelPhoneme>();
		
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
		consonants = new ArrayList<ConsonantPhoneme>();
		for (Consonant consonant : Consonant.values())
			consonants.add(new ConsonantPhoneme(consonant));
		
		vowelInventory = Vowel.values().length;
		vowels = new ArrayList<VowelPhoneme>();
		for (Vowel vowel : Vowel.values())
			vowels.add(new VowelPhoneme(vowel));
	}
	
	// Generate number of consonant phonemes based on possible ranges
	private void chooseConsonantInventory() {
		int i = Data.chooseIndexByWeights(random, cWeights);
		
		// Choose random number within chosen range, bottom clamped to minimum, top range up to maximum value
		consonantInventory = Math.max(cMin, random.nextInt((i == cInvs.length - 1 ? cMax : cInvs[i + 1]) - cInvs[i]) + cInvs[i]);
	}
	
	// Generate number of vowel phonemes based on number of consonants and typical consonant to vowel ratios
	private void chooseVowelInventory() {
		int i = Data.chooseIndexByWeights(random, rWeights);
		
		// Choose random ratio in chosen range, clamp to min, divide into consonant inventory, clamp min and max
		vowelInventory = (int) Math.min(vMax,
				Math.max(vMin, Math.round(consonantInventory / Math.max(rMin,
						(random.nextDouble() * ((i == rValues.length - 1 ? rMax : rValues[i + 1]) - rValues[i])
								+ rValues[i])))));
	}
	
	// Pick number of consonants from Consonant enum equal to consonant inventory
	private void chooseConsonants() {
		// Voicing contrast
		boolean plosiveVoicingContrast;
		boolean fricativeVoicingContrast;
		
		int voicingContrast = Data.chooseIndexByWeights(random, Data.VOICING_CONTRAST_WEIGHTS);
		
		if (voicingContrast == 3 || voicingContrast == 1)
			plosiveVoicingContrast = true;
		else
			plosiveVoicingContrast = false;
		
		if (voicingContrast == 3 || voicingContrast == 2)
			fricativeVoicingContrast = true;
		else
			fricativeVoicingContrast = false;	
		
		// Basic plosive system from /ptkbdg/
		boolean pPresent = false;
		boolean gPresent = false;
		
		int plosiveSystem = Data.chooseIndexByWeights(random, Data.PLOSIVE_SYSTEM_WEIGHTS);
		if (plosiveSystem == 1 || plosiveSystem == 2 || plosiveSystem == 0)
			gPresent = true;
		if (plosiveSystem == 1 || plosiveSystem == 3 || plosiveSystem == 0)
			pPresent = true;
		
		// Uvular consonants
		boolean uvularStopsPresent = false;
		boolean uvularContinuantsPresent = false;
		
		int uvularConsonantType = Data.chooseIndexByWeights(random, Data.UVULAR_WEIGHTS);
		if (uvularConsonantType == 1 || uvularConsonantType == 3)
			uvularStopsPresent = true;
		if (uvularConsonantType == 2 || uvularConsonantType == 3)
			uvularContinuantsPresent = true;
		
		// Glottalized consonants - ejectives and implosives
		boolean ejectivesPresent = false;
		boolean implosivesPresent = false;
		boolean resonantsPresent = false;
		
		int glottalizedType = Data.chooseIndexByWeights(random, Data.GLOTTALIZED_WEIGHTS);
		if (glottalizedType == 1 || glottalizedType == 4 || glottalizedType == 5 || glottalizedType == 7)
			ejectivesPresent = true;
		if (glottalizedType == 2 || glottalizedType == 4 || glottalizedType == 6 || glottalizedType == 7)
			implosivesPresent = true;
		if (glottalizedType == 3 || glottalizedType == 5 || glottalizedType == 6 || glottalizedType == 7)
			resonantsPresent = true;
		
		// Lateral consonants - L sounds
		boolean lPresent = false;
		boolean lateralObstruentsPresent = false;
		boolean lateralOthersPresent = false;
		
		int lateralConsonantType = Data.chooseIndexByWeights(random, Data.LATERAL_WEIGHTS);
		if (lateralConsonantType == 1 || lateralConsonantType == 3)
			lPresent = true;
		if (lateralConsonantType == 2)
			lateralOthersPresent = true;
		if (lateralConsonantType == 3 || lateralConsonantType == 4)
			lateralObstruentsPresent = true;
		
		// Missing consonants
		boolean bilabialsPresent = true;
		boolean fricativesPresent = true;
		boolean nasalsPresent = true;
		
		int absentConsonantType = Data.chooseIndexByWeights(random, Data.COMMON_ABSENCE_WEIGHTS);
		if (absentConsonantType == 1 || absentConsonantType == 4)
			bilabialsPresent = false;
		if (absentConsonantType == 2 || absentConsonantType == 5)
			fricativesPresent = false;
		if (absentConsonantType == 3 || absentConsonantType == 4 || absentConsonantType == 5)
			nasalsPresent = false;
		
		// Presence of uncommon consonants
		boolean clicksPresent = false;
		boolean labialVelarsPresent = false;
		boolean pharyngealsPresent = false;
		boolean thSoundsPresent = false;
		
		int uncommonConsonantType = Data.chooseIndexByWeights(random, Data.UNCOMMON_WEIGHTS);
		if (uncommonConsonantType == 1 || uncommonConsonantType == 5)
			clicksPresent = true;
		if (uncommonConsonantType == 2)
			labialVelarsPresent = true;
		if (uncommonConsonantType == 3 || uncommonConsonantType == 5 || uncommonConsonantType == 6)
			pharyngealsPresent = true;
		if (uncommonConsonantType == 4 || uncommonConsonantType == 5 || uncommonConsonantType == 6)
			thSoundsPresent = true;
		
		List<Consonant> allConsonants = new ArrayList<Consonant>();
		int totalRange = 0;
		for (Consonant consonant : Consonant.values()) {
			allConsonants.add(consonant);
			totalRange += consonant.weight();
		}		
		
		// Choosing and adding consonants to inventory
		int plosiveIndex = 0;
		while (consonants.size() < consonantInventory) {
			List<ConsonantPhoneme> consonantsToAdd = new ArrayList<ConsonantPhoneme>();
			
			if (plosiveIndex < 6 && consonants.size() < consonantInventory) {
				Consonant consonant = null;
				switch (plosiveIndex) {
				case 0:
					if (pPresent)
						consonant = chooseConsonantFromSet(random, Consonant.Voice.VOICELESS, Consonant.Place.BILABIAL, Consonant.Manner.STOP);
					break;
				case 1:
					Consonant alveolarT = chooseConsonantFromSet(random, Consonant.Voice.VOICELESS, Consonant.Place.ALVEOLAR, Consonant.Manner.STOP);
					Consonant dentalT = chooseConsonantFromSet(random, Consonant.Place.DENTAL, Consonant.Manner.STOP);
					
					int tConsonant = Data.chooseIndexByWeights(random, new int[] { alveolarT.weight(), dentalT.weight() });
					if (tConsonant == 0)
						consonant = alveolarT;
					else
						consonant = dentalT;
					break;
				case 2:
					consonant = chooseConsonantFromSet(random, Consonant.Voice.VOICELESS, Consonant.Place.VELAR, Consonant.Manner.STOP);
					break;
				case 3:
					if (plosiveVoicingContrast)
						consonant = chooseConsonantFromSet(random, Consonant.Voice.VOICED, Consonant.Place.BILABIAL, Consonant.Manner.STOP);
					break;
				case 4:
					if (plosiveVoicingContrast)
						consonant = chooseConsonantFromSet(random, Consonant.Voice.VOICED);
					break;
				case 5:
					if (plosiveVoicingContrast && gPresent)
						consonant = chooseConsonantFromSet(random, Consonant.Voice.VOICED, Consonant.Place.VELAR, Consonant.Manner.STOP);
					break;
				}
				
				if (consonant != null)
					consonantsToAdd.add(new ConsonantPhoneme(consonant));
				
				++plosiveIndex;
			}
			
			// Uvular Consonants
			if (uvularStopsPresent) {
				int[] weights = new int[Data.UVULAR_STOPS.length];
				for (int i = 0; i < Data.UVULAR_STOPS.length; ++i)
					weights[i] = Data.UVULAR_STOPS[i].weight();
				
				Consonant consonant = Data.UVULAR_STOPS[Data.chooseIndexByWeights(random, weights)];
				consonantsToAdd.add(new ConsonantPhoneme(consonant));
			}
			
			if (uvularContinuantsPresent) {
				int[] weights = new int[Data.UVULAR_FRICATIVES.length];
				for (int i = 0; i < Data.UVULAR_FRICATIVES.length; ++i)
					weights[i] = Data.UVULAR_FRICATIVES[i].weight();
				
				Consonant consonant = Data.UVULAR_FRICATIVES[Data.chooseIndexByWeights(random, weights)];
				consonantsToAdd.add(new ConsonantPhoneme(consonant));
			}
			
			// Other consonants;
			int[] weights = new int[allConsonants.size()];
			for (int i = 0; i < allConsonants.size(); ++i)
				weights[i] = allConsonants.get(i).weight();
			
			consonantsToAdd.add(new ConsonantPhoneme(allConsonants.get(Data.chooseIndexByWeights(random, weights))));
			
			// Add all chosen consonants
			for (int i = 0; i < consonantsToAdd.size() && consonants.size() < consonantInventory; ++i) {
				consonants.add(consonantsToAdd.get(i));
				
				for (Consonant allophone : consonantsToAdd.get(i).allophones()) {
					allConsonants.remove(allophone);
					totalRange -= allophone.weight();
				}
			}
		}
	}
	
	// Pick one consonant randomly from set of all consonants having given features
	private static Consonant chooseConsonantFromSet(Random random, Consonant.Feature... features) {
		List<Consonant> consonantSet = new ArrayList<Consonant>();
		
		boolean hasAllFeatures = true;
		for (Consonant consonant : Consonant.values()) {
			hasAllFeatures = true;
			for (Consonant.Feature feature : features)
				if (!consonant.hasFeature(feature))
					hasAllFeatures = false;
			
			if (hasAllFeatures) {
				consonantSet.add(consonant);
			}
		}
		
		int[] weights = new int[consonantSet.size()];
		for (int i = 0; i < consonantSet.size(); ++i)
			weights[i] = consonantSet.get(i).weight();
		
		return consonantSet.get(Data.chooseIndexByWeights(random, weights));
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
			
			vowels.add(new VowelPhoneme(allVowels.get(i)));
			totalRange -= allVowels.get(i).weight();
			allVowels.remove(i);
		}
	}
	
	// Getters
	public int consonantInventory() { return consonantInventory; }
	public int vowelInventory() { return vowelInventory; }
	public List<ConsonantPhoneme> consonants() { return consonants; }
	public List<VowelPhoneme> vowels() { return vowels; }
	public SyllableStructure syllableStructure() { return syllableStructure; }
}
