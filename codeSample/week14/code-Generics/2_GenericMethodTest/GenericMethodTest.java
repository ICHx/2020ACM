// Ch21, JHTP9, Fig. 21.3: GenericMethodTest.java
// Printing array elements using generic method printArray.

public class GenericMethodTest {
   public static void main (String[] args) {
      // create arrays of Integer, Double and Character
      Integer[] integerArray = { 1, 2, 3, 4, 5, 6 };
      Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7 };
      Character[] characterArray = { 'H', 'E', 'L', 'L', 'O' };

      System.out.println( "Array integerArray contains:" );
      printArray( integerArray );   // pass an Integer array 
      System.out.println( "\nArray doubleArray contains:" );
      printArray( doubleArray );    // pass a Double array
      System.out.println( "\nArray characterArray contains:" );
      printArray( characterArray ); // pass a Character array
   }

   // generic method printArray
   public static < T > void printArray (T[] array) {
      for ( T e : array )
         System.out.printf( "%s ", e );
      System.out.println();
   }
}
