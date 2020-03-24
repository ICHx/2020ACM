// HDU1017: A Mathematical Curiosity
import java.util.Scanner;
public class HDU1017B {
   public static void main (String[] args) {
      Scanner in = new Scanner( System.in );
      int nGroup = in.nextInt();
      int caseCount = 0;
      for (int g = 0; g < nGroup; g++) {
         while (true) {
            int m = in.nextInt(), n = in.nextInt();
            if (m == 0) break;

            System.out.printf( "Case %d: %d\n", 
               ++caseCount, countProperPairs( m, n )
            );
         }
      }
      in.close();
   }

   private static int countProperPairs(int n, int m) {
      int count = 0;
      for (int a = 1; a < n-1; a++)
         for (int b = a+1; b < n; b++) 
            if ((a * a + b * b + m) % (a * b) == 0) ++count;
      return count;
   }
 }
