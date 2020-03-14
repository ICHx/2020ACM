package q2;

import java.util.Scanner;

/**
 * 
 * 題目：求給定數字的平方根。
 * do n
 * 分析：數學，二分。可以利用模擬（手算開方）或者二分求解。
 * 
 * https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=964
 */
public class Main {
    public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
System.out.println("Please enter:");
int input1 = sc.nextInt();
    }

    public static int squareRoot(int input1) {
        switch (input1) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 4:
                return 2;
            default:
                break;
        }
int calc0;
boolean success;
        for (int i = 3; i < (input1>>1); i++) {
          calc0=  i*i;
          if(input1==calc0){
              success=true;
              break;
          }
            
        }


        return 0;
    }
}