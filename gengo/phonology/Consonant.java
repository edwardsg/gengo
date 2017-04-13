package gengo.phonology;

/* Contains all possible consonant phonemes with their features, UPSID occurrence, and IPA symbol */
public enum Consonant {
	VD_BILABIAL_NASAL							(425, "m", Voice.VOICED, Place.BILABIAL, Manner.NASAL),					// UPSID   m
	VL_VELAR_STOP								(403, "k", Voice.VOICELESS, Place.VELAR, Manner.STOP),							// k
	VD_PALATAL_APPROXIMANT						(378, "j", Voice.VOICED, Place.PALATAL, Manner.APPROXIMANT),					// j
	VL_BILABIAL_STOP							(375, "p", Voice.VOICELESS, Place.BILABIAL, Manner.STOP),						// p
	VD_LABIO_VELAR_APPROXIMANT					(332, "w", Voice.VOICED, Place.LABIO_VELAR, Manner.APPROXIMANT),				// w
	VD_BILABIAL_STOP							(287, "b", Voice.VOICED, Place.BILABIAL, Manner.STOP),							// b
	VL_GLOTTAL_FRICATIVE						(279, "h", Voice.VOICELESS, Place.GLOTTAL, Manner.NONSIB_FRICATIVE),			// h
	VD_VELAR_STOP								(253, "g", Voice.VOICED, Place.VELAR, Manner.STOP),								// g
	VD_VELAR_NASAL								(237, "\u014B", Voice.VOICED, Place.VELAR, Manner.NASAL),						// N
	VL_GLOTTAL_STOP								(216, "\u0294", Voice.VOICELESS, Place.GLOTTAL, Manner.STOP),					// ?
	VD_ALVEOLAR_NASAL							(202, "n", Voice.VOICED, Place.ALVEOLAR, Manner.NASAL),							// n
	VL_ALVEOLAR_SIB_FRICATIVE					(196, "s", Voice.VOICELESS, Place.ALVEOLAR, Manner.SIB_FRICATIVE),				// s
	VL_PALATO_ALVEOLAR_SIB_AFFRICATE			(188, "t\u0361\u0283", Voice.VOICELESS, Place.PALATO_ALVEOLAR, Manner.SIB_AFFRICATE),	// tS
	VL_PALATO_ALVEOLAR_SIB_FRICATIVE			(187, "\u0283", Voice.VOICELESS, Place.PALATO_ALVEOLAR, Manner.SIB_FRICATIVE),	// S
	VL_ALVEOLAR_STOP							(181, "t", Voice.VOICELESS, Place.ALVEOLAR, Manner.STOP),						// t
	VL_LABIODENTAL_FRICATIVE					(180, "f", Voice.VOICELESS, Place.LABIODENTAL, Manner.NONSIB_FRICATIVE),		// f
	VD_ALVEOLAR_LAT_APPROXIMANT					(174, "l", Voice.VOICED, Place.ALVEOLAR, Manner.LAT_APPROXIMANT),				// l
//	VD_DENTAL_ALVEOLAR_NASAL					(Voice.VOICED, Place.DENTAL, Manner.NASAL, 160, "n"),							// "n	*
//	VL_DENTAL_ALVEOLAR_STOP						(Voice.VOICELESS, Place.DENTAL, Manner.STOP, 152, "t"),							// "t	*
	VD_PALATAL_NASAL							(141, "\u0272", Voice.VOICED, Place.PALATAL, Manner.NASAL),						// nj
//	VD_DENTAL_ALVEOLAR_LAT_APPROXIMANT			(Voice.VOICED, Place.DENTAL, Manner.LAT_APPROXIMANT, 136, "l"),					// "l	*
//	VL_DENTAL_ALVEOLARD_SIB_FRICATIVE			(Voice.VOICELESS, Place.DENTAL, Manner.SIB_FRICATIVE, 135, "s"),				// "s	*
	VD_ALVEOLAR_STOP							(120, "d", Voice.VOICED, Place.ALVEOLAR, Manner.STOP),							// d
	VD_PALATO_ALVEOLAR_SIB_AFFRICATE			(113, "d\u0361\u0292", Voice.VOICED, Place.PALATO_ALVEOLAR, Manner.SIB_AFFRICATE),	// dZ
//	VL_DENTAL_STOP								(Voice.VOICELESS, Place.DENTAL, Manner.STOP, 106, "t"),							// tD	*
	VLA_VELAR_STOP								(103, "k\u02B0", Voice.VOICELESS, Aspiration.ASPIRATED, Place.VELAR, Manner.STOP),	// kh
	VLA_BILABIAL_STOP							(101, "p\u02B0", Voice.VOICELESS, Aspiration.ASPIRATED, Place.BILABIAL, Manner.STOP),// ph
	VD_ALVEOLAR_TRILL							(95, "r", Voice.VOICED, Place.ALVEOLAR, Manner.TRILL),							// r
	VD_LABIODENTAL_FRICATIVE					(95, "v", Voice.VOICED, Place.LABIODENTAL, Manner.NONSIB_FRICATIVE),			// v
	VL_VELAR_FRICATIVE							(94, "x", Voice.VOICELESS, Place.VELAR, Manner.NONSIB_FRICATIVE),							// x
//	VD_DENTAL_ALVEOLAR_STOP						(Voice.VOICED, Place.DENTAL, Manner.STOP, 91, "d"),							// "d	*
	VD_ALVEOLAR_FLAP							(91, "\u027E", Voice.VOICED, Place.ALVEOLAR, Manner.FLAP),							// r[
//	VD_DENTAL_NASAL								(Voice.VOICED, Place.DENTAL, Manner.NASAL, 83, "n"),							// nD	*
//	VD_DENTAL_STOP								(Voice.VOICED, Place.DENTAL, Manner.STOP, 80, "d"),							// dD	*
	VL_VELAR_EJECTIVE_STOP						(63, "k\u02BC", Voice.VOICELESS, Place.VELAR, Ejectivity.EJECTIVE, Manner.STOP),							// k'
	VL_ALVEOLAR_SIB_AFFRICATE					(62, "t\u0361s", Voice.VOICELESS, Place.ALVEOLAR, Manner.SIB_AFFRICATE),							// ts
	VD_ALVEOLAR_SIB_FRICATIVE					(62, "z", Voice.VOICED, Place.ALVEOLAR, Manner.SIB_FRICATIVE),							// z
	VD_PALATO_ALVEOLAR_SIB_FRICATIVE			(61, "\u0292", Voice.VOICED, Place.PALATO_ALVEOLAR, Manner.SIB_FRICATIVE),							// Z
	LABIALIZED_VL_VELAR_STOP					(60, "k\u02B7", Labialization.LABIALIZED, Voice.VOICELESS, Place.VELAR, Manner.STOP),							// kW
	VD_VELAR_FRICATIVE							(55, "\u0263", Voice.VOICED, Place.VELAR, Manner.NONSIB_FRICATIVE),							// gF
	VD_BILABIAL_FRICATIVE						(54, "\u03B2", Voice.VOICED, Place.BILABIAL, Manner.NONSIB_FRICATIVE),							// B
	VL_PALATAL_STOP								(54, "c", Voice.VOICELESS, Place.PALATAL, Manner.STOP),							// c
	VL_UVULAR_STOP								(52, "q", Voice.VOICELESS, Place.UVULAR, Manner.STOP),							// q
//	VD_DENTAL_ALVEOLAR_TRILL					(Voice.VOICED, Place.DENTAL, Manner.TRILL, 51, "r"),							// "r	*
	VLA_PALATO_ALVEOLAR_SIB_AFFRICATE			(51, "t\u0361\u0283\u02B0", Voice.VOICELESS, Aspiration.ASPIRATED, Place.PALATO_ALVEOLAR, Manner.SIB_AFFRICATE),							// tSh
//	VLA_DENTAL_ALVEOLAR_STOP					(Voice.VOICED, Aspiration.ASPIRATED, Place.ALVEOLAR, Manner.STOP, 49, "t\u02B0"),							// "th
	VD_BILABIAL_IMPLOSIVE						(49, "\u0253", Voice.VOICED, Place.BILABIAL, Manner.IMPLOSIVE),							// b<
	PRENASALIZED_VD_BILABIAL_STOP				(48, "m\u0361b", Voice.VOICED, Place.BILABIAL, Manner.STOP),							// mb
//	VL_DENTAL_ALVEOLAR_SIB_AFFRICATE			(Voice.VOICELESS, Place.DENTAL, Manner.SIB_AFFRICATE, 45, "t\u0361s"),							// "ts
	PRENASALIZED_VD_VELAR_STOP					(45, "\u014B\u0361g", Voice.VOICED, Place.VELAR, Manner.STOP),							// Ng
//	VD_PALATO_ALVEOLAR_NASAL					(Voice.VOICED, Place.PALATO_ALVEOLAR, Manner.NASAL, 45, "n"),							// n_
	VL_UVULAR_FRICATIVE							(44, "\u03C7", Voice.VOICELESS, Place.UVULAR, Manner.NONSIB_FRICATIVE),							// X
	VL_BILABIAL_EJECTIVE_STOP					(44, "p\u02BC", Voice.VOICELESS, Place.BILABIAL, Ejectivity.EJECTIVE, Manner.STOP),							// p'
	VL_PALATO_ALVEOLAR_EJECTIVE_SIB_AFFRICATE	(44, "t\u0361\u0283\u02BC", Voice.VOICELESS, Place.PALATO_ALVEOLAR, Ejectivity.EJECTIVE, Manner.SIB_AFFRICATE),					// tS'
//	VD_DENTAL_ALVEOLAR_SIB_FRICATIVE			(Voice.VOICED, Place.DENTAL, Manner.SIB_FRICATIVE, 43, "z"),							// "z
	VD_PALATAL_STOP								(43, "\u025F", Voice.VOICED, Place.PALATAL, Manner.STOP),							// dj
//	VL_DENTAL_SIB_FRICATIVE						(Voice.VOICELESS, Place.DENTAL, Manner.SIB_FRICATIVE, 42, "s"),							// sD	*
	VL_BILABIAL_FRICATIVE						(39, "\u0278", Voice.VOICELESS, Place.BILABIAL, Manner.NONSIB_FRICATIVE),							// P
	VD_LABIAL_VELAR_STOP						(39, "g\u0361b", Voice.VOICED, Place.BILABIAL, Place.VELAR, Manner.STOP),							// gb	*
//	VD_DENTAL_R								(Voice.VOICED, Place.ALVEOLAR, Manner.APPROXIMANT, 36, "r"),							// "rr
	VL_LABAL_VELAR_STOP							(35, "k\u0361p", Voice.VOICELESS, Place.VELAR, Manner.STOP),							// kp	*
//	VD_DENTAL_LAT_APPROXIMANT					(Voice.VOICED, Place.DENTAL, Manner.LAT_APPROXIMANT, 34, "l"),							// lD	*
	VL_RETROFLEX_STOP							(34, "\u0288", Voice.VOICELESS, Place.RETROFLEX, Manner.STOP),							// t.
	VLA_ALVEOLAR_STOP							(34, "t\u02B0", Voice.VOICELESS, Aspiration.ASPIRATED, Place.ALVEOLAR, Manner.STOP),							// th
//	VLA_DENTAL_STOP								(Voice.VOICELESS, Aspiration.ASPIRATED, Place.DENTAL, Manner.STOP, 30, "t\u02B0"),							// tDh	*
	VD_RETROFLEX_STOP							(27, "\u0256", Voice.VOICED, Place.RETROFLEX, Manner.STOP),							// d.
	VD_RETROFLEX_LAT_APPROXIMANT				(27, "\u026D", Voice.VOICED, Place.RETROFLEX, Manner.LAT_APPROXIMANT),							// l.
//	VD_DENTAL_ALVEOLAR_FLAP						(Voice.VOICED, Place.DENTAL, Manner.FLAP, 26, "\u027E"),							// "r[	*
	PRENASALIZED_VD_ALVEOLAR_STOP				(26, "n\u0361d", Voice.VOICED, Place.ALVEOLAR, Manner.STOP),							// nd
	VL_UVULAR_EJECTIVE_STOP						(26, "q\u02BC", Voice.VOICELESS, Place.UVULAR, Ejectivity.EJECTIVE, Manner.STOP),							// q'
	VL_ALVEOLAR_EJECTIVE_SIB_AFFRICATE			(26, "t\u0361s\u02BC", Voice.VOICELESS, Place.ALVEOLAR, Ejectivity.EJECTIVE, Manner.SIB_AFFRICATE),	// ts'	*
//	VLA_DENTAL_ALVEOLAR_SIB_AFFRICATE			(Voice.VOICELESS, Aspiration.ASPIRATED, Place.DENTAL, Manner.SIB_AFFRICATE, 25, "t\u0361s\u02B0"),							// "tsh
	LABIALIZED_VL_VELAR_FRICATIVE				(25, "x\u02B7", Labialization.LABIALIZED, Voice.VOICELESS, Place.VELAR, Manner.NONSIB_FRICATIVE),							// xW
//	VL_DENTAL_ALVEOLAR_LAT_FRICATIVE			(Voice.VOICELESS, Place.DENTAL, Manner.LAT_FRICATIVE, 24, "\u026C"),							// "hlF	*
//	VL_DENTAL_ALVEOLAR_EJECTIVE_STOP			(Voice.VOICELESS, Place.DENTAL, Ejectivity.EJECTIVE, Manner.STOP, 24, "t\u02BC"),							// "t'
	VD_ALVEOLAR_SIB_AFFRICATE					(24, "d\u0361z", Voice.VOICED, Place.ALVEOLAR, Manner.SIB_FRICATIVE),							// dz
	LABIALIZED_VD_VELAR_STOP					(24, "g\u02B7", Labialization.LABIALIZED, Voice.VOICED, Place.VELAR, Manner.STOP),							// gW
	VD_RETROFLEX_NASAL							(24, "\u0273", Voice.VOICED, Place.RETROFLEX, Manner.NASAL),							// n.
	VL_ALVEOLAR_EJECTIVE_STOP					(24, "t\u02BC", Voice.VOICELESS, Place.ALVEOLAR, Ejectivity.EJECTIVE, Manner.STOP),							// t'
	VD_ALVEOLAR_IMPLOSIVE						(23, "\u0257", Voice.VOICED, Place.ALVEOLAR, Manner.IMPLOSIVE),							// d<
	LABIALIZED_VL_VELAR_EJECTIVE_STOP			(23, "k\u02B7\u02BC", Labialization.LABIALIZED, Voice.VOICELESS, Place.VELAR, Ejectivity.EJECTIVE, Manner.STOP),							// kW'
	VL_RETROFLEX_SIB_FRICATIVE					(23, "\u0282", Voice.VOICELESS, Place.RETROFLEX, Manner.SIB_FRICATIVE),							// s.
	VD_DENTAL_FRICATIVE							(22, "\u00F0", Voice.VOICED, Place.DENTAL, Manner.NONSIB_FRICATIVE),							// 6D
	VD_UVULAR_FRICATIVE							(22, "\u0281", Voice.VOICED, Place.UVULAR, Manner.NONSIB_FRICATIVE),							// RF
	VL_ALVEOLAR_LAT_FRICATIVE					(22, "\u026C", Voice.VOICELESS, Place.ALVEOLAR, Manner.LAT_FRICATIVE),							// hlF
	LABIALIZED_VLA_VELAR_STOP					(21, "k\u02B7\u02B0", Labialization.LABIALIZED, Voice.VOICELESS, Aspiration.ASPIRATED, Place.VELAR, Manner.STOP),							// kWh
//	VD_DENTAL_ALVEOLAR_SIB_AFFRICATE			(Voice.VOICED, Place.DENTAL, Manner.SIB_AFFRICATE, 20, "d\u0361z"),							// "dz
	VD_PALATAL_LAT_APPROXIMANT					(20, "\u028E", Voice.VOICED, Place.PALATAL, Manner.LAT_APPROXIMANT),							// lj
//	VL_PALATO_ALVEOLAR_STOP						(Voice.VOICELESS, Place.PALATO_ALVEOLAR, Manner.STOP, 20, "t"),							// t_
//	VD_BILABIAL_APPROXIMANT						(Voice.VOICED, Place.BILABIAL, Manner.APPROXIMANT, 19, "\u03B2"),							// BA
	VL_PHARYNGEAL_FRICATIVE						(19, "\u0127", Voice.VOICELESS, Place.PHARYNGEAL, Manner.NONSIB_FRICATIVE),							// H
	VL_DENTAL_FRICATIVE							(18, "\u03B8", Voice.VOICELESS, Place.DENTAL, Manner.NONSIB_FRICATIVE),							// 0D
//	PRENASALIZED_VD_POSTALVEOLAR_STOP			(Voice.VOICED, Place.POSTALVEOLAR, Manner.STOP, 17, "n\u0361d"),							// "nd	*
//	VL_POSTALVEOLAR_EJECTIVE_SIB_AFFRICATE		(Voice.VOICELESS, Place.POSTALVEOLAR, Ejectivity.EJECTIVE, Manner.SIB_AFFRICATE, 17, "t\u0361s\u02BC"),							// "ts'
	LABIALIZED_VD_VELAR_NASAL					(17, "\u014B\u02B7", Labialization.LABIALIZED, Voice.VOICED, Place.VELAR, Manner.NASAL),							// NW
	VLA_PALATAL_STOP							(17, "c\u02B0", Voice.VOICELESS, Aspiration.ASPIRATED, Place.PALATAL, Manner.STOP),							// ch
	VL_BILABIAL_NASAL							(17, "m\u0325", Voice.VOICELESS, Place.BILABIAL, Manner.NASAL),							// hm
//	LARYNGEALIZED_VD_PALATAL_APPROXIMANT		(Voice.VOICED, Place.PALATAL, Manner.APPROXIMANT, 17, "j"),							// j*
	VLA_UVULAR_STOP								(17, "q\u02B0", Voice.VOICELESS, Aspiration.ASPIRATED, Place.UVULAR, Manner.STOP),							// qh
	VD_RETROFLEX_APPROXIMANT					(17, "\u027B", Voice.VOICED, Place.RETROFLEX, Manner.APPROXIMANT),							// r.A
	VLA_ALVEOLAR_SIB_AFFRICATE					(17, "t\u0361s\u02B0", Voice.VOICELESS, Aspiration.ASPIRATED, Place.ALVEOLAR, Manner.SIB_AFFRICATE),							// tsh
//	LARYNGEALIZED_VD_LABIO_VELAR_APPROXIMANT	(Voice.VOICED, Place.LABIO_VELAR, Manner.APPROXIMANT, 17, "w"),							// w*
//	VD_DENTAL_SIB_FRICATIVE						(Voice.VOICED, Place.DENTAL, Manner.SIB_FRICATIVE, 17, "z"),							// zD	*
	VD_GLOTTAL_FRICATIVE						(16, "\u0266", Voice.VOICED, Place.GLOTTAL, Manner.NONSIB_FRICATIVE),							// hh
	VL_RETROFLEX_SIB_AFFRICATE					(16, "\u0288\u0361s", Voice.VOICED, Place.RETROFLEX, Manner.NONSIB_FRICATIVE),							// t.s
//	VL_DENTAL_EJECTIVE_STOP						(Voice.VOICELESS, Place.DENTAL, Ejectivity.EJECTIVE, Manner.STOP, 16, "t\u02BC"),							// tD'
//	VL_DENTAL_SIB_AFFRICATE						(Voice.VOICELESS, Place.DENTAL, Manner.SIB_AFFRICATE, 16, "t\u0361s"),							// tDs
//	LARYNGEALIZED_VD_BILABIAL_STOP				(Voice.VOICED, Place.BILABIAL, Manner.STOP, 15, "b"),							// b*
	VL_LABIO_VELAR_APPROXIMANT					(15, "\u028D", Voice.VOICELESS, Place.LABIO_VELAR, Manner.APPROXIMANT),							// hw
//	VD_DENTAL_IMPLOSIVE							(Voice.VOICED, Place.DENTAL, Manner.IMPLOSIVE, 14, "\u0257"),							// "d<
	VD_UVULAR_STOP								(14, "\u0262", Voice.VOICED, Place.UVULAR, Manner.STOP),							// G
	LABIALIZED_VL_UVULAR_FRICATIVE				(14, "\u03C7\u02B7", Voice.VOICELESS, Place.UVULAR, Manner.NONSIB_FRICATIVE),							// XW
//	LARYNGEALIZED_VD_BILABIAL_NASAL				(Voice.VOICED, Place.BILABIAL, Manner.NASAL, 14, "m"),							// m*
	VD_RETROFLEX_FLAP							(14, "\u027D", Voice.VOICED, Place.RETROFLEX, Manner.FLAP),							// r.[
	PALATALIZED_VL_VELAR_STOP					(13, "k\u02B2", Voice.VOICELESS, Place.VELAR, Manner.STOP),							// kJ
	PALATALIZED_VL_BILABIAL_STOP				(13, "p\u02B2", Voice.VOICELESS, Place.BILABIAL, Manner.STOP),							// pJ
	VL_PALATAL_AFFRICATE						(12, "c\u0361\u00E7", Voice.VOICELESS, Place.PALATAL, Manner.NONSIB_AFFRICATE),							// cC
	VD_VELAR_APPROXIMANT						(12, "\u0270", Voice.VOICED, Place.VELAR, Manner.APPROXIMANT),							// gA
	VD_PALATAL_FRICATIVE						(12, "\u029D", Voice.VOICED, Place.PALATAL, Manner.NONSIB_FRICATIVE),							// jF
//	VD_PALATO_ALVEOLAR_LAT_APPROXIMANT			(Voice.VOICED, Place.PALATO_ALVEOLAR, Manner.LAT_APPROXIMANT, 12, "l"),							// l_
	LABIALIZED_VL_UVULAR_STOP					(12, "q\u02B7", Labialization.LABIALIZED, Voice.VOICELESS, Place.UVULAR, Manner.STOP),							// qW
//	PALATALIZED_VL_DENTAL_STOP					(Voice.VOICELESS, Place.DENTAL, Manner.STOP, 11, "t\u02B2"),							// "tJ
//	VL_DENTAL_EJECTIVE_LAT_AFFRICATE			(Voice.VOICELESS, Place.DENTAL, Ejectivity.EJECTIVE, Manner.LAT_AFFRICATE, 11, "t\u0361\u026C\u02BC"),							// "tlF'
	VL_PALATAL_FRICATIVE						(11, "\u00E7", Voice.VOICELESS, Place.PALATAL, Manner.NONSIB_FRICATIVE),							// C
	LABIALIZED_VL_UVULAR_EJECTIVE_STOP			(11, "q\u02B7\u02BC", Labialization.LABIALIZED, Voice.VOICELESS, Place.UVULAR, Ejectivity.EJECTIVE, Manner.STOP),							// qW'
	VD_ALVEOLAR_APPROXIMANT						(11, "\u0279", Voice.VOICED, Place.ALVEOLAR, Manner.APPROXIMANT),							// rA
//	VL_DENTAL_LAT_APPROXIMANT					(Voice.VOICELESS, Place.DENTAL, Manner.LAT_APPROXIMANT, 10, "l\u0325"),							// "hl
	VD_PHARYNGEAL_FRICATIVE						(10, "\u0295", Voice.VOICED, Place.PHARYNGEAL, Manner.NONSIB_FRICATIVE),							// 9
	PRENASALIZED_LABIALIZED_VD_VELAR_STOP		(10, "\u014B\u0361g\u02B7", Labialization.LABIALIZED, Voice.VOICED, Place.VELAR, Manner.STOP),							// NgW
//	VD_DENTAL_SIB_AFFRICATE						(Voice.VOICED, Place.DENTAL, Manner.SIB_AFFRICATE, 10, "d\u0361z"),							// dDz
	VD_PALATAL_IMPLOSIVE						(10, "\u0284", Voice.VOICED, Place.PALATAL, Manner.IMPLOSIVE),							// dj<
	BVD_VELAR_STOP								(10, "g\u0324", Voice.BREATHY, Place.VELAR, Manner.STOP),							// gh
	PALATALIZED_VD_BILABIAL_NASAL				(10, "m\u02B2", Voice.VOICED, Place.BILABIAL, Manner.NASAL),							// mJ
	PRENASALIZED_VD_PALATO_ALVEOLAR_SIB_AFFRICATE	(10, "nd\u0361\u0292", Voice.VOICED, Place.PALATO_ALVEOLAR, Manner.SIB_AFFRICATE),							// ndZ
//	VD_ALVEOLAR_							(Voice.VOICED, Place.ALVEOLAR, Manner.STOP, 10, "r"),							// rr
	VLA_RETROFLEX_STOP							(10, "\u0288\u02B0", Voice.VOICELESS, Aspiration.ASPIRATED, Place.RETROFLEX, Manner.STOP),							// t.h
//	VL_DENTAL_NASAL								(Voice.VOICELESS, Place.DENTAL, Manner.NASAL, 9, "n\u0325"),							// "hn	*
	VL_ALVEOLO_PALATAL_SIB_FRICATIVE			(9, "\u0255", Voice.VOICELESS, Place.ALVEOLO_PALATAL, Manner.SIB_FRICATIVE),							// C,
	BVD_BILABIAL_STOP							(9, "b\u0324", Voice.BREATHY, Place.BILABIAL, Manner.STOP),							// bh
	VL_PALATAL_EJECTIVE_STOP					(9, "c\u02BC", Voice.VOICELESS, Place.PALATAL, Ejectivity.EJECTIVE, Manner.STOP),							// c'
	VL_VELAR_NASAL								(9, "\u014B\u030A", Voice.VOICELESS, Place.VELAR, Manner.NASAL),							// hN
	VL_PALATAL_APPROXIMANT						(9, "j\u030A", Voice.VOICELESS, Place.PALATAL, Manner.APPROXIMANT),							// hj
	VD_ALVEOLAR_LAT_FLAP						(9, "\u027A", Voice.VOICED, Place.ALVEOLAR, Manner.LAT_FLAP),							// l[
//	VD_DENTAL_TRILL								(Voice.VOICED, Place.DENTAL, Manner.TRILL, 9, "r"),							// rD	*
	VLA_RETROFLEX_SIB_AFFRICATE					(9, "\u0288\u0361s\u02B0", Voice.VOICELESS, Aspiration.ASPIRATED, Place.RETROFLEX, Manner.SIB_AFFRICATE),							// t.sh
	VL_ALVEOLAR_EJECTIVE_LAT_AFFRICATE			(9, "t\u0361\u026C\u02BC", Voice.VOICELESS, Place.ALVEOLAR, Ejectivity.EJECTIVE, Manner.LAT_AFFRICATE),							// tlF'
	VD_RETROFLEX_SIB_FRICATIVE					(9, "\u0290", Voice.VOICED, Place.RETROFLEX, Manner.SIB_FRICATIVE),							// z.
//	LARYNGEALIZED_VD_DENTAL_NASAL				(Voice.VOICED, Place.DENTAL, Manner.NASAL, 8, "n"),							// "n*	*
	PALATALIZED_VD_BILABIAL_STOP				(8, "b\u02B2", Voice.VOICED, Place.BILABIAL, Manner.STOP),							// bJ
	VD_PALATAL_AFFRICATE						(8, "\u025F\u0361\u029D", Voice.VOICED, Place.PALATAL, Manner.NONSIB_AFFRICATE),							// djjF
	VL_PALATAL_NASAL							(8, "\u0272\u030A", Voice.VOICELESS, Place.PALATAL, Manner.NASAL),							// hnj
	VD_RETROFLEX_LAT_FLAP						(8, "\u027A\u0306", Voice.VOICED, Place.RETROFLEX, Manner.LAT_FLAP),							// l.[
	VD_ALVEOLAR_LAT_FRICATIVE					(8, "\u026E", Voice.VOICED, Place.ALVEOLAR, Manner.LAT_FRICATIVE),							// lF
//	VLA_DENTAL_SIB_AFFRICATE					(Voice.VOICELESS, Aspiration.ASPIRATED, Place.DENTAL, Manner.SIB_AFFRICATE, 8, "t\u0361s\u02B0"),							// tDsh	*
//	LARYNGEALIZED_VD_DENTAL_LAT_APPROXIMANT		(Voice.VOICED, Place.DENTAL, Manner.LAT_APPROXIMANT, 7, "l"),							// "l*	*
//	VL_DENTAL_EJECTIVE_SIB_FRICATIVE			(Voice.VOICELESS, Place.DENTAL, Ejectivity.EJECTIVE, Manner.SIB_FRICATIVE, 7, "s\u02BC"),							// "s'	*
//	PALATALIZED_VL_DENTAL_SIB_FRICATIVE			(Voice.VOICELESS, Place.DENTAL, Manner.SIB_FRICATIVE, 7, "s\u02B2"),							// "sJ	*
	VD_LABIAL_VELAR_NASAL						(7, "\u014B\u0361m", Voice.VOICED, Place.BILABIAL, Place.VELAR, Manner.NASAL),							// Nm
	VL_ALVEOLO_PALATAL_SIB_AFFRICATE			(7, "t\u0361\u0255", Voice.VOICELESS, Place.ALVEOLO_PALATAL, Manner.SIB_AFFRICATE),							// cC,
//	LARYNGEALIZED_VD_ALVEOLAR_STOP				(Voice.VOICED, Place.ALVEOLAR, Manner.STOP, 7, "d"),							// d*
	BVD_PALATO_ALVEOLAR_SIB_AFFRICATE			(7, "d\u0361\u0292\u0324", Voice.BREATHY, Place.PALATO_ALVEOLAR, Manner.SIB_AFFRICATE),							// dZh
	PALATALIZED_VD_VELAR_STOP					(7, "g\u02B2", Voice.VOICED, Place.VELAR, Manner.STOP),							// gJ
//	VD_ALVEOLAR_FLAP							(Voice.VOICED, Place.ALVEOLAR, Manner.STOP, 7, ""),							// rT
	VD_ALVEOLO_PALATAL_SIB_FRICATIVE			(7, "\u0291", Voice.VOICED, Place.ALVEOLO_PALATAL, Manner.SIB_FRICATIVE),							// z,
//	PALATALIZED_VD_DENTAL_LAT_APPROXIMANT		(Voice.VOICED, Place.DENTAL, Manner.LAT_APPROXIMANT, 6, "l\u02B2"),							// "lJ	*
//	VL_DENTAL_LAT_AFFRICATE						(Voice.VOICELESS, Place.DENTAL, Manner.LAT_AFFRICATE, 6, "t\u0361\u026C"),							// "tlF	*
	PRENASALIZED_VL_VELAR_STOP					(6, "\u014B\u0361k", Voice.VOICELESS, Place.VELAR, Manner.STOP),							// Nk
	PRENASALIZED_VD_LABIAL_VELAR_STOP			(6, "nmg\u0361b", Voice.VOICED, Place.BILABIAL, Place.VELAR, Manner.STOP),							// Nmgb
	BVD_RETROFLEX_STOP							(6, "\u0257\u0324", Voice.BREATHY, Place.RETROFLEX, Manner.STOP),							// d.h
//	VD_PALATO_ALVEOLAR_STOP						(Voice.VOICED, Place.PALATO_ALVEOLAR, Manner.STOP, 6, "d"),							// d_
	LABIALIZED_VD_VELAR_FRICATIVE				(6, "\u0263\u02B7", Labialization.LABIALIZED, Voice.VOICED, Place.VELAR, Manner.NONSIB_FRICATIVE),							// gFW
//	LARYNGEALIZED_VL_VELAR_STOP					(Voice.VOICELESS, Place.VELAR, Manner.STOP, 6, "k"),							// k*
	PRENASALIZED_VL_BILABIAL_STOP				(6, "m\u0361p", Voice.VOICELESS, Place.BILABIAL, Manner.STOP),							// mp
//	PRENASALIZED_VD_DENTAL_STOP					(Voice.VOICED, Place.DENTAL, Manner.STOP, 6, "n\u0361d"),							// ndD	*
	PRENASALIZED_VD_PALATAL_STOP				(6, "\u0272\u0361\u025F", Voice.VOICED, Place.PALATAL, Manner.STOP),							// ndj
//	VL_DENTAL_EJECTIVE_SIB_AFFRICATE			(Voice.VOICELESS, Place.DENTAL, Ejectivity.EJECTIVE, Manner.SIB_AFFRICATE, 6, "t\u0361s\u02BC"),							// tDs'	*
	VD_LABIODENTAL_APPROXIMANT					(6, "\u028B", Voice.VOICED, Place.LABIODENTAL, Manner.APPROXIMANT),							// vA
	LABIALIZED_VD_PALATAL_APPROXIMANT			(6, "\u0265", Labialization.LABIALIZED, Voice.VOICED, Place.PALATAL, Manner.APPROXIMANT),							// wj
//	PALATALIZED_VD_DENTAL_STOP					(Voice.VOICED, Place.DENTAL, Manner.STOP, 5, "d\u02B2"),							// "dJ	*
//	VD_DENTAL_LAT_AFFRICATE						(Voice.VOICED, Place.DENTAL, Manner.LAT_AFFRICATE, 5, "d\u0361\u026E"),							// "dlF	*
//	VELARIZED_VD_DENTAL_LAT_APPROXIMANT			(Voice.VOICED, Place.DENTAL, Manner.LAT_APPROXIMANT, 5, "l\u02E0"),							// "l-	*
	LABIALIZED_VD_UVULAR_STOP					(5, "\u0262\u02B7", Labialization.LABIALIZED, Voice.VOICED, Place.UVULAR, Manner.STOP),							// GW
//	BVD_DENTAL_STOP								(Voice.BREATHY, Place.DENTAL, Manner.STOP, 5, "d\u0324"),							// dDh	*
	VD_VELAR_IMPLOSIVE							(5, "\u0260", Voice.VOICED, Place.VELAR, Manner.IMPLOSIVE),							// g<
	LABIALIZED_VL_GLOTTAL_FRICATIVE				(5, "h\u02B7", Labialization.LABIALIZED, Voice.VOICELESS, Place.GLOTTAL, Manner.NONSIB_FRICATIVE),							// hW
//	LARYNGEALIZED_VD_ALVEOLAR_LAT_APPROXIMANT	(Voice.VOICED, Place.ALVEOLAR, Manner.LAT_APPROXIMANT, 5, "l"),							// l*
	LABIALIZED_VD_BILABIAL_NASAL				(5, "m\u02B7", Labialization.LABIALIZED, Voice.VOICED, Place.BILABIAL, Manner.NASAL),							// mW
	PRENASALIZED_VD_ALVEOLAR_SIB_AFFRICATE		(5, "nd\u0361z", Voice.VOICED, Place.ALVEOLAR, Manner.SIB_AFFRICATE),							// ndz
	NASALIZED_VD_DENTAL_AFFRICATED_CLICK		(5, "", Voice.VOICED, Place.DENTAL, Manner.CLICK),							// n|
//	LARYNGEALIZED_VL_BILABIAL_STOP				(Voice.VOICELESS, Place.BILABIAL, Manner.STOP, 5, "p"),							// p*
	VL_ALVEOLAR_LAT_AFFRICATE					(5, "t\u0361\u026C", Voice.VOICELESS, Place.ALVEOLAR, Manner.LAT_AFFRICATE),							// tlF
	PALATALIZED_VD_LABIODENTAL_FRICATIVE		(5, "v\u02B2", Voice.VOICED, Place.LABIODENTAL, Manner.NONSIB_FRICATIVE),							// vJ
	VL_DENTAL_AFFRICATED_CLICK					(5, "", Voice.VOICED, Place.ALVEOLAR, Manner.CLICK);							// |
	
