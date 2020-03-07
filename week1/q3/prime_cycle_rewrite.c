#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

#define N 20

#if defined(WIN32) && !defined(__cplusplus)
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

void PrintCircle(circle_t cir1);
bool isPrime(int n_test);
void InitializeDFS();
void DFS(int j, circle_t cir1, bool visited[], int last);

void PrintCircle(circle_t cir1) {
    // traverse through cir1.num_of_elem
    setbuf(stdout, 0);
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
    bool visited[N] = {0};  // 1 .. N
    circle_t cir1;
    cir1.array[0] = 1;
    visited[0] = 1;
    DFS(1, cir1, visited, 0);
}

void DFS(int step_j, circle_t cir1, bool visited[], int last) {
    int startPos = (step_j) % 2;
    // determine traversal origin

    if (step_j != (circle_num_of_elem - 1)) {
        int EndPos = (circle_num_of_elem - 2) + startPos;


        int num_k, testPrime;
        for (num_k = startPos; num_k <=EndPos;num_k+=2) {
        // for (num_k = startPos; num_k > 0;num_k-=2) {
            if(visited[num_k])continue;
            // number to select and add to the ring except the last one: n-1
            // success enough times will break the for
            // j is pos in circle, (k+1) is actual number

            testPrime = ((cir1.array[step_j - 1] + (num_k + 1)));
            if (isPrime(testPrime)) {
                // if this condition never called == no more number can be added
                visited[num_k] = true;
                cir1.array[step_j] = num_k + 1;

                DFS(step_j + 1, cir1, visited, num_k);  //go deeper to find circle
            }
            // end for adding edge

            // backtrack
            visited[num_k] = false;
        }  // end of k-loop
        return;
    } else {
        // find what is left in visited[]
        for (; startPos < circle_num_of_elem; startPos += 2) {
            if (visited[startPos] == 0) break;
        }

        if ((!isPrime(startPos + 2))) {
            return;
        } else {
            if (isPrime(last + startPos + 2)) {  //check last one
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
        if (temp >= 20) {
            printf("too large\n");
            continue;
        }
        switch (temp) {
            case 0:
                continue;
                break;
            case 1:
                printf("1\n");
                continue;
                break;
            case 2:
                printf("1 2\n");
                continue;
                break;
            default:
                break;
        }
        if (temp % 2)
            continue;
        circle_num_of_elem = temp;
        InitializeDFS();

        puts("");
    }

    return 0;
}
