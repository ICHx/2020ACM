//
// Created by HHPP on 2020/5/1.
//

#include "Interval.h"
Interval::Interval() {
    dist=0;
    index=0;
}
Interval::Interval(double dist, int index) {
    this->dist=dist;
    this->index=index;
}
double Interval::getDist() {
    return dist;
}
int Interval::getIndex() {
    return index;
}
void Interval::set(double dist, int index) {
    this->dist=dist;
    this->index=index;
}