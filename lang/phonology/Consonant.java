package lang.phonology;

import lang.Data;

/* Contains all possible consonant phonemes with their features, UPSID occurrence, and IPA symbol */
public enum Consonant {
	VD_BILABIAL_NASAL							(Voice.VOICED, Place.BILABIAL, Manner.NASAL, 425, "m"),					// UPSID   m
	VL_VELAR_STOP								(Voice.VOICELESS, Place.VELAR, Manner.STOP, 403, "k"),							// k
	VD_PALATAL_APPROXIMANT						(Voice.VOICED, Place.PALATAL, Manner.APPROXIMANT, 378, "j"),					// j
	VL_BILABIAL_STOP							(Voice.VOICELESS, Place.BILABIAL, Manner.STOP, 375, "p"),						// p
	VD_LABIO_VELAR_APPROXIMANT					(Voice.VOICED, Place.LABIO_VELAR, Manner.APPROXIMANT, 332, "w"),				// w
	VD_BILABIAL_STOP							(Voice.VOICED, Place.BILABIAL, Manner.STOP, 287, "b"),							// b
	VL_GLOTTAL_FRICATIVE						(Voice.VOICELESS, Place.GLOTTAL, Manner.NONSIB_FRICATIVE, 279, "h"),			// h
	VD_VELAR_STOP								(Voice.VOICED, Place.VELAR, Manner.STOP, 253, "g"),								// g
	VD_VELAR_NASAL								(Voice.VOICED, Place.VELAR, Manner.NASAL, 237, "\u014B"),						// N
	VL_GLOTTAL_STOP								(Voice.VOICELESS, Place.GLOTTAL, Manner.STOP, 216, "\u0294"),					// ?
	VD_ALVEOLAR_NASAL							(Voice.VOICED, Place.ALVEOLAR, Manner.NASAL, 202, "n"),							// n
	VL_ALVEOLAR_SIB_FRICATIVE					(Voice.VOICELESS, Place.ALVEOLAR, Manner.SIB_FRICATIVE, 196, "s"),				// s
	VL_PALATO_ALVEOLAR_SIB_AFFRICATE			(Voice.VOICELESS, Place.PALATO_ALVEOLAR, Manner.SIB_AFFRICATE, 188, "t\u0361\u0283"),	// tS
	VL_PALATO_ALVEOLAR_SIB_FRICATIVE			(Voice.VOICELESS, Place.PALATO_ALVEOLAR, Manner.SIB_FRICATIVE, 187, "\u0283"),	// S
	VL_ALVEOLAR_STOP							(Voice.VOICELESS, Place.ALVEOLAR, Manner.STOP, 181, "t"),						// t
	VL_LABIODENTAL_FRICATIVE					(Voice.VOICELESS, Place.LABIODENTAL, Manner.NONSIB_FRICATIVE, 180, "f"),		// f
	VD_ALVEOLAR_LAT_APPROXIMANT					(Voice.VOICED, Place.ALVEOLAR, Manner.LAT_APPROXIMANT, 174, "l"),				// l
	VD_DENTAL_ALVEOLAR_NASAL					(Voice.VOICED, Place.DENTAL, Manner.NASAL, 160, "n"),							// "n	*
	VL_DENTAL_ALVEOLAR_STOP						(Voice.VOICELESS, Place.DENTAL, Manner.STOP, 152, "t"),							// "t	*
	VD_PALATAL_NASAL							(Voice.VOICED, Place.PALATAL, Manner.NASAL, 141, "\u0272"),						// nj
	VD_DENTAL_ALVEOLAR_LAT_APPROXIMANT			(Voice.VOICED, Place.DENTAL, Manner.LAT_APPROXIMANT, 136, "l"),					// "l	*
	VL_DENTAL_ALVEOLARD_SIB_FRICATIVE			(Voice.VOICELESS, Place.DENTAL, Manner.SIB_FRICATIVE, 135, "s"),				// "s	*
	VD_ALVEOLAR_STOP							(Voice.VOICED, Place.ALVEOLAR, Manner.STOP, 120, "d"),							// d
	VD_PALATO_ALVEOLAR_SIB_AFFRICATE			(Voice.VOICED, Place.PALATO_ALVEOLAR, Manner.SIB_AFFRICATE, 113, "d\u0361\u0292"),	// dZ
	VL_DENTAL_STOP								(Voice.VOICELESS, Place.DENTAL, Manner.STOP, 106, "t"),							// tD	*
	VLA_VELAR_STOP								(Voice.VOICELESS, Consonant.ASPIRATED, Place.VELAR, Manner.STOP, 103, "k\u02B0"),	// kh
	VLA_BILABIAL_STOP							(Voice.VOICELESS, Consonant.ASPIRATED, Place.BILABIAL, Manner.STOP, 101, "p\u02B0"),// ph
	VD_ALVEOLAR_TRILL							(Voice.VOICED, Place.ALVEOLAR, Manner.TRILL, 95, "r"),							// r
	VD_LABIODENTAL_FRICATIVE					(Voice.VOICED, Place.LABIODENTAL, Manner.NONSIB_FRICATIVE, 95, "v"),			// v
	VL_VELAR_FRICATIVE							(Voice.VOICELESS, Place.VELAR, Manner.NONSIB_FRICATIVE, 94, "x"),							// x
	VD_DENTAL_ALVEOLAR_STOP						(Voice.VOICED, Place.DENTAL, Manner.STOP, 91, "d"),							// "d	*
	VD_ALVEOLAR_FLAP							(Voice.VOICED, Place.ALVEOLAR, Manner.FLAP, 91, "\u027E"),							// r[
	VD_DENTAL_NASAL								(Voice.VOICED, Place.DENTAL, Manner.NASAL, 83, "n"),							// nD	*
	VD_DENTAL_STOP								(Voice.VOICED, Place.DENTAL, Manner.STOP, 80, "d"),							// dD	*
	VL_VELAR_EJECTIVE_STOP						(Voice.VOICELESS, Place.VELAR, Consonant.EJECTIVE, Manner.STOP, 63, "k\u02BC"),							// k'
	VL_ALVEOLAR_SIB_AFFRICATE					(Voice.VOICELESS, Place.ALVEOLAR, Manner.SIB_AFFRICATE, 62, "t\u0361s"),							// ts
	VD_ALVEOLAR_SIB_FRICATIVE					(Voice.VOICED, Place.ALVEOLAR, Manner.SIB_FRICATIVE, 62, "z"),							// z
	VD_PALATO_ALVEOLAR_SIB_FRICATIVE			(Voice.VOICED, Place.PALATO_ALVEOLAR, Manner.SIB_FRICATIVE, 61, "\u0292"),							// Z
	LABIALIZED_VL_VELAR_STOP					(Consonant.LABIALIZED, Voice.VOICELESS, Place.VELAR, Manner.STOP, 60, "k\u02B7"),							// kW
	VD_VELAR_FRICATIVE							(Voice.VOICED, Place.VELAR, Manner.NONSIB_FRICATIVE, 55, "\u0263"),							// gF
	VD_BILABIAL_FRICATIVE						(Voice.VOICED, Place.BILABIAL, Manner.NONSIB_FRICATIVE, 54, "\u03B2"),							// B
	VL_PALATAL_STOP								(Voice.VOICELESS, Place.PALATAL, Manner.STOP, 54, "c"),							// c
	VL_UVULAR_STOP								(Voice.VOICELESS, Place.UVULAR, Manner.STOP, 52, "q"),							// q
	VD_DENTAL_ALVEOLAR_TRILL					(Voice.VOICED, Place.DENTAL, Manner.TRILL, 51, "r"),							// "r	*
	VLA_PALATO_ALVEOLAR_SIB_AFFRICATE			(Voice.VOICELESS, Consonant.ASPIRATED, Place.PALATO_ALVEOLAR, Manner.SIB_AFFRICATE, 51, "t\u0361\u0283\u02B0"),							// tSh
	VLA_DENTAL_ALVEOLAR_STOP					(Voice.VOICED, Consonant.ASPIRATED, Place.ALVEOLAR, Manner.STOP, 49, "t\u02B0"),							// "th
	VD_BILABIAL_IMPLOSIVE						(Voice.VOICED, Place.BILABIAL, Manner.IMPLOSIVE, 49, "\u0253"),							// b<
	PRENASALIZED_VD_BILABIAL_STOP				(Voice.VOICED, Place.BILABIAL, Manner.STOP, 48, "m\u0361b"),							// mb
	VL_DENTAL_ALVEOLAR_SIB_AFFRICATE			(Voice.VOICELESS, Place.DENTAL, Manner.SIB_AFFRICATE, 45, "t\u0361s"),							// "ts
	PRENASALIZED_VD_VELAR_STOP					(Voice.VOICED, Place.VELAR, Manner.STOP, 45, "\u014B\u0361g"),							// Ng
	VD_PALATO_ALVEOLAR_NASAL					(Voice.VOICED, Place.PALATO_ALVEOLAR, Manner.NASAL, 45, "n"),							// n_
	VL_UVULAR_FRICATIVE							(Voice.VOICELESS, Place.UVULAR, Manner.NONSIB_FRICATIVE, 44, "\u03C7"),							// X
	VL_BILABIAL_EJECTIVE_STOP					(Voice.VOICELESS, Place.BILABIAL, Consonant.EJECTIVE, Manner.STOP, 44, "p\u02BC"),							// p'
	VL_PALATO_ALVEOLAR_EJECTIVE_SIB_AFFRICATE	(Voice.VOICELESS, Place.PALATO_ALVEOLAR, Consonant.EJECTIVE, Manner.SIB_AFFRICATE, 44, "t\u0361\u0283\u02BC"),					// tS'
	VD_DENTAL_ALVEOLAR_SIB_FRICATIVE			(Voice.VOICED, Place.DENTAL, Manner.SIB_FRICATIVE, 43, "z"),							// "z
	VD_PALATAL_STOP								(Voice.VOICED, Place.PALATAL, Manner.STOP, 43, "\u025F"),							// dj
	VL_DENTAL_SIB_FRICATIVE						(Voice.VOICELESS, Place.DENTAL, Manner.SIB_FRICATIVE, 42, "s"),							// sD	*
	VL_BILABIAL_FRICATIVE						(Voice.VOICELESS, Place.BILABIAL, Manner.NONSIB_FRICATIVE, 39, "\u0278"),							// P
	VD_LABIAL_VELAR_STOP						(Voice.VOICED, Place.VELAR, Manner.STOP, 39, "g\u0361b"),							// gb	*
	VD_DENTAL_R								(Voice.VOICED, Place.ALVEOLAR, Manner.APPROXIMANT, 36, "r"),							// "rr
	VL_LABAL_VELAR_STOP							(Voice.VOICELESS, Place.VELAR, Manner.STOP, 35, "k\u0361p"),							// kp	*
	VD_DENTAL_LAT_APPROXIMANT					(Voice.VOICED, Place.DENTAL, Manner.LAT_APPROXIMANT, 34, "l"),							// lD	*
	VL_RETROFLEX_STOP							(Voice.VOICELESS, Place.RETROFLEX, Manner.STOP, 34, "\u0288"),							// t.
	VLA_ALVEOLAR_STOP							(Voice.VOICELESS, Consonant.ASPIRATED, Place.ALVEOLAR, Manner.STOP, 34, "t\u02B0"),							// th
	VLA_DENTAL_STOP								(Voice.VOICELESS, Consonant.ASPIRATED, Place.DENTAL, Manner.STOP, 30, "t\u02B0"),							// tDh	*
	VD_RETROFLEX_STOP							(Voice.VOICED, Place.RETROFLEX, Manner.STOP, 27, "\u0256"),							// d.
	VD_RETROFLEX_LAT_APPROXIMANT				(Voice.VOICED, Place.RETROFLEX, Manner.LAT_APPROXIMANT, 27, "\u026D"),							// l.
	VD_DENTAL_ALVEOLAR_FLAP						(Voice.VOICED, Place.DENTAL, Manner.FLAP, 26, "\u027E"),							// "r[	*
	PRENASALIZED_VD_ALVEOLAR_STOP				(Voice.VOICED, Place.ALVEOLAR, Manner.STOP, 26, "n\u0361d"),							// nd
	VL_UVULAR_EJECTIVE_STOP						(Voice.VOICELESS, Place.UVULAR, Consonant.EJECTIVE, Manner.STOP, 26, "q\u02BC"),							// q'
	VL_ALVEOLAR_EJECTIVE_SIB_AFFRICATE			(Voice.VOICELESS, Place.ALVEOLAR, Consonant.EJECTIVE, Manner.SIB_AFFRICATE, 26, "t\u0361s\u02BC"),	// ts'	*
	VLA_DENTAL_ALVEOLAR_SIB_AFFRICATE			(Voice.VOICELESS, Consonant.ASPIRATED, Place.DENTAL, Manner.SIB_AFFRICATE, 25, "t\u0361s\u02B0"),							// "tsh
	LABIALIZED_VL_VELAR_FRICATIVE				(Consonant.LABIALIZED, Voice.VOICELESS, Place.VELAR, Manner.NONSIB_FRICATIVE, 25, "x\u02B7"),							// xW
	VL_DENTAL_ALVEOLAR_LAT_FRICATIVE			(Voice.VOICELESS, Place.DENTAL, Manner.LAT_FRICATIVE, 24, "\u026C"),							// "hlF	*
	VL_DENTAL_ALVEOLAR_EJECTIVE_STOP			(Voice.VOICELESS, Place.DENTAL, Consonant.EJECTIVE, Manner.STOP, 24, "t\u02BC"),							// "t'
	VD_ALVEOLAR_SIB_AFFRICATE					(Voice.VOICED, Place.ALVEOLAR, Manner.SIB_FRICATIVE, 24, "d\u0361z"),							// dz
	LABIALIZED_VD_VELAR_STOP					(Consonant.LABIALIZED, Voice.VOICED, Place.VELAR, Manner.STOP, 24, "g\u02B7"),							// gW
	VD_RETROFLEX_NASAL							(Voice.VOICED, Place.RETROFLEX, Manner.NASAL, 24, "\u0273"),							// n.
	VL_ALVEOLAR_EJECTIVE_STOP					(Voice.VOICELESS, Place.ALVEOLAR, Consonant.EJECTIVE, Manner.STOP, 24, "t\u02BC"),							// t'
	VD_ALVEOLAR_IMPLOSIVE						(Voice.VOICED, Place.ALVEOLAR, Manner.IMPLOSIVE, 23, "\u0257"),							// d<
	LABIALIZED_VL_VELAR_EJECTIVE_STOP			(Consonant.LABIALIZED, Voice.VOICELESS, Place.VELAR, Consonant.EJECTIVE, Manner.STOP, 23, "k\u02B7\u02BC"),							// kW'
	VL_RETROFLEX_SIB_FRICATIVE					(Voice.VOICELESS, Place.RETROFLEX, Manner.SIB_FRICATIVE, 23, "\u0282"),							// s.
	VD_DENTAL_FRICATIVE							(Voice.VOICED, Place.DENTAL, Manner.NONSIB_FRICATIVE, 22, "\u00F0"),							// 6D
	VD_UVULAR_FRICATIVE							(Voice.VOICED, Place.UVULAR, Manner.NONSIB_FRICATIVE, 22, "\u0281"),							// RF
	VL_ALVEOLAR_LAT_FRICATIVE					(Voice.VOICELESS, Place.ALVEOLAR, Manner.LAT_FRICATIVE, 22, "\u026C"),							// hlF
	LABIALIZED_VLA_VELAR_STOP					(Consonant.LABIALIZED, Voice.VOICELESS, Consonant.ASPIRATED, Place.VELAR, Manner.STOP, 21, "k\u02B7\u02B0"),							// kWh
	VD_DENTAL_ALVEOLAR_SIB_AFFRICATE			(Voice.VOICED, Place.DENTAL, Manner.SIB_AFFRICATE, 20, "d\u0361z"),							// "dz
	VD_PALATAL_LAT_APPROXIMANT					(Voice.VOICED, Place.PALATAL, Manner.LAT_APPROXIMANT, 20, "\u028E"),							// lj
	VL_PALATO_ALVEOLAR_STOP						(Voice.VOICELESS, Place.PALATO_ALVEOLAR, Manner.STOP, 20, "t"),							// t_
	VD_BILABIAL_APPROXIMANT						(Voice.VOICED, Place.BILABIAL, Manner.APPROXIMANT, 19, "\u03B2"),							// BA
	VL_PHARYNGEAL_FRICATIVE						(Voice.VOICELESS, Place.PHARYNGEAL, Manner.NONSIB_FRICATIVE, 19, "\u0127"),							// H
	VL_DENTAL_FRICATIVE							(Voice.VOICELESS, Place.DENTAL, Manner.NONSIB_FRICATIVE, 18, "\u03B8"),							// 0D
	PRENASALIZED_VD_POSTALVEOLAR_STOP			(Voice.VOICED, Place.POSTALVEOLAR, Manner.STOP, 17, "n\u0361d"),							// "nd	*
	VL_POSTALVEOLAR_EJECTIVE_SIB_AFFRICATE		(Voice.VOICELESS, Place.POSTALVEOLAR, Consonant.EJECTIVE, Manner.SIB_AFFRICATE, 17, "t\u0361s\u02BC"),							// "ts'
	LABIALIZED_VD_VELAR_NASAL					(Consonant.LABIALIZED, Voice.VOICED, Place.VELAR, Manner.NASAL, 17, "\u014B\u02B7"),							// NW
	VLA_PALATAL_STOP							(Voice.VOICELESS, Consonant.ASPIRATED, Place.PALATAL, Manner.STOP, 17, "c\u02B0"),							// ch
	VL_BILABIAL_NASAL							(Voice.VOICELESS, Place.BILABIAL, Manner.NASAL, 17, "m\u0325"),							// hm
	LARYNGEALIZED_VD_PALATAL_APPROXIMANT		(Voice.VOICED, Place.PALATAL, Manner.APPROXIMANT, 17, "j"),							// j*
	VLA_UVULAR_STOP								(Voice.VOICELESS, Consonant.ASPIRATED, Place.UVULAR, Manner.STOP, 17, "q\u02B0"),							// qh
	VD_RETROFLEX_APPROXIMANT					(Voice.VOICED, Place.RETROFLEX, Manner.APPROXIMANT, 17, "\u027B"),							// r.A
	VLA_ALVEOLAR_SIB_AFFRICATE					(Voice.VOICELESS, Consonant.ASPIRATED, Place.ALVEOLAR, Manner.SIB_AFFRICATE, 17, "t\u0361s\u02B0"),							// tsh
	LARYNGEALIZED_VD_LABIO_VELAR_APPROXIMANT	(Voice.VOICED, Place.LABIO_VELAR, Manner.APPROXIMANT, 17, "w"),							// w*
	VD_DENTAL_SIB_FRICATIVE						(Voice.VOICED, Place.DENTAL, Manner.SIB_FRICATIVE, 17, "z"),							// zD	*
	VD_GLOTTAL_FRICATIVE						(Voice.VOICED, Place.GLOTTAL, Manner.STOP, 16, "\u0294"),							// hh
	VL_RETROFLEX_SIB_AFFRICATE					(Voice.VOICED, Place.RETROFLEX, Manner.NONSIB_FRICATIVE, 16, "\u0288\u0361s"),							// t.s
	VL_DENTAL_EJECTIVE_STOP						(Voice.VOICELESS, Place.DENTAL, Consonant.EJECTIVE, Manner.STOP, 16, "t\u02BC"),							// tD'
	VL_DENTAL_SIB_AFFRICATE						(Voice.VOICELESS, Place.DENTAL, Manner.SIB_AFFRICATE, 16, "t\u0361s"),							// tDs
	LARYNGEALIZED_VD_BILABIAL_STOP				(Voice.VOICED, Place.BILABIAL, Manner.STOP, 15, "b"),							// b*
	VL_LABIO_VELAR_APPROXIMANT					(Voice.VOICELESS, Place.LABIO_VELAR, Manner.APPROXIMANT, 15, "\u028D"),							// hw
	VD_DENTAL_IMPLOSIVE							(Voice.VOICED, Place.DENTAL, Manner.IMPLOSIVE, 14, "\u0257"),							// "d<
	VD_UVULAR_STOP								(Voice.VOICED, Place.UVULAR, Manner.STOP, 14, "\u0262"),							// G
	LABIALIZED_VL_UVULAR_FRICATIVE				(Voice.VOICELESS, Place.UVULAR, Manner.NONSIB_FRICATIVE, 14, "\u03C7\u02B7"),							// XW
	LARYNGEALIZED_VD_BILABIAL_NASAL				(Voice.VOICED, Place.BILABIAL, Manner.NASAL, 14, "m"),							// m*
	VD_RETROFLEX_FLAP							(Voice.VOICED, Place.RETROFLEX, Manner.FLAP, 14, "\u027D"),							// r.[
	PALATALIZED_VL_VELAR_STOP					(Voice.VOICELESS, Place.VELAR, Manner.STOP, 13, "k\u02B2"),							// kJ
	PALATALIZED_VL_BILABIAL_STOP				(Voice.VOICELESS, Place.BILABIAL, Manner.STOP, 13, "p\u02B2"),							// pJ
	VL_PALATAL_AFFRICATE						(Voice.VOICELESS, Place.PALATAL, Manner.NONSIB_AFFRICATE, 12, "c\u0361\u00E7"),							// cC
	VD_VELAR_APPROXIMANT						(Voice.VOICED, Place.VELAR, Manner.APPROXIMANT, 12, "\u0270"),							// gA
	VD_PALATAL_FRICATIVE						(Voice.VOICED, Place.PALATAL, Manner.NONSIB_FRICATIVE, 12, "\u029D"),							// jF
	VD_PALATO_ALVEOLAR_LAT_APPROXIMANT			(Voice.VOICED, Place.PALATO_ALVEOLAR, Manner.LAT_APPROXIMANT, 12, "l"),							// l_
	LABIALIZED_VL_UVULAR_STOP					(Consonant.LABIALIZED, Voice.VOICELESS, Place.UVULAR, Manner.STOP, 12, "q\u02B7"),							// qW
	PALATALIZED_VL_DENTAL_STOP					(Voice.VOICELESS, Place.DENTAL, Manner.STOP, 11, "t\u02B2"),							// "tJ
	VL_DENTAL_EJECTIVE_LAT_AFFRICATE			(Voice.VOICELESS, Place.DENTAL, Consonant.EJECTIVE, Manner.LAT_AFFRICATE, 11, "t\u0361\u026C\u02BC"),							// "tlF'
	VL_PALATAL_FRICATIVE						(Voice.VOICELESS, Place.PALATAL, Manner.NONSIB_FRICATIVE, 11, "\u00E7"),							// C
	LABIALIZED_VL_UVULAR_EJECTIVE_STOP			(Consonant.LABIALIZED, Voice.VOICELESS, Place.UVULAR, Consonant.EJECTIVE, Manner.STOP, 11, "q\u02B7\u02BC"),							// qW'
	VD_ALVEOLAR_APPROXIMANT						(Voice.VOICED, Place.ALVEOLAR, Manner.APPROXIMANT, 11, "\u0279"),							// rA
	VL_DENTAL_LAT_APPROXIMANT					(Voice.VOICELESS, Place.DENTAL, Manner.LAT_APPROXIMANT, 10, "l\u0325"),							// "hl
	VD_PHARYNGEAL_FRICATIVE						(Voice.VOICED, Place.PHARYNGEAL, Manner.NONSIB_FRICATIVE, 10, "\u0295"),							// 9
	PRENASALIZED_LABIALIZED_VD_VELAR_STOP		(Consonant.LABIALIZED, Voice.VOICED, Place.VELAR, Manner.STOP, 10, "\u014B\u0361g\u02B7"),							// NgW
	VD_DENTAL_SIB_AFFRICATE						(Voice.VOICED, Place.DENTAL, Manner.SIB_AFFRICATE, 10, "d\u0361z"),							// dDz
	VD_PALATAL_IMPLOSIVE						(Voice.VOICED, Place.PALATAL, Manner.IMPLOSIVE, 10, "\u0284"),							// dj<
	BVD_VELAR_STOP								(Voice.BREATHY, Place.VELAR, Manner.STOP, 10, "g\u0324"),							// gh
	PALATALIZED_VD_BILABIAL_NASAL				(Voice.VOICED, Place.BILABIAL, Manner.NASAL, 10, "m\u02B2"),							// mJ
	PRENASALIZED_VD_PALATO_ALVEOLAR_SIB_AFFRICATE	(Voice.VOICED, Place.PALATO_ALVEOLAR, Manner.SIB_AFFRICATE, 10, "nd\u0361\u0292"),							// ndZ
	VD_ALVEOLAR_							(Voice.VOICED, Place.ALVEOLAR, Manner.STOP, 10, "r"),							// rr
	VLA_RETROFLEX_STOP							(Voice.VOICELESS, Consonant.ASPIRATED, Place.RETROFLEX, Manner.STOP, 10, "\u0288\u02B0"),							// t.h
	VL_DENTAL_NASAL								(Voice.VOICELESS, Place.DENTAL, Manner.NASAL, 9, "n\u0325"),							// "hn	*
	VL_ALVEOLO_PALATAL_SIB_FRICATIVE			(Voice.VOICELESS, Place.ALVEOLO_PALATAL, Manner.SIB_FRICATIVE, 9, "\u0255"),							// C,
	BVD_BILABIAL_STOP							(Voice.BREATHY, Place.BILABIAL, Manner.STOP, 9, "b\u0324"),							// bh
	VL_PALATAL_EJECTIVE_STOP					(Voice.VOICELESS, Place.PALATAL, Consonant.EJECTIVE, Manner.STOP, 9, "c\u02BC"),							// c'
	VL_VELAR_NASAL								(Voice.VOICELESS, Place.VELAR, Manner.NASAL, 9, "\u014B\u030A"),							// hN
	VL_PALATAL_APPROXIMANT						(Voice.VOICELESS, Place.PALATAL, Manner.APPROXIMANT, 9, "j\u030A"),							// hj
	VD_ALVEOLAR_LAT_FLAP						(Voice.VOICED, Place.ALVEOLAR, Manner.LAT_FLAP, 9, "\u027A"),							// l[
	VD_DENTAL_TRILL								(Voice.VOICED, Place.DENTAL, Manner.TRILL, 9, "r"),							// rD	*
	VLA_RETROFLEX_SIB_AFFRICATE					(Voice.VOICELESS, Consonant.ASPIRATED, Place.RETROFLEX, Manner.SIB_AFFRICATE, 9, "\u0288\u0361s\u02B0"),							// t.sh
	VL_ALVEOLAR_EJECTIVE_LAT_AFFRICATE			(Voice.VOICELESS, Place.ALVEOLAR, Consonant.EJECTIVE, Manner.LAT_AFFRICATE, 9, "t\u0361\u026C\u02BC"),							// tlF'
	VD_RETROFLEX_SIB_FRICATIVE					(Voice.VOICED, Place.RETROFLEX, Manner.SIB_FRICATIVE, 9, "\u0290"),							// z.
	LARYNGEALIZED_VD_DENTAL_NASAL				(Voice.VOICED, Place.DENTAL, Manner.NASAL, 8, "n"),							// "n*	*
	PALATALIZED_VD_BILABIAL_STOP				(Voice.VOICED, Place.BILABIAL, Manner.STOP, 8, "b\u02B2"),							// bJ
	VD_PALATAL_AFFRICATE						(Voice.VOICED, Place.PALATAL, Manner.NONSIB_AFFRICATE, 8, "\u025F\u0361\u029D"),							// djjF
	VL_PALATAL_NASAL							(Voice.VOICELESS, Place.PALATAL, Manner.NASAL, 8, "\u0272\u030A"),							// hnj
	VD_RETROFLEX_LAT_FLAP						(Voice.VOICED, Place.RETROFLEX, Manner.LAT_FLAP, 8, "\u027A\u0306"),							// l.[
	VD_ALVEOLAR_LAT_FRICATIVE					(Voice.VOICED, Place.ALVEOLAR, Manner.LAT_FRICATIVE, 8, "\u026C"),							// lF
	VLA_DENTAL_SIB_AFFRICATE					(Voice.VOICELESS, Consonant.ASPIRATED, Place.DENTAL, Manner.SIB_AFFRICATE, 8, "t\u0361s\u02B0"),							// tDsh	*
	LARYNGEALIZED_VD_DENTAL_LAT_APPROXIMANT		(Voice.VOICED, Place.DENTAL, Manner.LAT_APPROXIMANT, 7, "l"),							// "l*	*
	VL_DENTAL_EJECTIVE_SIB_FRICATIVE			(Voice.VOICELESS, Place.DENTAL, Consonant.EJECTIVE, Manner.SIB_FRICATIVE, 7, "s\u02BC"),							// "s'	*
	PALATALIZED_VL_DENTAL_SIB_FRICATIVE			(Voice.VOICELESS, Place.DENTAL, Manner.SIB_FRICATIVE, 7, "s\u02B2"),							// "sJ	*
	VD_LABIAL_VELAR_NASAL						(Voice.VOICED, Place.VELAR, Manner.NASAL, 7, "\u014B\u0361m"),							// Nm
	VL_ALVEOLO_PALATAL_SIB_AFFRICATE			(Voice.VOICELESS, Place.ALVEOLO_PALATAL, Manner.SIB_AFFRICATE, 7, "t\u0361\u0255"),							// cC,
	LARYNGEALIZED_VD_ALVEOLAR_STOP				(Voice.VOICED, Place.ALVEOLAR, Manner.STOP, 7, "d"),							// d*
	BVD_PALATO_ALVEOLAR_SIB_AFFRICATE			(Voice.BREATHY, Place.PALATO_ALVEOLAR, Manner.SIB_AFFRICATE, 7, "d\u0361\u0292\u0324"),							// dZh
	PALATALIZED_VD_VELAR_STOP					(Voice.VOICED, Place.VELAR, Manner.STOP, 7, "g\u02B2"),							// gJ
//	VD_ALVEOLAR_FLAP							(Voice.VOICED, Place.ALVEOLAR, Manner.STOP, 7, ""),							// rT
	VD_ALVEOLO_PALATAL_SIB_FRICATIVE			(Voice.VOICED, Place.ALVEOLO_PALATAL, Manner.SIB_FRICATIVE, 7, "\u0291"),							// z,
	PALATALIZED_VD_DENTAL_LAT_APPROXIMANT		(Voice.VOICED, Place.DENTAL, Manner.LAT_APPROXIMANT, 6, "l\u02B2"),							// "lJ	*
	VL_DENTAL_LAT_AFFRICATE						(Voice.VOICELESS, Place.DENTAL, Manner.LAT_AFFRICATE, 6, "t\u0361\u026C"),							// "tlF	*
	PRENASALIZED_VL_VELAR_STOP					(Voice.VOICELESS, Place.VELAR, Manner.STOP, 6, "\u014B\u0361k"),							// Nk
	PRENASALIZED_VD_LABIAL_VELAR_STOP			(Voice.VOICED, Place.VELAR, Manner.STOP, 6, "nmg\u0361b"),							// Nmgb
	BVD_RETROFLEX_STOP							(Voice.BREATHY, Place.RETROFLEX, Manner.STOP, 6, "\u0257\u0324"),							// d.h
	VD_PALATO_ALVEOLAR_STOP						(Voice.VOICED, Place.PALATO_ALVEOLAR, Manner.STOP, 6, "d"),							// d_
	LABIALIZED_VD_VELAR_FRICATIVE				(Consonant.LABIALIZED, Voice.VOICED, Place.VELAR, Manner.NONSIB_FRICATIVE, 6, "\u0263\u02B7"),							// gFW
	LARYNGEALIZED_VL_VELAR_STOP					(Voice.VOICELESS, Place.VELAR, Manner.STOP, 6, "k"),							// k*
	PRENASALIZED_VL_BILABIAL_STOP				(Voice.VOICELESS, Place.BILABIAL, Manner.STOP, 6, "m\u0361p"),							// mp
	PRENASALIZED_VD_DENTAL_STOP					(Voice.VOICED, Place.DENTAL, Manner.STOP, 6, "n\u0361d"),							// ndD	*
	PRENASALIZED_VD_PALATAL_STOP				(Voice.VOICED, Place.PALATAL, Manner.STOP, 6, "\u0272\u0361\u025F"),							// ndj
	VL_DENTAL_EJECTIVE_SIB_AFFRICATE			(Voice.VOICELESS, Place.DENTAL, Consonant.EJECTIVE, Manner.SIB_AFFRICATE, 6, "t\u0361s\u02BC"),							// tDs'	*
	VD_LABIODENTAL_APPROXIMANT					(Voice.VOICED, Place.LABIODENTAL, Manner.APPROXIMANT, 6, "\u028B"),							// vA
	LABIALIZED_VD_PALATAL_APPROXIMANT			(Consonant.LABIALIZED, Voice.VOICED, Place.PALATAL, Manner.APPROXIMANT, 6, "\u0265"),							// wj
	PALATALIZED_VD_DENTAL_STOP					(Voice.VOICED, Place.DENTAL, Manner.STOP, 5, "d\u02B2"),							// "dJ	*
	VD_DENTAL_LAT_AFFRICATE						(Voice.VOICED, Place.DENTAL, Manner.LAT_AFFRICATE, 5, "d\u0361\u026E"),							// "dlF	*
	VELARIZED_VD_DENTAL_LAT_APPROXIMANT			(Voice.VOICED, Place.DENTAL, Manner.LAT_APPROXIMANT, 5, "l\u02E0"),							// "l-	*
	LABIALIZED_VD_UVULAR_STOP					(Consonant.LABIALIZED, Voice.VOICED, Place.UVULAR, Manner.STOP, 5, "\u0262\u02B7"),							// GW
	BVD_DENTAL_STOP								(Voice.BREATHY, Place.DENTAL, Manner.STOP, 5, "d\u0324"),							// dDh	*
	VD_VELAR_IMPLOSIVE							(Voice.VOICED, Place.VELAR, Manner.IMPLOSIVE, 5, "\u0260"),							// g<
	LABIALIZED_VL_GLOTTAL_FRICATIVE				(Consonant.LABIALIZED, Voice.VOICELESS, Place.GLOTTAL, Manner.NONSIB_FRICATIVE, 5, "h\u02B7"),							// hW
	LARYNGEALIZED_VD_ALVEOLAR_LAT_APPROXIMANT	(Voice.VOICED, Place.ALVEOLAR, Manner.LAT_APPROXIMANT, 5, "l"),							// l*
	LABIALIZED_VD_BILABIAL_NASAL				(Consonant.LABIALIZED, Voice.VOICED, Place.BILABIAL, Manner.NASAL, 5, "m\u02B7"),							// mW
	PRENASALIZED_VD_ALVEOLAR_SIB_AFFRICATE		(Voice.VOICED, Place.ALVEOLAR, Manner.SIB_AFFRICATE, 5, "nd\u0361z"),							// ndz
//	NASALIZED_VD_DENTAL_AFFRICATED_CLICK		(Voice.VOICED, Place.DENTAL, Manner.STOP, 5, ""),							// n|
	LARYNGEALIZED_VL_BILABIAL_STOP				(Voice.VOICELESS, Place.BILABIAL, Manner.STOP, 5, "p"),							// p*
	VL_ALVEOLAR_LAT_AFFRICATE					(Voice.VOICELESS, Place.ALVEOLAR, Manner.LAT_AFFRICATE, 5, "t\u0361\u026C"),							// tlF
	PALATALIZED_VD_LABIODENTAL_FRICATIVE		(Voice.VOICED, Place.LABIODENTAL, Manner.NONSIB_FRICATIVE, 5, "v\u02B2");							// vJ
//	VL_DENTAL_AFFRICATED_CLICK					(Voice.VOICED, Place.ALVEOLAR, Manner.STOP, 5, "");							// |

