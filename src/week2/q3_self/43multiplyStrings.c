#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
/* 
https://leetcode.com/problems/multiply-strings/

43. Multiply Strings
Medium
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"

Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"

Note:

    The length of both num1 and num2 is < 110.
    Both num1 and num2 contain only digits 0-9.
    Both num1 and num2 do not contain any leading zero, except the number 0 itself.
    You must not use any built-in BigInteger library or convert the inputs to integer directly.

 */
#define M 110
#define M2 12100
#define DEBUG 1

typedef struct {
    char digits[M];
    bool sign;       //negative ==true
    int lastDigits;  //個位位置
} bignum;

void initNum(bignum *num) {
    num->sign = 0;        //negative ==true
    num->lastDigits = 0;  //個位位置
}

bignum createNumFromStr(char *str) {
    //todo has problem
    int count = strlen(str);
    if (count > 110) {
        puts("e(1): too large");
        exit(1);
    };

    bignum cList;
    initNum(&cList);

    /* 反序瀏覽字串 eg: char[6]="10002", arr[count-1]=2, arr[count]=null */
    int i = 0;
    bool hasPrefix = 0;

    switch (str[0]) {
        case '-':
            cList.sign = 1;
        case '+':
            hasPrefix = 1;
            break;  //do nothing
        default:
            break;
    }  //如果有prefix符號，減少數字數目

    if (hasPrefix) {
        for (; i < count - 1; i++) {
            cList.digits[i] = str[i + 1] - '0';
            //最細digit index是【count-2】, digit 由ascii 變真數字
            cList.lastDigits = count - 2;
        }
    } else {
        for (; i < count; i++) {
            cList.digits[i] = str[i] - '0';
            //最細digit index是【count-1】, digit 由ascii 變真數字
            cList.lastDigits = count - 1;
        }
    }

    return cList;
}

void DispNum(bignum *n) {
    int i;
    //array 是由大到小先後存放的
    if (n->sign) printf("-");
    // for (i = n->lastDigits; i >= 0; i--) {
    for (i = 0; i <= n->lastDigits; i++) {
        printf("%d", n->digits[i]);
    }
}

char *DispNumArray(int array[], int lastIndex, bool sign) {
    int index = 0, i = 0;
    // string index, array traversal index
    static char dispStr[M2];
    if (sign) dispStr[index++] = '-';

    while (array[i] == 0 && i <= lastIndex) {
        i++;
    }
    if (i > lastIndex) return "0";
    //remove leading zero, or empty

    // if (array[i++] != 0) printf("%d", array[0]);

    for (; i <= lastIndex; i++) {
        dispStr[index++] = array[i] + '0';
    }

    dispStr[index] = '\0';
    if (DEBUG) puts(dispStr);
    return dispStr;
}

char *multiply(char *num1, char *num2) {
    // from last char of num1, multiply all num2 number
    bignum aList = createNumFromStr(num1);
    bignum bList = createNumFromStr(num2);

    bool sign = aList.sign ^ bList.sign;  //xor
    //add result together

    // int steps = (aList.lastDigits > bList.lastDigits) ?     aList.lastDigits + 1 : bList.lastDigits;

    int i = aList.lastDigits, j = bList.lastDigits;
    int tempArr[M2] = {0}, tempIndex = i + j + 1;
    // tempIndex是個位所在坐標
    for (; i >= 0; i--) {
        //storing multiply result for each iteration
        //todo: 方向錯了
        for (; j >= 0; j--) {
            // TODO: multiplying
            // 左邊希望是個位：0開始，右邊是個位開始:2
            // 現在左邊實際上個位是i+j來的，透過全體右移，可以保留進位
            tempArr[i + j + 1] += aList.digits[i] * bList.digits[j];
        }
        j = bList.lastDigits;  //reset
    }
    //case 1000 * 1000 ： i=3, j=3, result is (7digit )=i+j+1
    //case 7000 * 8000 ： i=3, j=3, result is (8digit )=i+j+2

    // tempIndex = (tempArr[tempIndex] > 10) ? (tempIndex + 2) : (tempIndex + 1);

    //do carry here
    int carry = 0;
    for (int k = tempIndex; k > 0; k--) {  //最大位前停止
        //TODO: shift the carry
        if ((carry = tempArr[k]) < 10) continue;
        tempArr[k] = carry % 10;
        carry /= 10;
        tempArr[k - 1] += carry;

        carry = 0;
    }
    char *displayStr;
    displayStr = DispNumArray(tempArr, tempIndex, sign);
    return displayStr;
}

int main(int argc, char const *argv[]) {
    bool string_negative = 0;
    char string1[] = "+13579";
    bignum number0 = createNumFromStr(string1);
    DispNum(&number0);
    puts("hello\n");

    char str1[M], str2[M];
    gets(str1);
    gets(str2);

    multiply(str1, str2);
    return 0;
}