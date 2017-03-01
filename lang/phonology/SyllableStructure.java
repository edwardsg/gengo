package lang.phonology;

import java.util.List;
import java.util.Random;

import lang.Data;

/* Contains rules and structure for creating syllables */
public class SyllableStructure {
	private int[] complexityWeights = Data.SYLLABLE_COMPLEXITY_FREQUENCIES;
	
	private Random random;
	
	private Cluster onset;
	private Nucleus nucleus;
	private Cluster coda;
	
	private List<Consonant> consonants;
	private List<Vowel> vowels;
	
	public SyllableStructure(List<Consonant> consonants, List<Vowel> vowels, Random random) {
		this.random = random;
		this.consonants = consonants;
		this.vowels = vowels;
		
		createSyllableStructure();
	}
	
	// Create more or less complex syllable structure based on WALS data
	private void createSyllableStructure() {
		// Choose complexity of 0, 1, or 2 based real world occurrence
		int syllableComplexity = Data.chooseIndexByWeights(complexityWeights, random);
		
		// Syllable nucleus is essentially the same for every language
		nucleus = new Nucleus(random);
		
		switch (syllableComplexity) {
		case 0:		// Simple syllable structure - 1 onset slot, no coda
			onset = new Cluster(1, random);
			coda = new Cluster();
			break;
		case 1:		// Moderately complex - 1 or 2 onset slots, 0 or 1 coda slots
			onset = new Cluster(random.nextInt(2) + 1, random);
			coda = new Cluster(random.nextInt(2), random);
			break;
		case 2:		// Complex - 3 or more onset slots, 2 or more coda slots
			onset = new Cluster(random.nextInt(1) + 3, random);
			coda = new Cluster(random.nextInt(2) + 2, random);
			break;
		}
	}
	
	// Turns structure into string like (C)(C)V(C)
	public String toString() {
		return "" + onset + nucleus + coda;
	}
	
	public Cluster onset() { return onset; }
	public Nucleus nucleus() { return nucleus; }
	public Cluster coda() { return coda; }
}
