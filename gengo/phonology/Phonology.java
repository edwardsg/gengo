package gengo.phonology;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import gengo.RandomGen;

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
	
	// Nasal vowel contrast
	private boolean nasalVowelContrast = false;
	
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
		
		// Generate phonology
		choosePhonemeTypes();
		
		chooseConsonantInventory();
		chooseConsonants();
		
		chooseVowelInventory();
		chooseVowels();
		
		Collections.sort(consonants);
		Collections.sort(vowels);
		
		syllableStructure = new SyllableStructure(consonants, vowels, random);
	}
	
	// Choose what types of sounds will be in the inventory
	private void choosePhonemeTypes() {
		// Voicing contrast
		int voicingContrast = RandomGen.chooseIndexByWeights(random, Data.VOICING_CONTRAST_WEIGHTS);
		if (voicingContrast == 3 || voicingContrast == 1)
			plosiveVoicingContrast = true;
		if (voicingContrast == 3 || voicingContrast == 2)
			fricativeVoicingContrast = true;
		
		// Basic plosive system from /ptkbdg/
		int plosiveSystem = RandomGen.chooseIndexByWeights(random, Data.PLOSIVE_SYSTEM_WEIGHTS);
		if (plosiveSystem == 1 || plosiveSystem == 2 || plosiveSystem == 0)
			gPresent = true;
		if (plosiveSystem == 1 || plosiveSystem == 3 || plosiveSystem == 0)
			pPresent = true;
		
		// Uvular consonants
		int uvularConsonantType = RandomGen.chooseIndexByWeights(random, Data.UVULAR_WEIGHTS);
		if (uvularConsonantType == 1 || uvularConsonantType == 3)
			uvularStopsPresent = true;
		if (uvularConsonantType == 2 || uvularConsonantType == 3)
			uvularContinuantsPresent = true;
		
		// Glottalized consonants - ejectives and implosives
		int glottalizedType = RandomGen.chooseIndexByWeights(random, Data.GLOTTALIZED_WEIGHTS);
		if (glottalizedType == 1 || glottalizedType == 4 || glottalizedType == 5 || glottalizedType == 7)
			ejectivesPresent = true;
		if (glottalizedType == 2 || glottalizedType == 4 || glottalizedType == 6 || glottalizedType == 7)
			implosivesPresent = true;
		if (glottalizedType == 3 || glottalizedType == 5 || glottalizedType == 6 || glottalizedType == 7)
			resonantsPresent = true;
		
		// Lateral consonants - L sounds
		int lateralConsonantType = RandomGen.chooseIndexByWeights(random, Data.LATERAL_WEIGHTS);
		if (lateralConsonantType == 1 || lateralConsonantType == 3)
			lPresent = true;
		if (lateralConsonantType == 2)
			lateralOthersPresent = true;
		if (lateralConsonantType == 3 || lateralConsonantType == 4)
			lateralObstruentsPresent = true;
		
		// Missing consonants
		int absentConsonantType = RandomGen.chooseIndexByWeights(random, Data.COMMON_ABSENCE_WEIGHTS);
		if (absentConsonantType == 1 || absentConsonantType == 4)
			bilabialsPresent = false;
		if (absentConsonantType == 2 || absentConsonantType == 5)
			fricativesPresent = false;
		if (absentConsonantType == 3 || absentConsonantType == 4 || absentConsonantType == 5)
			nasalsPresent = false;
		
		// Presence of uncommon consonants
		int uncommonConsonantType = RandomGen.chooseIndexByWeights(random, Data.UNCOMMON_WEIGHTS);
		if (uncommonConsonantType == 1 || uncommonConsonantType == 5)
			clicksPresent = true;
		if (uncommonConsonantType == 2)
			labialVelarsPresent = true;
		if (uncommonConsonantType == 3 || uncommonConsonantType == 5 || uncommonConsonantType == 6)
			pharyngealsPresent = true;
		if (uncommonConsonantType == 4 || uncommonConsonantType == 5 || uncommonConsonantType == 6)
			thSoundsPresent = true;
		
		// Nasal vowel contrast
		if (RandomGen.chooseIndexByWeights(random, Data.NASAL_CONTRAST_WEIGHTS) == 1)
			nasalVowelContrast = true;
	}
	
	// Generate number of consonant phonemes based on possible ranges
	private void chooseConsonantInventory() {
		int i = RandomGen.chooseIndexByWeights(random, cWeights);
		
		// Choose random number within chosen range, bottom clamped to minimum, top range up to maximum value
		consonantInventory = Math.max(cMin, random.nextInt((i == cInvs.length - 1 ? cMax : cInvs[i + 1]) - cInvs[i]) + cInvs[i]);
	}
	
	// Pick number of consonants from Consonant enum equal to consonant inventory
	private void chooseConsonants() {
		// Determine which sounds must be and cannot be included
		List<Consonant> requiredConsonants = getRequiredConsonants();		
		List<Consonant> availableConsonants = createAvailableConsonants();
		
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
			
			// Uncommon consonants
			if (clicksPresent)
				addConsonant(chooseConsonantFromSet(random, Data.CLICKS), availableConsonants);
			if (labialVelarsPresent)
				addConsonant(chooseConsonantFromSet(random, Data.LABIAL_VELARS), availableConsonants);
			
			// Other consonants
			Consonant[] availableArray = new Consonant[availableConsonants.size()];
			availableArray = availableConsonants.toArray(availableArray);
			addConsonant(chooseConsonantFromSet(random, availableArray), availableConsonants);
			
			// If we run out of usable consonants
			if (availableConsonants.size() == 0)
				consonantInventory = consonants.size();
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
	private List<Consonant> createAvailableConsonants() {
		ArrayList<Consonant> availableConsonants = new ArrayList<Consonant>();
		
		// Add all consonants, not including voiced if no voicing contrast
		for (Consonant consonant : Consonant.values())
			if (plosiveVoicingContrast || !consonant.hasFeature(Consonant.Manner.STOP))
				availableConsonants.add(consonant);
			else if (fricativeVoicingContrast || !(consonant.hasFeature(Consonant.Manner.SIB_FRICATIVE) || consonant.hasFeature(Consonant.Manner.NONSIB_FRICATIVE)))
				availableConsonants.add(consonant);
		
		// Uvulars
		removeConsonantsIfAbsent(availableConsonants, uvularStopsPresent, Data.UVULAR_STOPS);
		removeConsonantsIfAbsent(availableConsonants, uvularContinuantsPresent, Data.UVULAR_FRICATIVES);
		
		// Glottalized consonants
		removeConsonantsIfAbsent(availableConsonants, ejectivesPresent, Data.EJECTIVES);
		removeConsonantsIfAbsent(availableConsonants, implosivesPresent, Data.IMPLOSIVES);
		
		// Laterals
		removeConsonantsIfAbsent(availableConsonants, lPresent, Consonant.VD_ALVEOLAR_APPROXIMANT);
		removeConsonantsIfAbsent(availableConsonants, lateralObstruentsPresent, Data.LATERAL_OBSTRUENTS);
		removeConsonantsIfAbsent(availableConsonants, lateralOthersPresent, Data.LATERAL_OTHERS);
		
		// Absence of common consonants
		removeConsonantsIfAbsent(availableConsonants, bilabialsPresent, Data.BILABIALS);
		removeConsonantsIfAbsent(availableConsonants, fricativesPresent, Data.FRICATIVES);
		removeConsonantsIfAbsent(availableConsonants, nasalsPresent, Data.NASALS);
		
		// Uncommon sounds
		removeConsonantsIfAbsent(availableConsonants, clicksPresent, Data.CLICKS);
		removeConsonantsIfAbsent(availableConsonants, labialVelarsPresent, Data.LABIAL_VELARS);
		removeConsonantsIfAbsent(availableConsonants, thSoundsPresent, Consonant.VL_DENTAL_FRICATIVE, Consonant.VD_DENTAL_FRICATIVE);
		
		return availableConsonants;
	}
	
	// Remove a set of consonants from list based on corresponding flag
	private void removeConsonantsIfAbsent(List<Consonant> originalList, boolean flag, Consonant... soundsToRemove) {
		if (!flag)
			for (Consonant sound : soundsToRemove)
				originalList.remove(sound);
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
		
		Consonant consonant =  set[RandomGen.chooseIndexByWeights(random, weights)];
		
		return consonant;
	}
	
	// Generate number of vowel phonemes based on number of consonants and typical consonant to vowel ratios
	private void chooseVowelInventory() {
		int i = RandomGen.chooseIndexByWeights(random, rWeights);
		
		// Choose random ratio in chosen range, clamp to min, divide into consonant inventory, clamp min and max
		vowelInventory = (int) Math.min(vMax,
				Math.max(vMin, Math.round(consonantInventory / Math.max(rMin,
						(random.nextDouble() * ((i == rValues.length - 1 ? rMax : rValues[i + 1]) - rValues[i])
								+ rValues[i])))));
	}
	
	// Pick number of vowels from Vowel enum equal to vowel inventory
	private void chooseVowels() {
		// Determine which sounds can be included		
		List<Vowel> availableVowels = new ArrayList<Vowel>();
		for (Vowel vowel : Vowel.values())
			availableVowels.add(vowel);
		
		// Remove missing sounds
		if (!nasalVowelContrast)
			for (Vowel vowel : Data.NASAL_VOWELS)
				availableVowels.remove(vowel);
		
		// Choosing and adding vowels to inventory
		while (vowels.size() < vowelInventory) {
			int[] weights = new int[availableVowels.size()];
			for (int i = 0; i < availableVowels.size(); ++i)
				weights[i] = availableVowels.get(i).weight();
			
			Vowel vowel = availableVowels.get(RandomGen.chooseIndexByWeights(random, weights));
			VowelPhoneme phoneme = new VowelPhoneme(vowel);
			
			if (!vowels.contains(phoneme))
				vowels.add(phoneme);
			
			availableVowels.remove(vowel);
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
