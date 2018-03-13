package gengo.phonology;

import gengo.phonology.Consonant.*;
import gengo.phonology.Vowel.*;

import java.util.ArrayList;
import java.util.List;

class IPA {
    public static List<Consonant> CONSONANTS = new ArrayList<>();
    public static List<Vowel> VOWELS = new ArrayList<>();
    
    /* Consonants */
    private static final Consonant VD_BILABIAL_NASAL = new Consonant(425, "m", Voice.VOICED, Place.BILABIAL, Manner.NASAL);                    // UPSID   m
    public static final Consonant VL_VELAR_STOP = new Consonant(403, "k", Voice.VOICELESS, Place.VELAR, Manner.STOP);                            // k
    public static final Consonant VD_PALATAL_APPROXIMANT = new Consonant(378, "j", Voice.VOICED, Place.PALATAL, Manner.APPROXIMANT);                    // j
    public static final Consonant VL_BILABIAL_STOP = new Consonant(375, "p", Voice.VOICELESS, Place.BILABIAL, Manner.STOP);                        // p
    public static final Consonant VD_LABIO_VELAR_APPROXIMANT = new Consonant(332, "w", Voice.VOICED, Place.LABIO_VELAR, Manner.APPROXIMANT);                // w
    public static final Consonant VD_BILABIAL_STOP = new Consonant(287, "b", Voice.VOICED, Place.BILABIAL, Manner.STOP);                            // b
    private static final Consonant VL_GLOTTAL_FRICATIVE = new Consonant(279, "h", Voice.VOICELESS, Place.GLOTTAL, Manner.NONSIB_FRICATIVE);            // h
    public static final Consonant VD_VELAR_STOP = new Consonant(253, "g", Voice.VOICED, Place.VELAR, Manner.STOP);                                // g
    private static final Consonant VD_VELAR_NASAL = new Consonant(237, "\u014B", Voice.VOICED, Place.VELAR, Manner.NASAL);                        // N
    public static final Consonant VL_GLOTTAL_STOP = new Consonant(216, "\u0294", Voice.VOICELESS, Place.GLOTTAL, Manner.STOP);                    // ?
    private static final Consonant VD_ALVEOLAR_NASAL = new Consonant(202, "n", Voice.VOICED, Place.ALVEOLAR, Manner.NASAL);                            // n
    private static final Consonant VL_ALVEOLAR_SIB_FRICATIVE = new Consonant(196, "s", Voice.VOICELESS, Place.ALVEOLAR, Manner.SIB_FRICATIVE);                // s
    public static final Consonant VL_PALATO_ALVEOLAR_SIB_AFFRICATE = new Consonant(188, "t\u0361\u0283", Voice.VOICELESS, Place.PALATO_ALVEOLAR, Manner.SIB_AFFRICATE);    // tS
    public static final Consonant VL_PALATO_ALVEOLAR_SIB_FRICATIVE = new Consonant(187, "\u0283", Voice.VOICELESS, Place.PALATO_ALVEOLAR, Manner.SIB_FRICATIVE);    // S
    public static final Consonant VL_ALVEOLAR_STOP = new Consonant(181, "t", Voice.VOICELESS, Place.ALVEOLAR, Manner.STOP);                        // t
    private static final Consonant VL_LABIODENTAL_FRICATIVE = new Consonant(180, "f", Voice.VOICELESS, Place.LABIODENTAL, Manner.NONSIB_FRICATIVE);        // f
    public static final Consonant VD_ALVEOLAR_LAT_APPROXIMANT = new Consonant(174, "l", Voice.VOICED, Place.ALVEOLAR, Manner.LAT_APPROXIMANT);                // l
    //	public static final Consonant VD_DENTAL_ALVEOLAR_NASAL					= new Consonant(Voice.VOICED, Place.DENTAL, Manner.NASAL, 160, "n");							// "n	*
//	public static final Consonant VL_DENTAL_ALVEOLAR_STOP					= new Consonant(152, "t", Voice.VOICELESS, Place.DENTAL, Manner.STOP);							// "t	*
    public static final Consonant VD_PALATAL_NASAL = new Consonant(141, "\u0272", Voice.VOICED, Place.PALATAL, Manner.NASAL);                        // nj
    //	public static final Consonant VD_DENTAL_ALVEOLAR_LAT_APPROXIMANT		= new Consonant(Voice.VOICED, Place.DENTAL, Manner.LAT_APPROXIMANT, 136, "l");					// "l	*
//	public static final Consonant VL_DENTAL_ALVEOLARD_SIB_FRICATIVE			= new Consonant(Voice.VOICELESS, Place.DENTAL, Manner.SIB_FRICATIVE, 135, "s");				// "s	*
    public static final Consonant VD_ALVEOLAR_STOP = new Consonant(120, "d", Voice.VOICED, Place.ALVEOLAR, Manner.STOP);                            // d
    public static final Consonant VD_PALATO_ALVEOLAR_SIB_AFFRICATE = new Consonant(113, "d\u0361\u0292", Voice.VOICED, Place.PALATO_ALVEOLAR, Manner.SIB_AFFRICATE);    // dZ
    //	public static final Consonant VL_DENTAL_STOP							= new Consonant(106, "t", Voice.VOICELESS, Place.DENTAL, Manner.STOP);							// tD	*
//	public static final Consonant VLA_VELAR_STOP							= new Consonant(103, "k\u02B0", Voice.VOICELESS, Aspiration.ASPIRATED, Place.VELAR, Manner.STOP);	// kh
//	public static final Consonant VLA_BILABIAL_STOP							= new Consonant(101, "p\u02B0", Voice.VOICELESS, Aspiration.ASPIRATED, Place.BILABIAL, Manner.STOP);// ph
    public static final Consonant VD_ALVEOLAR_TRILL = new Consonant(95, "r", Voice.VOICED, Place.ALVEOLAR, Manner.TRILL);                            // r
    private static final Consonant VD_LABIODENTAL_FRICATIVE = new Consonant(95, "v", Voice.VOICED, Place.LABIODENTAL, Manner.NONSIB_FRICATIVE);            // v
    private static final Consonant VL_VELAR_FRICATIVE = new Consonant(94, "x", Voice.VOICELESS, Place.VELAR, Manner.NONSIB_FRICATIVE);                            // x
    //	public static final Consonant VD_DENTAL_ALVEOLAR_STOP					= new Consonant(Voice.VOICED, Place.DENTAL, Manner.STOP, 91, "d");							// "d	*
    public static final Consonant VD_ALVEOLAR_FLAP = new Consonant(91, "\u027E", Voice.VOICED, Place.ALVEOLAR, Manner.FLAP);                            // r[
    //	public static final Consonant VD_DENTAL_NASAL							= new Consonant(Voice.VOICED, Place.DENTAL, Manner.NASAL, 83, "n");							// nD	*
//	public static final Consonant VD_DENTAL_STOP							= new Consonant(Voice.VOICED, Place.DENTAL, Manner.STOP, 80, "d");							// dD	*
    private static final Consonant VL_VELAR_EJECTIVE_STOP = new Consonant(63, "k\u02BC", Voice.VOICELESS, Place.VELAR, Ejectivity.EJECTIVE, Manner.STOP);                            // k'
    public static final Consonant VL_ALVEOLAR_SIB_AFFRICATE = new Consonant(62, "t\u0361s", Voice.VOICELESS, Place.ALVEOLAR, Manner.SIB_AFFRICATE);                            // ts
    private static final Consonant VD_ALVEOLAR_SIB_FRICATIVE = new Consonant(62, "z", Voice.VOICED, Place.ALVEOLAR, Manner.SIB_FRICATIVE);                            // z
    private static final Consonant VD_PALATO_ALVEOLAR_SIB_FRICATIVE = new Consonant(61, "\u0292", Voice.VOICED, Place.PALATO_ALVEOLAR, Manner.SIB_FRICATIVE);                            // Z
    //	public static final Consonant LABIALIZED_VL_VELAR_STOP					= new Consonant(60, "k\u02B7", Labialization.LABIALIZED, Voice.VOICELESS, Place.VELAR, Manner.STOP);							// kW
    private static final Consonant VD_VELAR_FRICATIVE = new Consonant(55, "\u0263", Voice.VOICED, Place.VELAR, Manner.NONSIB_FRICATIVE);                            // gF
    private static final Consonant VD_BILABIAL_FRICATIVE = new Consonant(54, "\u03B2", Voice.VOICED, Place.BILABIAL, Manner.NONSIB_FRICATIVE);                            // B
    private static final Consonant VL_PALATAL_STOP = new Consonant(54, "c", Voice.VOICELESS, Place.PALATAL, Manner.STOP);                            // c
    private static final Consonant VL_UVULAR_STOP = new Consonant(52, "q", Voice.VOICELESS, Place.UVULAR, Manner.STOP);                            // q
    //	public static final Consonant VD_DENTAL_ALVEOLAR_TRILL					= new Consonant(Voice.VOICED, Place.DENTAL, Manner.TRILL, 51, "r");							// "r	*
//	public static final Consonant VLA_PALATO_ALVEOLAR_SIB_AFFRICATE			= new Consonant(51, "t\u0361\u0283\u02B0", Voice.VOICELESS, Aspiration.ASPIRATED, Place.PALATO_ALVEOLAR, Manner.SIB_AFFRICATE);							// tSh
//	public static final Consonant VLA_DENTAL_ALVEOLAR_STOP					= new Consonant(Voice.VOICED, Aspiration.ASPIRATED, Place.ALVEOLAR, Manner.STOP, 49, "t\u02B0");							// "th
    private static final Consonant VD_BILABIAL_IMPLOSIVE = new Consonant(49, "\u0253", Voice.VOICED, Place.BILABIAL, Manner.IMPLOSIVE);                            // b<
    //	public static final Consonant PRENASALIZED_VD_BILABIAL_STOP				= new Consonant(48, "m\u0361b", Voice.VOICED, Place.BILABIAL, Manner.STOP);							// mb
//	public static final Consonant VL_DENTAL_ALVEOLAR_SIB_AFFRICATE			= new Consonant(Voice.VOICELESS, Place.DENTAL, Manner.SIB_AFFRICATE, 45, "t\u0361s");							// "ts
//	public static final Consonant PRENASALIZED_VD_VELAR_STOP				= new Consonant(45, "\u014B\u0361g", Voice.VOICED, Place.VELAR, Manner.STOP);							// Ng
//	public static final Consonant VD_PALATO_ALVEOLAR_NASAL					= new Consonant(Voice.VOICED, Place.PALATO_ALVEOLAR, Manner.NASAL, 45, "n");							// n_
    private static final Consonant VL_UVULAR_FRICATIVE = new Consonant(44, "\u03C7", Voice.VOICELESS, Place.UVULAR, Manner.NONSIB_FRICATIVE);                            // X
    private static final Consonant VL_BILABIAL_EJECTIVE_STOP = new Consonant(44, "p\u02BC", Voice.VOICELESS, Place.BILABIAL, Ejectivity.EJECTIVE, Manner.STOP);                            // p'
    private static final Consonant VL_PALATO_ALVEOLAR_EJECTIVE_SIB_AFFRICATE = new Consonant(44, "t\u0361\u0283\u02BC", Voice.VOICELESS, Place.PALATO_ALVEOLAR, Ejectivity.EJECTIVE, Manner.SIB_AFFRICATE);                    // tS'
    //	public static final Consonant VD_DENTAL_ALVEOLAR_SIB_FRICATIVE			= new Consonant(Voice.VOICED, Place.DENTAL, Manner.SIB_FRICATIVE, 43, "z");							// "z
    private static final Consonant VD_PALATAL_STOP = new Consonant(43, "\u025F", Voice.VOICED, Place.PALATAL, Manner.STOP);                            // dj
    //	public static final Consonant VL_DENTAL_SIB_FRICATIVE					= new Consonant(Voice.VOICELESS, Place.DENTAL, Manner.SIB_FRICATIVE, 42, "s");							// sD	*
    private static final Consonant VL_BILABIAL_FRICATIVE = new Consonant(39, "\u0278", Voice.VOICELESS, Place.BILABIAL, Manner.NONSIB_FRICATIVE);                            // P
    private static final Consonant VD_LABIAL_VELAR_STOP = new Consonant(39, "g\u0361b", Voice.VOICED, Place.BILABIAL, Place.VELAR, Manner.STOP);                            // gb	*
    //	public static final Consonant VD_DENTAL_R								= new Consonant(Voice.VOICED, Place.ALVEOLAR, Manner.APPROXIMANT, 36, "r");							// "rr
    public static final Consonant VL_LABAL_VELAR_STOP = new Consonant(35, "k\u0361p", Voice.VOICELESS, Place.VELAR, Manner.STOP);                            // kp	*
    //	public static final Consonant VD_DENTAL_LAT_APPROXIMANT					= new Consonant(Voice.VOICED, Place.DENTAL, Manner.LAT_APPROXIMANT, 34, "l");							// lD	*
    private static final Consonant VL_RETROFLEX_STOP = new Consonant(34, "\u0288", Voice.VOICELESS, Place.RETROFLEX, Manner.STOP);                            // t.
    //	public static final Consonant VLA_ALVEOLAR_STOP							= new Consonant(34, "t\u02B0", Voice.VOICELESS, Aspiration.ASPIRATED, Place.ALVEOLAR, Manner.STOP);							// th
//	public static final Consonant VLA_DENTAL_STOP							= new Consonant(Voice.VOICELESS, Aspiration.ASPIRATED, Place.DENTAL, Manner.STOP, 30, "t\u02B0");							// tDh	*
    private static final Consonant VD_RETROFLEX_STOP = new Consonant(27, "\u0256", Voice.VOICED, Place.RETROFLEX, Manner.STOP);                            // d.
    private static final Consonant VD_RETROFLEX_LAT_APPROXIMANT = new Consonant(27, "\u026D", Voice.VOICED, Place.RETROFLEX, Manner.LAT_APPROXIMANT);                            // l.
    //	public static final Consonant VD_DENTAL_ALVEOLAR_FLAP					= new Consonant(Voice.VOICED, Place.DENTAL, Manner.FLAP, 26, "\u027E");							// "r[	*
//	public static final Consonant PRENASALIZED_VD_ALVEOLAR_STOP				= new Consonant(26, "n\u0361d", Voice.VOICED, Place.ALVEOLAR, Manner.STOP);							// nd
    private static final Consonant VL_UVULAR_EJECTIVE_STOP = new Consonant(26, "q\u02BC", Voice.VOICELESS, Place.UVULAR, Ejectivity.EJECTIVE, Manner.STOP);                            // q'
    private static final Consonant VL_ALVEOLAR_EJECTIVE_SIB_AFFRICATE = new Consonant(26, "t\u0361s\u02BC", Voice.VOICELESS, Place.ALVEOLAR, Ejectivity.EJECTIVE, Manner.SIB_AFFRICATE);    // ts'	*
    //	public static final Consonant VLA_DENTAL_ALVEOLAR_SIB_AFFRICATE			= new Consonant(Voice.VOICELESS, Aspiration.ASPIRATED, Place.DENTAL, Manner.SIB_AFFRICATE, 25, "t\u0361s\u02B0");							// "tsh
//	public static final Consonant LABIALIZED_VL_VELAR_FRICATIVE				= new Consonant(25, "x\u02B7", Labialization.LABIALIZED, Voice.VOICELESS, Place.VELAR, Manner.NONSIB_FRICATIVE);							// xW
//	public static final Consonant VL_DENTAL_ALVEOLAR_LAT_FRICATIVE			= new Consonant(Voice.VOICELESS, Place.DENTAL, Manner.LAT_FRICATIVE, 24, "\u026C");							// "hlF	*
//	public static final Consonant VL_DENTAL_ALVEOLAR_EJECTIVE_STOP			= new Consonant(Voice.VOICELESS, Place.DENTAL, Ejectivity.EJECTIVE, Manner.STOP, 24, "t\u02BC");							// "t'
    public static final Consonant VD_ALVEOLAR_SIB_AFFRICATE = new Consonant(24, "d\u0361z", Voice.VOICED, Place.ALVEOLAR, Manner.SIB_FRICATIVE);                            // dz
    //	public static final Consonant LABIALIZED_VD_VELAR_STOP					= new Consonant(24, "g\u02B7", Labialization.LABIALIZED, Voice.VOICED, Place.VELAR, Manner.STOP);							// gW
    private static final Consonant VD_RETROFLEX_NASAL = new Consonant(24, "\u0273", Voice.VOICED, Place.RETROFLEX, Manner.NASAL);                            // n.
    private static final Consonant VL_ALVEOLAR_EJECTIVE_STOP = new Consonant(24, "t\u02BC", Voice.VOICELESS, Place.ALVEOLAR, Ejectivity.EJECTIVE, Manner.STOP);                            // t'
    private static final Consonant VD_ALVEOLAR_IMPLOSIVE = new Consonant(23, "\u0257", Voice.VOICED, Place.ALVEOLAR, Manner.IMPLOSIVE);                            // d<
    //	public static final Consonant LABIALIZED_VL_VELAR_EJECTIVE_STOP			= new Consonant(23, "k\u02B7\u02BC", Labialization.LABIALIZED, Voice.VOICELESS, Place.VELAR, Ejectivity.EJECTIVE, Manner.STOP);							// kW'
    private static final Consonant VL_RETROFLEX_SIB_FRICATIVE = new Consonant(23, "\u0282", Voice.VOICELESS, Place.RETROFLEX, Manner.SIB_FRICATIVE);                            // s.
    public static final Consonant VD_DENTAL_FRICATIVE = new Consonant(22, "\u00F0", Voice.VOICED, Place.DENTAL, Manner.NONSIB_FRICATIVE);                            // 6D
    private static final Consonant VD_UVULAR_FRICATIVE = new Consonant(22, "\u0281", Voice.VOICED, Place.UVULAR, Manner.NONSIB_FRICATIVE);                            // RF
    private static final Consonant VL_ALVEOLAR_LAT_FRICATIVE = new Consonant(22, "\u026C", Voice.VOICELESS, Place.ALVEOLAR, Manner.LAT_FRICATIVE);                            // hlF
    //	public static final Consonant LABIALIZED_VLA_VELAR_STOP					= new Consonant(21, "k\u02B7\u02B0", Labialization.LABIALIZED, Voice.VOICELESS, Aspiration.ASPIRATED, Place.VELAR, Manner.STOP);							// kWh
//	public static final Consonant VD_DENTAL_ALVEOLAR_SIB_AFFRICATE			= new Consonant(Voice.VOICED, Place.DENTAL, Manner.SIB_AFFRICATE, 20, "d\u0361z");							// "dz
    private static final Consonant VD_PALATAL_LAT_APPROXIMANT = new Consonant(20, "\u028E", Voice.VOICED, Place.PALATAL, Manner.LAT_APPROXIMANT);                            // lj
    //	public static final Consonant VL_PALATO_ALVEOLAR_STOP					= new Consonant(Voice.VOICELESS, Place.PALATO_ALVEOLAR, Manner.STOP, 20, "t");							// t_
//	public static final Consonant VD_BILABIAL_APPROXIMANT					= new Consonant(Voice.VOICED, Place.BILABIAL, Manner.APPROXIMANT, 19, "\u03B2");							// BA
    private static final Consonant VL_PHARYNGEAL_FRICATIVE = new Consonant(19, "\u0127", Voice.VOICELESS, Place.PHARYNGEAL, Manner.NONSIB_FRICATIVE);                            // H
    public static final Consonant VL_DENTAL_FRICATIVE = new Consonant(18, "\u03B8", Voice.VOICELESS, Place.DENTAL, Manner.NONSIB_FRICATIVE);                            // 0D
    //	public static final Consonant PRENASALIZED_VD_POSTALVEOLAR_STOP			= new Consonant(Voice.VOICED, Place.POSTALVEOLAR, Manner.STOP, 17, "n\u0361d");							// "nd	*
//	public static final Consonant VL_POSTALVEOLAR_EJECTIVE_SIB_AFFRICATE	= new Consonant(Voice.VOICELESS, Place.POSTALVEOLAR, Ejectivity.EJECTIVE, Manner.SIB_AFFRICATE, 17, "t\u0361s\u02BC");							// "ts'
//	public static final Consonant LABIALIZED_VD_VELAR_NASAL					= new Consonant(17, "\u014B\u02B7", Labialization.LABIALIZED, Voice.VOICED, Place.VELAR, Manner.NASAL);							// NW
//	public static final Consonant VLA_PALATAL_STOP							= new Consonant(17, "c\u02B0", Voice.VOICELESS, Aspiration.ASPIRATED, Place.PALATAL, Manner.STOP);							// ch
    public static final Consonant VL_BILABIAL_NASAL = new Consonant(17, "m\u0325", Voice.VOICELESS, Place.BILABIAL, Manner.NASAL);                            // hm
    //	public static final Consonant LARYNGEALIZED_VD_PALATAL_APPROXIMANT		= new Consonant(Voice.VOICED, Place.PALATAL, Manner.APPROXIMANT, 17, "j");							// j*
//	public static final Consonant VLA_UVULAR_STOP							= new Consonant(17, "q\u02B0", Voice.VOICELESS, Aspiration.ASPIRATED, Place.UVULAR, Manner.STOP);							// qh
    public static final Consonant VD_RETROFLEX_APPROXIMANT = new Consonant(17, "\u027B", Voice.VOICED, Place.RETROFLEX, Manner.APPROXIMANT);                            // r.A
    //	public static final Consonant VLA_ALVEOLAR_SIB_AFFRICATE				= new Consonant(17, "t\u0361s\u02B0", Voice.VOICELESS, Aspiration.ASPIRATED, Place.ALVEOLAR, Manner.SIB_AFFRICATE);							// tsh
//	public static final Consonant LARYNGEALIZED_VD_LABIO_VELAR_APPROXIMANT	= new Consonant(Voice.VOICED, Place.LABIO_VELAR, Manner.APPROXIMANT, 17, "w");							// w*
//	public static final Consonant VD_DENTAL_SIB_FRICATIVE					= new Consonant(Voice.VOICED, Place.DENTAL, Manner.SIB_FRICATIVE, 17, "z");							// zD	*
    private static final Consonant VD_GLOTTAL_FRICATIVE = new Consonant(16, "\u0266", Voice.VOICED, Place.GLOTTAL, Manner.NONSIB_FRICATIVE);                            // hh
    public static final Consonant VL_RETROFLEX_SIB_AFFRICATE = new Consonant(16, "\u0288\u0361s", Voice.VOICED, Place.RETROFLEX, Manner.NONSIB_FRICATIVE);                            // t.s
    //	public static final Consonant VL_DENTAL_EJECTIVE_STOP					= new Consonant(Voice.VOICELESS, Place.DENTAL, Ejectivity.EJECTIVE, Manner.STOP, 16, "t\u02BC");							// tD'
//	public static final Consonant VL_DENTAL_SIB_AFFRICATE					= new Consonant(Voice.VOICELESS, Place.DENTAL, Manner.SIB_AFFRICATE, 16, "t\u0361s");							// tDs
//	public static final Consonant LARYNGEALIZED_VD_BILABIAL_STOP			= new Consonant(Voice.VOICED, Place.BILABIAL, Manner.STOP, 15, "b");							// b*
    public static final Consonant VL_LABIO_VELAR_APPROXIMANT = new Consonant(15, "\u028D", Voice.VOICELESS, Place.LABIO_VELAR, Manner.APPROXIMANT);                            // hw
    //	public static final Consonant VD_DENTAL_IMPLOSIVE						= new Consonant(Voice.VOICED, Place.DENTAL, Manner.IMPLOSIVE, 14, "\u0257");							// "d<
    private static final Consonant VD_UVULAR_STOP = new Consonant(14, "\u0262", Voice.VOICED, Place.UVULAR, Manner.STOP);                            // G
    //	public static final Consonant LABIALIZED_VL_UVULAR_FRICATIVE			= new Consonant(14, "\u03C7\u02B7", Voice.VOICELESS, Place.UVULAR, Manner.NONSIB_FRICATIVE);							// XW
//	public static final Consonant LARYNGEALIZED_VD_BILABIAL_NASAL			= new Consonant(Voice.VOICED, Place.BILABIAL, Manner.NASAL, 14, "m");							// m*
    public static final Consonant VD_RETROFLEX_FLAP = new Consonant(14, "\u027D", Voice.VOICED, Place.RETROFLEX, Manner.FLAP);                            // r.[
    //	public static final Consonant PALATALIZED_VL_VELAR_STOP					= new Consonant(13, "k\u02B2", Voice.VOICELESS, Place.VELAR, Manner.STOP);							// kJ
//	public static final Consonant PALATALIZED_VL_BILABIAL_STOP				= new Consonant(13, "p\u02B2", Voice.VOICELESS, Place.BILABIAL, Manner.STOP);							// pJ
    public static final Consonant VL_PALATAL_AFFRICATE = new Consonant(12, "c\u0361\u00E7", Voice.VOICELESS, Place.PALATAL, Manner.NONSIB_AFFRICATE);                            // cC
    public static final Consonant VD_VELAR_APPROXIMANT = new Consonant(12, "\u0270", Voice.VOICED, Place.VELAR, Manner.APPROXIMANT);                            // gA
    private static final Consonant VD_PALATAL_FRICATIVE = new Consonant(12, "\u029D", Voice.VOICED, Place.PALATAL, Manner.NONSIB_FRICATIVE);                            // jF
    //	public static final Consonant VD_PALATO_ALVEOLAR_LAT_APPROXIMANT		= new Consonant(Voice.VOICED, Place.PALATO_ALVEOLAR, Manner.LAT_APPROXIMANT, 12, "l");							// l_
//	public static final Consonant LABIALIZED_VL_UVULAR_STOP					= new Consonant(12, "q\u02B7", Labialization.LABIALIZED, Voice.VOICELESS, Place.UVULAR, Manner.STOP);							// qW
//	public static final Consonant PALATALIZED_VL_DENTAL_STOP				= new Consonant(Voice.VOICELESS, Place.DENTAL, Manner.STOP, 11, "t\u02B2");							// "tJ
//	public static final Consonant VL_DENTAL_EJECTIVE_LAT_AFFRICATE			= new Consonant(Voice.VOICELESS, Place.DENTAL, Ejectivity.EJECTIVE, Manner.LAT_AFFRICATE, 11, "t\u0361\u026C\u02BC");							// "tlF'
    public static final Consonant VL_PALATAL_FRICATIVE = new Consonant(11, "\u00E7", Voice.VOICELESS, Place.PALATAL, Manner.NONSIB_FRICATIVE);                            // C
    //	public static final Consonant LABIALIZED_VL_UVULAR_EJECTIVE_STOP		= new Consonant(11, "q\u02B7\u02BC", Labialization.LABIALIZED, Voice.VOICELESS, Place.UVULAR, Ejectivity.EJECTIVE, Manner.STOP);							// qW'
    public static final Consonant VD_ALVEOLAR_APPROXIMANT = new Consonant(11, "\u0279", Voice.VOICED, Place.ALVEOLAR, Manner.APPROXIMANT);                            // rA
    //	public static final Consonant VL_DENTAL_LAT_APPROXIMANT					= new Consonant(Voice.VOICELESS, Place.DENTAL, Manner.LAT_APPROXIMANT, 10, "l\u0325");							// "hl
    private static final Consonant VD_PHARYNGEAL_FRICATIVE = new Consonant(10, "\u0295", Voice.VOICED, Place.PHARYNGEAL, Manner.NONSIB_FRICATIVE);                            // 9
    //	public static final Consonant PRENASALIZED_LABIALIZED_VD_VELAR_STOP		= new Consonant(10, "\u014B\u0361g\u02B7", Labialization.LABIALIZED, Voice.VOICED, Place.VELAR, Manner.STOP);							// NgW
//	public static final Consonant VD_DENTAL_SIB_AFFRICATE					= new Consonant(Voice.VOICED, Place.DENTAL, Manner.SIB_AFFRICATE, 10, "d\u0361z");							// dDz
    private static final Consonant VD_PALATAL_IMPLOSIVE = new Consonant(10, "\u0284", Voice.VOICED, Place.PALATAL, Manner.IMPLOSIVE);                            // dj<
    //	public static final Consonant BVD_VELAR_STOP							= new Consonant(10, "g\u0324", Voice.BREATHY, Place.VELAR, Manner.STOP);							// gh
//	public static final Consonant PALATALIZED_VD_BILABIAL_NASAL				= new Consonant(10, "m\u02B2", Voice.VOICED, Place.BILABIAL, Manner.NASAL);							// mJ
//	public static final Consonant PRENASALIZED_VD_PALATO_ALVEOLAR_SIB_AFFRICATE	= new Consonant(10, "nd\u0361\u0292", Voice.VOICED, Place.PALATO_ALVEOLAR, Manner.SIB_AFFRICATE);							// ndZ
//	public static final Consonant VD_ALVEOLAR_								= new Consonant(Voice.VOICED, Place.ALVEOLAR, Manner.STOP, 10, "r");							// rr
//	public static final Consonant VLA_RETROFLEX_STOP						= new Consonant(10, "\u0288\u02B0", Voice.VOICELESS, Aspiration.ASPIRATED, Place.RETROFLEX, Manner.STOP);							// t.h
//	public static final Consonant VL_DENTAL_NASAL							= new Consonant(Voice.VOICELESS, Place.DENTAL, Manner.NASAL, 9, "n\u0325");							// "hn	*
    private static final Consonant VL_ALVEOLO_PALATAL_SIB_FRICATIVE = new Consonant(9, "\u0255", Voice.VOICELESS, Place.ALVEOLO_PALATAL, Manner.SIB_FRICATIVE);                            // C,
    //	public static final Consonant BVD_BILABIAL_STOP							= new Consonant(9, "b\u0324", Voice.BREATHY, Place.BILABIAL, Manner.STOP);							// bh
    private static final Consonant VL_PALATAL_EJECTIVE_STOP = new Consonant(9, "c\u02BC", Voice.VOICELESS, Place.PALATAL, Ejectivity.EJECTIVE, Manner.STOP);                            // c'
    public static final Consonant VL_VELAR_NASAL = new Consonant(9, "\u014B\u030A", Voice.VOICELESS, Place.VELAR, Manner.NASAL);                            // hN
    public static final Consonant VL_PALATAL_APPROXIMANT = new Consonant(9, "j\u030A", Voice.VOICELESS, Place.PALATAL, Manner.APPROXIMANT);                            // hj
    private static final Consonant VD_ALVEOLAR_LAT_FLAP = new Consonant(9, "\u027A", Voice.VOICED, Place.ALVEOLAR, Manner.LAT_FLAP);                            // l[
    //	public static final Consonant VD_DENTAL_TRILL							= new Consonant(Voice.VOICED, Place.DENTAL, Manner.TRILL, 9, "r");							// rD	*
//	public static final Consonant VLA_RETROFLEX_SIB_AFFRICATE				= new Consonant(9, "\u0288\u0361s\u02B0", Voice.VOICELESS, Aspiration.ASPIRATED, Place.RETROFLEX, Manner.SIB_AFFRICATE);							// t.sh
    private static final Consonant VL_ALVEOLAR_EJECTIVE_LAT_AFFRICATE = new Consonant(9, "t\u0361\u026C\u02BC", Voice.VOICELESS, Place.ALVEOLAR, Ejectivity.EJECTIVE, Manner.LAT_AFFRICATE);                            // tlF'
    private static final Consonant VD_RETROFLEX_SIB_FRICATIVE = new Consonant(9, "\u0290", Voice.VOICED, Place.RETROFLEX, Manner.SIB_FRICATIVE);                            // z.
    //	public static final Consonant LARYNGEALIZED_VD_DENTAL_NASAL				= new Consonant(Voice.VOICED, Place.DENTAL, Manner.NASAL, 8, "n");							// "n*	*
//	public static final Consonant PALATALIZED_VD_BILABIAL_STOP				= new Consonant(8, "b\u02B2", Voice.VOICED, Place.BILABIAL, Manner.STOP);							// bJ
    public static final Consonant VD_PALATAL_AFFRICATE = new Consonant(8, "\u025F\u0361\u029D", Voice.VOICED, Place.PALATAL, Manner.NONSIB_AFFRICATE);                            // djjF
    public static final Consonant VL_PALATAL_NASAL = new Consonant(8, "\u0272\u030A", Voice.VOICELESS, Place.PALATAL, Manner.NASAL);                            // hnj
    private static final Consonant VD_RETROFLEX_LAT_FLAP = new Consonant(8, "\u027A\u0306", Voice.VOICED, Place.RETROFLEX, Manner.LAT_FLAP);                            // l.[
    private static final Consonant VD_ALVEOLAR_LAT_FRICATIVE = new Consonant(8, "\u026E", Voice.VOICED, Place.ALVEOLAR, Manner.LAT_FRICATIVE);                            // lF
    //	public static final Consonant VLA_DENTAL_SIB_AFFRICATE					= new Consonant(Voice.VOICELESS, Aspiration.ASPIRATED, Place.DENTAL, Manner.SIB_AFFRICATE, 8, "t\u0361s\u02B0");							// tDsh	*
//	public static final Consonant LARYNGEALIZED_VD_DENTAL_LAT_APPROXIMANT	= new Consonant(Voice.VOICED, Place.DENTAL, Manner.LAT_APPROXIMANT, 7, "l");							// "l*	*
//	public static final Consonant VL_DENTAL_EJECTIVE_SIB_FRICATIVE			= new Consonant(Voice.VOICELESS, Place.DENTAL, Ejectivity.EJECTIVE, Manner.SIB_FRICATIVE, 7, "s\u02BC");							// "s'	*
//	public static final Consonant PALATALIZED_VL_DENTAL_SIB_FRICATIVE		= new Consonant(Voice.VOICELESS, Place.DENTAL, Manner.SIB_FRICATIVE, 7, "s\u02B2");							// "sJ	*
    private static final Consonant VD_LABIAL_VELAR_NASAL = new Consonant(7, "\u014B\u0361m", Voice.VOICED, Place.BILABIAL, Place.VELAR, Manner.NASAL);                            // Nm
    public static final Consonant VL_ALVEOLO_PALATAL_SIB_AFFRICATE = new Consonant(7, "t\u0361\u0255", Voice.VOICELESS, Place.ALVEOLO_PALATAL, Manner.SIB_AFFRICATE);                            // cC,
    //	public static final Consonant LARYNGEALIZED_VD_ALVEOLAR_STOP			= new Consonant(Voice.VOICED, Place.ALVEOLAR, Manner.STOP, 7, "d");							// d*
//	public static final Consonant BVD_PALATO_ALVEOLAR_SIB_AFFRICATE			= new Consonant(7, "d\u0361\u0292\u0324", Voice.BREATHY, Place.PALATO_ALVEOLAR, Manner.SIB_AFFRICATE);							// dZh
//	public static final Consonant PALATALIZED_VD_VELAR_STOP					= new Consonant(7, "g\u02B2", Voice.VOICED, Place.VELAR, Manner.STOP);							// gJ
//	public static final Consonant VD_ALVEOLAR_FLAP							= new Consonant(Voice.VOICED, Place.ALVEOLAR, Manner.STOP, 7, "");							// rT
    private static final Consonant VD_ALVEOLO_PALATAL_SIB_FRICATIVE = new Consonant(7, "\u0291", Voice.VOICED, Place.ALVEOLO_PALATAL, Manner.SIB_FRICATIVE);                            // z,
    //	public static final Consonant PALATALIZED_VD_DENTAL_LAT_APPROXIMANT		= new Consonant(Voice.VOICED, Place.DENTAL, Manner.LAT_APPROXIMANT, 6, "l\u02B2");							// "lJ	*
//	public static final Consonant VL_DENTAL_LAT_AFFRICATE					= new Consonant(Voice.VOICELESS, Place.DENTAL, Manner.LAT_AFFRICATE, 6, "t\u0361\u026C");							// "tlF	*
//	public static final Consonant PRENASALIZED_VL_VELAR_STOP				= new Consonant(6, "\u014B\u0361k", Voice.VOICELESS, Place.VELAR, Manner.STOP);							// Nk
//	public static final Consonant PRENASALIZED_VD_LABIAL_VELAR_STOP			= new Consonant(6, "nmg\u0361b", Voice.VOICED, Place.BILABIAL, Place.VELAR, Manner.STOP);							// Nmgb
//	public static final Consonant BVD_RETROFLEX_STOP						= new Consonant(6, "\u0257\u0324", Voice.BREATHY, Place.RETROFLEX, Manner.STOP);							// d.h
//	public static final Consonant VD_PALATO_ALVEOLAR_STOP					= new Consonant(Voice.VOICED, Place.PALATO_ALVEOLAR, Manner.STOP, 6, "d");							// d_
//	public static final Consonant LABIALIZED_VD_VELAR_FRICATIVE				= new Consonant(6, "\u0263\u02B7", Labialization.LABIALIZED, Voice.VOICED, Place.VELAR, Manner.NONSIB_FRICATIVE);							// gFW
//	public static final Consonant LARYNGEALIZED_VL_VELAR_STOP				= new Consonant(Voice.VOICELESS, Place.VELAR, Manner.STOP, 6, "k");							// k*
//	public static final Consonant PRENASALIZED_VL_BILABIAL_STOP				= new Consonant(6, "m\u0361p", Voice.VOICELESS, Place.BILABIAL, Manner.STOP);							// mp
//	public static final Consonant PRENASALIZED_VD_DENTAL_STOP				= new Consonant(Voice.VOICED, Place.DENTAL, Manner.STOP, 6, "n\u0361d");							// ndD	*
//	public static final Consonant PRENASALIZED_VD_PALATAL_STOP				= new Consonant(6, "\u0272\u0361\u025F", Voice.VOICED, Place.PALATAL, Manner.STOP);							// ndj
//	public static final Consonant VL_DENTAL_EJECTIVE_SIB_AFFRICATE			= new Consonant(Voice.VOICELESS, Place.DENTAL, Ejectivity.EJECTIVE, Manner.SIB_AFFRICATE, 6, "t\u0361s\u02BC");							// tDs'	*
    public static final Consonant VD_LABIODENTAL_APPROXIMANT = new Consonant(6, "\u028B", Voice.VOICED, Place.LABIODENTAL, Manner.APPROXIMANT);                            // vA
    //	public static final Consonant LABIALIZED_VD_PALATAL_APPROXIMANT			= new Consonant(6, "\u0265", Labialization.LABIALIZED, Voice.VOICED, Place.PALATAL, Manner.APPROXIMANT);							// wj
//	public static final Consonant PALATALIZED_VD_DENTAL_STOP				= new Consonant(Voice.VOICED, Place.DENTAL, Manner.STOP, 5, "d\u02B2");							// "dJ	*
//	public static final Consonant VD_DENTAL_LAT_AFFRICATE					= new Consonant(Voice.VOICED, Place.DENTAL, Manner.LAT_AFFRICATE, 5, "d\u0361\u026E");							// "dlF	*
//	public static final Consonant VELARIZED_VD_DENTAL_LAT_APPROXIMANT		= new Consonant(Voice.VOICED, Place.DENTAL, Manner.LAT_APPROXIMANT, 5, "l\u02E0");							// "l-	*
    public static final Consonant LABIALIZED_VD_UVULAR_STOP = new Consonant(5, "\u0262\u02B7", Labialization.LABIALIZED, Voice.VOICED, Place.UVULAR, Manner.STOP);                            // GW
    //	public static final Consonant BVD_DENTAL_STOP							= new Consonant(Voice.BREATHY, Place.DENTAL, Manner.STOP, 5, "d\u0324");							// dDh	*
    private static final Consonant VD_VELAR_IMPLOSIVE = new Consonant(5, "\u0260", Voice.VOICED, Place.VELAR, Manner.IMPLOSIVE);                            // g<
    //	public static final Consonant LABIALIZED_VL_GLOTTAL_FRICATIVE			= new Consonant(5, "h\u02B7", Labialization.LABIALIZED, Voice.VOICELESS, Place.GLOTTAL, Manner.NONSIB_FRICATIVE);							// hW
//	public static final Consonant LARYNGEALIZED_VD_ALVEOLAR_LAT_APPROXIMANT	= new Consonant(Voice.VOICED, Place.ALVEOLAR, Manner.LAT_APPROXIMANT, 5, "l");							// l*
//	public static final Consonant LABIALIZED_VD_BILABIAL_NASAL				= new Consonant(5, "m\u02B7", Labialization.LABIALIZED, Voice.VOICED, Place.BILABIAL, Manner.NASAL);							// mW
//	public static final Consonant PRENASALIZED_VD_ALVEOLAR_SIB_AFFRICATE	= new Consonant(5, "nd\u0361z", Voice.VOICED, Place.ALVEOLAR, Manner.SIB_AFFRICATE);							// ndz
    private static final Consonant NASALIZED_VD_DENTAL_AFFRICATED_CLICK = new Consonant(5, "\u01C0\u0303", Voice.VOICED, Place.DENTAL, Manner.CLICK);                            // n|
    //	public static final Consonant LARYNGEALIZED_VL_BILABIAL_STOP			= new Consonant(Voice.VOICELESS, Place.BILABIAL, Manner.STOP, 5, "p");							// p*
    private static final Consonant VL_ALVEOLAR_LAT_AFFRICATE = new Consonant(5, "t\u0361\u026C", Voice.VOICELESS, Place.ALVEOLAR, Manner.LAT_AFFRICATE);                            // tlF
    //	public static final Consonant PALATALIZED_VD_LABIODENTAL_FRICATIVE		= new Consonant(5, "v\u02B2", Voice.VOICED, Place.LABIODENTAL, Manner.NONSIB_FRICATIVE);							// vJ
    private static final Consonant VL_DENTAL_AFFRICATED_CLICK = new Consonant(5, "\u01C0", Voice.VOICED, Place.ALVEOLAR, Manner.CLICK);                            // |
    
