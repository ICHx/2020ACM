// Problem ACM006: [UVa10023] Square root
// @ Max, 2020
import java.math.BigInteger;
import java.util.Scanner;

public class SquareRoot {
   public static void main (String[] args) {
      Scanner in = new Scanner( System.in );
      int nCase = in.nextInt();
      for (int i = 0; i < nCase; i++){
         BigInteger n = new BigInteger( in.next() );
         System.out.printf( "%s%s\n", i==0 ? "" : "\n", sqrt(n) );
      }
      in.close();
   }

   private static BigInteger sqrt (BigInteger n) {
      BigInteger a = BigInteger.ONE;
      BigInteger b = n;
      BigInteger m, p;
      while (a.compareTo(b) != 0) {     // a != b
         m = a.add(b).shiftRight(1);    // (a+b)/2
         p = m.multiply(m);             // m*m
         if (p.compareTo(n) == 0)       // p == n
            return m;
         else if (p.compareTo(n) < 0)   // p < n
            a = m;
         else
            b = m;
      }
      return a;
   }
}

/*

1) Newton method to find sqrt(c)

   t_ = c;
   do {
       t = .5 * ( t_ + t_ / c );
       t_ = t;
   } while (t != t_);   // why? 


2) Binary search to find integral sqrt(c):

   a = 1, b = c;
   while (a != b) {
      m = (a+b)/2;
      p = m * m;
      if (p == c)
         return m;
      else if (p < c)
         a = m;
      else
         b = m;
   }
   return a;

*/
 