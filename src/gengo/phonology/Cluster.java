package gengo.phonology;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* Consonant cluster to represent onset or coda of syllable - 1 or more possibly optional consonants */
public class Cluster {
	private int slots;
	
	private boolean geminationAllowed;
	private List<Consonant> possibleSecondValues;
	
	private Random random;
	
	// Constructor taking number of slots to be in cluster
	Cluster(int slots, Random random) {
		this.slots = slots;
		this.random = random;
		
		generateStructure();
	}
	
	// General constructor for empty coda
	Cluster() {
		slots = 0;
	}
	
	private void generateStructure() {
		possibleSecondValues = new ArrayList<>();
		
		if (slots > 1) {
			geminationAllowed = random.nextBoolean();
			
			// Liquids
			if (random.nextBoolean()) {
				possibleSecondValues.add(IPA.VD_ALVEOLAR_LAT_APPROXIMANT);
				possibleSecondValues.add(IPA.VD_ALVEOLAR_APPROXIMANT);
			}
			
			// Glides
			if (random.nextBoolean()) {
				possibleSecondValues.add(IPA.VD_LABIO_VELAR_APPROXIMANT);
				possibleSecondValues.add(IPA.VD_PALATAL_APPROXIMANT);
			}
		} else {
			geminationAllowed = false;
		}
	}
	
	// Turns cluster into string of Cs with parentheses showing optionality
	public String toString() {
		String cluster = "";
		
		for (int i = 0; i < slots; ++i) {
			cluster += "(C)";
		}
		
		return cluster;
	}
	
	public int slots() { return slots; }
	public boolean geminationAllowed() { return geminationAllowed; }
}
