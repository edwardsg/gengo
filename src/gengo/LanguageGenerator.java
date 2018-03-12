package gengo;

import gengo.grammar.GrammaticalStructure;
import gengo.lexicon.Primes;
import gengo.lexicon.Root;
import gengo.phonology.Consonant;
import gengo.phonology.Vowel;

import java.io.IOException;
import java.util.Map.Entry;

/* Main class */
public class LanguageGenerator {
	public static final boolean IPA_SYLLABLE_SEPARATION = true;
	
	private static Language language;
	
	public static void main(String[] args) {
		displayConsoleMenu();
		
		language = new Language();
		
		printToConsole();
		
		buildHTML();
	}
	
	private static void displayConsoleMenu() {
		System.out.println("\nProcedural Language Generator by Gabriel Edwards\n");
	}
	
	// Console output
	private static void printToConsole() {
		System.out.println();
		
		// Print consonants in language
		System.out.println("Consonants (" + language.phonology().consonantInventory() + "):");
		for (Consonant consonant : language.phonology().consonants()) {
			System.out.println(consonant);
		}
		
		// Print vowels in language
		System.out.println("\nVowels (" + language.phonology().vowelInventory() + "):");
		for (Vowel vowel : language.phonology().vowels()) {
			System.out.println(vowel);
		}
		
		// Print syllable structure
		System.out.println("\nSyllable structure: " + language.phonology().syllableStructure());
		
		// Grammar
		System.out.println("\nGrammar:");
		for (GrammaticalStructure structure : language.grammar().grammaticalStructures())
			System.out.println(structure + "\n");
		
		// Semantic roots
		System.out.println("\nWord roots: ");
		for (Entry<Primes.BasicPrime, Root> entry : language.lexicon().roots().entrySet())
			System.out.println(entry.getKey().name() + ": " + entry.getValue().root());
		
		// Additional information
		System.out.println("\nSeed: " + language.seed());
	}
	
	private static void buildHTML() {
		try {
			new HTMLBuilder(language, "lang").build();
		} catch (IOException e) {
			System.err.println("Something went wrong while writing HTML file.");
			e.printStackTrace();
		}
	}
}
