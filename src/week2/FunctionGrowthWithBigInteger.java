import java.math.BigInteger;

public class FunctionGrowthWithBigInteger {  
   public static void main (String[] args) {
      System.out.printf( "%10s%10s%20s%10s%20s%30s\n",
         "log(n)", "n", "n*log(n)", "n^2", "n^3", "2^n + (next line)" 
      );
      long n = 16;
      BigInteger p = new BigInteger( "" + (1 << n) );
      //     ... p = new BigInteger( "" + (int)Math.pow(2,n) );
     
      while (n <= 2048) {
         System.out.printf( "%10f%10d%20f%10d%20d%30e\n",
            Math.log(n), n, n*Math.log(n), n*n, n*n*n, Math.pow(2,n)
         );
         System.out.println( p );
         n *= 2;
         p = p.multiply( p );
      }
   }
}
