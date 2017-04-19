package gengo.grammar;

import java.util.List;
import java.util.Random;

public abstract class NominalCategory extends GrammaticalStructure {
	protected int numberOfValues;
	
	protected List<CategoryValue> values;
	
	public NominalCategory(Random random) {
		super(random);
		
		createSystem();
	}
	
	protected abstract void createSystem();
	
	public int numberOfValues() { return numberOfValues; }
	public List<CategoryValue> values() { return values; }
	
	public abstract interface CategoryValue {}
}
