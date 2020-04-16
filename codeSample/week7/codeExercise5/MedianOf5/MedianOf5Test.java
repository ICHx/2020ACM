public class MedianOf5Test {   
   public static void main (String[] args) {
      String[][] s = { 
         { "30", "0", "123", "-5", "88" },
         { "0", "123", "88", "30", "-5" },
         { "3", "8", "9", "1", "5" }
      };
      
      for (int i = 0; i < s.length; i++) {
         System.out.printf( "Median of %s = ", java.util.Arrays.toString( s[i]));
         MedianOf5.main( s[i] );
      }
   }
}
