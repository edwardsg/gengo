package gengo.grammar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* Contains and generates information about grammatical structures */

public class Grammar {
	private Random random;
	
	private List<GrammarStructure> grammaticalStructures;
	private WordOrder wordOrder;
	
	public Grammar (Random random) {
		this.random = random;
		grammaticalStructures = new ArrayList<GrammarStructure>();
		
		createGrammar();
	}
	
	private void createGrammar() {
		wordOrder = new WordOrder(random);
		
		grammaticalStructures.add(wordOrder);
	}
	
	public List<GrammarStructure> grammaticalStructures() { return grammaticalStructures; }
	public WordOrder wordOrder() { return wordOrder; }
}
