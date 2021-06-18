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

    int i = 0, j = 0;

    current_add_ptr = l1;

    current_sum_ptr = sumList;
    for (; current_add_ptr != NULL; i++) {
        current_sum_ptr->next = create();
        //移動到下一節點
        current_sum_ptr = current_sum_ptr->next;

        current_sum_ptr->val += current_add_ptr->val;

        current_add_ptr = current_add_ptr->next;
    }

    current_add_ptr = l2;
    current_sum_ptr = sumList;
    short carry=0;
    for (; current_add_ptr != NULL; j++) {
        current_sum_ptr = current_sum_ptr->next;

        current_sum_ptr->val += current_add_ptr->val+ carry;
        // carry=0;

        carry = current_sum_ptr->val /10;
        current_sum_ptr->val%=10;

        current_add_ptr = current_add_ptr->next;
    }


}

int main(int argc, char const* argv[]) {
    bool string_negative = 0;
    char string1[] = "13579";

    node_p test1 = create(), test1ptr = test1;
    test1ptr->val = 1;
    test1->next = create();
    test1ptr = test1ptr->next;
    test1ptr->val = 2;
    //this is "21"

    node_p test2 = create(), test2ptr = test2;
    test2ptr->val = 9;
    test2->next = create();
    test2ptr = test2ptr->next;
    test2ptr->val = 4;
    //this is "43

    addTwoNumbers(test1, test2);

    // 49+21 = 70

    puts("hello\n");
    return 0;
}
