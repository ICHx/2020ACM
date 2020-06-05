//
// Created by HHPP on 2020/4/29.
//

#ifndef ACM031_RECTANGULAR_H
#define ACM031_RECTANGULAR_H

#include "Point.h"

class Rectangular {
private:
    Point rec[4];
public:
    Rectangular();
    void setPoint(int, double, double);//This member function sets one point of the rectangular
    double area();
};


#endif //ACM031_RECTANGULAR_H
