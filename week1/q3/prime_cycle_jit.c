#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

#define N 20

#if !defined(__cplusplus)
#define inline __inline
#endif

// static const char prime_array[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37};
//prime: 2..37, comp: 0..20+19 = 39
static char prime_cache[40] = {0};
static int circle_num_of_elem;

struct Circle {
    int array[N];
};
typedef struct Circle circle_t;

struct Stack {
    int top;
    int capacity;
    int array[12];
};
typedef struct Stack stack_t;

static inline stack_t newStack() {
    stack_t s;
    s.top = -1;
    s.capacity = 13;
    // hardcoded cap
    return s;
}

void push(stack_t *s, int elem) {
    if (s->top < s->capacity) {
        //not full
        int temp = ++s->top;
        // s->top += 1;
        s->array[temp] = elem;
    } else {
        puts("stack overflow");
        exit(1);
    }
}

int pop(stack_t *s) {
    if (!(s->top == -1)) {
        int temp;
        temp = s->array[s->top];
        s->array[s->top] = 0;
        s->top -= 1;
        return temp;
    } else {
        puts("stack underflow");
        exit(2);
    }
}

static inline bool isEmpty(stack_t s) { return (s.top == -1); }

void PrintCircle(circle_t cir1);
bool isPrime(int n_test);
void InitializeDFS();
void DFS(int j, circle_t cir1, bool visited[]);

void PrintCircle(circle_t cir1) {
    // traverse through cir1.num_of_elem
#if DEBUG
    setbuf(stdout, 0);
#endif
    int i;
    printf("%d ", 1);

    int *array_ptr;
    array_ptr = &cir1.array[1];

    for (i = 1; i < (circle_num_of_elem - 1); i += 2) {  // 0..N-1
        printf("%d ", *array_ptr++);
        printf("%d ", *array_ptr++);
    }
    printf("%d\n", *array_ptr);
}

bool isPrime(int num) {
    if (prime_cache[num] == 2) return 0;
    if (prime_cache[num] == 1) return 1;

    int root = num >> 1;
    int i = 2;
#pragma GCC unroll 2
    for (; i <= root; i++) {
        if (num % i == 0) {
            prime_cache[num] = 2;  //mark compound
            return false;
        }
    }
    prime_cache[num] = 1;  //load on use
    return true;
}

void InitializeDFS() {
    if (!(circle_num_of_elem % 2)) {
        bool visited[N] = {0};  // 1 .. N
        circle_t cir1;

        cir1.array[0] = 1;
        visited[0] = 1;
        DFS(1, cir1, visited);
        // free(cir1);
    }        // bipartite graph
    return;  // not possible for odd number of elements
}

void DFS(int step_j, circle_t cir1, bool visited[]) {
    int num_n = circle_num_of_elem;
    // int *array = cir1.array;
    int startPos = (step_j) % 2;
    // determine traversal origin

    if (step_j != (num_n - 1)) {
        // get all possible moves
        stack_t s = newStack();
        startPos = num_n - 2 + startPos;
        while (startPos > 0) {
            if (!visited[startPos])
                push(&s, startPos);
            startPos -= 2;
        }

        startPos = pop(&s);

        int num_k, test;
        for (num_k = startPos; num_k <= (num_n - 1);) {
            // number to select and add to the ring except the last one: n-1
            // success enough times will break the for
            // j is pos in circle, (k+1) is actual number

            test = ((cir1.array[step_j - 1] + (num_k + 1)));
            if (isPrime(test)) {
                // if this condition never called == no more number can be added
                visited[num_k] = true;
                cir1.array[step_j] = num_k + 1;

                DFS(step_j + 1, cir1, visited);  //go deeper to find circle
            }                                    // end of Prime test for adding edge

            // reset and try other possibilities in stack
            visited[num_k] = false;
            if (isEmpty(s)) break;
            num_k = pop(&s);

        }  // end of k-loop
        return;
    } else {
        //find first number left
        while (visited[startPos] && ((startPos + 2) < num_n)) {
            // if the j-th number visited and j <=n, traverse
            startPos += 2;
        }

        // if ((!isPrime(1 + startPos + 1)) || visited[startPos]) {
        if ((!isPrime(startPos + 2)) || visited[startPos]) {
            // #if DEBUG
            //             PrintCircle(&cir1);
            //             puts("ring is not closed\n");
            // #endif

            return;
        } else {
            if (isPrime(cir1.array[step_j - 1] + (startPos + 1))) {  //check last one
                cir1.array[step_j] = startPos + 1;
                PrintCircle(cir1);
            }
        }
        return;
    }
}

int main(int argc, char const *argv[]) {
    int temp, count = 1;

    while (scanf("%d", &temp) != EOF) {
        printf("Case %d:\n", count++);
        if (temp == 1) {
            printf("1\n");
            continue;
        }
        if (temp == 2) {
            printf("1 2\n");
            continue;
        }
        if (temp >= 20) {
            printf("too large\n");
            continue;
        }
        circle_num_of_elem = temp;
        InitializeDFS();

        puts("");
    }

    return 0;
}
