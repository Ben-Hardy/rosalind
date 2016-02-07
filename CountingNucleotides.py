import sys

def countNucs(dna):
	return " ".join([str(dna.count(i)) for i in sorted(set(list(dna)))])

def main():
	print(countNucs('AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC'))

if __name__ == '__main__':
	main()