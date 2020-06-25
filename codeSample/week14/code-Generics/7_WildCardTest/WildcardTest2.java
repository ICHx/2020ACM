// Ch21, JHTP9, Fig. 21.14: WildcardTest.java
// Wildcard test program.
import java.util.ArrayList;

public class WildcardTest2 {
   public static void main (String[] args) {
      // create, initialize and output ArrayList of Integers, then 
      // display total of the elements 
      Integer[] integers = { 1, 2, 3, 4, 5 };
      ArrayList<Integer> integerList = new ArrayList<Integer>();

      // insert elements in integerList
      for (Integer e : integers )
         integerList.add( e );

      System.out.printf( "integerList contains: %s\n", integerList );
      System.out.printf( "Total of the elements in integerList: %.0f\n\n",
         sum( integerList ) 
      );

      // create, initialize and output ArrayList of Doubles, then 
      // display total of the elements 
      Double[] doubles = { 1.1, 3.3, 5.5 };
      ArrayList<Double> doubleList = new ArrayList<Double>();

      // insert elements in doubleList
      for (Double e : doubles )
         doubleList.add( e );

      System.out.printf( "doubleList contains: %s\n", doubleList );
      System.out.printf( "Total of the elements in doubleList: %.1f\n\n", 
         sum( doubleList ) 
      );

      // create, initialize and output ArrayList of Numbers containing 
      // both Integers and Doubles, then display total of the elements 
      Number[] numbers = { 1, 2.4, 3, 4.1 }; // Integers and Doubles
      ArrayList<Number> numberList = new ArrayList<Number>();

      // insert elements in numberList
      for (Number e : numbers )
         numberList.add( e );

      System.out.printf( "numberList contains: %s\n", numberList );
      System.out.printf( "Total of the elements in numberList: %.1f\n", 
         sum( numberList ) 
      );
   }

   // calculate total of stack elements
   public static <T extends Number> double sum (ArrayList<T> list) {
      double total = 0; // initialize total

      // calculate sum
      for ( T e : list )
         total += e.doubleValue();

      return total;
   }
}
