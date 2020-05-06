package P2;

import java.util.Scanner;

/*
 * p2 : construct an RE that specifies each of the following
 * a. All binary Strings except 11 or 111
 * b. Bin Strings with 1 in every odd-number bit pos
 * c. Bin Strings with at least 2 zeros and at most 1 one
 * d. Bin Strings with no two consecutive 1s
 * 
 * Press -1 to go to next stage
 */
public class p2 {

    public static void main(String[] args) {
        String input1 = "0";
        String patA, patB, patC, patD;

        patA = "^(1|1{4,}|[10]*0+[01]*)$";
        patB = "^([10]?(1[10])*1)$";
        patC = "^(0+10+|10{2,}|0{2,}1?)$";
        patD = "^1?(01?)*$";

        Scanner sc = new Scanner(System.in);

        // A:
        System.out.println("Case A");
        do {
            input1 = sc.next();
            System.out.println(input1.matches(patA));

        } while (!input1.equals("-1"));

        // B

        System.out.println("\nCase B");

        do {
            input1 = sc.next();
            System.out.println(input1.matches(patB));

        } while (!input1.equals("-1"));

        // C

        System.out.println("\nCase C");

        do {
            input1 = sc.next();
            System.out.println(input1.matches(patC));

        } while (!input1.equals("-1"));

        // D

        System.out.println("\nCase D");

        do {
            input1 = sc.next();
            System.out.println(input1.matches(patD));

        } while (!input1.equals("-1"));

        sc.close();
    }
}