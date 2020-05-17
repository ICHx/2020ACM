package week9;

import static java.lang.Math.abs;

public class Line {
    static final double EPS = 1e-9;
    Point p1;
    Point p2;
    double slope;
    double angler;
    
    double a;
    double b;
    double c;
    

    Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
        getSlope();

        pointsToLine();
    }
    
@Override
    public String toString(){
        return String.format("\n Line: %.2g x + %.2g y + %.2g = 0\n", a,b,c);
    }
    
    private void pointsToLine() {
        if (abs(p1.x - p2.x) < EPS) {
            this.a = 1;
            this.b = 0;
            this.c = -p1.x;
            
            if(abs(this.c) < EPS) this.c = 0;
            
            return;
        }
        this.a = -this.slope;
        if(abs(this.a) < EPS) this.a = 0;
        this.b = 1;
        this.c = this.slope * p1.x - p1.y;
        if(abs(this.c) < EPS) this.c = 0;
    }

    private void getSlope() {
        double dx, dy;
        dy = p1.y - p2.y;
        dx = p1.x - p2.x;

        this.slope = dy / dx;
        
        this.angler = Math.atan(this.slope);
    }

    public boolean areParallel(Line L2) {
        System.out.println("Parallel");
        return abs(this.slope - L2.slope) < EPS;
    }

    public boolean areSame(Line L2) {
        return areParallel(L2) && (abs(this.c - L2.c) < EPS);
    }

    public Point Intersect(Line L2) {
        if (areParallel(L2))
            return null;
        double det;
        // c is positive in book, negative in geek4geek
        det = this.a * L2.b - L2.a * this.b;

        double px, py;
        px = -(this.c * L2.b) + (this.b * L2.c);
        px /= det;

        py = -(this.a * L2.c) + (this.c * L2.a);
        py /= det;

        Point p = new Point(px, py);
        return p;

    }
    
    public Line rotate(double degree){
        // rotate line
        Line newLine;
        Point p1p = p1.rotate(degree);
        Point p2p = p2.rotate(degree);
        newLine = new Line(p1p, p2p);
        
        return newLine;
    }

    public Point midPt() {
        Point midPt = new Point();
        midPt.x = (p1.x + p2.x) / 2;
        midPt.y = (p1.y + p2.y) / 2;
        return midPt;
    }

}
