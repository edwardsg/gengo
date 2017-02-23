package lang.phonology;

import java.util.Random;

/* Nucleus of syllable - either vowel (including diphthongs) or syllabic consonant */
public class Nucleus {
	private Random random;
	
	public Nucleus(Random random) {
		this.random = random;
	}
	
	// Turns nucleus into a string - usually just V, but may also include syllabic consonant
	public String toString() {
		return "V";
	}
}