    /* Vowel */
    public static final Vowel CLOSE_FRONT_UR = new Vowel(393, "i", Height.CLOSE, Backness.FRONT, Roundedness.UNROUNDED);                                    // UPSID   i
    public static final Vowel OPEN_CENTRAL_UR = new Vowel(392, "a", Height.OPEN, Backness.CENTRAL, Roundedness.UNROUNDED);                                            // a
    public static final Vowel CLOSE_BACK_RD = new Vowel(369, "u", Height.CLOSE, Backness.BACK, Roundedness.ROUNDED);                                                // u
    public static final Vowel OPEN_MID_FRONT_UR = new Vowel(186, "\u025B", Height.OPEN_MID, Backness.FRONT, Roundedness.UNROUNDED);                                    // E
    public static final Vowel MID_BACK_RD = new Vowel(181, "o", Height.MID, Backness.BACK, Roundedness.ROUNDED);                                                    // "o	*
    public static final Vowel MID_FRONT_UR = new Vowel(169, "e", Height.MID, Backness.FRONT, Roundedness.UNROUNDED);                                                // "e	*
    public static final Vowel OPEN_MID_BACK_RD = new Vowel(162, "\u0254", Height.OPEN_MID, Backness.BACK, Roundedness.ROUNDED);                                        // O
    //	public static final Vowel CLOSE_MID_BACK_RD			= new Vowel(131, "o", Height.CLOSE_MID, Backness.BACK, Roundedness.ROUNDED);											// o
//	public static final Vowel CLOSE_MID_FRONT_UR		= new Vowel(124, "e", Height.CLOSE_MID, Backness.FRONT, Roundedness.UNROUNDED); 										// e
    private static final Vowel N_OPEN_CENTRAL_UR = new Vowel(83, "a\u0303", Nasalization.NASAL, Height.OPEN, Backness.CENTRAL, Roundedness.UNROUNDED);                    // a~
    private static final Vowel N_CLOSE_FRONT_UR = new Vowel(82, "i\u0303", Nasalization.NASAL, Height.CLOSE, Backness.FRONT, Roundedness.UNROUNDED);                        // i~
    public static final Vowel MID_CENTRAL_UR = new Vowel(76, "\u0259", Height.MID, Backness.CENTRAL, Roundedness.UNROUNDED);                                        // "@
    public static final Vowel NEAR_CLOSE_NEAR_FRONT_UR = new Vowel(74, "\u026A", Height.NEAR_CLOSE, Backness.NEAR_FRONT, Roundedness.UNROUNDED);                                // I
    private static final Vowel N_CLOSE_BACK_RD = new Vowel(74, "u\u0303", Nasalization.NASAL, Height.CLOSE, Backness.BACK, Roundedness.ROUNDED);                        // u~
    public static final Vowel NEAR_CLOSE_NEAR_BACK_RD = new Vowel(66, "\u028A", Height.NEAR_CLOSE, Backness.NEAR_BACK, Roundedness.ROUNDED);                                // U
    public static final Vowel CLOSE_CENTRAL_UR = new Vowel(61, "\u0268", Height.CLOSE, Backness.CENTRAL, Roundedness.UNROUNDED);                                        // i_
    public static final Vowel CLOSE_BACK_UR = new Vowel(41, "\u026F", Height.CLOSE, Backness.BACK, Roundedness.UNROUNDED);                                        // uu
    public static final Vowel L_CLOSE_FRONT_UR = new Vowel(40, "i\u02D0", Length.LONG, Height.CLOSE, Backness.FRONT, Roundedness.UNROUNDED);                            // i:
    public static final Vowel NEAR_OPEN_FRONT_UR = new Vowel(39, "\u00E6", Height.NEAR_OPEN, Backness.FRONT, Roundedness.UNROUNDED);                                    // aa
    public static final Vowel L_CLOSE_BACK_RD = new Vowel(36, "u\u02D0", Length.LONG, Height.CLOSE, Backness.BACK, Roundedness.ROUNDED);                            // u:
    private static final Vowel N_MID_BACK_RD = new Vowel(35, "o\u0303", Nasalization.NASAL, Height.MID, Backness.BACK, Roundedness.ROUNDED);                            // "o~	*
    private static final Vowel N_OPEN_MID_FRONT_UR = new Vowel(35, "\u025B\u0303", Nasalization.NASAL, Height.OPEN_MID, Backness.FRONT, Roundedness.UNROUNDED);                // E~
    public static final Vowel L_OPEN_CENTRAL_UR = new Vowel(34, "a\u02D0", Length.LONG, Height.OPEN, Backness.CENTRAL, Roundedness.UNROUNDED);                        // a:
    private static final Vowel N_MID_FRONT_UR = new Vowel(33, "e\u0303", Nasalization.NASAL, Height.MID, Backness.FRONT, Roundedness.UNROUNDED);                        // "e~	*
    private static final Vowel N_OPEN_MID_BACK_RD = new Vowel(32, "\u0254\u0303", Nasalization.NASAL, Height.OPEN_MID, Backness.BACK, Roundedness.ROUNDED);                // O~
    //	public static final Vowel N_CLOSE_MID_BACK_RD		= new Vowel(27, "o\u0303", Nasalization.NASAL, Height.CLOSE_MID, Backness.BACK, Roundedness.ROUNDED); 					// o~
//	public static final Vowel OPEN_FRONT_UR				= new Vowel(26, "a", Height.OPEN, Backness.FRONT, Roundedness.UNROUNDED); 												// a+
    public static final Vowel OPEN_BACK_UR = new Vowel(25, "\u0251", Height.OPEN, Backness.BACK, Roundedness.UNROUNDED);                                            // a_
    //	public static final Vowel L_CLOSE_MID_BACK_RD		= new Vowel(24, "o\u02D0", Length.LONG, Height.CLOSE_MID, Backness.BACK, Roundedness.ROUNDED); 						// o:
    public static final Vowel CLOSE_FRONT_RD = new Vowel(24, "y", Height.CLOSE, Backness.FRONT, Roundedness.ROUNDED);                                                // y
    //	public static final Vowel L_CLOSE_MID_FRONT_UR		= new Vowel(21, "e\u02D0", Length.LONG, Height.CLOSE_MID, Backness.FRONT, Roundedness.UNROUNDED); 						// e:
    public static final Vowel CLOSE_MID_CENTRAL_UR = new Vowel(20, "\u0258", Height.CLOSE_MID, Backness.CENTRAL, Roundedness.UNROUNDED);                                    // @
    public static final Vowel OPEN_BACK_RD = new Vowel(19, "\u0252", Height.OPEN, Backness.BACK, Roundedness.ROUNDED);                                            // a_)
    //	public static final Vowel CLOSE_MID_FRONT_UR		= new Vowel(124, "e", Height.CLOSE_MID, Backness.FRONT, Roundedness.UNROUNDED); 										// ai
//	public static final Vowel CLOSE_MID_FRONT_UR		= new Vowel(124, "e", Height.CLOSE_MID, Backness.FRONT, Roundedness.UNROUNDED); 										// au
//	public static final Vowel N_CLOSE_MID_FRONT_UR		= new Vowel(18, "e\u0303", Nasalization.NASAL, Height.CLOSE_MID, Backness.FRONT, Roundedness.UNROUNDED); 					// e~
    public static final Vowel OPEN_MID_CENTRAL_UR = new Vowel(15, "\u025C", Height.CLOSE_MID, Backness.CENTRAL, Roundedness.UNROUNDED);                                    // 3
    public static final Vowel NEAR_OPEN_CETNRAL_UR = new Vowel(14, "\u0250", Height.NEAR_OPEN, Backness.CENTRAL, Roundedness.UNROUNDED);                                    // 4
    public static final Vowel L_OPEN_MID_FRONT_UR = new Vowel(14, "\u025B\u02D0", Length.LONG, Height.OPEN_MID, Backness.FRONT, Roundedness.UNROUNDED);                    // E:
    private static final Vowel N_MID_CENTRAL_UR = new Vowel(12, "\u0259\u0303", Nasalization.NASAL, Height.MID, Backness.CENTRAL, Roundedness.UNROUNDED);                // "@~
    public static final Vowel L_MID_BACK_RD = new Vowel(12, "o\u02D0", Length.LONG, Height.MID, Backness.BACK, Roundedness.ROUNDED);                                // "o:	*
    public static final Vowel CLOSE_MID_BACK_UR = new Vowel(12, "\u0264", Height.CLOSE_MID, Backness.BACK, Roundedness.UNROUNDED);                                    // o(
    public static final Vowel CLOSE_MID_FRONT_RD = new Vowel(12, "\u00F8", Height.CLOSE_MID, Backness.FRONT, Roundedness.ROUNDED);                                        // o/
    public static final Vowel L_MID_FRONT_UR = new Vowel(11, "e\u02D0", Length.LONG, Height.MID, Backness.FRONT, Roundedness.UNROUNDED);                            // "e:	*
    private static final Vowel N_CLOSE_CENTRAL_UR = new Vowel(11, "\u0268\u0303", Nasalization.NASAL, Height.CLOSE, Backness.CENTRAL, Roundedness.UNROUNDED);                // i_~
    private static final Vowel N_NEAR_CLOSE_NEAR_FRONT_UR = new Vowel(10, "\u026A\u0303", Nasalization.NASAL, Height.NEAR_CLOSE, Backness.NEAR_FRONT, Roundedness.UNROUNDED);        // I~
    public static final Vowel OPEN_MID_BACK_UR = new Vowel(10, "\u028C", Height.OPEN_MID, Backness.BACK, Roundedness.UNROUNDED);                                        // ^
    private static final Vowel N_NEAR_OPEN_FRONT_UR = new Vowel(10, "\u00E6\u0303", Nasalization.NASAL, Height.NEAR_OPEN, Backness.FRONT, Roundedness.UNROUNDED);            // aa~
    private static final Vowel N_NEAR_CLOSE_NEAR_BACK_RD = new Vowel(9, "\u028A\u0303", Nasalization.NASAL, Height.NEAR_CLOSE, Backness.NEAR_BACK, Roundedness.ROUNDED);            // U~
    //	public static final Vowel MID_BACK_UR				= new Vowel(8, "\u0264", Height.MID, Backness.BACK, Roundedness.UNROUNDED); 											// "o(	*
    public static final Vowel OPEN_MID_FRONT_RD = new Vowel(8, "\u0153", Height.OPEN_MID, Backness.FRONT, Roundedness.ROUNDED);                                        // E)
    public static final Vowel L_OPEN_MID_BACK_RD = new Vowel(8, "\u0254\u02D0", Length.LONG, Height.OPEN_MID, Backness.BACK, Roundedness.ROUNDED);                        // O:
    public static final Vowel L_OPEN_BACK_UR = new Vowel(8, "\u0251\u02D0", Length.LONG, Height.OPEN, Backness.BACK, Roundedness.UNROUNDED);                        // a_:
    public static final Vowel L_NEAR_OPEN_FRONT_UR = new Vowel(8, "\u00E6\u02D0", Length.LONG, Height.NEAR_OPEN, Backness.FRONT, Roundedness.UNROUNDED);                    // aa:
    private static final Vowel LN_CLOSE_FRONT_UR = new Vowel(8, "i\u0303\u02D0", Length.LONG, Nasalization.NASAL, Height.CLOSE, Backness.FRONT, Roundedness.UNROUNDED);    // i~:
    //	public static final Vowel CLOSE_MID_FRONT_UR		= new Vowel(124, "e", Height.CLOSE_MID, Backness.FRONT, Roundedness.UNROUNDED); 										// ui
    private static final Vowel LN_OPEN_CENTRAL_UR = new Vowel(7, "a\u0303\u02D0", Length.LONG, Nasalization.NASAL, Height.OPEN, Backness.CENTRAL, Roundedness.UNROUNDED);    // a~:
    //	public static final Vowel CLOSE_MID_FRONT_UR		= new Vowel(124, "e", Height.CLOSE_MID, Backness.FRONT, Roundedness.UNROUNDED); 										// ei
    private static final Vowel N_CLOSE_BACK_UR = new Vowel(7, "\u026F\u0303", Nasalization.NASAL, Height.CLOSE, Backness.BACK, Roundedness.UNROUNDED);                    // uu~
    private static final Vowel LN_CLOSE_BACK_RD = new Vowel(7, "u\u0303\u02D0", Length.LONG, Nasalization.NASAL, Height.CLOSE, Backness.BACK, Roundedness.ROUNDED);        // u~:
    //	public static final Vowel CLOSE_MID_FRONT_UR		= new Vowel(124, "e", Height.CLOSE_MID, Backness.FRONT, Roundedness.UNROUNDED); 										// Oi
    private static final Vowel N_OPEN_BACK_UR = new Vowel(6, "\u0251\u0303", Nasalization.NASAL, Height.OPEN, Backness.BACK, Roundedness.UNROUNDED);                    // a_~
    //	public static final Vowel CLOSE_MID_FRONT_UR		= new Vowel(124, "e", Height.CLOSE_MID, Backness.FRONT, Roundedness.UNROUNDED); 										// ie
//	public static final Vowel CLOSE_MID_FRONT_UR		= new Vowel(124, "e", Height.CLOSE_MID, Backness.FRONT, Roundedness.UNROUNDED); 										// oi
    public static final Vowel CLOSE_CENTRAL_RD = new Vowel(6, "\u0289", Height.CLOSE, Backness.CENTRAL, Roundedness.ROUNDED);                                        // u+
    public static final Vowel MID_CENTRAL_RD = new Vowel(5, "\u0275", Height.MID, Backness.CENTRAL, Roundedness.ROUNDED);                                            // "@)	*
//	public static final Vowel L_OPEN_FRONT_UR			= new Vowel(5, "a\u02D0", Length.LONG, Height.OPEN, Backness.FRONT, Roundedness.UNROUNDED); 							// a+:
//	public static final Vowel N_OPEN_FRONT_UR			= new Vowel(5, "a\u0303", Nasalization.NASAL, Height.OPEN, Backness.FRONT, Roundedness.UNROUNDED); 						// a+~
//	public static final Vowel CLOSE_MID_FRONT_UR		= new Vowel(124, "e", Height.CLOSE_MID, Backness.FRONT, Roundedness.UNROUNDED); 										// ah
    
