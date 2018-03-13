package gengo;

import gengo.grammar.Grammar;
import gengo.lexicon.Lexicon;
import gengo.phonology.Phonology;

import java.util.Random;

class LanguageBuilder {
    public static Language build() {
        return build(new Random().nextLong());
    }

    private static Language build(long seed) {
        Language language = new Language();
        language.seed = seed;

        Random random = new Random(seed);

        language.phonology = new Phonology(random);
        language.grammar = new Grammar(random);
        language.lexicon = new Lexicon(random, language.phonology);

        return language;
    }
}
