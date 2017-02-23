package lang.phonology;

import java.util.Random;

/* Coda of syllable - 1 or more possibly optional consonants */
public class Coda {
	private int slots;
	
	private Random random;
	
	public Coda(int slots, Random random) {
		this.slots = slots;
		this.random = random;
	}
	
	public Coda() {
		this.slots = 0;
	}
	
	
	public String toString() {
		String coda = "";
		
		for (int i = 0; i < slots; ++i) {
			coda += "C";
		}
		
		return coda;
	}
}
