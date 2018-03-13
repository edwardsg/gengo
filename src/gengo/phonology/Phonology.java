package gengo.phonology;

import java.util.List;

/* Contains phonological information for a language, including phonemes and syllable structure */
public class Phonology {
    public int consonantInventory;
    public int vowelInventory;

    public List<Consonant> consonants;
    public List<Vowel> vowels;

    public SyllableStructure syllableStructure;

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
}
