package gengo;

import gengo.grammar.GrammaticalStructure;
import gengo.lexicon.Primes;
import gengo.lexicon.Root;
import gengo.phonology.Consonant;
import gengo.phonology.Vowel;

import java.util.Map;

class ConsoleWriter {
    private final Language language;
    private final long seed;

    ConsoleWriter(Language language, long seed) {
        this.language = language;
        this.seed = seed;
    }

    void printLanguageDetails() {
        printConsonants();
        printVowels();
        printSyllableStructure();
        printGrammar();
        printLexicon();
        printFooter();
    }

    private void printConsonants() {
        System.out.println("Consonants (" + language.phonology.consonantInventory + "):");
        for (Consonant consonant : language.phonology.consonants)
            System.out.println(consonant);

        System.out.println();
    }

    private void printVowels() {
        System.out.println("Vowels (" + language.phonology.vowelInventory + "):");
        for (Vowel vowel : language.phonology.vowels)
            System.out.println(vowel);

        System.out.println();
    }

    private void printSyllableStructure() {
        System.out.println("Syllable structure: " + language.phonology.syllableStructure);
        System.out.println();
    }

    private void printGrammar() {
        System.out.println("Grammar:");
        for (GrammaticalStructure structure : language.grammar.grammaticalStructures())
            System.out.println(structure + "\n");

        System.out.println();
    }

    private void printLexicon() {
        System.out.println("Word roots: ");
        for (Map.Entry<Primes.BasicPrime, Root> entry : language.lexicon.roots().entrySet())
            System.out.println(entry.getKey().name() + ": " + entry.getValue().root());

        System.out.println();
    }

    private void printFooter() {
        System.out.println("Seed: " + seed);
        System.out.println();
    }
}
