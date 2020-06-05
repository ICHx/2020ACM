//
// Created by HHPP on 2020/5/1.
//

#ifndef ACM033_INTERVAL_H
#define ACM033_INTERVAL_H


class Interval {
private:
    double dist;
    int index;
public:
    Interval();
    Interval(double,int);
    double getDist();
    int getIndex();
    void set(double,int);

};


#endif //ACM033_INTERVAL_H
