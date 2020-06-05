//
// Created by HHPP on 2020/5/2.
//

#include "Point.h"
Point::Point() {
    this->x=0;
    this->y=0;
    this->depth=0;
}
Point::Point(double newX, double newY) {
    this->x=newX;
    this->y=newY;
    this->depth=0;
}
void Point::set(double newX, double newY) {
    this->x=newX;
    this->y=newY;
    this->depth=0;
}
void Point::setDepth(int d) {
    this->depth=d;
}
void Point::setIndex(int index) {
    this->index=index;
}
int Point::getIndex() {
    return index;
}
int Point::getDepth() {
    return depth;
}
double Point::getX() {
    return x;
}
double Point::getY() {
    return y;
}