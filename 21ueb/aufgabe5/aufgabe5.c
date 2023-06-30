#include <stdio.h>

int i = 1;

void modify(void) {
   printf("[modify] i: %d\n", i);
   i = 3;
   printf("[modify] i: %d\n", i);
}

int main(void) {
   int i = 2;

   printf("[main] i: %d\n", i);
   modify();
   printf("[main] i: %d\n", i);

   return 0;
}
