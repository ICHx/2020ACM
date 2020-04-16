// Thanks the student who provides the wonderful solving strategy!
public class MedianOf5 {   
   public static void main (String[] args) {
      int a = Integer.parseInt( args[0] );
      int b = Integer.parseInt( args[1] );
      int c = Integer.parseInt( args[2] );
      int d = Integer.parseInt( args[3] );
      int e = Integer.parseInt( args[4] );
      
      System.out.println( median(a, b, c, d, e) );
   }

   public static int median (int a, int b, int c, int d, int e) {
      int t;
      if (a > b) { t=a; a=b; b=t; }                  // a<b
      if (c > d) { t=c; c=d; d=t; }                  // a<b & c<d
      if (a > c) { t=a; a=c; c=t;  t=b; b=d; d=t; }  // a<b & a<c<d ==> not a
      if (b > e) { t=b; b=e; e=t; }                  // b<e & c<d
      if (b > c) { t=b; b=c; c=t;  t=e; e=d; d=t; }  // b<e & b<c<d ==> not b & not d
      return (e > c) ? c : e;                        // min(c,e) is the median
   }
}