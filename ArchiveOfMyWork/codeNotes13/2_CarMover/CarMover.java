import javax.swing.*;

/**
   A program that allows users to move a car with the mouse.
*/
public class CarMover {
   public static void main (String[] args) {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

      frame.add( new CarComponent() );
      frame.setTitle( "Car Mover" );
      frame.setSize( FRAME_WIDTH, FRAME_HEIGHT );
      frame.setVisible( true );
   }

   private static final int FRAME_WIDTH = 800;
   private static final int FRAME_HEIGHT = 800;
}
