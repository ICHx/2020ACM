//
// Created by HHPP on 2020/4/29.
//

#include "Point.h"
#include <iostream>
using namespace std;
Point::Point() {
    this->x=0;
    this->y=0;
}
Point::Point(double x, double y) {
    //default the point is the original point
    //The constructor function assign the position to point
    this->x=x;
    this->y=y;
}
void Point::display() {
    cout<<"The position of this point is ("<<x<<","<<y<<")"<<endl;
}
void Point::setX(double newX) {
    this->x=newX;
}
void Point::setY(double newY) {
    this->y=newY;
}
void Point::set(double newX, double newY) {
    this->x=newX;
    this->y=newY;
}
double Point::getX() {
    return x;
}
double Point::getY() {
    return y;
}