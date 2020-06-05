//
// Created by HHPP on 2020/5/1.
//

#include "Point.h"
Point::Point() {
    x=0;
    y=0;//The default of point is the original point
}
Point::Point(double x, double y) {
    this->x=x;
    this->y=y;
}
void Point::set(double newX, double newY) {
    this->x=newX;
    this->y=newY;
}
void Point::setX(double newX) {
    this->x=newX;
}
void Point::setY(double newY) {
    this->y=newY;
}
double Point::getX() {
    return x;
}
double Point::getY() {
    return y;
}