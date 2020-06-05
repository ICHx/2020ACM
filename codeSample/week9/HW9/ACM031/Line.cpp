//
// Created by HHPP on 2020/4/30.
//

#include "Line.h"
#include "Point.h"
#include <iostream>
#include <cmath>

Line::Line() {
    b=1;
    a=c=0;
}
Line::Line(Point X1,Point X2) {
    //用两个点来初始化一条直线
    //首先判断是不是一条垂直线
    A.x=X1.x;
    A.y=X1.y;
    B.x=X2.x;
    B.y=X2.y;//记录两个确定点
    if(fabs(X1.x-X2.x)<0.0000001){
        a=-1;
        b=0;
        c=X1.x;
    }
    //如果不是垂直线，则y=ax+c,按照这种方式来计算
    else{
        b=1;
        a=(X1.y-X2.y)/(X1.x-X2.x);
        c=(X1.x*X2.y-X1.y*X2.x)/(X1.x-X2.x);
    }
}
double Line::fromXtoY(double x) {
    double y=a*x+c;
    return y;
}
double Line::fromYtoX(double y) {
    double x=(y-c)/a;
    return x;
}