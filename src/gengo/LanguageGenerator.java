package gengo;

import java.io.IOException;

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
    
    private static void printToConsole() {
        System.out.println();
        new ConsoleWriter(language).printLanguageDetails();
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
