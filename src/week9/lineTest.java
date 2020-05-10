package week9;

public class lineTest {
    public static void main(String[] args) {
        Point a, b, c, d, ixt;
        a = new Point(1, 1);
        b = new Point(4, 4);
        c = new Point(1, 8);
        d = new Point(2, 4);
        
        Line l1, l2;
        l1 = new Line(a, b);
        l2 = new Line(c, d);
        
        ixt = l1.Intersect(l2);
        System.out.println(ixt.toString());
        
    }
    
}
