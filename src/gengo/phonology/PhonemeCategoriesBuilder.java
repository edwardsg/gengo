package gengo.phonology;

import gengo.RandomGen;

import java.util.Random;

public class PhonemeCategoriesBuilder {
    private Random random;
    private PhonemeCategories categories;

    public PhonemeCategoriesBuilder(Random random) {
        this.random = random;
        categories = new PhonemeCategories();
    }

    public PhonemeCategories build() {
        choosePhonemeTypes();
        return categories;
    }

    private void choosePhonemeTypes() {
        chooseVoicingContrasts();
        chooseBasicPlosives();
        chooseUvulars();
        chooseGlottalizedConsonants();
        chooseLaterals();
        chooseAbsentConsonants();
        chooseUncommonConsonants();
        chooseNasalVowelContrast();
    }

    private void chooseVoicingContrasts() {
        int voicingContrast = RandomGen.chooseIndexByWeights(random, Data.VOICING_CONTRAST_WEIGHTS);
        if (voicingContrast == 3 || voicingContrast == 1)
            categories.plosiveVoicingContrast = true;
        if (voicingContrast == 3 || voicingContrast == 2)
            categories.fricativeVoicingContrast = true;
    }

    private void chooseBasicPlosives() {
        int plosiveSystem = RandomGen.chooseIndexByWeights(random, Data.PLOSIVE_SYSTEM_WEIGHTS);
        if (plosiveSystem == 1 || plosiveSystem == 2 || plosiveSystem == 0)
            categories.gPresent = true;
        if (plosiveSystem == 1 || plosiveSystem == 3 || plosiveSystem == 0)
            categories.pPresent = true;
    }

    private void chooseUvulars() {
        int uvularConsonantType = RandomGen.chooseIndexByWeights(random, Data.UVULAR_WEIGHTS);
        if (uvularConsonantType == 1 || uvularConsonantType == 3)
            categories.uvularStopsPresent = true;
        if (uvularConsonantType == 2 || uvularConsonantType == 3)
            categories.uvularContinuantsPresent = true;
    }

    private void chooseGlottalizedConsonants() {
        int glottalizedType = RandomGen.chooseIndexByWeights(random, Data.GLOTTALIZED_WEIGHTS);
        if (glottalizedType == 1 || glottalizedType == 4 || glottalizedType == 5 || glottalizedType == 7)
            categories.ejectivesPresent = true;
        if (glottalizedType == 2 || glottalizedType == 4 || glottalizedType == 6 || glottalizedType == 7)
            categories.implosivesPresent = true;
        if (glottalizedType == 3 || glottalizedType == 5 || glottalizedType == 6 || glottalizedType == 7)
            categories.resonantsPresent = true;
    }

    private void chooseLaterals() {
        int lateralConsonantType = RandomGen.chooseIndexByWeights(random, Data.LATERAL_WEIGHTS);
        if (lateralConsonantType == 1 || lateralConsonantType == 3)
            categories.lPresent = true;
        if (lateralConsonantType == 2)
            categories.lateralOthersPresent = true;
        if (lateralConsonantType == 3 || lateralConsonantType == 4)
            categories.lateralObstruentsPresent = true;
    }

    private void chooseAbsentConsonants() {
        int absentConsonantType = RandomGen.chooseIndexByWeights(random, Data.COMMON_ABSENCE_WEIGHTS);
        if (absentConsonantType == 1 || absentConsonantType == 4)
            categories.bilabialsPresent = false;
        if (absentConsonantType == 2 || absentConsonantType == 5)
            categories.fricativesPresent = false;
        if (absentConsonantType == 3 || absentConsonantType == 4 || absentConsonantType == 5)
            categories.nasalsPresent = false;
    }

    private void chooseUncommonConsonants() {
        int uncommonConsonantType = RandomGen.chooseIndexByWeights(random, Data.UNCOMMON_WEIGHTS);
        if (uncommonConsonantType == 1 || uncommonConsonantType == 5)
            categories.clicksPresent = true;
        if (uncommonConsonantType == 2)
            categories.labialVelarsPresent = true;
        if (uncommonConsonantType == 3 || uncommonConsonantType == 5 || uncommonConsonantType == 6)
            categories.pharyngealsPresent = true;
        if (uncommonConsonantType == 4 || uncommonConsonantType == 5 || uncommonConsonantType == 6)
            categories.thSoundsPresent = true;
    }

    private void chooseNasalVowelContrast() {
        if (RandomGen.chooseIndexByWeights(random, Data.NASAL_CONTRAST_WEIGHTS) == 1)
            categories.nasalVowelContrast = true;
    }
}
