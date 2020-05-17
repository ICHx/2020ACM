package week9;

import java.util.Scanner;

/* P1. Let P be a simple (not necessarily convex) polygon enclosed in a 
given rectangle R, and q be an arbitrary point inside R. 

Design an efficient algorithm to find a line segment connecting q to any point 
outside R such that the number of edge of P that this line intersects is minimum. 
 */


public class PolyDriver {
    
    private static final Scanner sc = new Scanner(System.in);
    
    static Polygon R;
    
    public static void main(String[] args) {
        
        // get a polygon.
        System.out.println("Enter Polygon sides#");
        int N = sc.nextInt();
        Point[] points = new Point[N];
        System.out.println("Enter Polygon corners coordinate");
        // get x y line by line
        for (int i = 0; i < N; i++) {
            points[i] = new Point(sc.nextDouble(), sc.nextDouble());
        }
        
        
        if (!sc.next().equals("===")) {
            System.exit(-1);
        }
        
        // get Point q
        System.out.println("Enter Q");
        Point q = new Point(sc.nextDouble(), sc.nextDouble());
        
        Polygon P = new Polygon(points);
        EncloseRectangle(P);
        
        Point Pt = findMinIntersects(P, q);
        
        //finish
        System.out.println(Pt);
    }
    
    public static void EncloseRectangle(Polygon P) {
        double x_min = Double.MAX_VALUE,
            x_max = Double.MIN_VALUE,
            y_min = Double.MAX_VALUE,
            y_max = Double.MIN_VALUE;
        Point pp;
        for (int i = 0; i < P.points.length; i++) {
            pp = P.points[i];
            
            if (pp.x > x_max) {
                x_max = pp.x;
            } else if (pp.x < x_min) {
                x_min = pp.x;
            }
            if (pp.y > y_max) {
                y_max = pp.y;
            } else if (pp.y < y_min) {
                y_min = pp.y;
            }
        }
    
        Point[] points = new Point[4];
        points[0] = new Point(x_min,y_min);
        points[1] = new Point(x_max,y_min);
        points[2] = new Point(x_max,y_max);
        points[3] = new Point(x_min,y_max);
        
        R = new Polygon(points);
    }
    
    public static Point findMinIntersects(Polygon P, Point q) {
        boolean inside = P.isPtInPolygon(q); //class polygon
//TODO
        
        Point outsideR = new Point(1000, 1000); // a point outside R
        Point origin = new Point(0, 0);
        Line outSide = new Line(outsideR, origin);
        
        
        double MAX = Double.MIN_VALUE;
        double MIN = Double.MAX_VALUE;
        Point maxPoint, minPoint;
        
        int interceptCnt = 0;
        if (inside) {
            double angle = 0;
            for (int i = 0; i < 360; i++) {
                //TODO : rotate line, cut through q <-> midpoints
                outSide = outSide.rotate(angle + i);
                
                
            }
            
            
        } else {
            //TODO : find range of vertices angle , any angle outside the range is fine
            
            double slope = 0;
            
            
            for (int i = 0; i < P.vertNum; i++) {
                Line l1 = new Line(q, P.points[i]);
                slope = l1.slope;
                
                if (slope > MAX) {
                    MAX = slope;
                    maxPoint = P.points[i];
                    continue;
                }
                
                if (slope < MIN) {
                    MIN = slope;
                    minPoint = P.points[i];
                    continue;
                }
                
                
            }
            
            
        }
        
        return null;
    }
}
