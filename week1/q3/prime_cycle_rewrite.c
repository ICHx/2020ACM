#include <stdbool.h>
#include <stdio.h>
#include <string.h>

#define N 20
#define DEBUG 0

// static const char prime_array[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37};
//prime: 2..37, comp: 0..20+19 = 39
static char prime_cache[40] = {0};
static int circle_num_of_elem;

typedef int *circle_t;

void PrintCircle(circle_t cir1);

bool isPrime(int n_test);

//void InitializeDFS();

void DFS(int j, circle_t cir1, bool visited[], int last);

void closure(int step_j, circle_t cir1, const bool *visited, int last);

void PrintCircle(circle_t cir1) {
//     traverse through cir1.num_of_elem
#if DEBUG
    setbuf(stdout, 0);
#endif
    int i, temp1, temp2;
    printf("%d ", 1);
    ++cir1;

    for (i = 1; i < (circle_num_of_elem - 1); i += 2) {  // 0..N-2
        temp1 = *(cir1++);
        temp2 = *(cir1++);
        printf("%d %d ", temp1, temp2);
//        printf("%d ", *(cir1++));
    }
    printf("%d\n", *(cir1++)); //N-1
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

//void InitializeDFS() {
//    bool visited[N] = {0};  // 1 .. N
//    int cir1[N] = {0};
//    cir1[0] = 1;
//    visited[0] = 1;
//    DFS(1, cir1, visited, 0); //last is an index
//}

 __attribute__((hot))  void DFS(int step_j, circle_t cir1, bool visited[], int last) {
    int startPos = (step_j) % 2;

    int num_k, testPrime, next_step;
//    for (num_k = startPos; num_k <= EndPos; num_k += 2) {
    for (num_k = startPos; num_k < circle_num_of_elem; num_k += 2) {
        if (visited[num_k])continue;
        // k is index, (k+1) is actual number

//        testPrime = ((cir1[step_j - 1] + (num_k + 1)));
        testPrime = last + num_k + 2; //(both are index)
        if (isPrime(testPrime)) {
            // if this condition never called == no more number can be added
            visited[num_k] = true;
            cir1[step_j] = num_k + 1;

            //go deeper to find circle
            next_step = step_j + 1;
            if (next_step != (circle_num_of_elem - 1))
                DFS(next_step, cir1, visited, num_k);
            else closure(next_step, cir1, visited, num_k);
        }
        // end for adding edge

        // backtrack
        visited[num_k] = false;
    }  // end of k-loop

}

void closure(int step_j, circle_t cir1, const bool *visited, int last) {
    //close the thing
    // find what is left in visited[]
    int startPos = (step_j) % 2;
    for (; startPos < circle_num_of_elem; startPos += 2) {
        if (visited[startPos] == 0) break;
    }

    if ((!isPrime(startPos + 2))) { // startPos+1 and 1
        return;
    } else {
        if (isPrime(last + startPos + 2)) {  //check last one(both are index)
            cir1[step_j] = startPos + 1;
            PrintCircle(cir1);
        }
    }
}

int main(int argc, char const *argv[]) {
    int temp, count = 1;

    //def
    bool visited[N] = {0};  // 1 .. N
    int cir1[N] = {0};
    cir1[0] = 1;
    visited[0] = 1;
    //def

    while (scanf("%d", &temp) != EOF) {
        printf("Case %d:\n", count++);
        if (temp >= 20) {
            printf("too large\n");
            continue;
        }
        switch (temp) {
            case 0:
                puts("\n\n");
                continue;
                break;
            case 1:
                printf("1\n\n");
                continue;
                break;
            case 2:
                printf("1 2\n\n");
                continue;
                break;
            default:
                break;
        }
        if (temp % 2) {
            puts("\n");
            continue;
        }
        circle_num_of_elem = temp;

//        InitializeDFS();


        DFS(1, cir1, visited, 0); //last is an index
        puts("");//blank line after case
        //reset
        memset(visited, 0, N * sizeof(bool));
        memset(cir1, 0, N * sizeof(int));
        cir1[0] = 1;
        visited[0] = 1;
    }

    return 0;
}
