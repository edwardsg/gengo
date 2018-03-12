package gengo.grammar;

import gengo.RandomGen;

import java.util.ArrayList;
import java.util.Random;

public class GenderSystem extends NominalCategory {	
	GenderSystem(Random random) {
		super(random);
	}
	
	protected void createSystem() {
		int numberOfGendersType = RandomGen.chooseIndexByWeights(random, Data.GENDER_WEIGHTS);
		numberOfValues = numberOfGendersType + 1;
		
		values = new ArrayList<>();
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
	
	public enum Gender implements CategoryValue {
		MASCULINE("Masculine"), FEMININE("Feminine"), NEUTER("Neuter"), ANIMATE("Animate"), INANIMATE("Inanimate");
		
		private final String name;
		
		Gender(String name) {
			this.name = name;
		}
	}
}
