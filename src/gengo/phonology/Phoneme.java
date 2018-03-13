package gengo.phonology;

public abstract class Phoneme implements Comparable<Phoneme> {
    private final int occurrence;
    private final double probability;
    private final String symbol;
    private final Feature[] features;

    Phoneme(int occurence, String symbol, Feature... features) {
        this.occurrence = occurence;
        probability = (double) occurrence / Data.LANGUAGE_SAMPLE_SIZE;
        this.symbol = symbol;
        this.features = features;
    }

    public boolean hasFeature(Feature feature) {
        for (Feature f : features)
            if (f == feature)
                return true;

        return false;
    }

    public boolean hasFeatures(Feature... features) {
        for (Feature feature : features)
            if (!hasFeature(feature))
                return false;

        return true;
    }

    public int compareTo(Phoneme other) {
        return symbol.compareTo(other.symbol);
    }

    interface Feature {
    }

    public int weight() {
        return occurrence;
    }

    public double probability() {
        return probability;
    }

    public String symbol() {
        return symbol;
    }
}
