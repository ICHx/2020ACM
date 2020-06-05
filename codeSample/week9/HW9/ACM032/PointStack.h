//
// Created by HHPP on 2020/5/2.
//

#ifndef ACM032_POINTSTACK_H
#define ACM032_POINTSTACK_H

#include "Point.h"

class PointStack {
private:
    Point* S;
    int length;
    int top;
public:
    PointStack(int l);//初始化需要空间
    void push(Point);
    void pop();
    int getTop();

};


#endif //ACM032_POINTSTACK_H
