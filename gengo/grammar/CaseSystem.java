package gengo.grammar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import gengo.RandomGen;

public class CaseSystem extends GrammaticalStructure {
	private int numberOfCases;
	
	private List<Case> cases;
	
	public CaseSystem(Random random) {
		super(random);
		
		int numberOfCasesType = RandomGen.chooseIndexByWeights(random, Data.CASE_WEIGHTS);
		if (numberOfCasesType == 0)
			numberOfCases = 0;
		else if (numberOfCasesType < 5)
			numberOfCases = numberOfCasesType + 1;
		else if (numberOfCasesType == 5)
			numberOfCases = random.nextInt(2) + 6;
		else if (numberOfCasesType == 6)
			numberOfCases = random.nextInt(2) + 8;
		else if (numberOfCasesType == 7)
			numberOfCases = random.nextInt(Case.values().length - 10) + 10;
		else
			numberOfCases = 0;
		
		cases = new ArrayList<Case>();
		for (int i = 0; i < numberOfCases; ++i)
			cases.add(Case.values()[i]);
	}
	
	public String toString() {
		String string = "";
		
		if (numberOfCases > 0) {
			string += numberOfCases + " noun cases:\n";
			for (Case c : cases)
				string += c.name + "\n";
		} else
			string = "No noun cases";
		
		return string;
	}
	
	public static enum Case {
		NOM("Nominative"), ACC("Accusative"), GEN("Genitive"), DAT("Dative"), LOC("Locative"), 
		ABL("Ablative"), INS("Instrumental"), VOC("Vocative"), COM("Comitative"), ALL("Allative"),
		COMP("Comparative");
		
		private final String name;
		
		private Case(String name) {
			this.name = name;
		}
	}
}
