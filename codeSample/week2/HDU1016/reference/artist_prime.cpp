#include <stdio.h>
#include <string.h>

const int maxn=17;
int vis[maxn+2];//用于dfs内部的递归判断 
int circle[maxn+2];//储存每个圈圈 
int prime[maxn*2+2];//=1:合数；=0：质数 
int getpri(){
	prime[0]=1;prime[1]=1;prime[2]=1;//其实这三个不是质数也不是合数 
	for(int i=3;i<maxn*2+2;i++){
		for(int j=2;j*j<=i;j++){
			if(i%j==0){
				prime[i]=1;
				break;
			}
		}
	}
	return 0;
}
//重点思想：递归 
void dfs(int n,int step,int last){//n:一共的圈圈个数/step：当前在第几个圈圈/last：上一个圈圈的值 
	if(step==n){//当现在处于最后一个圈圈的时候 （能到达这里说明前面的都满足） 
		if(!prime[last+1]){//如果最后一个圈圈+1是prime，则打印 
			int i;
			for(i=1;i<n;i++){
				printf("%d ",circle[i]);
			}
			printf("%d\n",circle[i]);
		}
		return;
	}
	for(int i=2;i<=n;i++){
		if(vis[i])continue;//如果此串项链已经使用过这个值的圈圈 
		if(!prime[i+last]){ //满足条件 
			vis[i]=1;//设置为访问过 
			circle[step+1]=i;
			dfs(n,step+1,i);//进入下一个递归 
			vis[i]=0;//回溯 
		}
	}
	return;
}
int main(){
	int n;
	//freopen("in.txt","r",stdin);
	getpri();//得到prime数组 
	int cnt=1;//当前case数 
	while(~scanf("%d",&n)){
		printf("Case %d:\n",cnt++);
		if(n==1){//n==1特判 
			printf("1\n");continue;
		}
		if(n==2){//n==2特判 
			printf("1 2\n");continue;
		}
		memset(vis,0,sizeof(vis));//每次都清空一下vis 
		circle[1]=1;//第一个圆圈是1 
		dfs(n,1,1);//进入dfs算法。 
		printf("\n");
	}
}