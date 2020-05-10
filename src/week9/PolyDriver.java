package week9;
import java.util.Scanner;

/* P1. Let P be a simple (not necessarily convex) polygon enclosed in a 
given rectangle R, and q be an arbitrary point inside R. 

Design an efficient algorithm to find a line segment connecting q to any point 
outside R such that the number of edge of P that this line intersects is minimum. 
 */

 //let R is a square, from 0,0 to 9,9
 

public class PolyDriver {

    private static final Scanner sc = new Scanner(System.in);

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

        if (!sc.next().equals("==="))
            System.exit(-1);

        // get Point q
        System.out.println("Enter Q");
        Point q = new Point(sc.nextDouble(), sc.nextDouble());

        Polygon P = new Polygon(points);
        
        Point Pt = findMinIntersects(P, q);
        
        //finish
        System.out.println(Pt);
    }
    
    
    public static Point findMinIntersects(Polygon P, Point q) {
        boolean inside = P.ptInPolygon(q); //class polygon
        //TODO inside polygon
        
        Point outsideR = new Point(1000,1000); // a point outside R
        Point origin = new Point(0,0);
        Line outSide = new Line(outsideR, origin);
        double angle = 0;
        
        
        if(inside){
            for (int i = 0; i < 360; i++) {
                //rotate line
                outSide = outSide.rotate(angle + i);
                
            }
            
            
        }
        else{
            //find range of vertices angle , any angle outside the range is fine
        }
        
        return null;
    }
}
