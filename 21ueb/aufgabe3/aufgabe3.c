#include <stdio.h>
#include <limits.h>

int validateInput() {
    int number;

    printf("Geben Sie einen Wert ein: ");
    scanf("%d", &number);

    if (number <= 0) {
        printf("Die Zahl soll größer als 0 sein!\n");
        return -1;
    }

    return number;
}

void printFibonacci(int number) {
    int prev = 1;
    int current = 1;
    int next;

    printf("Fibonacci-Zahlen:\n");

    for (int i = 0; i < number; i++) {
        printf("%d\n", current);

        // Check for potential overflow before performing addition
        if (current > INT_MAX - prev) {
            printf("Integer overflow detected!\n");
            break;
        }

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