	// Named consonants to make declarations clearer
	private static final boolean EJECTIVE = true;
	private static final boolean ASPIRATED = true;
	private static final boolean LABIALIZED = true;
	private static final boolean PALATALIZED = true;
	private static final boolean PRENASALIZED = true;
	
	private final boolean labialized;
	private final Voice voice;
	private final boolean aspirated;
	private final Place place;
	private final boolean ejective;
	private final Manner manner;
	private final int occurrence;
	private final double probability;
	private final String symbol;
	
	// Constructors for various features if present - aspiration, ejective, labialization
	private Consonant(Voice voice, Place place, Manner manner, int occurrence, String symbol) {
		labialized = false;
		this.voice = voice;
		aspirated = false;
		this.place = place;
		ejective = false;
		this.manner = manner;
		this.occurrence = occurrence;
		probability = (double) occurrence / Data.LANGUAGE_SAMPLE_SIZE;
		this.symbol = symbol;
	}
	
	private Consonant(Voice voice, boolean aspirated, Place place, Manner manner, int occurrence, String symbol) {
		labialized = false;
		this.voice = voice;
		this.aspirated = aspirated;
		this.place = place;
		ejective = false;
		this.manner = manner;
		this.occurrence = occurrence;
		probability = (double) occurrence / Data.LANGUAGE_SAMPLE_SIZE;
		this.symbol = symbol;
	}
	
