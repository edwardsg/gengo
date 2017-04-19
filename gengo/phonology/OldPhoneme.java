package gengo.phonology;

import java.util.ArrayList;
import java.util.List;

public class OldPhoneme implements Comparable<OldPhoneme> {
	private String symbol;
	
	private List<Phoneme> allophones;
	
	public OldPhoneme(Phoneme... allophones) {
		symbol = allophones[0].symbol();
		
		this.allophones = new ArrayList<Phoneme>();
		for (Phoneme allophone : allophones)
			this.allophones.add(allophone);
	}
	
	public Phoneme getAllophone() {
		return allophones.get(0);
	}

	public int compareTo(OldPhoneme other) {
		return symbol.compareTo(other.symbol);
	}
	
	public boolean equals(Object other) {
		if (other == null) return false;
		if (other == this) return true;
		if (!(other instanceof OldPhoneme)) return false;
		
		OldPhoneme otherPhoneme = (OldPhoneme) other;
		
		if (otherPhoneme.allophones().equals(this.allophones)) return true;
		else return false;
	}
	
	public String toString() {
		return allophones.get(0).toString();
	}
	
	public String symbol() { return symbol; }
	public List<Phoneme> allophones() { return allophones; }
}
