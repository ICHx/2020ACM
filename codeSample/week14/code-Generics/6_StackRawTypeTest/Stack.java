// CH21, JHTP9, Fig. 21.7: Stack.java
// Stack generic class declaration.
import java.util.ArrayList;

public class Stack<T> {
   private ArrayList<T> elements; // ArrayList stores stack elements

   public Stack () {
      this( 10 );     // default stack size
   }
   
   // constructor creates a stack of the specified number of elements
   public Stack (int capacity) {
      int initCapacity = capacity > 0 ? capacity : 10;  // validate
      elements = new ArrayList<T>( initCapacity );      // create ArrayList
   }

   // push element onto stack
   public void push (T pushValue) {
      elements.add( pushValue );
   }

   // return the top element if not empty; else throw EmptyStackException
   public T pop() {
      if (elements.isEmpty())
         throw new EmptyStackException( "Stack is empty, cannot pop" );

      // remove and return top element of Stack
      return elements.remove( elements.size() - 1 ); 
   }
}
