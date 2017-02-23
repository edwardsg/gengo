package lang;

import java.util.Random;

import lang.phonology.Phonology;

/* Contains all aspects of a single language */
public class Language {
	private Phonology phonology;
	private Lexicon lexicon;
	private Dictionary dictionary;
	
	private long seed;
	private Random random;
	
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
		random = new Random(seed);
		
		phonology = new Phonology(random);
		lexicon = new Lexicon();
		dictionary = new Dictionary();
	}
	
	// Getters
	public Phonology phonology() { return phonology; }
	public Lexicon lexicon() { return lexicon; }
	public Dictionary dictionary() { return dictionary; }
	public long seed() { return seed; }
}
