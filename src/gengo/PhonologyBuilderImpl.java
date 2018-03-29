package gengo;

import gengo.phonology.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class PhonologyBuilderImpl implements PhonologyBuilder {
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


    private Random random;

    private PhonemeCategories categories;

    private int consonantCount;
    private int vowelCount;

    private List<Consonant> consonantsToAdd;
    private List<Vowel> vowelsToAdd;

    PhonologyBuilderImpl(Random random) {
        this.random = random;
    }

    @Override
    public Phonology build() {
        consonantsToAdd = new ArrayList<>();
        vowelsToAdd = new ArrayList<>();
        categories = new PhonemeCategoriesBuilder(random).build();

        new IPA();

        choosePhonemes(false);

        SyllableStructure syllable = new SyllableStructure(consonantsToAdd, vowelsToAdd, random);

        return new Phonology() {{
            phonemeCategories = categories;
            consonantInventory = consonantCount;
            vowelInventory = vowelCount;
            consonants = consonantsToAdd;
            vowels = vowelsToAdd;
            syllableStructure = syllable;
        }};
    }

    // Choose all consonants and vowels for the language, plus test flag to use all possible phonemes
    private void choosePhonemes(boolean useAllPhonemes) {
        if (useAllPhonemes)
            getAllPhonemes();
        else {
            chooseConsonantInventory();
            chooseConsonants();

            chooseVowelInventory();
            chooseVowels();
        }

        Collections.sort(consonantsToAdd);
        Collections.sort(vowelsToAdd);
    }

    private void getAllPhonemes() {
        consonantCount = IPA.CONSONANTS.size();
        consonantsToAdd = new ArrayList<>();
        consonantsToAdd.addAll(IPA.CONSONANTS);

        vowelCount = IPA.VOWELS.size();
        vowelsToAdd = new ArrayList<>();
        vowelsToAdd.addAll(IPA.VOWELS);
    }

    // Generate number of consonant phonemes based on possible ranges
    private void chooseConsonantInventory() {
        int i = RandomGen.chooseIndexByWeights(random, cWeights);

        // Choose random number within chosen range, bottom clamped to minimum, top range up to maximum value
        consonantCount = Math.max(cMin, random.nextInt((i == cInvs.length - 1 ? cMax : cInvs[i + 1]) - cInvs[i]) + cInvs[i]);
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
        while (consonantsToAdd.size() < consonantCount) {
            // Uvulars
            if (categories.uvularStopsPresent)
                addConsonant(chooseConsonantFromSet(IPA.UVULAR_STOPS), availableConsonants);
            if (categories.uvularContinuantsPresent)
                addConsonant(chooseConsonantFromSet(IPA.UVULAR_FRICATIVES), availableConsonants);

            // Glottalized consonants
            if (categories.ejectivesPresent)
                addConsonant(chooseConsonantFromSet(IPA.EJECTIVES), availableConsonants);
            if (categories.implosivesPresent)
                addConsonant(chooseConsonantFromSet(IPA.IMPLOSIVES), availableConsonants);

            // Lateral consonants
            if (categories.lateralObstruentsPresent)
                addConsonant(chooseConsonantFromSet(IPA.LATERAL_OBSTRUENTS), availableConsonants);
            if (categories.lateralOthersPresent)
                addConsonant(chooseConsonantFromSet(IPA.LATERAL_OTHERS), availableConsonants);

            // Uncommon consonants
            if (categories.clicksPresent)
                addConsonant(chooseConsonantFromSet(IPA.CLICKS), availableConsonants);
            if (categories.labialVelarsPresent)
                addConsonant(chooseConsonantFromSet(IPA.LABIAL_VELARS), availableConsonants);

            // Other consonants
            Consonant[] availableArray = new Consonant[availableConsonants.size()];
            availableArray = availableConsonants.toArray(availableArray);
            addConsonant(chooseConsonantFromSet(availableArray), availableConsonants);

            // If we run out of usable consonants
            if (availableConsonants.size() == 0)
                consonantCount = consonantsToAdd.size();
        }
    }

    // Make a list of all consonants that must be added
    private List<Consonant> getRequiredConsonants() {
        ArrayList<Consonant> requiredConsonants = new ArrayList<>();

        // Plosive system - /ptkbdg/
        if (categories.pPresent)
            requiredConsonants.add(IPA.VL_BILABIAL_STOP);
        requiredConsonants.add(IPA.VL_ALVEOLAR_STOP);
        requiredConsonants.add(IPA.VL_VELAR_STOP);

        if (categories.plosiveVoicingContrast) {
            requiredConsonants.add(IPA.VD_BILABIAL_STOP);
            requiredConsonants.add(IPA.VD_ALVEOLAR_STOP);
            if (categories.gPresent)
                requiredConsonants.add(IPA.VD_VELAR_STOP);
        }

        // L sound
        if (categories.lPresent)
            requiredConsonants.add(IPA.VD_ALVEOLAR_LAT_APPROXIMANT);

        // Th sounds
        if (categories.thSoundsPresent) {
            requiredConsonants.add(IPA.VL_DENTAL_FRICATIVE);
            if (categories.fricativeVoicingContrast)
                requiredConsonants.add(IPA.VD_DENTAL_FRICATIVE);
        }

        return requiredConsonants;
    }

    // Make a list of all consonants minus ones that are not included
    private List<Consonant> createAvailableConsonants() {
        ArrayList<Consonant> availableConsonants = new ArrayList<>();


        // Add all consonants, not including voiced if no voicing contrast
        for (Consonant consonant : IPA.CONSONANTS)
            if (categories.plosiveVoicingContrast || !consonant.hasFeatures(Consonant.Manner.STOP, Consonant.Voice.VOICED))
                availableConsonants.add(consonant);
            else if (categories.fricativeVoicingContrast || !(consonant.hasFeature(Consonant.Voice.VOICED) && (consonant.hasFeature(Consonant.Manner.SIB_FRICATIVE) || consonant.hasFeature(Consonant.Manner.NONSIB_FRICATIVE))))
                availableConsonants.add(consonant);

        // Basic plosives
        removeConsonantsIfAbsent(availableConsonants, categories.pPresent, IPA.VL_BILABIAL_STOP);
        removeConsonantsIfAbsent(availableConsonants, categories.gPresent, IPA.VD_VELAR_STOP);

        // Uvulars
        removeConsonantsIfAbsent(availableConsonants, categories.uvularStopsPresent, IPA.UVULAR_STOPS);
        removeConsonantsIfAbsent(availableConsonants, categories.uvularContinuantsPresent, IPA.UVULAR_FRICATIVES);

        // Glottalized consonants
        removeConsonantsIfAbsent(availableConsonants, categories.ejectivesPresent, IPA.EJECTIVES);
        removeConsonantsIfAbsent(availableConsonants, categories.implosivesPresent, IPA.IMPLOSIVES);

        // Laterals
        removeConsonantsIfAbsent(availableConsonants, categories.lPresent, IPA.VD_ALVEOLAR_APPROXIMANT);
        removeConsonantsIfAbsent(availableConsonants, categories.lateralObstruentsPresent, IPA.LATERAL_OBSTRUENTS);
        removeConsonantsIfAbsent(availableConsonants, categories.lateralOthersPresent, IPA.LATERAL_OTHERS);

        // Absence of common consonants
        removeConsonantsIfAbsent(availableConsonants, categories.bilabialsPresent, IPA.BILABIALS);
        removeConsonantsIfAbsent(availableConsonants, categories.fricativesPresent, IPA.FRICATIVES);
        removeConsonantsIfAbsent(availableConsonants, categories.nasalsPresent, IPA.NASALS);

        // Uncommon sounds
        removeConsonantsIfAbsent(availableConsonants, categories.clicksPresent, IPA.CLICKS);
        removeConsonantsIfAbsent(availableConsonants, categories.labialVelarsPresent, IPA.LABIAL_VELARS);
        removeConsonantsIfAbsent(availableConsonants, categories.thSoundsPresent, IPA.VL_DENTAL_FRICATIVE, IPA.VD_DENTAL_FRICATIVE);

        return availableConsonants;
    }

    // Remove a set of consonants from list based on corresponding flag
    private static void removeConsonantsIfAbsent(List<Consonant> originalList, boolean flag, Consonant... soundsToRemove) {
        if (!flag)
            for (Consonant sound : soundsToRemove)
                originalList.remove(sound);
    }

    // Add one consonant to inventory
    private void addConsonant(Consonant consonant, List<Consonant> availableConsonants) {
        if (!availableConsonants.contains(consonant)) return;

        if (!consonantsToAdd.contains(consonant))
            consonantsToAdd.add(consonant);

        availableConsonants.remove(consonant);
    }

    // Pick one consonant from a predefined list
    private Consonant chooseConsonantFromSet(Consonant[] set) {
        int[] weights = new int[set.length];
        for (int i = 0; i < set.length; ++i)
            weights[i] = set[i].weight();

        return set[RandomGen.chooseIndexByWeights(random, weights)];
    }

    // Generate number of vowel phonemes based on number of consonants and typical consonant to vowel ratios
    private void chooseVowelInventory() {
        int i = RandomGen.chooseIndexByWeights(random, rWeights);

        // Choose random ratio in chosen range, clamp to min, divide into consonant inventory, clamp min and max
        vowelCount = (int) Math.min(vMax,
                Math.max(vMin, Math.round(consonantCount / Math.max(rMin,
                        (random.nextDouble() * ((i == rValues.length - 1 ? rMax : rValues[i + 1]) - rValues[i])
                                + rValues[i])))));
    }

    // Pick number of vowels from Vowel enum equal to vowel inventory
    private void chooseVowels() {
        // Determine which sounds can be included
        List<Vowel> availableVowels = new ArrayList<>(IPA.VOWELS);

        // Remove missing sounds
        if (!categories.nasalVowelContrast)
            for (Vowel vowel : IPA.NASAL_VOWELS)
                availableVowels.remove(vowel);

        // Choosing and adding vowels to inventory
        while (vowelsToAdd.size() < vowelCount) {
            int[] weights = new int[availableVowels.size()];
            for (int i = 0; i < availableVowels.size(); ++i)
                weights[i] = availableVowels.get(i).weight();

            Vowel vowel = availableVowels.get(RandomGen.chooseIndexByWeights(random, weights));

            if (!vowelsToAdd.contains(vowel))
                vowelsToAdd.add(vowel);

            availableVowels.remove(vowel);
        }
    }
}
