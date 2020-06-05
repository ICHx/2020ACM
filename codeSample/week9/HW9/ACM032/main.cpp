#include <iostream>
#include <cmath>
#include "Point.h"
#include "Vector.h"
#include "PointStack.h"
using namespace std;
bool CCW(Point X1,Point X2,Point X3){
    double crossProduct;
    Vector a(X1,X2);
    Vector b(X2,X3);
    crossProduct=a.getXM()*b.getYM()-a.getYM()*b.getXM();
    if(crossProduct>0.000001){
        return true;
    }
    else{
        return false;
    }
}
int findPivot(Point* P,int num){
    //first set the fist point as the pivot
    int index=0;
    double lowestY=P[0].getY();
    for(int i=1;i<num;i++){
        if(fabs(P[i].getY()-lowestY)<0.000001){
            if(P[i].getX()-P[index].getX()>-0.000001){
                index=i;
            }
        }
        if((P[i].getY()-lowestY)<0.000001){
            index=i;
            lowestY=P[i].getY();
        }
    }
    return index;
}
bool angleCom(Point a,Point b,Point pivot){
    double aXD=a.getX()-pivot.getX();
    double aYD=a.getY()-pivot.getY();
    double bXD=b.getX()-pivot.getX();
    double bYD=b.getY()-pivot.getY();
    if(fabs(atan2(aYD,aXD)-atan2(bYD,bXD))<0.000001){
        return aXD<bXD;
    }
    else{
        return atan2(aYD,aXD)<atan2(bYD,bXD);
    }
}
void sort(Point* P,int num){
    double tempX,tempY;
    for(int i=0;i<num-1;i++){
        for(int j=1;j<num-i-1;j++){
            if(!angleCom(P[j],P[j+1],P[0])){
                tempX=P[j].getX();
                tempY=P[j].getY();
                P[j].set(P[j+1].getX(),P[j+1].getY());
                P[j+1].set(tempX,tempY);
            }
        }
    }
}
int computeDepth(Point* SP,Point* temp,int DNum, int depth){
    int last;
    PointStack S(DNum);
    S.push(temp[DNum-1]); SP[temp[DNum-1].getIndex()].setDepth(depth);
    S.push(temp[0]); SP[temp[0].getIndex()].setDepth(1);
    S.push(temp[1]); SP[temp[1].getIndex()].setDepth(depth);
    for(int i=2;i<DNum;i++){
        if(CCW(temp[i-2],temp[i-1],temp[i])){
            S.push(temp[i]);
            SP[temp[i].getIndex()].setDepth(depth);
            last=i;
        }
        else{
            S.pop(); SP[temp[last].getIndex()].setDepth(0);
        }
    }
    return S.getTop();
}
int main() {
    //初始化平面中的点
    int num;
    double newX,newY;
    cout<<"Please input the number of points in the plane"<<endl;
    cin>>num;
    Point* P=new Point[num];
    cout<<"Please input the coordinates of the points in order"<<endl;
    for(int i=0;i<num;i++){
        cin>>newX>>newY;
        P[i].set(newX,newY);
    }

    //将pivot 首先置于第一位
    int pivot=findPivot(P,num);
    double tempX=P[0].getX(); double tempY=P[0].getY();
    P[0].set(P[pivot].getX(),P[pivot].getY());
    P[pivot].set(tempX,tempY);


    //根据与pivot的夹角来将P排序
    sort(P,num);
    for(int i=0;i<num;i++){
        P[i].setIndex(i);
    }

    for(int i=0;i<num;i++){
        cout<<P[i].getX()<<"  "<<endl;
    }
    int DNum=num;
    int depth=1;
    int flag=1;
    Point* temp=new Point[DNum];
    temp[0].set(P[0].getX(),P[0].getY());
    temp[0].setDepth(P[0].getDepth());
    temp[0].setIndex(P[0].getIndex());
    while (DNum>3){

        flag=1;
        for(int i=1;i<num;i++){
            if(P[i].getDepth()==0){
                temp[flag].set(P[i].getX(),P[i].getY());
                temp[flag].setIndex(P[i].getIndex());
                flag++;
            }
        }
        int used=computeDepth(P,temp,DNum,depth);
        //delete []temp;
        if(depth==1){
            DNum=DNum-(used+1);
        }
        else{
            DNum=DNum-(used);
        }
        depth++;
    }
    for(int i=0;i<num;i++){
        if(P[i].getDepth()==0){
            P[i].setDepth(depth);
        }
    }
    cout<<"The depth in the ordered points which is ordered by angle w.r.t the pivot is :"<<endl;
    for(int i=0;i<num;i++){
       cout<<P[i].getDepth()<<"  ";
    }
    return 0;
}