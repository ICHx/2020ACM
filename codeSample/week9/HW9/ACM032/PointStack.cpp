//
// Created by HHPP on 2020/5/2.
//

#include "PointStack.h"
#include "Point.h"
PointStack::PointStack(int l) {
    this->length=l;
    top=-1;
    this->S=new Point[l];
}

void PointStack::push(Point A ) {
    S[++top].set(A.getX(),A.getY());
}
int PointStack::getTop() {
    return top;
}
void PointStack::pop() {
    top--;
}