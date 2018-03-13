package gengo.grammar;

import gengo.RandomGen;

import java.util.Random;

public class WordOrder extends GrammaticalStructure {
    private Order order;
    
    WordOrder(Random random) {
        super(random);
        order = Order.values()[RandomGen.chooseIndexByWeights(random, Data.WORD_ORDER_WEIGHTS)];
    }
    
    public String toString() {
        if (order == Order.NONE)
            return "No dominant word order";
        else
            return "Dominant word order: " + order;
    }
    
    public enum Order {
        SOV, SVO, VSO, VOS, OVS, OSV, NONE
    }
    
    public Order order() {
        return order;
    }
}
