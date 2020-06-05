//
// Created by HHPP on 2020/5/2.
//

#include "Vector.h"
#include "Point.h"
Vector::Vector() {
    xMagnitude=0;
    yMagnitude=0;
}
Vector::Vector(Point A, Point B) {
    xMagnitude=B.getX()-A.getX();
    yMagnitude=B.getY()-A.getY();
}
double Vector::getXM() {
    return xMagnitude;
}
double Vector::getYM() {
    return yMagnitude;
}