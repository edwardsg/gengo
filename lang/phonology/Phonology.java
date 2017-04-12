package lang.phonology;

import java.util.ArrayList;
import java.util.Collections;
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

	// Voicing contrast
	private boolean plosiveVoicingContrast = false;
	private boolean fricativeVoicingContrast = false;
	
	// Basic plosive system from /ptkbdg/
	private boolean pPresent = false;
	private boolean gPresent = false;
	
	// Uvular consonants
	private boolean uvularStopsPresent = false;
	private boolean uvularContinuantsPresent = false;
	
	// Glottalized consonants - ejectives and implosives
	private boolean ejectivesPresent = false;
	private boolean implosivesPresent = false;
	private boolean resonantsPresent = false;
	
	// Lateral consonants - L sounds
	private boolean lPresent = false;
	private boolean lateralObstruentsPresent = false;
	private boolean lateralOthersPresent = false;
	
	// Missing consonants
	private boolean bilabialsPresent = true;
	private boolean fricativesPresent = true;
	private boolean nasalsPresent = true;
	
	// Presence of uncommon consonants
	private boolean clicksPresent = false;
	private boolean labialVelarsPresent = false;
	private boolean pharyngealsPresent = false;
	private boolean thSoundsPresent = false;
	
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
		chooseConsonantInventory();
		chooseVowelInventory();
		
		choosePhonemeTypes();
		
		chooseConsonants();
		chooseVowels();
		
		Collections.sort(consonants);
		Collections.sort(vowels);
		
		syllableStructure = new SyllableStructure(consonants, vowels, random);
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
	
	// Choose what types of sounds will be in the inventory
	private void choosePhonemeTypes() {
		// Voicing contrast
		int voicingContrast = Data.chooseIndexByWeights(random, Data.VOICING_CONTRAST_WEIGHTS);
		if (voicingContrast == 3 || voicingContrast == 1)
			plosiveVoicingContrast = true;
		if (voicingContrast == 3 || voicingContrast == 2)
			fricativeVoicingContrast = true;
		
		// Basic plosive system from /ptkbdg/
		int plosiveSystem = Data.chooseIndexByWeights(random, Data.PLOSIVE_SYSTEM_WEIGHTS);
		if (plosiveSystem == 1 || plosiveSystem == 2 || plosiveSystem == 0)
			gPresent = true;
		if (plosiveSystem == 1 || plosiveSystem == 3 || plosiveSystem == 0)
			pPresent = true;
		
		// Uvular consonants
		int uvularConsonantType = Data.chooseIndexByWeights(random, Data.UVULAR_WEIGHTS);
		if (uvularConsonantType == 1 || uvularConsonantType == 3)
			uvularStopsPresent = true;
		if (uvularConsonantType == 2 || uvularConsonantType == 3)
			uvularContinuantsPresent = true;
		
		// Glottalized consonants - ejectives and implosives
		int glottalizedType = Data.chooseIndexByWeights(random, Data.GLOTTALIZED_WEIGHTS);
		if (glottalizedType == 1 || glottalizedType == 4 || glottalizedType == 5 || glottalizedType == 7)
			ejectivesPresent = true;
		if (glottalizedType == 2 || glottalizedType == 4 || glottalizedType == 6 || glottalizedType == 7)
			implosivesPresent = true;
		if (glottalizedType == 3 || glottalizedType == 5 || glottalizedType == 6 || glottalizedType == 7)
			resonantsPresent = true;
		
		// Lateral consonants - L sounds
		int lateralConsonantType = Data.chooseIndexByWeights(random, Data.LATERAL_WEIGHTS);
		if (lateralConsonantType == 1 || lateralConsonantType == 3)
			lPresent = true;
		if (lateralConsonantType == 2)
			lateralOthersPresent = true;
		if (lateralConsonantType == 3 || lateralConsonantType == 4)
			lateralObstruentsPresent = true;
		
		// Missing consonants
		int absentConsonantType = Data.chooseIndexByWeights(random, Data.COMMON_ABSENCE_WEIGHTS);
		if (absentConsonantType == 1 || absentConsonantType == 4)
			bilabialsPresent = false;
		if (absentConsonantType == 2 || absentConsonantType == 5)
			fricativesPresent = false;
		if (absentConsonantType == 3 || absentConsonantType == 4 || absentConsonantType == 5)
			nasalsPresent = false;
		
		// Presence of uncommon consonants
		int uncommonConsonantType = Data.chooseIndexByWeights(random, Data.UNCOMMON_WEIGHTS);
		if (uncommonConsonantType == 1 || uncommonConsonantType == 5)
			clicksPresent = true;
		if (uncommonConsonantType == 2)
			labialVelarsPresent = true;
		if (uncommonConsonantType == 3 || uncommonConsonantType == 5 || uncommonConsonantType == 6)
			pharyngealsPresent = true;
		if (uncommonConsonantType == 4 || uncommonConsonantType == 5 || uncommonConsonantType == 6)
			thSoundsPresent = true;
	}
	
	// Pick number of consonants from Consonant enum equal to consonant inventory
	private void chooseConsonants() {
		// Determine which sounds must be and cannot be included
		List<Consonant> requiredConsonants = getRequiredConsonants();		
		List<Consonant> availableConsonants = createAvailableConsonants(requiredConsonants);
		
		// Add required consonants
		for (Consonant consonant : requiredConsonants)
			addConsonant(consonant, availableConsonants);
		
		// Choosing and adding consonants to inventory
		while (consonants.size() < consonantInventory) {			
			// Uvulars
			if (uvularStopsPresent)
				addConsonant(chooseConsonantFromSet(random, Data.UVULAR_STOPS), availableConsonants);
			if (uvularContinuantsPresent)
				addConsonant(chooseConsonantFromSet(random, Data.UVULAR_FRICATIVES), availableConsonants);
			
			// Glottalized consonants
			if (ejectivesPresent)
				addConsonant(chooseConsonantFromSet(random, Data.EJECTIVES), availableConsonants);
			if (implosivesPresent)
				addConsonant(chooseConsonantFromSet(random, Data.IMPLOSIVES), availableConsonants);
			
			// Lateral consonants
			if (lateralObstruentsPresent)
				addConsonant(chooseConsonantFromSet(random, Data.LATERAL_OBSTRUENTS), availableConsonants);
			if (lateralOthersPresent)
				addConsonant(chooseConsonantFromSet(random, Data.LATERAL_OTHERS), availableConsonants);
			
			// Other consonants;
			int[] weights = new int[availableConsonants.size()];
			for (int i = 0; i < availableConsonants.size(); ++i)
				weights[i] = availableConsonants.get(i).weight();
			
			Consonant[] allConsonantsArray = new Consonant[availableConsonants.size()];
			allConsonantsArray = availableConsonants.toArray(allConsonantsArray);
			addConsonant(chooseConsonantFromSet(random, allConsonantsArray), availableConsonants);
		}
	}
	
	// Make a list of all consonants that must be added
	private List<Consonant> getRequiredConsonants() {
		ArrayList<Consonant> requiredConsonants = new ArrayList<Consonant>();
		
		// Plosive system - /ptkbdg/
		if (pPresent)
			requiredConsonants.add(Consonant.VL_BILABIAL_STOP);
		requiredConsonants.add(Consonant.VL_ALVEOLAR_STOP);
		requiredConsonants.add(Consonant.VL_VELAR_STOP);
		
		if (plosiveVoicingContrast) {
			requiredConsonants.add(Consonant.VD_BILABIAL_STOP);
			requiredConsonants.add(Consonant.VD_ALVEOLAR_STOP);
			if (gPresent)
				requiredConsonants.add(Consonant.VD_VELAR_STOP);
		}
		
		// L sound
		if (lPresent)
			requiredConsonants.add(Consonant.VD_ALVEOLAR_LAT_APPROXIMANT);
		
		// Th sounds
		if (thSoundsPresent) {
			requiredConsonants.add(Consonant.VL_DENTAL_FRICATIVE);
			if (fricativeVoicingContrast)
				requiredConsonants.add(Consonant.VD_DENTAL_FRICATIVE);
		}
		
		return requiredConsonants;
	}
	
	// Make a list of all consonants minus ones that are not included
	private List<Consonant> createAvailableConsonants(List<Consonant> requiredConsonants) {
		ArrayList<Consonant> availableConsonants = new ArrayList<Consonant>();
		
		// Add all consonants that aren't required to be included
		for (Consonant consonant : Consonant.values())
			if (!requiredConsonants.contains(consonant))
				availableConsonants.add(consonant);
		
		// List of consonant sounds to remove from list of available sounds
		List<Consonant> consonantsToRemove = new ArrayList<Consonant>();
		
		// Voicing contrasts
		for (Consonant consonant : availableConsonants)
			if (consonant.hasFeature(Consonant.Voice.VOICED)) {
				if (!plosiveVoicingContrast && consonant.hasFeature(Consonant.Manner.STOP))
					consonantsToRemove.add(consonant);
				else if (!fricativeVoicingContrast && (consonant.hasFeature(Consonant.Manner.SIB_FRICATIVE) || consonant.hasFeature(Consonant.Manner.NONSIB_FRICATIVE)))
					consonantsToRemove.add(consonant);
			}
		
		// Uvulars
		if (!uvularStopsPresent)
			for (Consonant consonant : Data.UVULAR_STOPS)
				consonantsToRemove.add(consonant);
		if (!uvularContinuantsPresent)
			for (Consonant consonant : Data.UVULAR_FRICATIVES)
				consonantsToRemove.add(consonant);
		
		// Glottalized consonants
		if (!ejectivesPresent)
			for (Consonant consonant : Data.EJECTIVES)
				consonantsToRemove.add(consonant);
		if (!implosivesPresent)
			for (Consonant consonant : Data.IMPLOSIVES)
				consonantsToRemove.add(consonant);
		
		// Laterals
		if (!lPresent)
			availableConsonants.remove(Consonant.VD_ALVEOLAR_LAT_APPROXIMANT);
		if (!lateralObstruentsPresent)
			for (Consonant consonant : Data.LATERAL_OBSTRUENTS)
				consonantsToRemove.add(consonant);
		if (!lateralOthersPresent)
			for (Consonant consonant : Data.LATERAL_OTHERS)
				consonantsToRemove.add(consonant);
		
		// Absence of common consonants
		if (!bilabialsPresent)
			for (Consonant consonant : Data.BILABIALS)
				consonantsToRemove.add(consonant);
		if (!fricativesPresent)
			for (Consonant consonant : Data.FRICATIVES)
				consonantsToRemove.add(consonant);
		if (!nasalsPresent)
			for (Consonant consonant : Data.NASALS)
				consonantsToRemove.add(consonant);
		
		// Uncommon sounds
		if (!thSoundsPresent) {
			consonantsToRemove.add(Consonant.VL_DENTAL_FRICATIVE);
			consonantsToRemove.add(Consonant.VD_DENTAL_FRICATIVE);
		}
		
		availableConsonants.removeAll(consonantsToRemove);
		
		return availableConsonants;
	}

	// Pick one consonant randomly from set of all consonants having given features
	private static Consonant chooseConsonantByFeatures(Random random, Consonant.Feature... features) {
		List<Consonant> consonantSet = new ArrayList<Consonant>();
		
		for (Consonant consonant : Consonant.values())
			if (consonant.hasFeatures(features))
				consonantSet.add(consonant);
		
		int[] weights = new int[consonantSet.size()];
		for (int i = 0; i < consonantSet.size(); ++i)
			weights[i] = consonantSet.get(i).weight();
		
		return consonantSet.get(Data.chooseIndexByWeights(random, weights));
	}
	
	// Add one consonant to inventory
	private void addConsonant(Consonant consonant, List<Consonant> allConsonants) {
		ConsonantPhoneme phoneme = new ConsonantPhoneme(consonant);
		
		if (!consonants.contains(phoneme))
			consonants.add(phoneme);
		
		allConsonants.remove(consonant);
	}
	
	// Pick one consonant from a predefined list
	private static Consonant chooseConsonantFromSet(Random random, Consonant[] set) {
		int[] weights = new int[set.length];
		for (int i = 0; i < set.length; ++i)
			weights[i] = set[i].weight();
		
		Consonant consonant =  set[Data.chooseIndexByWeights(random, weights)];
		
		return consonant;
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
	
	// Getters
	public int consonantInventory() { return consonantInventory; }
	public int vowelInventory() { return vowelInventory; }
	public List<ConsonantPhoneme> consonants() { return consonants; }
	public List<VowelPhoneme> vowels() { return vowels; }
	public SyllableStructure syllableStructure() { return syllableStructure; }
}
