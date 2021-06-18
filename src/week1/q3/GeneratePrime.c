// Count the number of prime numbers less than a non-negative number, n.
// Example:
// Input: 10
// Output: 4
// Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
#include <stdio.h>
int FindPrimes(int n);
int main(int argc, char const *argv[]) {
  FindPrimes(40);
  return 0;
}

int FindPrimes(int n) {
  int count = 0, div_flag = 0;
  if (n > 1) {
    puts("2");  // include 2 for n>=2
    count = 1;
  }
  for (int m = 3; m < n; m += 2) {  // test only odd no. ,excluded 2
    for (int i = 2; i < m / 2; i++) {
      if (m % i == 0) {  // divisible by a factor
        div_flag = 1;
        break;
      }
    }
    if (div_flag == 0) {  // no divisor,check after each loop
      printf("%d\n", m);
      count++;
    } else
      div_flag = 0;
  }

  printf("\ncount=%d", count);
  return count;
}