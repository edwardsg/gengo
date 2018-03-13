package gengo.grammar;

import java.util.List;
import java.util.Random;

abstract class NominalCategory extends GrammaticalStructure {
    int numberOfValues;

    List<CategoryValue> values;

    NominalCategory(Random random) {
        super(random);

        createSystem();
    }

    protected abstract void createSystem();

    public int numberOfValues() {
        return numberOfValues;
    }

    public List<CategoryValue> values() {
        return values;
    }

    interface CategoryValue {
    }
}
