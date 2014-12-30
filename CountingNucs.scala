/*  Ben Hardy
    
    From Project Rosalind, Question 1:
    Given: A DNA string s of length at most 1000 nt.

    Return: Four integers (separated by spaces) counting the respective number of times that the symbols 'A', 'C', 'G', and 'T' occur in s.
*/

object CountingNucs {

    /* this is my first ever Scala program so it's going to be rough and
       and not very idiomatic */

    def nucCounter(str: String) : String = {
        var ACount = 0;
        var CCount = 0;
        var GCount = 0;
        var TCount = 0;
        var i = 0;

        for( i <- 0 to str.length -1){
            var tempChar = str.charAt(i);

            if (tempChar == 'A') {
                ACount += 1;
            } else if (tempChar == 'C') {
                CCount += 1;
            } else if (tempChar == 'G') {
                GCount += 1;
            } else if (tempChar == 'T') {
                TCount += 1;
            }   
        }

        var res = "" + " " + ACount + " " + CCount + " " + GCount + " " +  TCount;
        return res;
    }

	def main(args: Array[String]) {
		if (args.length != 1) {
            println("Incorrect input formats. Need 1 string of DNA values!")
        } else {
            var res = nucCounter(args(0));
            println(res);
        }
	}
}
