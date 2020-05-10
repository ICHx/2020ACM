package week5.q4;

// A More Efficient Testing Framework
public class TestMedianOf5Ints2 {
  public static void main(String[] args) {
    for (int i = 1; i <= 5; i++) {
      for (int j = 1; j <= 5; j++) {
        if (j == i)
          continue;
        for (int k = 1; k <= 5; k++) {
          if (k == j || k == i)
            continue;
          for (int m = 1; m <= 5; m++) {
            if (m == k || m == j || m == i)
              continue;
            for (int n = 1; n <= 5; n++) {
              if (n == m || n == k || n == j || n == i)
                continue;
              // i,j,k,m,n is a permutation of 1..5
              int a = i, b = j, c = k, d = m, e = n;
              // ...
              // code to find out median-of-5

              int[] list = { a, b, c, d, e };
              int step=0;
              // selection sort(ish) alg with early pause
              out: for (int key = 0; key < list.length; key++) {
                int countSmaller = 0; // # smaller than key.
                int countBigger = 0; // # bigger than key.
                for (int test = 0; test < list.length; test++) {
                  if(test==key)continue;
                  
                  if (list[key] > list[test]) {
                    countSmaller++;
                  } else {
                    countBigger++;
                  }
                  step++;
                  if(countSmaller>2||countBigger>2){
                    continue out;
                  }
                }
                    if(countSmaller==2){
                      c=list[key];
                      break out;
                }
              }

              System.out.println("steps:" + step);
              // ...
              if (c != 3) {
                System.out.printf( // another if style
                    "[%d %d %d %d %d] ==> [%d %d %d %d %d]\n", i, j, k, m, n, a, b, c, d, e);
              }
              // end of printf and if
            } // end of for n
          } // end of for m
        } // end of for k
      } // end of for j
    } // end of for i
  } // end of main()
} // end of class
