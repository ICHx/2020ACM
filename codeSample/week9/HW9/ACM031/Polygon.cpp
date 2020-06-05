//
// Created by HHPP on 2020/4/30.
//

#include "Polygon.h"
#include "Point.h"
#include "Line.h"
Polygon::Polygon(int n, double ** p) {
    num=n;
    poly=new Point[n];
    for(int i=0;i<n;i++){
        poly[i].x=p[i][0];
        poly[i].y=p[i][1];
    }
}

double Polygon::largestX() {
    double largestX=poly[0].x;
    double largest=poly[0].y;
    for(int i=1;i<num;i++){
        if(poly[i].y>largest){
            largest=poly[i].y;
            largestX=poly[i].x;
        }
    }
    return largestX;
}

double Polygon::largestY() {

    double largest=poly[0].y;
    for(int i=1;i<num;i++){
        if(poly[i].y>largest){
            largest=poly[i].y;
        }
    }
    return largest;
}

double Polygon::lowestY() {
    double lowest=poly[0].y;
    for(int i=1;i<num;i++){
        if(poly[i].y<lowest){
            lowest=poly[i].y;
        }
    }
    return lowest;
}

double Polygon::leftMostX() {
    double result=poly[0].x;
    for(int i=1;i<num;i++){
        if(poly[i].x<result){
            result=poly[i].x;
        }
    }
    return result;
}

double Polygon::leftMostY() {
    double result=poly[0].x;
    double resultY=poly[0].y;
    for(int i=1;i<num;i++){
        if(poly[i].x<result){
            result=poly[i].x;
            resultY=poly[i].y;
        }
    }
    return resultY;
}

double Polygon::rightMostX() {
    double result=poly[0].x;
    for(int i=1;i<num;i++){
        if(poly[i].x>result){
            result=poly[i].x;
        }
    }
    return result;
}

double Polygon::rightMostY() {
    double result=poly[0].x;
    double resultY=poly[0].y;
    for(int i=1;i<num;i++){
        if(poly[i].x>result){
            result=poly[i].x;
            resultY=poly[i].y;
        }
    }
    return resultY;
}
bool Polygon::Outside(Point random) {
    int count=0;
    for(int i=0;i<num-1;i++){
        Line l(poly[i],poly[i+1]);
        double intersect=l.fromXtoY(random.getX());
        if(intersect>random.getY()){
            count++;
        }
    }
    Line final(poly[num-1],poly[0]);
    if(final.fromXtoY(random.getX())>random.getY()){
        count++;
    }
    if(count%2==0){
        return true;
    }
    else{
        return false;
    }
}
