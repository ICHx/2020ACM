//
// Created by HHPP on 2020/4/30.
//

#ifndef ACM031_POLYGON_H
#define ACM031_POLYGON_H

#include "Point.h"

class Polygon {
private:
    int num;//how many vertex of this polygon
    Point* poly;//一个需要自动分配的点数组
public:
    Polygon(int,double **);

    double largestX();

    double largestY();//找到polygon最高点的Y值
    double lowestY();

    double leftMostX();

    double leftMostY();

    double rightMostY();

    double rightMostX();
    bool Outside(Point);
};


#endif //ACM031_POLYGON_H
