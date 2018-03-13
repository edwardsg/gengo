package gengo.lexicon;

import gengo.phonology.Phoneme;
import gengo.phonology.Syllable;

// Contains a meaningless root with its IPA representation
public class Root {
    private String root;
    private String ipa;

    Root() {
        root = "";
        ipa = "";
    }

    public Root(String root, String ipa) {
        this.root = root;
        this.ipa = ipa;
    }

    public void addSyllable(Syllable syllable) {
        for (Phoneme phoneme : syllable.phonemes())
            addPhoneme(phoneme);
    }

    private void addPhoneme(Phoneme phoneme) {
        root += phoneme.symbol();
        ipa += phoneme.symbol();
    }

    public void separateSyllable() {
        ipa += ".";
    }

    public String root() {
        return root;
    }

    public String ipa() {
        return ipa;
    }
}
