import java.awt.geom.*;

/**
   A car shape.
*/
public class CarShape extends CompoundShape {
   /**
      Constructs a car shape.
      @param x the left of the bounding rectangle
      @param y the top of the bounding rectangle
      @param width the width of the bounding rectangle
   */
   public CarShape (int x, int y, int width) {
      Rectangle2D body = new Rectangle2D.Double(
         x, y + width/6, width - 1, width / 6
      );
      Ellipse2D frontTire = new Ellipse2D.Double(
         x + width/6, y + width/3, width / 6, width / 6
      );
      Ellipse2D rearTire = new Ellipse2D.Double(
         x + width*2/3, y + width/3, width / 6, width / 6
      );

      // The bottom of the front windshield
      Point2D r1 = new Point2D.Double( x + width/6, y + width / 6 );
      // The front of the roof
      Point2D r2 = new Point2D.Double( x + width/3, y );
      // The rear of the roof
      Point2D r3 = new Point2D.Double( x + width*2/3, y );
      // The bottom of the rear windshield
      Point2D r4 = new Point2D.Double( x + width*5/6, y + width/6 );
      
      Line2D frontWindshield = new Line2D.Double( r1, r2 );
      Line2D roofTop = new Line2D.Double( r2, r3 );
      Line2D rearWindshield = new Line2D.Double( r3, r4 );

      add( body );
      add( frontTire );
      add( rearTire );
      add( frontWindshield );
      add( roofTop );
      add( rearWindshield );
   }
}
