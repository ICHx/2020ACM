// Example: BigSum with any-based BigIntegers
// BigSum base num1 num2
// num1 is positive, num2 might be positive or negative
// @ Max, 2020
import static java.lang.System.out;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class BigSum {
   public static void main (String[] args) {
      int base = args.length > 0 ? Integer.parseInt(args[0]) : 10;
      BigInteger num1 = args.length > 1 ? new BigInteger( args[1], base) : 
                        new BigInteger( 400, new Random() );  
                        // maximum 400 bits by a Random Generator

      BigInteger num2 = args.length > 2 ? 
         new BigInteger( args[2], base) : 
         new BigInteger( "" + (long)((Math.random() - .5) * Long.MAX_VALUE));

      String resultSign = "";
      String op = (num2.compareTo(BigInteger.ZERO) < 0) ? "-" : "+";
      if ("-".equals(op) && num1.compareTo(num2.abs()) < 0) {
         BigInteger t = new BigInteger( "-" + num1);  
         num1 = num2.abs();  
         num2 = t;
         resultSign = "-";
      }
      String sNum1 = num1.toString( base );
      String sNum2 = num2.abs().toString( base );

      BigInteger ANSWER = num1.add( num2 );

      Scanner in = new Scanner( System.in );
      while (true) {
         showProblem( base, sNum1, op, sNum2);
         System.out.printf( "%s %s\n",          // Tips for test
            reverse( ANSWER.toString( base)), resultSign
         );  
         BigInteger ans = new BigInteger( getAnswer(in), base);

         if (ans.equals(ANSWER)) {
            System.out.println( "\nGreat Job. Bye :-)\n");
            break;
         } else {
            System.out.println( "\nOoh..., Try Again!\n");
         }
      }
      in.close();
   }

   private static String getAnswer  (Scanner in) {
      String ans = in.next();
      return reverse( ans );
   }

   private static int maxLen;
   private static void showProblem (int base, String s1, String op, String s2) {
      maxLen = Math.max( s1.length(), s2.length() );
      out.printf( "%d-based %s in reverse order:\n", 
         base, "+".equals(op) ? "addtion" : "substraction"
      );
   
      String fmt = "%-" + maxLen + "s";
      out.printf( fmt + "\n" + fmt + " %s\n", reverse(s1), reverse(s2), op );
   
      out.println( repeatChar( maxLen+2, '-' ));
   }

   private static String reverse (String s) {
      return new StringBuilder(s).reverse().toString();
   }

   private static String repeatChar(int n, char c) {
      String s = "";
      for (int i = 0; i < n; i++) s += c;
      return s;
   }
}
