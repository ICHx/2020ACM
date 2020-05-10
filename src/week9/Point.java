package week9;
import static java.lang.Math.*;

public class Point implements Comparable<Point> {
    static final double EPS = 1e-9;
    double x;
    double y;
    Point p = this;
    
    Point(){}
    
    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public int compareTo(Point other) {
        // 1 is larger, -1 is smaller than
        double cmpX = this.x - other.x;
        if (Math.abs(cmpX) > EPS) {
            if (cmpX > EPS) {
                return 1;
            } else return -1;
        }
        
        // same x, then compare y
        double cmpY = this.y - other.y;
        if ((cmpY) > EPS) {
            return (1);
        } else return -1;
    }
    
    public Point rotate(double degree){
        //rotate counterclockwise(ly)
        Point p2p=null;
        double px,py;
        double rad = toRadians(degree);
        px = p.x * cos(rad) - p.y * sin(rad);
        py = p.x * sin(rad) + p.y * cos(rad);
        p2p = new Point(px,py);
        
        return p2p;
    }
    
    @Override
    public String toString() {
        return String.format("(%.2g, %.2g)", x, y);
    }
}