	private final int occurrence;
	private final String symbol;
	private final Feature[] features;
	private final boolean labialized;
	private final Voice voice;
	private final boolean aspirated;
	private final Place place;
	private final boolean ejective;
	private final Manner manner;
	private final double probability;
	
	private Consonant(int occurence, String symbol, Feature... features) {
		this.occurrence = occurence;
		this.symbol = symbol;
		this.features = features;
		
		Voice voice = Voice.VOICELESS;
		Place place = Place.LINGUO_LABIAL;
		Manner manner = Manner.IMPLOSIVE;
		boolean labialized = false;
		boolean aspirated = false;
		boolean ejective = false;
		for (Feature feature : features) {
			Class type = feature.getClass();
			
			if (type == Voice.class)
				voice = (Voice) feature;
			else if (type == Place.class)
				place = (Place) feature;
			else if (type == Manner.class)
				manner = (Manner) feature;
			else if (feature == Labialization.LABIALIZED)
				labialized = true;
			else if (feature == Aspiration.ASPIRATED)
				aspirated = true;
			else if (feature == Ejectivity.EJECTIVE)
				ejective = true;
		}
		
		this.voice = voice;
		this.place = place;
		this.manner = manner;
		this.labialized = labialized;
		this.aspirated = aspirated;
		this.ejective = ejective;
		probability = (double) occurrence / Data.LANGUAGE_SAMPLE_SIZE;
	}
	
