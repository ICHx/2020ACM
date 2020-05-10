package week9;

public class Vec {
    private double _x, _y;
    
    Vec(Point a, Point b) {
        _x = b.x - a.x;
        _y = b.y - a.y;
    }
    
    Vec(double Va, double Vb) {
        _x = Va;
        _y = Vb;
    }
    
    public Vec scaleWith(double s) {
        return new Vec(this._x * s, this._y * s);
    }
    
    Vec A = this;
    public Point translate(Point pt) {
        // translate p according to this v
        return new Point(pt.x + A._x, pt.y + A._y);
    }
    
    public double dotProdWith(Vec B){
        return (A._x*B._x + A._y * B._y);
    }
    
    public double norm_sq(){
        return A._x*A._x + A._y * A._y ;
    }
    

}