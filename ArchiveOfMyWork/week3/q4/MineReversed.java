import java.util.Scanner;

public class MineReversed {
    final static boolean DEBUG = true;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of rows in the matrix:");
        int N = sc.nextInt();
        if (N > 100)
            illegal("Too large");
        short[][] matrix = new short[N][N];
        System.out.println("Enter the matrix row by row:");

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // scan N*N numbers
                matrix[i][j] = sc.nextShort();
            }
        }

        maximalSquare(matrix, N);

        sc.close();
    }

    private static void maximalSquare(short[][] m, int N) {
        int maxSize = 0;
        int cRow = 0; // the coordinate (col,row)
        int cCol = 0;

        int[][] dp = new int[N][N];

        // dynamically find largest square

        for (int i = 0; i < N; i++) {// row 0..N-1
            for (int j = 0; j < N; j++) {// col 0..N-2
                int current = m[i][j];
                if (current == 0)
                    continue; // only want 1, don't want 0
                else {
                    // fix for out-of-bound
                    if (j == 0 || i == 0) {
                        dp[i][j] = 1;
                        continue;
                    }
                }

                // the comparison section
                // essentially, going left, going up and then going diagonally up-left
                int temp;
                temp = Math.min(dp[i][j - 1], dp[i - 1][j]);
                temp = Math.min(temp, dp[i - 1][j - 1]);
                // or use double min() : smallest = Math.min(a, Math.min(b, c));
                temp += 1;

                dp[i][j] = temp;

                if (temp > maxSize) {
                    maxSize = temp;
                    cRow = i;
                    cCol = j;
                }

                // dp[i][j] = m[i][j];
            }
        }

        // output square coordinate and size
        System.out.printf("The maximum square submatrix is at (%d,%d) with size %d\n", cCol, cRow, maxSize);

        if (DEBUG)
            for (int i = 0; i < N; i++) {// row 0..N-1
                for (int j = 0; j < N; j++) {// col 0..N-2
                    System.out.print(dp[i][j] + " ");
                }
                System.out.println();
            }

        return;
    }

    private static void illegal(String s) {
        System.out.println("E:" + s);
        System.exit(1);
    }
}