	private Consonant(Voice voice, Place place, boolean ejective, Manner manner, int occurrence, String symbol) {
		labialized = false;
		this.voice = voice;
		aspirated = false;
		this.place = place;
		this.ejective = ejective;
		this.manner = manner;
		this.occurrence = occurrence;
		probability = (double) occurrence / Data.LANGUAGE_SAMPLE_SIZE;
		this.symbol = symbol;
	}
	
	private Consonant(boolean labialized, Voice voice, Place place, Manner manner, int occurrence, String symbol) {
		this.labialized = labialized;
		this.voice = voice;
		aspirated = false;
		this.place = place;
		ejective = false;
		this.manner = manner;
		this.occurrence = occurrence;
		probability = (double) occurrence / Data.LANGUAGE_SAMPLE_SIZE;
		this.symbol = symbol;
	}
	
	private Consonant(boolean labialized, Voice voice, boolean aspirated, Place place, Manner manner, int occurrence, String symbol) {
		this.labialized = labialized;
		this.voice = voice;
		this.aspirated = aspirated;
		this.place = place;
		ejective = false;
		this.manner = manner;
		this.occurrence = occurrence;
		probability = (double) occurrence / Data.LANGUAGE_SAMPLE_SIZE;
		this.symbol = symbol;
	}
	
