package gengo.grammar;

import java.util.Random;

import gengo.RandomGen;

public class WordOrder extends GrammaticalStructure {	
	private Order order;
	
	public WordOrder(Random random) {
		super(random);
		order = Order.values()[RandomGen.chooseIndexByWeights(random, Data.WORD_ORDER_WEIGHTS)];
	}
	
	public String toString() {
		if (order == Order.NONE)
			return "No dominant word order";
		else
			return "Dominant word order: " + order;
	}
	
	public static enum Order {
		SOV, SVO, VSO, VOS, OVS, OSV, NONE;
	}
	
	public Order order() { return order; }
}
