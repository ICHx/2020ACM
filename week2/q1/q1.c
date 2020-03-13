#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
/* 
https://leetcode.com/problems/add-two-numbers/

2. Add Two Numbers
Medium
You are given two non-empty linked lists representing two non-negative integers. The val are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Example:
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

 */

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next; 
 * };
 */
struct ListNode {
    int val;
    struct ListNode* next;
};

// custom area begin

typedef struct ListNode* node_p;

node_p create() {
    node_p list = (node_p)malloc(sizeof(struct ListNode));
    list->next = NULL;
    //next is higher digit
    list->val = 0;
    return list;
}

struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2) {
    node_p sumList = create(), current_add_ptr, current_sum_ptr;
    //sumList has a head node, other lists doesn't

    int i = 0, j = 0;  //數字有多少個位， 雙位數=2
    bool first = 1;

    current_add_ptr = l1;
    current_sum_ptr = sumList;

    for (; current_add_ptr != NULL; i++) {
        current_sum_ptr->next = create();  //會多了一個位

        current_sum_ptr->val += current_add_ptr->val;

        //移動到下一節點
        current_sum_ptr = current_sum_ptr->next;
        current_add_ptr = current_add_ptr->next;
    }
    free(current_sum_ptr->next);
    current_sum_ptr->next = NULL;  //解決多了的位

    current_add_ptr = l2;
    current_sum_ptr = sumList;
    // TODO : 考慮一長一短
    short carry = 0;
    node_p previous_ptr;

    for (; current_add_ptr != NULL || (carry != 0); j++) {
        if (j >= i) {
            current_sum_ptr->next = create();
        }

        if (current_add_ptr != NULL) {
            current_sum_ptr->val += current_add_ptr->val + carry;
            current_add_ptr = current_add_ptr->next;

        } else {
            current_sum_ptr->val += carry;  //補囘最後一個進位
        }

        carry = current_sum_ptr->val / 10;
        current_sum_ptr->val %= 10;

        //移動到下一節點
        previous_ptr = current_sum_ptr;
        current_sum_ptr = current_sum_ptr->next;
    }

    // current_sum_ptr->val += +carry;  //補囘最後一個進位

    while (current_sum_ptr != NULL) {
        //出錯：會刪掉 2001 的 2
        if (current_sum_ptr->val == 0) {
            free(current_sum_ptr);
            previous_ptr->next = NULL;  //解決多了的位
            break;
        } else {
            previous_ptr = current_sum_ptr;
            current_sum_ptr = current_sum_ptr->next;
        }
    }

    return sumList;
}

int main(int argc, char const* argv[]) {
    bool string_negative = 0;
    char string1[] = "13579";

    node_p test1 = create(), test1ptr = test1;
    test1ptr->val = 9;
    test1ptr->next = create();
    test1ptr = test1ptr->next;
    test1ptr->val = 0;
    test1ptr->next = create();
    test1ptr = test1ptr->next;
    test1ptr->val = 0;
    test1ptr->next = create();
    test1ptr = test1ptr->next;
    test1ptr->val = 1;
    //this is "21"

    node_p test2 = create();
    node_p test2ptr = test2;
    test2ptr->val = 9;
    // test2ptr->next = create();
    // test2ptr = test2ptr->next;
    // test2ptr->val = 4;
    // test2ptr->next = create();
    // test2ptr = test2ptr->next;
    // test2ptr->val = 4;
    //this is "449

    addTwoNumbers(test1, test2);

    // 449+21 = 470

    puts("hello\n");
    return 0;
}
