package gengo.phonology;

import java.util.ArrayList;
import java.util.List;

public class Syllable {
    private List<Phoneme> phonemes;
    
    public Syllable() {
        phonemes = new ArrayList<>();
    }
    
    public void addPhoneme(Phoneme phoneme) {
        phonemes.add(phoneme);
    }
    
    public List<Phoneme> phonemes() {
        return phonemes;
    }
}
