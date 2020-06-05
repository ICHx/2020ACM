//
// Created by HHPP on 2020/4/29.
//

#include "Rectangular.h"
#include "Point.h"
#include <iostream>
Rectangular::Rectangular() {
    for(int i=0;i<4;i++){
        rec[i].set(0,0);
    }
}
void Rectangular::setPoint(int i, double newX, double newY) {
    rec[i].set(newX,newY);
}
double Rectangular::area() {
    double width=rec[1].getX()-rec[0].getX();
    double height=rec[3].getY()-rec[0].getY();
    return width*height;
}