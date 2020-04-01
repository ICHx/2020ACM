package P1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * P1
 */
public class P1 {
    /*
     * Find genes in a given genome start codon: ATG beg=i stop codon: TAG
     * 
     * if stop codon is found and substring length is a multiple of 3, print gene
     * and reset beg to -1
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 99; i++) {
            System.out.println("Enter a gene.");
            String gene = sc.next();
            // first req: recognize the start-end
            // String entireGene3="(ATG).*(TAG)";
            // second req: recognize only ACTG
            // third req: recognize only in multiple of 3s.
            // String entireGene2 = "ATG([ACTG]{3})*TAG";
            // FOURTH REQ: LESS GREEDY
            // String entireGene4 = "ATG([ACTG]{3})*?TAG";
            // FIFTH REQ: TAA TAG or TGA
            String entireGene1 = "ATG([ACTG]{3})+?(TAG|TAA|TGA)"; 
            //exclude empty gene

            Pattern genePattern = Pattern.compile(entireGene1);
            Matcher geneMatcher = genePattern.matcher(gene);

            String geneSeg;
            while (geneMatcher.find()) {
                /*
                 * geneMatcher.group(); the above command indicate showing which () of the
                 * regexp pattern eg: Pattern.compile("W(or)(ld!)");
                 * matcher.group(1));//得到第一组匹配——与(or)匹配 also applicable to start() end()
                 */

                geneSeg = gene.substring(geneMatcher.start() + 3, geneMatcher.end() - 3);
                //ignoring the start/end codons
                System.out.println(geneSeg);

            }

        }

        sc.close();
    }

}