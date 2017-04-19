package gengo.phonology;

import java.util.Random;

/* Nucleus of syllable - either vowel (including diphthongs) or syllabic consonant */
public class Nucleus {	
	private boolean canBeConsonant;
	
	public Nucleus(Random random) {		
		canBeConsonant = random.nextBoolean();
	}
	
	// Turns nucleus into a string - usually just V, but may also include syllabic consonant
	public String toString() {
		String nucleus = "V";
		return nucleus;
	}
	
	public boolean canBeConsonant() { return canBeConsonant; }
}
