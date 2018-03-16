package gengo;

import gengo.phonology.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PhonologyBuilder {
    // Local data for phonology generation; taken from real-world data but can be changed for specific results
    private static int cMin = Data.MIN_CONSONANT_INVENTORY;
    private static int cMax = Data.MAX_CONSONANT_INVENTORY;
    private static int[] cInvs = Data.CONSONANT_INVENTORIES;
    private static int[] cWeights = Data.CONSONANT_INVENTORY_FREQUENCIES;

    private static int vMin = Data.MIN_VOWEL_INVENTORY;
    private static int vMax = Data.MAX_VOWEL_INVENTORY;

    private static double rMin = Data.MIN_CONSONANT_VOWEL_RATIO;
    private static double rMax = Data.MAX_CONSONANT_VOWEL_RATIO;
    private static double[] rValues = Data.CONSONANT_VOWEL_RATIOS;
    private static int[] rWeights = Data.CONSONANT_VOWEL_RATIO_FREQUENCIES;

    private static Phonology phonology;
    private static Random random;

    private static List<Consonant> consonants;
    private static List<Vowel> vowels;

    public static Phonology build(Random random) {
        phonology = new Phonology();
        PhonologyBuilder.random = random;

        consonants = new ArrayList<>();
        vowels = new ArrayList<>();

        new IPA();

        choosePhonemes(false);

        phonology.syllableStructure = new SyllableStructure(consonants, vowels, random);

        phonology.consonants = consonants;
        phonology.vowels = vowels;

        return phonology;
    }

    // Choose all consonants and vowels for the language, plus test flag to use all possible phonemes
    private static void choosePhonemes(boolean useAllPhonemes) {
        if (useAllPhonemes)
            getAllPhonemes();
        else {
            choosePhonemeTypes();

            chooseConsonantInventory();
            chooseConsonants();

            chooseVowelInventory();
            chooseVowels();
        }

        Collections.sort(consonants);
        Collections.sort(vowels);
    }

    private static void getAllPhonemes() {
        phonology.consonantInventory = IPA.CONSONANTS.size();
        consonants = new ArrayList<>();
        consonants.addAll(IPA.CONSONANTS);

        phonology.vowelInventory = IPA.VOWELS.size();
        vowels = new ArrayList<>();
        vowels.addAll(IPA.VOWELS);
    }

    // Choose what types of sounds will be in the inventory
    private static void choosePhonemeTypes() {
        // Voicing contrast
        int voicingContrast = RandomGen.chooseIndexByWeights(random, Data.VOICING_CONTRAST_WEIGHTS);
        if (voicingContrast == 3 || voicingContrast == 1)
            phonology.categories.plosiveVoicingContrast = true;
        if (voicingContrast == 3 || voicingContrast == 2)
            phonology.categories.fricativeVoicingContrast = true;

        // Basic plosive system from /ptkbdg/
        int plosiveSystem = RandomGen.chooseIndexByWeights(random, Data.PLOSIVE_SYSTEM_WEIGHTS);
        if (plosiveSystem == 1 || plosiveSystem == 2 || plosiveSystem == 0)
            phonology.categories.gPresent = true;
        if (plosiveSystem == 1 || plosiveSystem == 3 || plosiveSystem == 0)
            phonology.categories.pPresent = true;

        // Uvular consonants
        int uvularConsonantType = RandomGen.chooseIndexByWeights(random, Data.UVULAR_WEIGHTS);
        if (uvularConsonantType == 1 || uvularConsonantType == 3)
            phonology.categories.uvularStopsPresent = true;
        if (uvularConsonantType == 2 || uvularConsonantType == 3)
            phonology.categories.uvularContinuantsPresent = true;

        // Glottalized consonants - ejectives and implosives
        int glottalizedType = RandomGen.chooseIndexByWeights(random, Data.GLOTTALIZED_WEIGHTS);
        if (glottalizedType == 1 || glottalizedType == 4 || glottalizedType == 5 || glottalizedType == 7)
            phonology.categories.ejectivesPresent = true;
        if (glottalizedType == 2 || glottalizedType == 4 || glottalizedType == 6 || glottalizedType == 7)
            phonology.categories.implosivesPresent = true;
        if (glottalizedType == 3 || glottalizedType == 5 || glottalizedType == 6 || glottalizedType == 7)
            phonology.categories.resonantsPresent = true;

        // Lateral consonants - L sounds
        int lateralConsonantType = RandomGen.chooseIndexByWeights(random, Data.LATERAL_WEIGHTS);
        if (lateralConsonantType == 1 || lateralConsonantType == 3)
            phonology.categories.lPresent = true;
        if (lateralConsonantType == 2)
            phonology.categories.lateralOthersPresent = true;
        if (lateralConsonantType == 3 || lateralConsonantType == 4)
            phonology.categories.lateralObstruentsPresent = true;

        // Missing consonants
        int absentConsonantType = RandomGen.chooseIndexByWeights(random, Data.COMMON_ABSENCE_WEIGHTS);
        if (absentConsonantType == 1 || absentConsonantType == 4)
            phonology.categories.bilabialsPresent = false;
        if (absentConsonantType == 2 || absentConsonantType == 5)
            phonology.categories.fricativesPresent = false;
        if (absentConsonantType == 3 || absentConsonantType == 4 || absentConsonantType == 5)
            phonology.categories.nasalsPresent = false;

        // Presence of uncommon consonants
        int uncommonConsonantType = RandomGen.chooseIndexByWeights(random, Data.UNCOMMON_WEIGHTS);
        if (uncommonConsonantType == 1 || uncommonConsonantType == 5)
            phonology.categories.clicksPresent = true;
        if (uncommonConsonantType == 2)
            phonology.categories.labialVelarsPresent = true;
        if (uncommonConsonantType == 3 || uncommonConsonantType == 5 || uncommonConsonantType == 6)
            phonology.categories.pharyngealsPresent = true;
        if (uncommonConsonantType == 4 || uncommonConsonantType == 5 || uncommonConsonantType == 6)
            phonology.categories.thSoundsPresent = true;

        // Nasal vowel contrast
        if (RandomGen.chooseIndexByWeights(random, Data.NASAL_CONTRAST_WEIGHTS) == 1)
            phonology.categories.nasalVowelContrast = true;
    }

    // Generate number of consonant phonemes based on possible ranges
    private static void chooseConsonantInventory() {
        int i = RandomGen.chooseIndexByWeights(random, cWeights);

        // Choose random number within chosen range, bottom clamped to minimum, top range up to maximum value
        phonology.consonantInventory = Math.max(cMin, random.nextInt((i == cInvs.length - 1 ? cMax : cInvs[i + 1]) - cInvs[i]) + cInvs[i]);
    }

    // Pick number of consonants from Consonant enum equal to consonant inventory
    private static void chooseConsonants() {
        // Determine which sounds must be and cannot be included
        List<Consonant> requiredConsonants = getRequiredConsonants();
        List<Consonant> availableConsonants = createAvailableConsonants();

        // Add required consonants
        for (Consonant consonant : requiredConsonants)
            addConsonant(consonant, availableConsonants);

        // Choosing and adding consonants to inventory
        while (consonants.size() < phonology.consonantInventory) {
            // Uvulars
            if (phonology.categories.uvularStopsPresent)
                addConsonant(chooseConsonantFromSet(IPA.UVULAR_STOPS), availableConsonants);
            if (phonology.categories.uvularContinuantsPresent)
                addConsonant(chooseConsonantFromSet(IPA.UVULAR_FRICATIVES), availableConsonants);

            // Glottalized consonants
            if (phonology.categories.ejectivesPresent)
                addConsonant(chooseConsonantFromSet(IPA.EJECTIVES), availableConsonants);
            if (phonology.categories.implosivesPresent)
                addConsonant(chooseConsonantFromSet(IPA.IMPLOSIVES), availableConsonants);

            // Lateral consonants
            if (phonology.categories.lateralObstruentsPresent)
                addConsonant(chooseConsonantFromSet(IPA.LATERAL_OBSTRUENTS), availableConsonants);
            if (phonology.categories.lateralOthersPresent)
                addConsonant(chooseConsonantFromSet(IPA.LATERAL_OTHERS), availableConsonants);

            // Uncommon consonants
            if (phonology.categories.clicksPresent)
                addConsonant(chooseConsonantFromSet(IPA.CLICKS), availableConsonants);
            if (phonology.categories.labialVelarsPresent)
                addConsonant(chooseConsonantFromSet(IPA.LABIAL_VELARS), availableConsonants);

            // Other consonants
            Consonant[] availableArray = new Consonant[availableConsonants.size()];
            availableArray = availableConsonants.toArray(availableArray);
            addConsonant(chooseConsonantFromSet(availableArray), availableConsonants);

            // If we run out of usable consonants
            if (availableConsonants.size() == 0)
                phonology.consonantInventory = consonants.size();
        }
    }

    // Make a list of all consonants that must be added
    private static List<Consonant> getRequiredConsonants() {
        ArrayList<Consonant> requiredConsonants = new ArrayList<>();

        // Plosive system - /ptkbdg/
        if (phonology.categories.pPresent)
            requiredConsonants.add(IPA.VL_BILABIAL_STOP);
        requiredConsonants.add(IPA.VL_ALVEOLAR_STOP);
        requiredConsonants.add(IPA.VL_VELAR_STOP);

        if (phonology.categories.plosiveVoicingContrast) {
            requiredConsonants.add(IPA.VD_BILABIAL_STOP);
            requiredConsonants.add(IPA.VD_ALVEOLAR_STOP);
            if (phonology.categories.gPresent)
                requiredConsonants.add(IPA.VD_VELAR_STOP);
        }

        // L sound
        if (phonology.categories.lPresent)
            requiredConsonants.add(IPA.VD_ALVEOLAR_LAT_APPROXIMANT);

        // Th sounds
        if (phonology.categories.thSoundsPresent) {
            requiredConsonants.add(IPA.VL_DENTAL_FRICATIVE);
            if (phonology.categories.fricativeVoicingContrast)
                requiredConsonants.add(IPA.VD_DENTAL_FRICATIVE);
        }

        return requiredConsonants;
    }

    // Make a list of all consonants minus ones that are not included
    private static List<Consonant> createAvailableConsonants() {
        ArrayList<Consonant> availableConsonants = new ArrayList<>();


        // Add all consonants, not including voiced if no voicing contrast
        for (Consonant consonant : IPA.CONSONANTS)
            if (phonology.categories.plosiveVoicingContrast || !consonant.hasFeatures(Consonant.Manner.STOP, Consonant.Voice.VOICED))
                availableConsonants.add(consonant);
            else if (phonology.categories.fricativeVoicingContrast || !(consonant.hasFeature(Consonant.Voice.VOICED) && (consonant.hasFeature(Consonant.Manner.SIB_FRICATIVE) || consonant.hasFeature(Consonant.Manner.NONSIB_FRICATIVE))))
                availableConsonants.add(consonant);

        // Basic plosives
        removeConsonantsIfAbsent(availableConsonants, phonology.categories.pPresent, IPA.VL_BILABIAL_STOP);
        removeConsonantsIfAbsent(availableConsonants, phonology.categories.gPresent, IPA.VD_VELAR_STOP);

        // Uvulars
        removeConsonantsIfAbsent(availableConsonants, phonology.categories.uvularStopsPresent, IPA.UVULAR_STOPS);
        removeConsonantsIfAbsent(availableConsonants, phonology.categories.uvularContinuantsPresent, IPA.UVULAR_FRICATIVES);

        // Glottalized consonants
        removeConsonantsIfAbsent(availableConsonants, phonology.categories.ejectivesPresent, IPA.EJECTIVES);
        removeConsonantsIfAbsent(availableConsonants, phonology.categories.implosivesPresent, IPA.IMPLOSIVES);

        // Laterals
        removeConsonantsIfAbsent(availableConsonants, phonology.categories.lPresent, IPA.VD_ALVEOLAR_APPROXIMANT);
        removeConsonantsIfAbsent(availableConsonants, phonology.categories.lateralObstruentsPresent, IPA.LATERAL_OBSTRUENTS);
        removeConsonantsIfAbsent(availableConsonants, phonology.categories.lateralOthersPresent, IPA.LATERAL_OTHERS);

        // Absence of common consonants
        removeConsonantsIfAbsent(availableConsonants, phonology.categories.bilabialsPresent, IPA.BILABIALS);
        removeConsonantsIfAbsent(availableConsonants, phonology.categories.fricativesPresent, IPA.FRICATIVES);
        removeConsonantsIfAbsent(availableConsonants, phonology.categories.nasalsPresent, IPA.NASALS);

        // Uncommon sounds
        removeConsonantsIfAbsent(availableConsonants, phonology.categories.clicksPresent, IPA.CLICKS);
        removeConsonantsIfAbsent(availableConsonants, phonology.categories.labialVelarsPresent, IPA.LABIAL_VELARS);
        removeConsonantsIfAbsent(availableConsonants, phonology.categories.thSoundsPresent, IPA.VL_DENTAL_FRICATIVE, IPA.VD_DENTAL_FRICATIVE);

        return availableConsonants;
    }

    // Remove a set of consonants from list based on corresponding flag
    private static void removeConsonantsIfAbsent(List<Consonant> originalList, boolean flag, Consonant... soundsToRemove) {
        if (!flag)
            for (Consonant sound : soundsToRemove)
                originalList.remove(sound);
    }

    // Add one consonant to inventory
    private static void addConsonant(Consonant consonant, List<Consonant> availableConsonants) {
        if (!availableConsonants.contains(consonant)) return;

        if (!consonants.contains(consonant))
            consonants.add(consonant);

        availableConsonants.remove(consonant);
    }

    // Pick one consonant from a predefined list
    private static Consonant chooseConsonantFromSet(Consonant[] set) {
        int[] weights = new int[set.length];
        for (int i = 0; i < set.length; ++i)
            weights[i] = set[i].weight();

        return set[RandomGen.chooseIndexByWeights(random, weights)];
    }

    // Generate number of vowel phonemes based on number of consonants and typical consonant to vowel ratios
    private static void chooseVowelInventory() {
        int i = RandomGen.chooseIndexByWeights(random, rWeights);

        // Choose random ratio in chosen range, clamp to min, divide into consonant inventory, clamp min and max
        phonology.vowelInventory = (int) Math.min(vMax,
                Math.max(vMin, Math.round(phonology.consonantInventory / Math.max(rMin,
                        (random.nextDouble() * ((i == rValues.length - 1 ? rMax : rValues[i + 1]) - rValues[i])
                                + rValues[i])))));
    }

    // Pick number of vowels from Vowel enum equal to vowel inventory
    private static void chooseVowels() {
        // Determine which sounds can be included
        List<Vowel> availableVowels = new ArrayList<>(IPA.VOWELS);

        // Remove missing sounds
        if (!phonology.categories.nasalVowelContrast)
            for (Vowel vowel : IPA.NASAL_VOWELS)
                availableVowels.remove(vowel);

        // Choosing and adding vowels to inventory
        while (vowels.size() < phonology.vowelInventory) {
            int[] weights = new int[availableVowels.size()];
            for (int i = 0; i < availableVowels.size(); ++i)
                weights[i] = availableVowels.get(i).weight();

            Vowel vowel = availableVowels.get(RandomGen.chooseIndexByWeights(random, weights));

            if (!vowels.contains(vowel))
                vowels.add(vowel);

            availableVowels.remove(vowel);
        }
    }
}
