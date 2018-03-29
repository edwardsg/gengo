package gengo;

import gengo.grammar.Grammar;
import gengo.lexicon.Lexicon;

import java.util.Random;

class LanguageBuilderImpl implements LanguageBuilder {
    private final Random random;
    private final PhonologyBuilder phonologyBuilder;

    LanguageBuilderImpl(Random random, PhonologyBuilder phonologyBuilder) {
        this.random = random;
        this.phonologyBuilder = phonologyBuilder;
    }

    @Override
    public Language build() {
        Language language = new Language();
        language.phonology = phonologyBuilder.build();
        language.grammar = new Grammar(random);
        language.lexicon = new Lexicon(random, language.phonology);
        return language;
    }
}
