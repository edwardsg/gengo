package gengo.grammar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import gengo.RandomGen;

public class GenderSystem extends NominalCategory {	
	public GenderSystem(Random random) {
		super(random);
	}
	
	protected void createSystem() {
		int numberOfGendersType = RandomGen.chooseIndexByWeights(random, Data.GENDER_WEIGHTS);
		numberOfValues = numberOfGendersType + 1;
		
		values = new ArrayList<CategoryValue>();
		for (int i = 0; i < numberOfValues; ++i)
			values.add(Gender.values()[i]);
	}
	
	public String toString() {
		String string = "";
		
		if (numberOfValues > 1) {
			string += numberOfValues + " grammatical genders:\n";
			for (CategoryValue g : values)
				string += ((Gender) g).name + "\n";
		} else
			string = "No grammatical gender";
		
		return string;
	}
	
	public static enum Gender implements CategoryValue {
		MASCULINE("Masculine"), FEMININE("Feminine"), NEUTER("Neuter"), ANIMATE("Animate"), INANIMATE("Inanimate");
		
		private final String name;
		
		private Gender(String name) {
			this.name = name;
		}
	}
}
