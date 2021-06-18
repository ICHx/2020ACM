package week7.q2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/** 
 * b589: 超級馬拉松賽 https://zerojudge.tw/ShowProblem?problemid=b589 
 * 
 * 參考資料 https://www.csie.ntu.edu.tw/~sprout/algo2018/ppt_pdf/dynamic_programming_2_inclass.pdf
 * 

*/
public class running {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        //  File  file1=new File("src/week7/q2/case.txt");
        //  Scanner sc = new Scanner(file1);
        int cnt = sc.nextInt();
        while (cnt!=0) {
            int route[] = new int[cnt];
            for (int kk = 0; kk < cnt; kk++) {
                route[kk]=sc.nextInt();
            }
            
            int result = run(cnt, route);
            System.out.println(result);
            cnt = sc.nextInt();
        }
    }

    private static int run(int cnt, int[] n) {

        int[] dp = new int[cnt];
        Arrays.fill(dp, 0);

        //initial condition
        dp[cnt - 1] = n[cnt - 1] << 1;

        for (int i = cnt - 2; i >= 0; i--) {
            // can have more than one accel, skipping i+1 and add i+2 for that
            if(i+2<cnt){
            dp[i] = Math.max(n[i] *2 + dp[i+2], n[i] + dp[i + 1]);
            }else{
            dp[i] = Math.max(n[i]*2, n[i] + dp[i + 1]);}
        }
        return dp[0];

    }
}