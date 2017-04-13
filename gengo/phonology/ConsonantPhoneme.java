package gengo.phonology;

import java.util.ArrayList;
import java.util.List;

public class ConsonantPhoneme implements Comparable<ConsonantPhoneme> {
	private String symbol;
	
	private List<Consonant> allophones;
	
	public ConsonantPhoneme(Consonant... allophones) {
		symbol = allophones[0].symbol();
		
		this.allophones = new ArrayList<Consonant>();
		for (Consonant allophone : allophones)
			this.allophones.add(allophone);
	}
	
	public Consonant getAllophone() {
		return allophones.get(0);
	}

	public int compareTo(ConsonantPhoneme other) {
		return symbol.compareTo(other.symbol);
	}
	
	public boolean equals(Object other) {
		if (other == null) return false;
		if (other == this) return true;
		if (!(other instanceof ConsonantPhoneme)) return false;
		
		ConsonantPhoneme otherPhoneme = (ConsonantPhoneme) other;
		
		if (otherPhoneme.allophones().equals(this.allophones)) return true;
		else return false;
	}
	
	public String toString() {
		return allophones.get(0).toString();
	}
	
	public String symbol() { return symbol; }
	public List<Consonant> allophones() { return allophones; }
	public Consonant.Voice voice() { return allophones.get(0).voice(); }
}
