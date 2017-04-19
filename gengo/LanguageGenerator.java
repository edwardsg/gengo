package gengo;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map.Entry;

import gengo.grammar.GrammaticalStructure;
import gengo.lexicon.Primes;
import gengo.lexicon.Root;
import gengo.phonology.Consonant;
import gengo.phonology.Vowel;

/* Main class */
public class LanguageGenerator {
	public static boolean IPA_SYLLABLE_SEPARATION = true;
	
	private static int HTML_FONT_SIZE = 5;
	
	private static Language language;
	
	public static void main(String[] args) {
		displayConsoleMenu();
		
		language = new Language();
		
		printToConsole();
		
		createHTML("lang");
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
	
	// Output an HTML file containing the details of the language
	private static void createHTML(String fileName) {
		fileName += ".html";
		
		try {
			Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
			
			writer.write("<html>\n");
			writer.write("\t<head>\n");
			writer.write("\t\t<title> Language generator </title>\n");
			writer.write("\t</head>\n\n");
			writer.write("\t<body>\n");
			
			/* Phonology Information */
			
			// Consonants
			writer.write("\t\t<p>\n");
			writer.write("\t\tConsonants (" + language.phonology().consonantInventory() + "): <br>\n");
			for (Consonant consonant : language.phonology().consonants()) {
				writer.write("\t\t");
				
				writer.write(String.format("<font size=\"%d\"> ", HTML_FONT_SIZE));
				
				for (char c : consonant.symbol().toCharArray())
					writer.write("&#" + (int) c);
				
				writer.write(" </font> ");
				
				writer.write(consonant.toString());
				
				writer.write("<br>\n");
			}
			
			// Vowels
			writer.write("\n");
			writer.write("\t\t<p>\n");
			writer.write("\t\tVowels (" + language.phonology().vowelInventory() + "): <br>\n");
			for (Vowel vowel : language.phonology().vowels()) {
				writer.write("\t\t");
				
				writer.write(String.format("<font size=\"%d\"> ", HTML_FONT_SIZE));
				
				for (char c : vowel.symbol().toCharArray())
					writer.write("&#" + (int) c);
				
				writer.write(" </font> ");
				
				writer.write(vowel.toString());
				
				writer.write("<br>\n");
			}
			
			// Syllable structure
			writer.write("\n");
			writer.write("\t\t<p>\n");
			writer.write("\t\tSyllable structure: <br>\n");
			writer.write(String.format("<font size=\"%d\"> ", HTML_FONT_SIZE));
			writer.write("" + language.phonology().syllableStructure() + " </font>\n");
			
			/* Grammar */
			
			writer.write("\n");
			writer.write("\t\t<p>\n");
			writer.write("\t\tGrammar: <br>\n");
			for (GrammaticalStructure structure : language.grammar().grammaticalStructures()) {
				writer.write("\t\t" + structure.toString() + " <br><br>\n\n");
			}
			
			/* Lexicon */
			
			writer.write("\n");
			writer.write("\t\t<p>\n");
			writer.write("\t\tWord roots: <br>\n");
			for (Entry<Primes.BasicPrime, Root> entry : language.lexicon().roots().entrySet()) {
				writer.write(entry.getKey().name() + ": ");
				
				for (char c : entry.getValue().root().toCharArray())
					writer.write("&#" + (int) c);
				
				writer.write(" &nbsp ");
				
				writer.write("/");
				for (char c : entry.getValue().ipa().toCharArray())
					writer.write("&#" + (int) c);
				writer.write("/");
				
				writer.write(" <br>\n");
			}
			
			/* Footer */
			
			// Seed
			writer.write("\n");
			writer.write("\t\t<p>\n");
			writer.write("Seed: " + language.seed() + "\n");
			
			writer.write("\n");
			writer.write("\t</body>\n");
			writer.write("</html>");
			
			writer.close();
			
			System.out.println("Created HTML file.");
		} catch (IOException e) {
			System.err.println("Problem creating html file");
		}
	}
}
