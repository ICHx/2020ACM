package week9;
import static java.lang.Math.*;
public class lineTest {
    public static void main(String[] args) {
        Point a, b, c, d, ixt;
        a = new Point(1, 1);
        b = new Point(4, 4);
        c = new Point(1, 8);
        d = new Point(2, 4);
        
        
        
        Line l1, l2, l3;
        l1 = new Line(a, b);
        l2 = new Line(c, d);
        l3 = l1.rotate(30);
        ixt = l1.Intersect(l2);
        System.out.println(ixt.toString());
        System.out.println(l1.toString());
        System.out.println(l3.toString());
        
        
        double angle = atan(l3.slope) - atan(l1.slope);
        angle = abs(angle);
        System.out.println(angle);
        
    }
    
}
