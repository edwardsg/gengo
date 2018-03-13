package gengo.grammar;

/* Contains data about grammatical structures */
class Data {
    /* Nouns */
    public static final int[] PLURAL_WEIGHTS = { 28, 20, 40, 55, 15, 133 };
    public static final String[] PLURAL_DESCR = { "None", "Only human nouns, optional",
            "Only human nouns, obligatory", "All nouns, always optional", "All nouns, optional in inanimates",
            "All nouns, always obligatory" };
    public static final int[] PLURAL_CODING_WEIGHTS = { 126, 513, 6, 4, 8, 60, 170, 81, 98 };
    public static final String[] PLURAL_CODING_DESCR = { "Prefix", "Suffix", "Stem change", "Tone",
            "Complete reduplication", "Mixed morphological", "Word", "Clitic", "None" };

    public static final int[] CASE_WEIGHTS = { 100, 23, 9, 9, 12, 37, 23, 24, 24 };
    public static final int[] CASE_POSITION_WEIGHTS = { 452, 38, 5, 1, 9, 123, 17, 7, 379 };

    public static final int[] GENDER_WEIGHTS = { 145, 50, 26, 12, 24 };
    public static final String[] GENDER_DESCR = { "None", "Two", "Three", "Four", "Five or more" };

    /* Verbs */
    public static final int[] FUTURE_WEIGHTS = { 110, 112 };
    public static final int[] PAST_WEIGHTS = { 94, 38, 2, 88 };

    /* Syntax */
    public static final int[] WORD_ORDER_WEIGHTS = { 565, 488, 95, 25, 11, 4, 189 };
}
