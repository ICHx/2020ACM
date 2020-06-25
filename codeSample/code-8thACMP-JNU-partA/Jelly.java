import java.util.Scanner;

// Max int, Integer.MAX_VALUE = 2^31 - 1 = 2147483647  ~  2.1e9

public class Jelly {
   public static void main (String[] args) {
      Scanner sc = new Scanner( System.in );
      int a = sc.nextInt(), b = sc.nextInt();    // a, b <= 1e9
      System.out.println( (a+b)%2 == 1 ? "YES" : "NO" );
      sc.close();
   }
}