    // Consonant categories - by manner of articulation
    public static final Consonant[] BASIC_PLOSIVE_SYSTEM = {VL_BILABIAL_STOP, VL_ALVEOLAR_STOP, VL_VELAR_STOP,
            VD_BILABIAL_STOP, VD_ALVEOLAR_STOP, VD_VELAR_STOP};
    
    public static final Consonant[] NASALS = {VD_BILABIAL_NASAL, VD_ALVEOLAR_NASAL, VD_RETROFLEX_NASAL,
            VD_VELAR_NASAL};
    public static final Consonant[] STOPS = {VL_BILABIAL_STOP, VD_BILABIAL_STOP, VL_ALVEOLAR_STOP,
            VD_ALVEOLAR_STOP, VL_RETROFLEX_STOP, VD_RETROFLEX_STOP, VL_PALATAL_STOP, VD_PALATAL_STOP,
            VL_VELAR_STOP, VD_VELAR_STOP, VL_UVULAR_STOP, VD_UVULAR_STOP};
    public static final Consonant[] FRICATIVES = {VL_ALVEOLAR_SIB_FRICATIVE, VD_ALVEOLAR_SIB_FRICATIVE,
            VD_PALATO_ALVEOLAR_SIB_FRICATIVE, VL_RETROFLEX_SIB_FRICATIVE, VD_RETROFLEX_SIB_FRICATIVE,
            VL_ALVEOLO_PALATAL_SIB_FRICATIVE, VD_ALVEOLO_PALATAL_SIB_FRICATIVE, VL_BILABIAL_FRICATIVE,
            VD_BILABIAL_FRICATIVE, VL_LABIODENTAL_FRICATIVE, VD_LABIODENTAL_FRICATIVE, VD_DENTAL_FRICATIVE,
            VL_DENTAL_FRICATIVE, VL_ALVEOLO_PALATAL_SIB_FRICATIVE, VD_PALATAL_FRICATIVE, VL_VELAR_FRICATIVE,
            VD_VELAR_FRICATIVE, VL_UVULAR_FRICATIVE, VD_UVULAR_FRICATIVE, VL_PHARYNGEAL_FRICATIVE,
            VD_PHARYNGEAL_FRICATIVE, VL_GLOTTAL_FRICATIVE, VD_GLOTTAL_FRICATIVE};
    
