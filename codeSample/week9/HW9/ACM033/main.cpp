#include <iostream>
#include "Point.h"
#include "Interval.h"
#include <math.h>
using namespace std;
double distance(double x1, double y1, double x2, double y2){
    double distance;
    distance=sqrt(pow(x2-x1,2)+pow(y2-y1,2));
    return distance;
}
void sort(Interval* X,int left, int right,Interval* result){
    if(left==right){
        //return;
        result[left].set(X[left].getDist(),X[left].getIndex());
        return;
    }
    int middle=(left+right)/2;
    sort(X,left,middle,result);
    sort(X,middle+1,right,result);
    int flagL=left;
    int start=left;
    int flagR=middle+1;
    while(flagL<=middle&&flagR<=right){
        if(X[flagL].getDist()>=X[flagR].getDist()){
            result[start++].set(X[flagR].getDist(),X[flagR].getIndex());
            flagR++;
        }
        else{
            result[start++].set(X[flagL].getDist(),X[flagL].getIndex());
            flagL++;
        }
    }
    if(flagL>middle){
        for(int i=middle+1;i<=right;i++){
            result[start++].set(X[flagR].getDist(),X[flagR].getIndex());
            flagR++;
        }
    }
    else{
        for(int i=left;i<=middle;i++){
            result[start++].set(X[flagL].getDist(),X[flagL].getIndex());
            flagL++;
        }
    }
}
int main() {
    int num, index1,index2;
    double newX,newY,minimal,temp;
    cout<<"Please input the number of points in the plane"<<endl;
    cin>>num;
    Point pointSet[num];
    cout<<"Please input the coordinate of points in order"<<endl;
    for(int i=0;i<num;i++){
        cin>>newX>>newY;
        pointSet[i].set(newX,newY);
    }

    Interval* forX=new Interval[num-1];
    Interval* forY=new Interval[num-1];
    Interval* forXS=new Interval[num-1];
    Interval* forYS=new Interval[num-1];
    for(int i=0;i<num-1;i++){
        forX[i].set(pointSet[i+1].getX()-pointSet[i].getX(),i);
    }
    for(int i=0;i<num-1;i++){
        forY[i].set(pointSet[i+1].getY()-pointSet[i].getY(),i);
    }
    sort(forX,0,num-2,forXS);
    sort(forY,0,num-2,forYS);
    for(int i=0;i<num-1;i++){
        if(forXS[i].getIndex()==forYS->getIndex()){
            cout<<"The index of closest points is "<<i<<" and "<<i+1<<endl;
        }
    }

    /*minimal=distance(pointSet[0].getX(),pointSet[0].getY(),pointSet[1].getX(),pointSet[1].getY());
    index1=0;
    index2=1;
    for(int i=0;i<num-1;i++){
        for(int j=i+1;j<num;j++){
            temp=distance(pointSet[i].getX(),pointSet[i].getY(),pointSet[j].getX(),pointSet[j].getY());
            if(temp<minimal){
                minimal=temp;
                index1=i;index2=j;
            }
        }
    }
    cout<<"The index of closest points is "<<index1<<" and "<<index2<<endl;*/
    return 0;
}
