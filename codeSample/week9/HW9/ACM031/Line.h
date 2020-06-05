//
// Created by HHPP on 2020/4/30.
//

#ifndef ACM031_LINE_H
#define ACM031_LINE_H

#include "Point.h"

class Line {
private:
    double a,b,c;//用三个值来确定的直线方程，一般b为1，垂直线时b为0
    Point A;
    Point B;//用两个点来确定一条直线，两个点默认是原点
public:
    Line();
    Line(Point,Point);
    double fromXtoY(double x);
    double fromYtoX(double y);
};


#endif //ACM031_LINE_H
