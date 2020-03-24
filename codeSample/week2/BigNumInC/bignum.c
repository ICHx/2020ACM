// bignum.c
#include <stdio.h>
#include "bignum.h"

void print_bignum (bignum *n) {
   int i;    /* counter */
   if (n->signbit == MINUS) printf( "- " );
   for (i = n->lastdigit; i >= 0; i--)
      printf( "%c", '0' + n->digits[i] );
   printf ("\n" );
}

void initialize_bignum (bignum *n) {
   int i;    /* counter */
   for (i = 0; i < MAXDIGITS; i++)
      n->digits[i] = 0;
   
   n->signbit = PLUS;
   n->lastdigit = 0;   
};

void set_bignum (bignum *n, char* s) {
   int i = 0, k, length;
   initialize_bignum( n );
   if (s[0] == '-') {       // skip beginning - sign
      n->signbit = MINUS;
      i = 1;
   } else if (s[0] == '+')  // skip beginning + sign
      i = 1;

   while (s[i]=='0') i++;   // skip beginning 0s
   
   for (k = i, length = 0; s[k] != '\0'; k++, length++) /* NONE */ ;

   n->lastdigit = length - 1;
   for (k = length-1; k >= 0; k--, i++)
      n->digits[k] = s[i] - '0';
};

void zero_justify (bignum *n) {
   while ((n->lastdigit > 0) && (n->digits[ n->lastdigit ] == 0))
      n->lastdigit --;

   if ((n->lastdigit == 0) && (n->digits[0] == 0))
      n->signbit = PLUS;   /* hack to avoid -0 */
}

int compare_bignum (bignum *a, bignum *b) {
   int i;    /* counter */
   if ((a->signbit==MINUS) && (b->signbit==PLUS)) return PLUS;
   if ((a->signbit==PLUS) && (b->signbit==MINUS)) return MINUS;
   if (b->lastdigit > a->lastdigit) return (PLUS * a->signbit);
   if (a->lastdigit > b->lastdigit) return (MINUS * a->signbit);
   for (i = a->lastdigit; i >= 0; i--) {
      if (a->digits[i] > b->digits[i])
         return (MINUS * a->signbit);
      if (b->digits[i] > a->digits[i])
         return (PLUS * a->signbit);
   }
   return 0;
}

int max (int a, int b) {
   return (a > b) ? a : b;
}

void add_bignum (bignum *a, bignum *b, bignum *c) {
   int carry;    /* carry digit */
   int i;        /* counter */
   initialize_bignum( c );
   if (a->signbit == b->signbit) c->signbit = a->signbit;
   else {
      if (a->signbit == MINUS) {
         a->signbit = PLUS;
         subtract_bignum(b,a,c);
         a->signbit = MINUS;
      } else {
         b->signbit = PLUS;
         subtract_bignum(a,b,c);
         b->signbit = MINUS;
      }
      return;
   }

   c->lastdigit = max(a->lastdigit, b->lastdigit) + 1;
   carry = 0;
   for (i = 0; i <= (c->lastdigit); i++) {
      c->digits[i] = (char)(carry + a->digits[i] + b->digits[i]) % 10;
      carry = (carry + a->digits[i] + b->digits[i]) / 10;
   }

   zero_justify( c );
}

void subtract_bignum (bignum *a, bignum *b, bignum *c) {
   int borrow;     /* anything borrowed? */
   int v;          /* placeholder digit */
   int i;          /* counter */
   if ((a->signbit == MINUS) || (b->signbit == MINUS)) {
      b->signbit = -1 * b->signbit;
      add_bignum( a, b, c );
      b->signbit = -1 * b->signbit;
      return;
   }

   if (compare_bignum(a,b) == PLUS) {
      subtract_bignum( b, a, c );
      c->signbit = MINUS;
      return;
   }

   c->lastdigit = max( a->lastdigit, b->lastdigit );
   borrow = 0;
   for (i = 0; i <= (c->lastdigit); i++) {
      v = (a->digits[i] - borrow - b->digits[i]);
      if (a->digits[i] > 0)
         borrow = 0;
      if (v < 0) {
         v = v + 10;
         borrow = 1;
      }
      c->digits[i] = (char) v % 10;
   }

   zero_justify(c);
}
