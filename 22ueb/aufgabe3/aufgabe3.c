#include <stdio.h>
#include <stdbool.h>
#include "checkutils.c"

void printPattern(int rows, int cols) {
    for (int i = 1; i <= rows; i++) {
        for (int j = 1; j <= cols; j++) {
            if (i == j || i + j == rows + 1) {
                printf("*");
            } else {
                printf("-");
            }
        }
        printf("\n");
    }
}

int run() {
    int rows;
    int cols;
    
    printf("Geben Sie die Anzahl der Zeilen ein: ");
    if (scanf("%d", &rows) != 1 || !isAValidInteger(rows)) {
        printf("Ungültige Eingabe für die Anzahl der Zeilen.\n");
        return 1;
    }
    
    printf("Geben Sie die Anzahl der Spalten ein: ");
    if (scanf("%d", &cols) != 1 || !isAValidInteger(cols)) {
        printf("Ungültige Eingabe für die Anzahl der Zeilen.\n");
        return 1;
    }
    
    printPattern(rows, cols);
    
    return 0;
}
int main() {
    run();
}
