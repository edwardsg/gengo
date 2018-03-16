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

    public static Phonology build(Random random) {
        phonology = new Phonology();
        PhonologyBuilder.random = random;

        phonology.consonants = new ArrayList<>();
        phonology.vowels = new ArrayList<>();

        new IPA();

        choosePhonemes(false);

        phonology.syllableStructure = new SyllableStructure(phonology.consonants, phonology.vowels, random);

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

        Collections.sort(phonology.consonants);
        Collections.sort(phonology.vowels);
    }

    private static void getAllPhonemes() {
        phonology.consonantInventory = IPA.CONSONANTS.size();
        phonology.consonants = new ArrayList<>();
        phonology.consonants.addAll(IPA.CONSONANTS);

        phonology.vowelInventory = IPA.VOWELS.size();
        phonology.vowels = new ArrayList<>();
        phonology.vowels.addAll(IPA.VOWELS);
    }

    // Choose what types of sounds will be in the inventory
    private static void choosePhonemeTypes() {
        // Voicing contrast
        int voicingContrast = RandomGen.chooseIndexByWeights(random, Data.VOICING_CONTRAST_WEIGHTS);
        if (voicingContrast == 3 || voicingContrast == 1)
            phonology.plosiveVoicingContrast = true;
        if (voicingContrast == 3 || voicingContrast == 2)
            phonology.fricativeVoicingContrast = true;

        // Basic plosive system from /ptkbdg/
        int plosiveSystem = RandomGen.chooseIndexByWeights(random, Data.PLOSIVE_SYSTEM_WEIGHTS);
        if (plosiveSystem == 1 || plosiveSystem == 2 || plosiveSystem == 0)
            phonology.gPresent = true;
        if (plosiveSystem == 1 || plosiveSystem == 3 || plosiveSystem == 0)
            phonology.pPresent = true;

        // Uvular consonants
        int uvularConsonantType = RandomGen.chooseIndexByWeights(random, Data.UVULAR_WEIGHTS);
        if (uvularConsonantType == 1 || uvularConsonantType == 3)
            phonology.uvularStopsPresent = true;
        if (uvularConsonantType == 2 || uvularConsonantType == 3)
            phonology.uvularContinuantsPresent = true;

        // Glottalized consonants - ejectives and implosives
        int glottalizedType = RandomGen.chooseIndexByWeights(random, Data.GLOTTALIZED_WEIGHTS);
        if (glottalizedType == 1 || glottalizedType == 4 || glottalizedType == 5 || glottalizedType == 7)
            phonology.ejectivesPresent = true;
        if (glottalizedType == 2 || glottalizedType == 4 || glottalizedType == 6 || glottalizedType == 7)
            phonology.implosivesPresent = true;
        if (glottalizedType == 3 || glottalizedType == 5 || glottalizedType == 6 || glottalizedType == 7)
            phonology.resonantsPresent = true;

        // Lateral consonants - L sounds
        int lateralConsonantType = RandomGen.chooseIndexByWeights(random, Data.LATERAL_WEIGHTS);
        if (lateralConsonantType == 1 || lateralConsonantType == 3)
            phonology.lPresent = true;
        if (lateralConsonantType == 2)
            phonology.lateralOthersPresent = true;
        if (lateralConsonantType == 3 || lateralConsonantType == 4)
            phonology.lateralObstruentsPresent = true;

        // Missing consonants
        int absentConsonantType = RandomGen.chooseIndexByWeights(random, Data.COMMON_ABSENCE_WEIGHTS);
        if (absentConsonantType == 1 || absentConsonantType == 4)
            phonology.bilabialsPresent = false;
        if (absentConsonantType == 2 || absentConsonantType == 5)
            phonology.fricativesPresent = false;
        if (absentConsonantType == 3 || absentConsonantType == 4 || absentConsonantType == 5)
            phonology.nasalsPresent = false;

        // Presence of uncommon consonants
        int uncommonConsonantType = RandomGen.chooseIndexByWeights(random, Data.UNCOMMON_WEIGHTS);
        if (uncommonConsonantType == 1 || uncommonConsonantType == 5)
            phonology.clicksPresent = true;
        if (uncommonConsonantType == 2)
            phonology.labialVelarsPresent = true;
        if (uncommonConsonantType == 3 || uncommonConsonantType == 5 || uncommonConsonantType == 6)
            phonology.pharyngealsPresent = true;
        if (uncommonConsonantType == 4 || uncommonConsonantType == 5 || uncommonConsonantType == 6)
            phonology.thSoundsPresent = true;

        // Nasal vowel contrast
        if (RandomGen.chooseIndexByWeights(random, Data.NASAL_CONTRAST_WEIGHTS) == 1)
            phonology.nasalVowelContrast = true;
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
        while (phonology.consonants.size() < phonology.consonantInventory) {
            // Uvulars
            if (phonology.uvularStopsPresent)
                addConsonant(chooseConsonantFromSet(IPA.UVULAR_STOPS), availableConsonants);
            if (phonology.uvularContinuantsPresent)
                addConsonant(chooseConsonantFromSet(IPA.UVULAR_FRICATIVES), availableConsonants);

            // Glottalized consonants
            if (phonology.ejectivesPresent)
                addConsonant(chooseConsonantFromSet(IPA.EJECTIVES), availableConsonants);
            if (phonology.implosivesPresent)
                addConsonant(chooseConsonantFromSet(IPA.IMPLOSIVES), availableConsonants);

            // Lateral consonants
            if (phonology.lateralObstruentsPresent)
                addConsonant(chooseConsonantFromSet(IPA.LATERAL_OBSTRUENTS), availableConsonants);
            if (phonology.lateralOthersPresent)
                addConsonant(chooseConsonantFromSet(IPA.LATERAL_OTHERS), availableConsonants);

            // Uncommon consonants
            if (phonology.clicksPresent)
                addConsonant(chooseConsonantFromSet(IPA.CLICKS), availableConsonants);
            if (phonology.labialVelarsPresent)
                addConsonant(chooseConsonantFromSet(IPA.LABIAL_VELARS), availableConsonants);

            // Other consonants
            Consonant[] availableArray = new Consonant[availableConsonants.size()];
            availableArray = availableConsonants.toArray(availableArray);
            addConsonant(chooseConsonantFromSet(availableArray), availableConsonants);

            // If we run out of usable consonants
            if (availableConsonants.size() == 0)
                phonology.consonantInventory = phonology.consonants.size();
        }
    }

    // Make a list of all consonants that must be added
    private static List<Consonant> getRequiredConsonants() {
        ArrayList<Consonant> requiredConsonants = new ArrayList<>();

        // Plosive system - /ptkbdg/
        if (phonology.pPresent)
            requiredConsonants.add(IPA.VL_BILABIAL_STOP);
        requiredConsonants.add(IPA.VL_ALVEOLAR_STOP);
        requiredConsonants.add(IPA.VL_VELAR_STOP);

        if (phonology.plosiveVoicingContrast) {
            requiredConsonants.add(IPA.VD_BILABIAL_STOP);
            requiredConsonants.add(IPA.VD_ALVEOLAR_STOP);
            if (phonology.gPresent)
                requiredConsonants.add(IPA.VD_VELAR_STOP);
        }

        // L sound
        if (phonology.lPresent)
            requiredConsonants.add(IPA.VD_ALVEOLAR_LAT_APPROXIMANT);

        // Th sounds
        if (phonology.thSoundsPresent) {
            requiredConsonants.add(IPA.VL_DENTAL_FRICATIVE);
            if (phonology.fricativeVoicingContrast)
                requiredConsonants.add(IPA.VD_DENTAL_FRICATIVE);
        }

        return requiredConsonants;
    }

    // Make a list of all consonants minus ones that are not included
    private static List<Consonant> createAvailableConsonants() {
        ArrayList<Consonant> availableConsonants = new ArrayList<>();


        // Add all consonants, not including voiced if no voicing contrast
        for (Consonant consonant : IPA.CONSONANTS)
            if (phonology.plosiveVoicingContrast || !consonant.hasFeatures(Consonant.Manner.STOP, Consonant.Voice.VOICED))
                availableConsonants.add(consonant);
            else if (phonology.fricativeVoicingContrast || !(consonant.hasFeature(Consonant.Voice.VOICED) && (consonant.hasFeature(Consonant.Manner.SIB_FRICATIVE) || consonant.hasFeature(Consonant.Manner.NONSIB_FRICATIVE))))
                availableConsonants.add(consonant);

        // Basic plosives
        removeConsonantsIfAbsent(availableConsonants, phonology.pPresent, IPA.VL_BILABIAL_STOP);
        removeConsonantsIfAbsent(availableConsonants, phonology.gPresent, IPA.VD_VELAR_STOP);

        // Uvulars
        removeConsonantsIfAbsent(availableConsonants, phonology.uvularStopsPresent, IPA.UVULAR_STOPS);
        removeConsonantsIfAbsent(availableConsonants, phonology.uvularContinuantsPresent, IPA.UVULAR_FRICATIVES);

        // Glottalized consonants
        removeConsonantsIfAbsent(availableConsonants, phonology.ejectivesPresent, IPA.EJECTIVES);
        removeConsonantsIfAbsent(availableConsonants, phonology.implosivesPresent, IPA.IMPLOSIVES);

        // Laterals
        removeConsonantsIfAbsent(availableConsonants, phonology.lPresent, IPA.VD_ALVEOLAR_APPROXIMANT);
        removeConsonantsIfAbsent(availableConsonants, phonology.lateralObstruentsPresent, IPA.LATERAL_OBSTRUENTS);
        removeConsonantsIfAbsent(availableConsonants, phonology.lateralOthersPresent, IPA.LATERAL_OTHERS);

        // Absence of common consonants
        removeConsonantsIfAbsent(availableConsonants, phonology.bilabialsPresent, IPA.BILABIALS);
        removeConsonantsIfAbsent(availableConsonants, phonology.fricativesPresent, IPA.FRICATIVES);
        removeConsonantsIfAbsent(availableConsonants, phonology.nasalsPresent, IPA.NASALS);

        // Uncommon sounds
        removeConsonantsIfAbsent(availableConsonants, phonology.clicksPresent, IPA.CLICKS);
        removeConsonantsIfAbsent(availableConsonants, phonology.labialVelarsPresent, IPA.LABIAL_VELARS);
        removeConsonantsIfAbsent(availableConsonants, phonology.thSoundsPresent, IPA.VL_DENTAL_FRICATIVE, IPA.VD_DENTAL_FRICATIVE);

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

        if (!phonology.consonants.contains(consonant))
            phonology.consonants.add(consonant);

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
        if (!phonology.nasalVowelContrast)
            for (Vowel vowel : IPA.NASAL_VOWELS)
                availableVowels.remove(vowel);

        // Choosing and adding vowels to inventory
        while (phonology.vowels.size() < phonology.vowelInventory) {
            int[] weights = new int[availableVowels.size()];
            for (int i = 0; i < availableVowels.size(); ++i)
                weights[i] = availableVowels.get(i).weight();

            Vowel vowel = availableVowels.get(RandomGen.chooseIndexByWeights(random, weights));

            if (!phonology.vowels.contains(vowel))
                phonology.vowels.add(vowel);

            availableVowels.remove(vowel);
        }
    }
}
