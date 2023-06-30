#include <stdio.h>

int validateInput() {
    int number;

    printf("Geben Sie einen Wert ein: ");
    scanf("%d", &number);

    if (number < 0) {
        printf("Die Zahl sollte positiv sein.\n");
        return -1;
    }

    return number;
}

void printFibonacci(int number) {
    int prev = 0;
    int current = 1;
    int next;

    printf("Fibonacci-Zahlen:\n");

    for (int i = 0; i < number; i++) {
        printf("%d\n", prev);
        next = prev + current;
        prev = current;
        current = next;
    }
}

int main() {
    int number = validateInput();

    if (number == -1) {
        return 1;
    }

    printFibonacci(number);

    return 0;
}
