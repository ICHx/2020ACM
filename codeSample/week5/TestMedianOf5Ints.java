public class TestMedianOf5Ints {
  public static void main (String[] args) {
    for (int i = 1; i <= 5; i++) {
      for (int j = 1; j <= 5; j++) {
        for (int k = 1; k <= 5; k++) {
          for (int m = 1; m <= 5; m++) {
            for (int n = 1; n <= 5; n++) { 
              if (i!=j && i!=k && i!=m && i!=n && 
                  j!=k && j!=m && j!=n &&
                  k!=m && k!=n && m!=n) {  // permutation of 1..5 
                int a=i, b=j, c=k, d=m, e=n;  
                // ...
                // code to find out median-of-5
                // ...
                if (c != 3) 
                  System.out.printf( 
                    "[%d %d %d %d %d] ==> [%d %d %d %d %d]\n",
                      i, j, k, m, n,       a, b, c, d, e
                  );
              } // end of if
            } // end of for n
          } // end of for m
        } // end of for k
      } // end of for j
    } // end of for i
  } // end of main()
} // end of class
