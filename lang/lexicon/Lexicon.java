package lang.lexicon;

import java.util.EnumMap;
import java.util.Map;
import java.util.Random;

import lang.phonology.Cluster;
import lang.phonology.Consonant;
import lang.phonology.Phonology;

/* Contains semantic roots for the language paired with their universal meanings */
public class Lexicon {
	private static final int MAX_ROOT_SYLLABLES = 2;
	
	private Random random;
	
	private Phonology phonology;
	
	private Map<Prime, String> roots;
	
	public Lexicon(Random random, Phonology phonology) {
		this.random = random;
		this.phonology = phonology;
		
		roots = new EnumMap<Prime, String>(Prime.class);
		assignRoots();
	}
	
	// Assign generated roots to primes
	private void assignRoots() {
		for (Prime prime : Prime.values()) {
			roots.put(prime, createRoot());
		}
	}
	
	// Randomly generate a single word based on the syllable structure and phoneme inventory
	private String createRoot() {
		String root = "";
		
		// Each root may be one or more syllables
		int numSyllables = random.nextInt(MAX_ROOT_SYLLABLES) + 1;
		for (int syllable = 0; syllable < numSyllables; ++syllable) {
			// Syllable onset
			Cluster onset = phonology.syllableStructure().onset();
			double slotProbability = 1.0 / onset.slots();
			for (int i = 0; i < onset.slots(); ++i) {
				if (random.nextDouble() <= slotProbability) {
					Consonant consonant = phonology.consonants()
							.get(random.nextInt(phonology.consonantInventory()));
					root += consonant.symbol();
				}
				
				slotProbability *= 1.5;
			}
			
			// Nucleus
			root += phonology.vowels().get(random.nextInt(phonology.vowelInventory())).symbol();
			
			// Coda
			Cluster coda = phonology.syllableStructure().coda();
			slotProbability = 1.0 / coda.slots();
			for (int i = 0; i < coda.slots(); ++i) {
				if (random.nextDouble() <= slotProbability) {
					root += phonology.consonants().get(random.nextInt(phonology.consonantInventory())).symbol();
				}
				
				slotProbability *= 1.5;
			}
		}
		
		return root;
	}
	
	public Map<Prime, String> roots() { return roots; }
}
