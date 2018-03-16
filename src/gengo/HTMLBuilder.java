package gengo;

import gengo.grammar.GrammaticalStructure;
import gengo.lexicon.Primes;
import gengo.lexicon.Root;
import gengo.phonology.Consonant;
import gengo.phonology.Phoneme;
import gengo.phonology.Vowel;

import java.io.*;
import java.util.Map;

class HTMLBuilder {
    private static final int HTML_FONT_SIZE = 5;

    private final Language language;

    private String fileName;
    private Writer writer;

    HTMLBuilder(Language language, String fileName) {
        this.language = language;
        this.fileName = fileName;
    }

    public void build() throws IOException {
        checkFileNameEnding();
        startWriter();
        writePage();
        writer.close();
    }

    private void checkFileNameEnding() {
        if (!fileName.endsWith(".html"))
            fileName += ".html";
    }

    private void startWriter() throws FileNotFoundException {
        writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
    }

    private void writePage() throws IOException {
        writer.write("<html>\n");
        writeHead();
        writeBody();
        writer.write("</html>");
    }

    private void writeHead() throws IOException {
        writer.write("\t<head>\n");
        writer.write("\t\t<title> Language generator </title>\n");
        writer.write("\t</head>\n\n");
    }

    private void writeBody() throws IOException {
        writer.write("\t<body>\n");

        writePhonology();
        writeGrammar();
        writeLexicon();

        writeFooter();

        writer.write("\t</body>\n");
    }

    private void writePhonology() throws IOException {
        writeConsonants();
        writeVowels();
        writeSyllableStructure();
    }

    private void writeConsonants() throws IOException {
        writer.write("\t\t<p>\n");
        writer.write("\t\tConsonants (" + language.phonology.consonantInventory + "): <br>\n");

        for (Consonant consonant : language.phonology.consonants)
            writePhonemeDescription(consonant);
    }

    private void writeVowels() throws IOException {
        writer.write("\n");
        writer.write("\t\t<p>\n");
        writer.write("\t\tVowels (" + language.phonology.vowelInventory + "): <br>\n");

        for (Vowel vowel : language.phonology.vowels)
            writePhonemeDescription(vowel);
    }

    private void writePhonemeDescription(Phoneme phoneme) throws IOException {
        writer.write("\t\t");
        writer.write(String.format("<font size=\"%d\"> ", HTML_FONT_SIZE));

        for (char c : phoneme.symbol().toCharArray())
            writer.write("&#" + (int) c);

        writer.write(" </font> ");
        writer.write(phoneme.toString());
        writer.write("<br>\n");
    }

    private void writeSyllableStructure() throws IOException {
        writer.write("\n");
        writer.write("\t\t<p>\n");
        writer.write("\t\tSyllable structure: <br>\n");
        writer.write(String.format("<font size=\"%d\"> ", HTML_FONT_SIZE));
        writer.write("" + language.phonology.syllableStructure + " </font>\n");
    }

    private void writeGrammar() throws IOException {
        writer.write("\n");
        writer.write("\t\t<p>\n");
        writer.write("\t\tGrammar: <br>\n");

        for (GrammaticalStructure structure : language.grammar.grammaticalStructures())
            writer.write("\t\t" + structure.toString() + " <br><br>\n\n");
    }

    private void writeLexicon() throws IOException {
        writer.write("\n");
        writer.write("\t\t<p>\n");
        writer.write("\t\tWord roots: <br>\n");
        for (Map.Entry<Primes.BasicPrime, Root> entry : language.lexicon.roots().entrySet()) {
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
    }

    private void writeFooter() throws IOException {
        writer.write("\n");
        writer.write("\t\t<p>\n");
        writer.write("Seed: " + language.seed + "\n");

        writer.write("\n");
    }
}
