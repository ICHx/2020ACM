//
// Created by HHPP on 2020/5/2.
//

#ifndef ACM032_VECTOR_H
#define ACM032_VECTOR_H

#include "Point.h"

class Vector {
private:
    double xMagnitude,yMagnitude;
public:
    Vector();
    Vector(Point,Point);
    double getXM();
    double getYM();
};


#endif //ACM032_VECTOR_H