	public Consonant dentalize() {
		if (this.place == Place.ALVEOLAR)
			for (Consonant consonant : Consonant.values())
				if (consonant.place() == Place.DENTAL && consonant.manner == this.manner)
					return consonant;
			
		return this;	
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
	
	// Turns consonant into English name based on IPA standards
	public String toString() {		
		// Basic name with voice, place, manner, and aspiration and ejective if present
		String name = voice.name + " " + (aspirated ? "aspirated " : "") + place.name.toLowerCase() + " " + (ejective ? "ejective " : "") +  manner.name.toLowerCase();
		
		// Add labialization if present
		if (labialized)
			name = "Labialized " + name.toLowerCase();
		
		return name;
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
	
	/* Consonant features - each value has a string name */
	
	public interface Feature {}
	
	// Use of vocal cords during consonant's duration
	public static enum Voice implements Feature {
		VOICELESS("Voiceless"), VOICED("Voiced"), BREATHY("Breathy voiced");
		
		private final String name;
		
		private Voice(String name) {
			this.name = name;
		}
	}
	
	// Release of air along with consonant
	public static enum Aspiration  implements Feature {
		UNASPIRATED("Unaspirated"), ASPIRATED("Aspirated");
		
		private final String name;
		
		private Aspiration(String name) {
			this.name = name;
		}
	}
	
	// Glottal closure and release
	public static enum Ejectivity  implements Feature {
		EJECTIVE("Ejective");
		
		private final String name;
		
		private Ejectivity(String name) {
			this.name = name;
		}
	}
	
	// Rounding of lips
	public static enum Labialization  implements Feature {
		LABIALIZED("Labialized");
		
		private final String name;
		
		private Labialization(String name) {
			this.name = name;
		}
	}
	
	// Placement of release - either tongue or other part of vocal tract
	public static enum Place implements Feature {
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
	public static enum Manner implements Feature {
		NASAL("Nasal"), STOP("Stop"), SIB_AFFRICATE("Sibilant affricate"), NONSIB_AFFRICATE("Non-sibilant affricate"),
		SIB_FRICATIVE("Sibilant fricative"), NONSIB_FRICATIVE("Non-sibilant fricative"), APPROXIMANT("Approximant"),
		FLAP("Flap"), TRILL("Trill"), LAT_AFFRICATE("Lateral affricate"), LAT_FRICATIVE("Lateral fricative"),
		LAT_APPROXIMANT("Lateral approximant"), LAT_FLAP("Lateral flap"), IMPLOSIVE("Implosive"), CLICK("Click");
		
		private final String name;
		
		private Manner(String name) {
			this.name = name;
		}
	}
}
