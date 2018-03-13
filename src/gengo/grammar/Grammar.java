package gengo.grammar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* Contains and generates information about grammatical structures */

public class Grammar {
    private Random random;

    private List<GrammaticalStructure> grammaticalStructures;
    private WordOrder wordOrder;
    private CaseSystem caseSystem;
    private GenderSystem genderSystem;

    public Grammar(Random random) {
        this.random = random;
        grammaticalStructures = new ArrayList<>();

        createGrammar();
    }

    private void createGrammar() {
        wordOrder = new WordOrder(random);
        grammaticalStructures.add(wordOrder);

        caseSystem = new CaseSystem(random);
        grammaticalStructures.add(caseSystem);

        genderSystem = new GenderSystem(random);
        grammaticalStructures.add(genderSystem);
    }

    public List<GrammaticalStructure> grammaticalStructures() {
        return grammaticalStructures;
    }

    public WordOrder wordOrder() {
        return wordOrder;
    }
}