    public static final Consonant[] LATERALS = {VL_ALVEOLAR_LAT_AFFRICATE, VL_ALVEOLAR_LAT_FRICATIVE,
            VD_ALVEOLAR_LAT_FRICATIVE, VD_ALVEOLAR_LAT_APPROXIMANT, VD_RETROFLEX_LAT_APPROXIMANT,
            VD_PALATAL_LAT_APPROXIMANT, VD_ALVEOLAR_LAT_FLAP, VD_RETROFLEX_LAT_FLAP};
    public static final Consonant[] LATERAL_OBSTRUENTS = {VL_ALVEOLAR_LAT_AFFRICATE, VL_ALVEOLAR_LAT_FRICATIVE,
            VD_ALVEOLAR_LAT_FRICATIVE};
    public static final Consonant[] LATERAL_OTHERS = {VD_RETROFLEX_LAT_APPROXIMANT, VD_PALATAL_LAT_APPROXIMANT,
            VD_ALVEOLAR_LAT_FLAP, VD_RETROFLEX_LAT_FLAP};
    
    public static final Consonant[] CLICKS = {VL_DENTAL_AFFRICATED_CLICK, NASALIZED_VD_DENTAL_AFFRICATED_CLICK};
    
    // By place of articulation
    public static final Consonant[] BILABIALS = {VD_BILABIAL_NASAL, VL_BILABIAL_STOP,
            VL_BILABIAL_FRICATIVE, VD_BILABIAL_FRICATIVE};
    
