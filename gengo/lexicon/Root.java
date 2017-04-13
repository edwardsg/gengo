package gengo.lexicon;

import gengo.phonology.ConsonantPhoneme;
import gengo.phonology.VowelPhoneme;

// Contains a meaningless root with its IPA representation
public class Root {
	private String root;
	private String ipa;
	
	public Root() {
		root = "";
		ipa = "";
	}
	
	public Root(String root, String ipa) {
		this.root = root;
		this.ipa = ipa;
	}
	
	public void addConsonant(ConsonantPhoneme phoneme) {
		root += phoneme.symbol();
		ipa += phoneme.getAllophone().symbol();
	}
	
	public void addVowel(VowelPhoneme phoneme) {
		root += phoneme.symbol();
		ipa += phoneme.getAllophone().symbol();
	}
	
	public void endSyllable() {
		ipa += ".";
	}
	
	public String root() { return root; }
	public String ipa() { return ipa; }
}
