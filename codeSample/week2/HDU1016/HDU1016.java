// HDU1016: Prime Rings Problem
import java.util.Scanner;
public class HDU1016 {
   public static void main (String[] args) {
      initPrimeChecker();
      Scanner in = new Scanner( System.in );
      int count = 0;
      while (in.hasNext()) {
         System.out.printf( "%sCase %d:\n", 
            (count++ == 0 ? "" : "\n"),  count
         );
         
         int n = in.nextInt();
         if (n <= 1 || n % 2 == 1) continue;

         findPrimeRings( n );
      }
      in.close();
   }

   private static void findPrimeRings (int n) {
      int[] elements = new int[n];
      for (int i = 0; i < n; i++)
         elements[i] = i+1;

      permunation( elements, 1 );   
   }

   private static void permunation (int[] a, int k) {
      int n = a.length;
      if (k == n-1) {
         if (isPrimeRing( a )) 
            outRingElements( a );
      } else {
         for (int i = k; i < n; ++i) {
            { int t=a[i]; a[i]=a[k]; a[k]=t; }
            permunation(a, k+1);
            { int t=a[i]; a[i]=a[k]; a[k]=t; }
         }
      }
   }
   
   private static void outRingElements (int[] ring) {
      int n = ring.length;
      for (int i = 0; i < n; i++)
         System.out.printf( "%d%s", 
            ring[i],  i != n-1 ? " " : "\n"
         );
   }

   private static boolean isPrimeRing (int[] a) {
      int n = a.length;
      if (! isPrime[ a[n-1] + a[0] ]) return false;
      for (int i = 1; i < n; i++)
         if (! isPrime[ a[i-1] + a[i] ]) return false;
      return true;
   }

   private static void initPrimeChecker () {
      for (int i = 0; i < PRIMES.length; i++)
         isPrime[ PRIMES[i] ] = true;
   }
   
   private static final int[] PRIMES = { 
      2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37
   };

   private static final int MAX_N = 20;
   private static final boolean[] isPrime = new boolean[2 * MAX_N];
}
