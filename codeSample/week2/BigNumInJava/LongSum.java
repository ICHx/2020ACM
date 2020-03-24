// Example: LongSum with 10-based longs
// LongSum num1 num2
// @ Max, 2020
import static java.lang.System.out;
import java.util.Scanner;

public class LongSum {
   public static void main (String[] args) {
      int base = 10;
      long num1 = args.length > 0 ? Long.parseLong(args[0]) : 
                  (long) (.5 * Math.random() * Long.MAX_VALUE);
      long num2 = args.length > 1 ? Long.parseLong(args[1]) : 
                  (long) ((Math.random() - .5) * Long.MAX_VALUE);

      String op = num2 < 0 ? "-" : "+";
      if ("-".equals(op) && num1 < Math.abs(num2)) {
         long t = num1;  num1 = -num2;  num2 = -t;
      }
      String sNum1 = "" + num1;
      String sNum2 = "" + Math.abs(num2);

      final long ANSWER = num1 + num2;

      Scanner in = new Scanner( System.in );

      while (true) {
         showProblem(base, sNum1, op, sNum2);
         System.out.println( reverse( "" + ANSWER ) );
         long ans = getAnswer( in );

         if (ans == ANSWER) {
            System.out.println("\nGreat Job. Bye :-)\n");
            break;
         } else {
            System.out.println("\nOoh..., Try Again!\n");
         }
      }
      in.close();
   }

   private static long getAnswer (Scanner in) {
      String ans = in.next();
      ans = reverse( ans );
      return Long.parseLong( ans );
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
