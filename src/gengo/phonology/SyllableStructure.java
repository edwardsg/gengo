package gengo.phonology;

import gengo.RandomGen;

import java.util.List;
import java.util.Random;

/* Contains rules and structure for creating syllables */
public class SyllableStructure {
    private int[] complexityWeights = Data.SYLLABLE_COMPLEXITY_FREQUENCIES;
    
    private Random random;
    
    private Cluster onset;
    private Nucleus nucleus;
    private Cluster coda;
    
    private boolean geminationAllowed;
    
    private List<Consonant> consonants;
    private List<Vowel> vowels;
    
    private Phoneme previousPhoneme = null;
    
    SyllableStructure(List<Consonant> consonants, List<Vowel> vowels, Random random) {
        this.random = random;
        this.consonants = consonants;
        this.vowels = vowels;
        
        geminationAllowed = random.nextBoolean();
        
        createSyllableStructure();
    }
    
    // Create more or less complex syllable structure based on WALS data
    private void createSyllableStructure() {
        // Choose complexity of 0, 1, or 2 based real world occurrence
        int syllableComplexity = RandomGen.chooseIndexByWeights(random, complexityWeights);
        
        // Syllable nucleus is essentially the same for every language
        nucleus = new Nucleus(random);
        
        switch (syllableComplexity) {
            case 0:        // Simple syllable structure - 1 onset slot, no coda
                onset = new Cluster(1, random);
                coda = new Cluster();
                break;
            case 1:        // Moderately complex - 1 or 2 onset slots, 0 or 1 coda slots
                onset = new Cluster(random.nextInt(2) + 1, random);
                coda = new Cluster(random.nextInt(2), random);
                break;
            case 2:        // Complex - 3 or more onset slots, 2 or more coda slots
                onset = new Cluster(random.nextInt(1) + 3, random);
                coda = new Cluster(random.nextInt(2) + 2, random);
                break;
        }
    }
    
    // Creates a single new syllable based on the generated structure
    public Syllable nextSyllable() {
        Syllable syllable = new Syllable();
        
        // Syllable onset
        double slotProbability = 1.0 / onset.slots();
        for (int i = 0; i < onset.slots(); ++i) {
            if (random.nextDouble() <= slotProbability) {
                // Make sure any adjacent consonants have same voice
                Consonant consonant;
                do {
                    consonant = consonants.get(random.nextInt(consonants.size()));
                } while ((consonant = (Consonant) changePhoneme(consonant)) == null);
                
                previousPhoneme = consonant;
                syllable.addPhoneme(consonant);
            }
            
            slotProbability *= 1.5;
        }
        
        // Nucleus
        Vowel vowel = vowels.get(random.nextInt(vowels.size()));
        syllable.addPhoneme(vowel);
        previousPhoneme = vowel;
        
        // Coda
        slotProbability = 1.0 / coda.slots();
        for (int i = 0; i < coda.slots(); ++i) {
            if (random.nextDouble() <= slotProbability) {
                // Make sure any adjacent consonants have same voice
                Consonant consonant;
                do {
                    consonant = consonants.get(random.nextInt(consonants.size()));
                } while ((consonant = (Consonant) changePhoneme(consonant)) == null);
                
                previousPhoneme = consonant;
                syllable.addPhoneme(consonant);
            }
            
            slotProbability *= 1.5;
        }
        
        return syllable;
    }
    
    // Accept, reject, or change a phoneme based on the one that comes before it
    private Phoneme changePhoneme(Phoneme phoneme) {
        if (previousPhoneme == null) return phoneme;
        
        if (previousPhoneme.getClass() == Consonant.class) {
            Consonant previous = (Consonant) previousPhoneme;
            
            if (phoneme.getClass() == Consonant.class) {
                Consonant current = (Consonant) phoneme;
                
                if (current.voice() != previous.voice())
                    return null;
                
                if (!geminationAllowed && current == previous)
                    return null;
            }
        }
        
        return phoneme;
    }
    
    public void reset() {
        previousPhoneme = null;
    }
    
    // Turns structure into string like (C)(C)V(C)
    public String toString() {
        return "" + onset + nucleus + coda;
    }
    
    public Cluster onset() {
        return onset;
    }
    
    public Nucleus nucleus() {
        return nucleus;
    }
    
    public Cluster coda() {
        return coda;
    }
}
