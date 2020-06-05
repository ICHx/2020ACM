//
// Created by HHPP on 2020/5/1.
//

#ifndef ACM033_POINT_H
#define ACM033_POINT_H


class Point {
private:
    double x,y;
public:
    Point();
    Point(double, double);
    void set(double, double);
    void setX(double);
    void setY(double);
    double getX();
    double getY();
};


#endif //ACM033_POINT_H
