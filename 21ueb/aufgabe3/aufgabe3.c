#include <stdio.h>

int main() {
    int number;

    printf("Geben sie ein wert ein\n");
    scanf("%d", &number);

    if ( number < 0 ) {
        printf("Die Zahl soll positiv sein\n");
        return 1;
    }

    int a = 0;
    int b = 1;
    int c = 0;

    for ( int i = 0; i < number; i++ ) {
        printf("%d\n", a);
        c = a + b;
        a = b;
        b = c;
    }

    return 0;
}
