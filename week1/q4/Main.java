import java.util.*;

public class Main {
    /*
     * Given two integers n and m, count the number of pairs of integers (a,b) such
     * that 0 < a < b < n and (a^2+b^2 +m)/(ab) is an integer. This problem contains
     * multiple test cases!
     * 
     * You will be given a number of cases in the input. Each case is specified by a
     * line containing the integers n and m. The end of input is indicated by a case
     * in which n = m = 0. You may assume that 0 < n <= 100.
     */
    public static void main(String[] args) {
        int m, n, count = 1;
        Scanner sc = new Scanner(System.in);
        System.out.println((count++) + "\n");
        while (sc.hasNextInt()) {
            m = sc.nextInt();
            n = sc.nextInt();
            payload(m, n);
        }
        sc.close();
    }

    public static void payload(int m, int n) {
        System.out.println("m=" + m + ",n=" + n);
        
    }

}