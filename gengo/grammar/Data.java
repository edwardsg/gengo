package gengo.grammar;

/* Contains data about grammatical structures */
public class Data {
	/* Nouns */
	public static final int[] CASE_WEIGHTS = { 100, 23, 9, 9, 12, 37, 23, 24, 24 };
	public static final int[] CASE_POSITION_WEIGHTS = { 452, 38, 5, 1, 9, 123, 17, 7, 379 };
	
	public static final int[] GENDER_WEIGHTS = { 145, 50, 26, 12, 24 };
	
	/* Verbs */
	public static final int[] FUTURE_WEIGHTS = { 110, 112 };
	public static final int[] PAST_WEIGHTS = { 94, 38, 2, 88 };
	
	/* Syntax */
	public static final int[] WORD_ORDER_WEIGHTS = { 565, 488, 95, 25, 11, 4, 189 };
}
