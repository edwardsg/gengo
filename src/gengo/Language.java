package gengo;

import gengo.grammar.Grammar;
import gengo.lexicon.Lexicon;
import gengo.phonology.Phonology;

import java.util.Random;

/* Contains all aspects of a single language */
class Language {
    private Phonology phonology;
    private Grammar grammar;
    private Lexicon lexicon;
    
    private final long seed;
    
    // General constructor that generates a random seed
    public Language() {
        seed = (new Random()).nextLong();
        
        createNewLanguage();
    }
    
    // Constructor taking an integer seed to allow finding a certain language again
    public Language(long seed) {
        this.seed = seed;
        
        createNewLanguage();
    }
    
    private void createNewLanguage() {
        Random random = new Random(seed);
        
        phonology = new Phonology(random);
        grammar = new Grammar(random);
        lexicon = new Lexicon(random, phonology);
    }
    
    // Getters
    public Phonology phonology() {
        return phonology;
    }
    
    public Grammar grammar() {
        return grammar;
    }
    
    public Lexicon lexicon() {
        return lexicon;
    }
    
    public long seed() {
        return seed;
    }
}
