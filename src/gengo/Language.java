package gengo;

import gengo.grammar.Grammar;
import gengo.lexicon.Lexicon;
import gengo.phonology.Phonology;

import java.util.Random;

class Language {
    public Phonology phonology;
    public Grammar grammar;
    public Lexicon lexicon;

    public long seed;
}