	private Consonant(boolean labialized, Voice voice, Place place, boolean ejective, Manner manner, int occurrence, String symbol) {
		this.labialized = labialized;
		this.voice = voice;
		aspirated = false;
		this.place = place;
		this.ejective = ejective;
		this.manner = manner;
		this.occurrence = occurrence;
		probability = (double) occurrence / Data.LANGUAGE_SAMPLE_SIZE;
		this.symbol = symbol;
	}
	
	// Getters
	public Voice voice() { return voice; }
	public boolean aspirated() { return aspirated; }
	public Place place() { return place; }
	public boolean ejective() { return ejective; }
	public Manner manner() { return manner; }
	public int weight() { return occurrence; }
	public double probability() { return probability; }
	public String symbol() { return symbol; }
	
	// Turns consonant into English name based on IPA standards
	public String toString() {		
		// Basic name with voice, place, manner, and aspiration and ejective if present
		String name = voice.name + " " + (aspirated ? "aspirated " : "") + place.name.toLowerCase() + " " + (ejective ? "ejective " : "") +  manner.name.toLowerCase();
		
		// Add labialization if present
		if (labialized)
			name = "Labialized " + name.toLowerCase();
		
		return name;
	}
	
	/* Consonant features - each value has a string name */
	
	// Use of vocal cords during consonant's duration
	public static enum Voice {
		VOICELESS("Voiceless"), VOICED("Voiced"), BREATHY("Breathy voiced");
		
