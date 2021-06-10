package SolvingProblemsInJava;

public class Week2SecondAssignmentPart1 {
    public int findStopCodon(String dna, int startIndex, String stopCodon) {
        int index = 0;

        while(true) {
            index = dna.indexOf(stopCodon, startIndex + 3);

            if (index == -1 || (index - startIndex) % 3 == 0) {
                break;
            }

            startIndex += 3;
        }

        if (index != -1) {
            return index;
        } else {
            return dna.length();
        }
    }

    public void testFindStopCodon() {
        String dna = "xxxyyyzzzTAAxxxyyyzzzTAAxx";

        int index = findStopCodon(dna, 0, "TAA");
        System.out.println("Index = " + index);

        index = findStopCodon(dna, 9, "TAA");
        System.out.println("Index = " + index);

        index = findStopCodon(dna, 1, "TAA");
        System.out.println("Index = " + index);

        index = findStopCodon(dna, 0, "TAG");
        System.out.println("Index = " + index);
    }

    public String findGene(String dna, int start) {
        final String START_CODON = "ATG";
        int startIndex = dna.indexOf(START_CODON, start);

        if (startIndex == -1) {
            return null;
        }

        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");

        int minIndex = Math.min(taaIndex, Math.min(tagIndex, tgaIndex));

        if (minIndex == dna.length()) {
            return null;
        } else {
            return dna.substring(startIndex, minIndex + 3);
        }
    }

    public void testFindGene() {
        String dna = "AATGTAGCTTAAACCTTTAAAGCAAGGCACTGAAAATGCAGATGA";
        System.out.println("Gene: " + findGene(dna, 0));

        dna = "GAGCTCACTCCATAGACACAAAGGTTTGGTCCTGGCCTTCTTATTAGT";
        System.out.println("Gene: " + findGene(dna, 0));

        dna = "TTTCAGTGAGCTTACACATGCAAGTATCCGCGCGCCAAATGCCCT";
        System.out.println("Gene: " + findGene(dna, 0));

        dna = "ATCATTACTGACCATAGCGGGTATCAAGCACACACCTATGT";
        System.out.println("Gene: " + findGene(dna, 0));

        dna = "CACAACACCTTGCTTAGCCACACCCCCACGGGATACAGCAGTGATA";
        System.out.println("Gene: " + findGene(dna, 0));
    }

    public void printAllGenes(String dna) {
        int start = 0;

        while (true) {
            String gene = findGene(dna, start);

            if (gene.isEmpty()) {
                break;
            }

            System.out.println("Gene: " + gene);

            start = dna.indexOf(gene, start) + gene.length();
        }
    }

    public void testPrintAllGenes() {
        String dna = "ATGATCTAATTTATGCTGCAACGGTGAAGA";
        printAllGenes(dna);
    }

}
