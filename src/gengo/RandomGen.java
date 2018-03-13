package gengo;

import java.util.Random;

public class RandomGen {
    // Randomly choose an index from an array of integer weights
    public static int chooseIndexByWeights(Random random, int... weights) {
        // Create a range by adding all weights
        int totalRange = 0;
        for (int weight : weights)
            totalRange += weight;

        int dart = random.nextInt(totalRange);    // Pick random number within total range

        // Determine in which sub range the dart landed, corresponding to the index of that weight
        totalRange = weights[0];
        int i;
        for (i = 0; totalRange < dart && i < weights.length - 1; ++i)
            totalRange += weights[i + 1];

        return i;
    }
}
