/*  
    Ben Hardy
    From Project Rosalind:

    Given: A DNA string t having length at most 1000 nt.
    Return: The transcribed RNA string of t.

    summary:
    So convert all T's to U basically
*/
object RNAizer {

    def RNAizer(str: String) : String = {
        var res = str.map(s => if (s == 'T') 'U' else s);

        return res;
    } 
	def main(args: Array[String]) {
		if (args.length != 1) {
            println("Incorrect input format! Must be a single DNA sequence string");
        } else {
            var res = RNAizer(args(0));
            println(res);
        }
	}
}
