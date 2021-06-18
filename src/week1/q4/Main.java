import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    final static boolean DEBUG = false;

    public static void main(String[] args) {
        int N, m = 0, n = 0;
        ArrayList<Integer> m_data = new ArrayList<>();
        ArrayList<Integer> n_data = new ArrayList<>();
        String nline, s[];
        boolean run = false;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // number of input blocks
        nline = sc.nextLine(); // get last enter
        a: for (int i = 0; i < N; i++) {
            do {
                do {
                    nline = sc.nextLine();// get number
                } while (nline.equals(""));// ignore empty input

                s = nline.split(" ");
                if (s.length != 2) {
                    illegal();
                    // continue a;
                }

                n = Integer.parseInt(s[0]);
                m = Integer.parseInt(s[1]);

                if (m == 0 & n == 0) {
                    if (n > 100 || n < 0){
                        illegal();
                        // continue a;
                    }

                    run = true;
                    break;
                }
                m_data.add(m);
                n_data.add(n);

            } while (sc.hasNext());

            if (run) {
                payload(m_data, n_data);
                run = false;
                if(i!=(N-1)) System.out.println(); //after 1 block
            }
            m_data.clear();
            n_data.clear();
        }

        // done
        sc.close();
    }

    /*
     * Given two integers n and m, count the number of pairs of integers (a,b) such
     * that 0 < a < b < n and (a^2+b^2 +m)/(ab) is an integer. This problem contains
     * multiple test cases!
     * 
     * You will be given a number of cases in the input. Each case is specified by a
     * line containing the integers n and m. The end of input is indicated by a case
     * in which n = m = 0. You may assume that 0 < n <= 100.
     */
    public static void payload(ArrayList<Integer> mList, ArrayList<Integer> nList) {
        // array[0] == arraylist.get(0);
        int m = -1, n = -1, a = 0, b = 0;
        int count = mList.size(), caseNo = 1, caseCount = 0;
        float result;

        for (int i = 0; i < count; i++) {
            m = mList.get(i);
            n = nList.get(i);

            for (a = 1; a < n; a++) {
                for (b = a + 1; b > a && b < n; b++) {
                    result = (a * a + b * b + m) % (a * b);
                    if (result == 0) // integer
                        caseCount++;

                }
            } // finish calc

            System.out.printf("Case %d: %d\n",caseNo++,caseCount);
            caseCount = 0;
        }
    }

    private static void illegal() {
        System.exit(1);
        return;
    }

}