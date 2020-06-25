import java.util.Scanner;

// (a * b) % n = (a%n * b%n) % n

public class POF {
   public static void main (String[] args) {
      final int DIVISOR = 1000000007; 

      Scanner sc = new Scanner( System.in );
      int T = sc.nextInt();  // 1 <= T <= 1000
      int[] m = new int[ T+1 ];
      m[1] = 1;  m[2] = 2;  m[3] = 3;
      for (int i = 4; i <= T; i++)
         m[i] = (int)((long)m[i-3] * m[i-2] % DIVISOR * m[i-1] % DIVISOR);

      for (int i = 0; i < T; i++)
         System.out.println( m[sc.nextInt()] );

      sc.close();
   }
}

