import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
   A component that shows a scene composed of items.
*/
public class CarComponent extends JComponent {
   private static final long serialVersionUID = 1L;

   public CarComponent() {
      car = new CarShape( 20, 20, 90 );
      addMouseListener(
         new MouseAdapter() {
            public void mousePressed (MouseEvent event) {
               mousePoint = event.getPoint();
               if (!car.contains(mousePoint))
                  mousePoint = null;
            }
         }
      );

      addMouseMotionListener(
         new MouseMotionAdapter() {
            public void mouseDragged (MouseEvent event) {
               if (mousePoint == null) return;
               Point lastMousePoint = mousePoint;
               mousePoint = event.getPoint();

               double dx = mousePoint.getX() - lastMousePoint.getX();
               double dy = mousePoint.getY() - lastMousePoint.getY();
               car.translate( (int)dx, (int)dy );
               repaint();
            }
         }
      );
   }

   public void paintComponent (Graphics g) {
      Graphics2D g2 = (Graphics2D) g;
      car.draw( g2 );
   }

   private CarShape car;
   private Point mousePoint;
}                               
