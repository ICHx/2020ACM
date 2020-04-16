public class TestMedianOf5FullTest {
  public static void main (String[] args) {
    if (fullTest())
      System.out.println( "PASS" );
  }
  
  public static boolean fullTest () {
    boolean isPassed = true;
    for (int i = 1; i <= 5; i++) {
      for (int j = 1; j <= 5; j++) {
        for (int k = 1; k <= 5; k++) {
          for (int m = 1; m <= 5; m++) {
            for (int n = 1; n <= 5; n++) {
              if (isPermutation( i, j, k, m, n)) {
                int a=i, b=j, c=k, d=m, e=n;

                int median = MedianOf5.median(a, b, c, d, e);

                if (median != 3) {
                  System.out.printf(
                    "Error!  %d : [%d %d %d %d %d] ==> [%d %d %d %d %d]\n",
                            median, i, j, k, m, n,       a, b, c, d, e
                  );
                  isPassed = flase;
                }  
              }
    } } } } }
    return isPassed;           
  }

  public static boolean isPermutation (int a, int b, int c, int d, int e) {
    return a!=b && a!=c && a!=d && a!=e &&
                   b!=c && b!=d && b!=e &&
                           c!=d && c!=e &&
                                   d!=e ;
  }
}
