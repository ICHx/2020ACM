// HDU1017: A Mathematical Curiosity
import java.util.Scanner;
public class HDU1017 {
   public static void main (String[] args) {
      Scanner in = new Scanner( System.in );
      boolean isFirstGroup = true;
      int nGroup = in.nextInt();
      for (int g = 0; g < nGroup; g++) {
         if (isFirstGroup) 
            isFirstGroup = false;
         else
            System.out.println(); 
         int caseCount = 0;
         while (true) {
            int n = in.nextInt(), m = in.nextInt();
            if (n == 0 && m == 0 ) break;

            System.out.printf( "Case %d: %d\n", 
               ++caseCount, countProperPairs( n, m )
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
