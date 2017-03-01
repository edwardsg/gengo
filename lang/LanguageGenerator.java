package lang;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map.Entry;

import lang.lexicon.Prime;
import lang.phonology.Consonant;
import lang.phonology.Vowel;

/* Main class */
public class LanguageGenerator {
	private static int HTML_FONT_SIZE = 5;
	
	private static Language language;
	
	public static void main(String[] args) {
		displayConsoleMenu();
		
		language = new Language();
		
		createHTML("lang");
		
		printToConsole();
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
			System.out.println(consonant.symbol() + "\t" + consonant);
		}
		
		// Print vowels in language
		System.out.println("\nVowels (" + language.phonology().vowelInventory() + "):");
		for (Vowel vowel : language.phonology().vowels()) {
			System.out.println(vowel.symbol() + "\t" + vowel);
		}
		
		// Print syllable structure
		System.out.println("\nSyllable structure: " + language.phonology().syllableStructure());
		
		// Semantic roots
		System.out.println("\nWord roots: ");
		for (Entry<Prime, String> entry : language.lexicon().roots().entrySet())
			System.out.println(entry.getKey().name() + ": " + entry.getValue());
		
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
				
				writer.write(consonant.toString() + " <br>\n");
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
				
				writer.write(" " + vowel.toString() + " <br>\n");
			}
			
			// Syllable structure
			writer.write("\n");
			writer.write("\t\t<p>\n");
			writer.write("\t\tSyllable structure: <br>\n");
			writer.write(String.format("<font size=\"%d\"> ", HTML_FONT_SIZE));
			writer.write("" + language.phonology().syllableStructure() + " </font>\n");
			
			/* Lexicon */
			
			writer.write("\n");
			writer.write("\t\t<p>\n");
			writer.write("\t\tWord roots: <br>\n");
			for (Entry<Prime, String> entry : language.lexicon().roots().entrySet()) {
				writer.write(entry.getKey().name() + ": ");
				
				for (char c : entry.getValue().toCharArray())
					writer.write("&#" + (int) c);
				
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
