import collection.mutable.HashMap

object RNATranslator {



/* RNA Codon Table
UUU F      CUU L      AUU I      GUU V
UUC F      CUC L      AUC I      GUC V
UUA L      CUA L      AUA I      GUA V
UUG L      CUG L      AUG M      GUG V
UCU S      CCU P      ACU T      GCU A
UCC S      CCC P      ACC T      GCC A
UCA S      CCA P      ACA T      GCA A
UCG S      CCG P      ACG T      GCG A
UAU Y      CAU H      AAU N      GAU D
UAC Y      CAC H      AAC N      GAC D
UAA Stop   CAA Q      AAA K      GAA E
UAG Stop   CAG Q      AAG K      GAG E
UGU C      CGU R      AGU S      GGU G
UGC C      CGC R      AGC S      GGC G
UGA Stop   CGA R      AGA R      GGA G
UGG W      CGG R      AGG R      GGG G 
*/

    def RNATranslator(str: String) : String = {
        val protmap = collection.immutable.HashMap(
            "UUU" -> "F",   
            "UUC" -> "F",   
            "UUA" -> "L",   
            "UUG" -> "L",   
            "UCU" -> "S",   
            "UCC" -> "S",   
            "UCA" -> "S",   
            "UCG" -> "S",   
            "UAU" -> "Y",   
            "UAC" -> "Y",   
            "UAA" -> "", // for empty strings, we will instead return the current 
            "UAG" -> "", // protein mapping 
            "UGU" -> "C",
            "UGC" -> "C",
            "UGA" -> "",
            "UGG" -> "W",   
            "CUU" -> "L",
            "CUC" -> "L",
            "CUA" -> "L",
            "CUG" -> "L",
            "CCU" -> "P",
            "CCC" -> "P",
            "CCA" -> "P",
            "CCG" -> "P",
            "CAU" -> "H",
            "CAC" -> "H",
            "CAA" -> "Q",
            "CAG" -> "Q",
            "CGU" -> "R",
            "CGC" -> "R",
            "CGA" -> "R",
            "CGG" -> "R",
            "AUU" -> "I", 
            "AUC" -> "I", 
            "AUA" -> "I", 
            "AUG" -> "M", 
            "ACU" -> "T", 
            "ACC" -> "T", 
            "ACA" -> "T", 
            "ACG" -> "T", 
            "AAU" -> "N", 
            "AAC" -> "N", 
            "AAA" -> "K", 
            "AAG" -> "K", 
            "AGU" -> "S", 
            "AGC" -> "S", 
            "AGA" -> "R",
            "AGG" -> "R",
            "GUU" -> "V",
            "GUC" -> "V",
            "GUA" -> "V",
            "GUG" -> "V",
            "GCU" -> "A",
            "GCC" -> "A",
            "GCA" -> "A",
            "GCG" -> "A",
            "GAU" -> "D",
            "GAC" -> "D",
            "GAA" -> "E",
            "GAG" -> "E",
            "GGU" -> "G",
            "GGC" -> "G",
            "GGA" -> "G",
            "GGG" -> "G"
        );

        var res = "";
        var curCodon = "";

        var rng = 0 until str.length by 3;

        for (i <- rng) {
            curCodon = str.substring(i, i+3);
            res += protmap(curCodon);

            if (curCodon == "UAA" || curCodon == "UAG" || curCodon == "UGA") {
                return res;
            }
        } 
        
        return res;
    }

    def isValidRNASeq(str: String) : Boolean = {
        var checkstr = "";
        checkstr = str.map(s =>
              if (s == 'A') 'A'
              else if (s == 'C') 'C'
              else if (s == 'G') 'G'
              else if (s == 'U') 'U'
              else return false); /* this case only happens if the string contains an invalid character*/

        return true;
    }


	def main(args: Array[String]) {
		if (args.length != 1) {
            println("Incorrect input format! Must be a single DNA sequence string");
        } else if(!isValidRNASeq(args(0))){
            println("Invalid String!");
        } else {
            var res = RNATranslator(args(0));
            println(res);
        }
	}
}