		private final String name;
		
		private Voice(String name) {
			this.name = name;
		}
	}
	
	// Release of air along with consonant
	public static enum Aspiration {
		UNASPIRATED("Unaspirated"), ASPIRATED("Aspirated");
		
		private final String name;
		
		private Aspiration(String name) {
			this.name = name;
		}
	}
	
	// Placement of release - either tongue or other part of vocal tract
	public static enum Place {
		BILABIAL("Bilabial"), LABIO_VELAR("Labio-velar"), LABIODENTAL("Labiodental"), LINGUO_LABIAL("Linguo-labial"),
		DENTAL("Dental"), POSTALVEOLAR("Postalveolar"), ALVEOLAR("Alveolar"), PALATO_ALVEOLAR("Palato-alveolar"), RETROFLEX("Retroflex"),
		ALVEOLO_PALATAL("Alveolo-palatal"), PALATAL("Palatal"), VELAR("Velar"), UVULAR("Uvular"),
		PHARYNGEAL("Pharyngeal"), GLOTTAL("Glottal");
		
		private final String name;
		
		private Place(String name) {
			this.name = name;
		}
	}
	
	// Manner in which air is released
	public static enum Manner {
		NASAL("Nasal"), STOP("Stop"), SIB_AFFRICATE("Sibilant affricate"), NONSIB_AFFRICATE("Non-sibilant affricate"),
		SIB_FRICATIVE("Sibilant fricative"), NONSIB_FRICATIVE("Non-sibilant fricative"), APPROXIMANT("Approximant"),
		FLAP("Flap"), TRILL("Trill"), LAT_AFFRICATE("Lateral affricate"), LAT_FRICATIVE("Lateral fricative"),
		LAT_APPROXIMANT("Lateral approximant"), LAT_FLAP("Lateral flap"), IMPLOSIVE("Implosive");
		
		private final String name;
		
		private Manner(String name) {
			this.name = name;
		}
	}
}