    public static final Consonant[] UVULARS = {VL_UVULAR_STOP, VD_UVULAR_STOP, VL_UVULAR_FRICATIVE,
            VD_UVULAR_FRICATIVE};
    public static final Consonant[] UVULAR_STOPS = {VL_UVULAR_STOP, VD_UVULAR_STOP};
    public static final Consonant[] UVULAR_FRICATIVES = {VL_UVULAR_FRICATIVE, VD_UVULAR_FRICATIVE};
    
    public static final Consonant[] LABIAL_VELARS = {VD_LABIAL_VELAR_STOP, VD_LABIAL_VELAR_NASAL};
    
    // Other consonant categories
    public static final Consonant[] EJECTIVES = {VL_BILABIAL_EJECTIVE_STOP, VL_ALVEOLAR_EJECTIVE_STOP,
            VL_PALATAL_EJECTIVE_STOP, VL_VELAR_EJECTIVE_STOP, VL_UVULAR_EJECTIVE_STOP,
            VL_ALVEOLAR_EJECTIVE_SIB_AFFRICATE, VL_ALVEOLAR_EJECTIVE_LAT_AFFRICATE,
            VL_PALATO_ALVEOLAR_EJECTIVE_SIB_AFFRICATE};
    public static final Consonant[] IMPLOSIVES = {VD_BILABIAL_IMPLOSIVE, VD_ALVEOLAR_IMPLOSIVE,
            VD_PALATAL_IMPLOSIVE, VD_VELAR_IMPLOSIVE};
    
    // Vowel categories
    public static final Vowel[] NASAL_VOWELS = {N_CLOSE_BACK_RD, N_CLOSE_BACK_UR, N_CLOSE_CENTRAL_UR,
            N_CLOSE_FRONT_UR, N_MID_BACK_RD, N_MID_CENTRAL_UR, N_MID_FRONT_UR, N_NEAR_CLOSE_NEAR_BACK_RD,
            N_NEAR_CLOSE_NEAR_FRONT_UR, N_NEAR_OPEN_FRONT_UR, N_OPEN_BACK_UR, N_OPEN_CENTRAL_UR,
            N_OPEN_MID_BACK_RD, N_OPEN_MID_FRONT_UR, LN_CLOSE_BACK_RD, LN_CLOSE_FRONT_UR, LN_OPEN_CENTRAL_UR};
}
