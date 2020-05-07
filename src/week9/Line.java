package week9;

public class Line {
Point a;
Point b;
double m;
double c;
// y = mx + c

Line(Point a, Point b) {
    this.a = a;
    this.b = b;
    getSlope();
}

private void getSlope() {
    double dx, dy;
    dy = a.y - b.y;
    dx = a.x - b.x;
    
    this.m = dy / dx;
    
    this.c = a.y - this.m * a.x;
}

public boolean intersectWith(Line other) {
    // not considering line segment
    if (this.m == other.m) {
        return this.c == other.c;
        //collinear case
    }
    return true;
    
}




}
