package gengo.phonology;

/* Contains phonological statistics */
class Data {
    // Number of languages in UPSID
    public static final int LANGUAGE_SAMPLE_SIZE = 451;

    /* Statistics from the World Atlas of Language Structures wals.info */

    // Phonemes
    public static final int MIN_CONSONANT_INVENTORY = 6;
    public static final int MAX_CONSONANT_INVENTORY = 122;
    public static final int[] CONSONANT_INVENTORIES = {MIN_CONSONANT_INVENTORY, 14, 18, 25, 33};
    public static final int[] CONSONANT_INVENTORY_FREQUENCIES = {89, 122, 201, 94, 57};

    public static final int MIN_VOWEL_INVENTORY = 2;
    public static final int MAX_VOWEL_INVENTORY = 31;

    public static final double MIN_CONSONANT_VOWEL_RATIO = 1.11;
    public static final double MAX_CONSONANT_VOWEL_RATIO = 29;
    public static final double[] CONSONANT_VOWEL_RATIOS = {MIN_CONSONANT_VOWEL_RATIO, 2.0, 2.75, 4.5, 6.5};
    public static final int[] CONSONANT_VOWEL_RATIO_FREQUENCIES = {58, 101, 234, 102, 69};

    // Consonants
    public static final int[] VOICING_CONTRAST_WEIGHTS = {182, 189, 38, 158};
    public static final int[] PLOSIVE_SYSTEM_WEIGHTS = {242, 255, 33, 34, 3};
    public static final int[] UVULAR_WEIGHTS = {470, 38, 11, 48};
    public static final int[] GLOTTALIZED_WEIGHTS = {409, 58, 55, 4, 14, 20, 4, 3};
    public static final int[] LATERAL_WEIGHTS = {95, 388, 29, 47, 8};
    public static final int[] COMMON_ABSENCE_WEIGHTS = {503, 4, 48, 10, 1, 1};
    public static final int[] UNCOMMON_WEIGHTS = {449, 9, 45, 21, 40, 1, 2};

    // Vowels
    public static final int[] NASAL_CONTRAST_WEIGHTS = {64, 180};

    // Syllables
    public static final int[] SYLLABLE_COMPLEXITY_FREQUENCIES = {61, 274, 151};
}
