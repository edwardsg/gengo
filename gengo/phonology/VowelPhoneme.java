package gengo.phonology;

import java.util.ArrayList;
import java.util.List;

public class VowelPhoneme implements Comparable<VowelPhoneme> {
	private String symbol;
	
	private List<Vowel> allophones;
	
	public VowelPhoneme(Vowel... allophones) {
		symbol = allophones[0].symbol();
		
		this.allophones = new ArrayList<Vowel>();
		for (Vowel allophone : allophones)
			this.allophones.add(allophone);
	}
	
	public Vowel getAllophone() {
		return allophones.get(0);
	}

	public int compareTo(VowelPhoneme other) {
		return symbol.compareTo(other.symbol);
	}
	
	public boolean equals(Object other) {
		if (other == null) return false;
		if (other == this) return true;
		if (!(other instanceof VowelPhoneme)) return false;
		
		VowelPhoneme otherPhoneme = (VowelPhoneme) other;
		
		if (otherPhoneme.allophones().equals(this.allophones)) return true;
		else return false;
	}
	
	public String toString() {
		return allophones.get(0).toString();
	}
	
	public String symbol() { return symbol; }
	public List<Vowel> allophones() { return allophones; }
}
