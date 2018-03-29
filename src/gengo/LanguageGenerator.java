package gengo;

import java.io.IOException;
import java.util.Random;

public class LanguageGenerator {
    public static final boolean IPA_SYLLABLE_SEPARATION = true;

    private static Language language;

    public static void main(String[] args) {
        displayConsoleMenu();
        buildLanguage();
        printToConsole();
        buildHTML();
    }

    private static void displayConsoleMenu() {
        System.out.println("\nProcedural Language Generator by Gabriel Edwards\n");
    }

    private static void buildLanguage() {
        long seed = new Random().nextLong();
        Random random = new Random(seed);
        PhonologyBuilder phonologyBuilder = new PhonologyBuilderImpl(random);
        LanguageBuilderImpl languageBuilder = new LanguageBuilderImpl(random, phonologyBuilder);
        language = languageBuilder.build();
    }

    private static void printToConsole() {
        System.out.println();
        new ConsoleWriter(language).printLanguageDetails();
    }

    private static void buildHTML() {
        try {
            new HTMLBuilder(language, "lang").build();
            System.out.println("Created lang.html");
        } catch (IOException e) {
            System.err.println("Something went wrong while writing HTML file.");
            e.printStackTrace();
        }
    }
}
