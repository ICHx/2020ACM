#include <stdio.h>

int minDigitChanges(int m, int d);
void checkFeb(int*, int);
void checkBigMonth(int*, int);
void checkSmlMonth(int*, int);

int main() {
  int month, day;
  while (scanf("%d", &month) != EOF) {
    scanf("%d", &day);
    printf("%d\n", minDigitChanges(month, day));
  }
  return 0;
}

int minDigitChanges(int month, int day) {
  int accum1 = 0;
  switch (month) {
    case 2:
      checkFeb(&accum1, day);
      break;

    case 1:  //大月
    case 3:
    case 5:
    case 7:
    case 8:
    case 10:
    case 12:
      checkBigMonth(&accum1, day);
      break;

    case 4:   //小月
    case 6:   //小月
    case 9:   //小月
    case 11:  //小月
      checkSmlMonth(&accum1, day);
      break;

    default:
      accum1++;
      checkBigMonth(&accum1, day);  // assume the best
  }
  return accum1;
}

void checkFeb(int* accum1, int day) {
  int tens = day / 10;
  int unit = day % 10;

  switch (tens) {
    case 2:  // asume no leap year
      if (unit > 8) ++*accum1;
    case 1:
      return;

    case 0:
      if (unit != 0) return;
    default:
      ++*accum1;
  }
}
void checkBigMonth(int* accum1, int day) {
  int tens = day / 10;
  int unit = day % 10;

  switch (tens) {
    case 1:
    case 2:
      return;
    case 3:
      if (unit > 1) {
        ++*accum1;
        return;
      }

      break;

    case 0:
      if (unit != 0) return;
    default:
      ++*accum1;
  }
}
void checkSmlMonth(int* accum1, int day) {
  int tens = day / 10;
  int unit = day % 10;

  switch (tens) {
    case 1:
    case 2:
      return;
    case 3:
      if (unit > 0) {
        ++*accum1;
        return;
      }

      break;

    case 0:
      if (unit != 0) return;
    default:
      ++*accum1;
  }
}