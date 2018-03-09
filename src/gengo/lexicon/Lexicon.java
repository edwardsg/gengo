package gengo.lexicon;

import java.util.EnumMap;
import java.util.Map;
import java.util.Random;

import gengo.LanguageGenerator;
import gengo.phonology.Phonology;

/* Contains semantic roots for the language paired with their universal meanings */
public class Lexicon {
	private static final int MAX_ROOT_SYLLABLES = 2;
	
	private Random random;
	
	private Phonology phonology;
	
	private Map<Primes.BasicPrime, Root> roots;
	
	public Lexicon(Random random, Phonology phonology) {
		this.random = random;
		this.phonology = phonology;
		
		roots = new EnumMap<>(Primes.BasicPrime.class);
		assignRoots();
	}
	
	// Assign generated roots to primes
	private void assignRoots() {
		for (Primes.BasicPrime prime : Primes.BasicPrime.values()) {
			roots.put(prime, createRoot());
		}
	}
	
	// Randomly generate a single word based on the syllable structure and phoneme inventory
	private Root createRoot() {
		Root root = new Root();
		
		// Each root may be one or more syllables
		int numSyllables = random.nextInt(MAX_ROOT_SYLLABLES) + 1;
		for (int i = 0; i < numSyllables; ++i) {
			root.addSyllable(phonology.syllableStructure().nextSyllable());
			
			if (i < numSyllables - 1 && LanguageGenerator.IPA_SYLLABLE_SEPARATION)
				root.separateSyllable();
		}
		
		phonology.syllableStructure().reset();
		
		return root;
	}
	
	public Map<Primes.BasicPrime, Root> roots() { return roots; }
}
