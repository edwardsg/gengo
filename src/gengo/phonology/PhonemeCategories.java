package gengo.phonology;

public class PhonemeCategories {
    // Voicing contrast
    public boolean plosiveVoicingContrast = false;
    public boolean fricativeVoicingContrast = false;

    // Basic plosive system from /ptkbdg/
    public boolean pPresent = false;
    public boolean gPresent = false;

    // Uvular consonants
    public boolean uvularStopsPresent = false;
    public boolean uvularContinuantsPresent = false;

    // Glottalized consonants - ejectives and implosives
    public boolean ejectivesPresent = false;
    public boolean implosivesPresent = false;
    public boolean resonantsPresent = false;

    // Lateral consonants - L sounds
    public boolean lPresent = false;
    public boolean lateralObstruentsPresent = false;
    public boolean lateralOthersPresent = false;

    // Missing consonants
    public boolean bilabialsPresent = true;
    public boolean fricativesPresent = true;
    public boolean nasalsPresent = true;

    // Presence of uncommon consonants
    public boolean clicksPresent = false;
    public boolean labialVelarsPresent = false;
    public boolean pharyngealsPresent = false;
    public boolean thSoundsPresent = false;

    // Nasal vowel contrast
    public boolean nasalVowelContrast = false;
}
