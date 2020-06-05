import java.awt.*;
import javax.swing.*;

/**
   Scene Editor v3
   A program that allows users to edit a scene composed of items.
*/
public class SceneEditor {
   public static void main (String[] args) {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

      final SceneComponent scene = new SceneComponent();

      JButton houseButton = new JButton( "House" );
      houseButton.addActionListener(
         event -> scene.add( new HouseShape( 20, 20, 90 ) )
      );

      JButton carButton = new JButton( "Car" );
      carButton.addActionListener(
         event -> scene.add( new CarShape( 20, 20, 90 ) )
      );

      JButton removeButton = new JButton( "Remove" );
      removeButton.addActionListener( 
         event -> scene.removeSelected()
      );

      JPanel buttons = new JPanel();
      buttons.add( houseButton );
      buttons.add( carButton );
      buttons.add( removeButton );

      frame.add( scene, BorderLayout.CENTER );
      frame.add( buttons, BorderLayout.NORTH );

      frame.setSize( 800, 800 );
      frame.setTitle( "Scane Editor v3" );
      frame.setVisible( true );
   }
}
