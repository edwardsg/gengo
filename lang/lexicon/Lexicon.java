package lang.lexicon;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import lang.lexicon.Primes.Prime;
import lang.phonology.Cluster;
import lang.phonology.ConsonantPhoneme;
import lang.phonology.Phonology;

/* Contains semantic roots for the language paired with their universal meanings */
public class Lexicon {
	private static final int MAX_ROOT_SYLLABLES = 2;
	
	private Random random;
	
	private Phonology phonology;
	private List<String[]> restrictedPairs;
	
	private Map<Primes.BasicPrime, Root> roots;
	
	public Lexicon(Random random, Phonology phonology) {
		this.random = random;
		this.phonology = phonology;
		
		roots = new EnumMap<Primes.BasicPrime, Root>(Primes.BasicPrime.class);
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
		for (int syllable = 0; syllable < numSyllables; ++syllable) {
			// Syllable onset
			Cluster onset = phonology.syllableStructure().onset();
			double slotProbability = 1.0 / onset.slots();
			for (int i = 0; i < onset.slots(); ++i) {
				if (random.nextDouble() <= slotProbability) {
					ConsonantPhoneme consonant = phonology.consonants()
							.get(random.nextInt(phonology.consonantInventory()));
					root.addConsonant(consonant);
				}
				
				slotProbability *= 1.5;
			}
			
			// Nucleus
			root.addVowel(phonology.vowels().get(random.nextInt(phonology.vowelInventory())));
			
			// Coda
			Cluster coda = phonology.syllableStructure().coda();
			slotProbability = 1.0 / coda.slots();
			for (int i = 0; i < coda.slots(); ++i) {
				if (random.nextDouble() <= slotProbability) {
					ConsonantPhoneme consonant = phonology.consonants()
							.get(random.nextInt(phonology.consonantInventory()));
					root.addConsonant(consonant);
				}
				
				slotProbability *= 1.5;
			}
			
			// Syllable separation
			if (syllable < numSyllables - 1)
				root.endSyllable();
		}
		
		return root;
	}
	
	public Map<Primes.BasicPrime, Root> roots() { return roots; }
}
