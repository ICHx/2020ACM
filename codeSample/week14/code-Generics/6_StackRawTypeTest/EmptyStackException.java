// Ch21, JHTP9, Fig. 21.8: EmptyStackException.java
// EmptyStackException class declaration.
public class EmptyStackException extends RuntimeException {
	private static final long serialVersionUID = 1L;

   public EmptyStackException () {                // no-argument constructor
      this( "Stack is empty" );
   }
   
   public EmptyStackException (String message) {  // one-argument constructor
      super( message );
   }
}
