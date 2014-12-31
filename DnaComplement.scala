/*
    Given: A DNA string s of length at most 1000 bp.
    Return: The reverse complement sc of s.
*/

object DnaComplement {

    def dnacomp(str: String) : String = {
        var rev = str.reverse;
        var res = "";
        res = rev.map(s =>
                          if (s == 'A') 'T'
                          else if (s == 'C') 'G'
                          else if (s == 'G') 'C'
                          else if (s == 'T') 'A'
                          else s); /* this case only happens if the string is invalid */
        return res;
    }

    def validDNASeq(str: String) : Boolean = {
        var checkstr = "";
        checkstr = str.map(s =>
              if (s == 'A') 'A'
              else if (s == 'C') 'C'
              else if (s == 'G') 'G'
              else if (s == 'T') 'T'
              else return false); /* this case only happens if the string contains an invalid character*/


        return true;
            
    }

	def main(args: Array[String]) {
		if (args.length != 1) {
            println("Incorrect input format! Must be a single DNA sequence string");
        } else if(!validDNASeq(args(0))){
            println("Invalid String!");
        } else {
            var res = dnacomp(args(0));
            println(res);
        }
	}
}
