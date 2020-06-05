//
// Created by HHPP on 2020/4/29.
//

#ifndef ACM031_POINT_H
#define ACM031_POINT_H


class Point {
    friend class Rectangular;
    friend class Line;
    friend class Polygon;
private:
    double x,y;
public:
    Point();
    Point(double , double );
    void display();
    void setX(double newX);
    void setY(double newY);
    void set(double newX, double newY);
    double getX();
    double getY();
};


#endif //ACM031_POINT_H
