// A More Efficient Testing Framework
public class TestMedianOf5Ints2 {
  public static void main (String[] args) {
    for (int i = 1; i <= 5; i++) {
      for (int j = 1; j <= 5; j++) {
        if (j == i) continue;
        for (int k = 1; k <= 5; k++) {
          if (k==j || k==i) continue;
          for (int m = 1; m <= 5; m++) {
            if (m==k || m==j || m==i) continue;
            for (int n = 1; n <= 5; n++) { 
              if (n==m || n==k || n==j || n==i) continue;
              // i,j,k,m,n is a permutation of 1..5 
              int a=i, b=j, c=k, d=m, e=n;  
              // ...
              // code to find out median-of-5
              
              // ...
              if (c != 3) System.out.printf(  // another if style
                "[%d %d %d %d %d] ==> [%d %d %d %d %d]\n",
                   i, j, k, m, n,       a, b, c, d, e
              ); // end of printf and if
            } // end of for n
          } // end of for m
        } // end of for k
      } // end of for j
    } // end of for i
  } // end of main()
} // end of class
