//
// Created by HHPP on 2020/5/2.
//

#ifndef ACM032_POINT_H
#define ACM032_POINT_H


class Point {
    friend class Vector;
    friend class PointStack;
private:
    double x,y;
    int depth;
    int index;
public:
    Point();
    Point(double, double);
    void set(double, double);
    void setDepth(int);
    void setIndex(int);
    int getIndex();
    int getDepth();
    double getX();
    double getY();
};


#endif //ACM032_POINT_H
