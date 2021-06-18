package week5.q2;

// Quick Permunations for HDU1016: Prime Rings Problem
// @ Max, March 2020
import java.util.Scanner;

public class HDU1016A {
   public static final int DEBUG = 0;

   public static void main(final String[] args) {
      initPrimeChecker();
      Scanner in = new Scanner(System.in);
      int count = 0;
      while (in.hasNext()) {
         if (DEBUG == 1) {
            System.out.printf("%sCase %d:\n", (count++ == 0 ? "" : "\n"), count);

         }
         else count++;

         int n = in.nextInt();
         if (n <= 1 || n % 2 == 1)
            continue;

         findPrimeRings(n);
      }
      in.close();
   }

   private static void findPrimeRings(final int n) {
      int[] elements = new int[n];
      for (int i = 0; i < n; i++)
         elements[i] = i + 1;

      permunation(elements, 1);
   }

   private static void permunation(int[] a, int iStart) {
      final int N = a.length;
      int i, j, t;
      while (true) {
         // process the permunation generated
         if (isPrimeRing(a))
            outRingElements(a);

         for (i = N - 1; i > iStart && a[i - 1] >= a[i]; i--)
            /* NONE */;

         if (i-- == iStart)
            break;

         for (j = N - 1; a[i] >= a[j]; j--)
            /* NONE */;

         t = a[i];
         a[i] = a[j];
         a[j] = t;

         for (i++, j = N - 1; i < j; i++, j--) {
            t = a[i];
            a[i] = a[j];
            a[j] = t;
         }
      }
   }

   private static void outRingElements(int[] ring) {
      final int N = ring.length;
      for (int i = 0; i < N; i++)
      if (DEBUG == 1) {  
      System.out.printf("%d%s", ring[i], i != N - 1 ? " " : "\n");
   }

}

   private static boolean isPrimeRing(int[] a) {
      final int N = a.length;
      if (!isPrime[a[N - 1] + a[0]])
         return false;
      for (int i = 1; i < N; i++)
         if (!isPrime[a[i - 1] + a[i]])
            return false;
      return true;
   }

   private static void initPrimeChecker() {
      for (int i = 0; i < PRIMES.length; i++)
         isPrime[PRIMES[i]] = true;
   }

   private static final int[] PRIMES = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37 };

   private static final int MAX_N = 20;
   private static final boolean[] isPrime = new boolean[2 * MAX_N];
}
