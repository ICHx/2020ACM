package week9;
import static java.lang.Math.*;

public class Polygon {
    static final double EPS = 1e-9;
    int vertNum, edgesNum;
    Point[] points;
    Line[] edges;
    
    Polygon(Point[] array) {
        this.points = array;
        this.vertNum = array.length;
        this.edgesNum = vertNum-1;
        
        edges();
    }
    
    
    public boolean ptInPolygon(Point q) {
        //TODO pointInPolygon
        double totalAngle= 0;
        int count = 0;
        boolean inside = false;
        
        Line pl1, pl2;
        double angle;
        for (int i = 0; i < points.length-1; i++) {
            pl1 = new Line(q, points[i]);
            pl2 = new Line(q, points[i+1]);
        angle = atan(pl1.slope) - atan(pl2.slope);
        angle = abs(angle);
        
        totalAngle +=angle;
        }
        
        pl1 = new Line(q, points[points.length-1]);
        pl2 = new Line(q, points[0]);
        angle = atan(pl1.slope) - atan(pl2.slope);
        angle = abs(angle);
        
        totalAngle +=angle;
        
        inside = abs(totalAngle -2*PI) < EPS;
        
        return inside;
    }
    
    private void edges() {
        edges = new Line[edgesNum];
        
        for (int i = 1; i < edgesNum; i++) {
            edges[i] = new Line(points[i-1], points[i]);
        }
        edges[edgesNum-1] = new Line(points[vertNum-1], points[0]);
    }
    
    public Line[] getEdges(){
        return edges;
    }
    
    
}
