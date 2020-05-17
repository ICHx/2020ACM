package week9;

import static java.lang.Math.PI;
import static java.lang.Math.abs;

public class Polygon {
    static final double EPS = 1e-9;
    int vertNum, edgesNum;
    Point[] points;
    Line[] edges;
    
    Polygon(Point[] array) {
        this.points = array;
        this.vertNum = array.length;
        this.edgesNum = vertNum;
        
        edges();
    }
    
    
    public boolean isPtInPolygon(Point q) {
        double totalAngle = 0;
        boolean inside = false;
        
        Vec pl1, pl2;
        double angle;
        for (int i = 0; i < points.length - 1; i++) {
            pl1 = new Vec(q, points[i]);
            pl2 = new Vec(q, points[i + 1]);
            angle = Vec.angle(q, pl1, pl2);
            totalAngle += abs(angle);
        }
        pl1 = new Vec(q, points[points.length - 1]);
        pl2 = new Vec(q, points[0]);
        angle = Vec.angle(q, pl1, pl2);
        totalAngle += abs(angle);
        inside = abs(abs(totalAngle) - 2 * PI) < EPS;
        return inside;
    }
    

    
    private void edges() {
        edges = new Line[edgesNum];
        
        for (int i = 1; i < edgesNum; i++) {
            edges[i] = new Line(points[i - 1], points[i]);
        }
        edges[edgesNum - 1] = new Line(points[vertNum - 1], points[0]);
    }

    
}
