// Problem 3 of Exercise 05, Version B
import java.util.Scanner;

public class E5P3B {
   public static void main (String[] args) {
      Scanner sc = new Scanner( System.in );
      int M = sc.nextInt();                 // input sizes
      int N = sc.nextInt();

      char[][] map = new char[M][];      
      for (int i = 0; i < M; i++)           // input and set the map
         map[i] = sc.next().toCharArray();  // string.toCharArray() => char[]
 
      int[][] count = new int[M][N];        // default with 0s
      for (int i = 0; i < M; i++)
         for (int j = 0; j < N; j++)
            if (map[i][j] == BOMB)
               for (int di = -1; di <= 1; di++)  // update counters for neighbors
                  for (int dj = -1; dj <= 1; dj++)
                     if (! (di == 0 && dj == 0)  &&
                         (0 <= i+di && i+di < M) && 
                         (0 <= j+dj && j+dj < N) 
                     ) count[i+di][j+dj]++;

      for (int i = 0; i < M; i++) {
         for (int j = 0; j < N; j++)
            System.out.print( map[i][j] == BOMB ? FLAG : MARK[count[i][j]] );
         System.out.println();
      }

      sc.close();
   }

   final static char BOMB = '*';
   final static char FLAG = 'F';
   final static char[] MARK = { '-', '1', '2', '3', '4', '5', '6', '7', '8' };
}
