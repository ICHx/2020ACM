// Problem ACM001: acm001.c
// @ Max, March 2020

#include <stdio.h>

int minDigitChanges (int m, int d) {
   const int DAYS_PER_MONTH[12] = { 
      31, 28, 31,  30, 31, 30,  31, 31, 30,  31, 30, 31
   };

   int count = 0;
   if (m == 0 || 12 < m) {
      count = 1;
       
      // try a minimum correction on MM 
      // to get a maximum valid range for DD
      if (m == 0)  m = 1;   // 00
      if (m > 12) {  
         if (m/10 == 1 || m%10 == 0) m = 10;  // 1M|M0
         else if         (m%10 == 2) m = 12;  //    M2          
         else m = m % 10;   // M1|M3|M4|M5|M6|M7|M8|M9
      }
   }
   count += (d == 0 || DAYS_PER_MONTH[m-1] < d) ? 1 : 0;
       
   return count;
}

int main () {
   int month, day;
   while (scanf("%d", &month) != EOF) {
      scanf( "%d", &day );
      printf( "%d\n", minDigitChanges( month, day ) );
   }
   return 0;
}
 