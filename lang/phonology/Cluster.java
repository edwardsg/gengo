package lang.phonology;

import java.util.Random;

/* Consonant cluster to represent onset or coda of syllable - 1 or more possibly optional consonants */
public class Cluster {
	private int slots;
	
	private Random random;
	
	// Constructor taking number of slots to be in cluster
	public Cluster(int slots, Random random) {
		this.slots = slots;
		this.random = random;
	}
	
	// General constructor for empty coda
	public Cluster() {
		slots = 0;
	}
	
	// Turns cluster into string of Cs with parentheses showing optionality
	public String toString() {
		String cluster = "";
		
		for (int i = 0; i < slots; ++i) {
			cluster += "C";
		}
		
		return cluster;
	}
}
