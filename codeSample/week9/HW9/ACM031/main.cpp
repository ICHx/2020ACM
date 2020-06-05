#include <iostream>
#include "Point.h"
#include "Rectangular.h"
#include "Line.h"
#include "Polygon.h"
using namespace std;
int main() {
    double rectangular[4][2];
   cout<<"Please inputs four points of the rectangular"<<endl;
   for(int i=0;i<4;i++){
       cin>>rectangular[i][0]>>rectangular[i][1];
   }
   Rectangular A;
   for(int i=0;i<4;i++){
       A.setPoint(i,rectangular[i][0],rectangular[i][1]);
   }
   //cout<<"The area of rectangular is "<<A.area()<<endl;
   //now let user to insert the number of points of the polygon

   cout<<"Please input the number of points of the polygon"<<endl;
   int numPoint;
   cin>>numPoint;
   double** p=new double*[numPoint];
   for(int i=0;i<numPoint;i++){
       p[i]=new double[2];
   }
   cout<<"Please input the coordinate of polygon in counter clockwise order"<<endl;
   for(int i=0;i<numPoint;i++){
       cin>>p[i][0]>>p[i][1];
   }
   Polygon plg(numPoint,p);

   cout<<"Please input a random point inside the rectangular"<<endl;
   Point random;
   double randomX,randomY;
   cin>>randomX>>randomY;
   random.set(randomX,randomY);

   //首先在大范围内判断点在polygon的外部
   //在最左边点的左侧
   if(random.getX()<plg.leftMostX()){
       cout<<"The found point outside the rectangular is ("<<rectangular[0][0]-1<<","<<random.getY()<<")"<<endl;
   }
   //在最右边点的右侧
   else if(random.getX()>plg.rightMostX()){
       cout<<"The found point outside the rectangular is ("<<rectangular[1][0]+1<<","<<random.getY()<<")"<<endl;
   }
   //在最高点的上侧
   else if(random.getY()>plg.largestY()){
       cout<<"The found point outside the rectangular is ("<<random.getX()<<","<<rectangular[2][1]+1<<")"<<endl;
   }
   //在最低点的下侧
   else if(random.getY()<plg.lowestY()){
       //向下做垂直
       cout<<"The found point outside the rectangular is ("<<random.getX()<<","<<rectangular[0][1]-1<<")"<<endl;
   }
   //接着判断在小范围内是不是在polygon的外侧
   else if(plg.Outside(random)){
       if(random.getY()<plg.leftMostY()||random.getY()<plg.rightMostY()){
           cout<<"The found point outside the rectangular is ("<<random.getX()<<","<<rectangular[0][1]-1<<")"<<endl;
       }
       else{
           cout<<"The found point outside the rectangular is ("<<random.getX()<<","<<rectangular[2][1]+1<<")"<<endl;
       }
   }
   //最后的情况就是在polygon的内侧
   else{
       Point largest(plg.largestX(),plg.largestY());
       Line l(random,largest);
       cout<<"The found point outside the rectangular is ("<<l.fromYtoX(rectangular[2][1])<<","<<rectangular[2][1]+1<<")"<<endl;
   }
    return 0;
}