package week9;

public class Polygon {
    
    int vertNum, edgesNum;
    Point[] points;
    Line[] edges;
    
    Polygon(Point[] array) {
        this.points = array;
        this.vertNum = array.length;
        this.edgesNum = vertNum-1;
        
        edges();
    }
    
    
    public boolean pointInPolygon(Point q) {
        //TODO point in polygon
        int count = 0;
        boolean inside = false;
        
        
        return inside;
    }
    
    public boolean lineIntersect(Line l) {
        // TODO intersection
        return false;
    }
    
    public void edges() {
        edges = new Line[edgesNum];
        
        for (int i = 1; i < edgesNum; i++) {
            edges[i] = new Line(points[i-1], points[i]);
        }
        edges[edgesNum-1] = new Line(points[vertNum-1], points[0]);
    }
    
    
}
