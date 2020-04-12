package week5.q4;

// A More Efficient Testing Framework
// algorithm wrt  http://mathcs.wilkes.edu/~bracken/cs328/fa2014/median5.pdf
public class TestMedianOf5IntsFast {
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

              while (true) {
                int temp;
                // form 2 pairs
                {temp = a + b;
                a = Math.min(a, b);
                b = temp - a;

                temp = c + d;
                c = Math.min(c, d);
                d = temp - c;
                }
                // compare a and c pair, swap pair if neccessary
                // for that (a<b)|(c<d)
                // !3
                if (a > c) {
                  temp = a;
                  a = c;
                  c = temp;

                  temp = b;
                  b = d;
                  d = temp;
                }

                //? compare c,e
                // !4
                if (e < c) {
                  // !5
                  //* compare e,b
                  temp = b+c;
                  b = Math.min(c,b);
                  c = temp - b;
                  break;
                  
                } else {
                  // * e > c, now compare e with d and b
                  // !5
                  if (d < e) {
                    // * compare e with b;
                    //!6
                    if(b>d){
                        //* compare b and d
                        //!7
                        c = Math.min(b,e);
                      }else{
                        //* d>b, b or c
                        //!7
                        c = Math.min(b,c);
                    }
                    break;
                  } else {
                    //* d > e
                    //!6
                    if(b>e){
                      //* ????
                      //!7
                      c = e;
                    }else{
                      //* b<e
                      //!7
                      c = Math.min(b,c);
                  }
                    break;
                  }
                }
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
