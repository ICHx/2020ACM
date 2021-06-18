package week5.q4;

// A More Efficient Testing Framework
public class TestMedianOf5IntsFaster {
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
              // selection sort(ish) alg with early pause
              {
                int temp = a+e;
                a = Math.min(a,e);
                e = temp - a;
                
                temp = c+e;
                c = Math.min(c,e);
                e = temp - c;
                
                temp = c+a;
                a = Math.min(c,a);
                c = temp - a;
                
                // ! now a<c<e
                
                // * now compare b,c,d
                temp = b+c;
                b = Math.min(c,b);
                c = temp - b;
                
                temp = b+d;
                b = Math.min(b,d);
                d = temp - b;
                
                temp = c+d;
                c = Math.min(c,d);
                d = temp - c;
                
                // ! did not work when 3 is in corner
                temp = a+e;
                a = Math.min(a,e);
                e = temp - a;
                
                temp = c+e;
                c = Math.min(c,e);
                e = temp - c;
                
                temp = c+a;
                a = Math.min(c,a);
                c = temp - a;
                
              }
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
