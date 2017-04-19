package gengo.grammar;

import java.util.Random;

public abstract class GrammaticalStructure {
	protected Random random;
	
	public GrammaticalStructure(Random random) {
		this.random = random;
	}
}
