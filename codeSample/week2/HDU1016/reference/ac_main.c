#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int size = 0;
struct Stack {
    int num;
    struct Stack* next;
};
struct Stack* top = NULL;

void push(int num) {
    struct Stack* newNode = (struct Stack*)malloc(sizeof(struct Stack));

    newNode->num = num;
    newNode->next = top;
    top = newNode;
    size++;
}

void pop() {
    struct Stack* temp = top->next;
    free(top);
    top = temp;
    size--;
}

bool contains (int num) {
    struct Stack* head = top;
    while (head != NULL) {
        if(head->num == num)
            return true;
        head = head->next;
    }

    return false;
}

bool isPrime (int num) {
    if(num == 1)
        return false;
    int root = num/2;
    int i = 2;
    for(;i <= root; i++){
        if(num%i == 0)
            return false;
    }

    return true;
}

bool checkHeadTail () {
    struct Stack* bottom = top;
    while(bottom->next != NULL)
        bottom = bottom->next;

    return isPrime(bottom->num + top->num);
}

void display () {
    struct Stack* head = top;
    while(head != NULL) {
        if(head->next == NULL)
            printf("%d\n", head->num);
        else
            printf("%d ", head->num);

        head = head->next;
    }
}

void solve (int num) {
    if(size >= num) {
        if(!checkHeadTail())
            return;
        display();
        return;
    }

    int i = 1;
    for(; i <= num; i++) {
        if(contains(i))
            continue;
        else {
            if(isPrime(i + top->num)) {
                push(i);
                solve(num);
                pop();
            }
        }
    }
}

void release () {
    while (top != NULL)
        pop();
}

int main() {
//    printf("Hello, World!\n");
	int n,cnt=1;
    push(1);
		while(~scanf("%d",&n)){
		printf("Case %d:\n",cnt++);
		if(n==1){//n==1特判 
			printf("1\n");continue;
		}
		if(n==2){//n==2特判 
			printf("1 2\n");continue;
		}
		solve(n); 
		printf("\n");
	}

    release();
    return 0;
}
