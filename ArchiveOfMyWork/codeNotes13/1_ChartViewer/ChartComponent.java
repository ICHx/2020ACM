import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/*
   A component that draws a bar chart.
*/
public class ChartComponent extends JComponent {
   private static final long serialVersionUID = 1L;

   public void paintComponent(Graphics g) {
      g.setColor(Color.CYAN);
      g.fillRect(0, 10, 200, 10);
      g.fillRect(0, 30, 300, 20);
      g.fillRect(0, 50, 100, 20);
   }
}
