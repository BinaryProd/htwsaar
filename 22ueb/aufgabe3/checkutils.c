#include <stdbool.h>
#include <limits.h>

bool isAValidInteger(int num) {
    if (num <= 0 || num > INT_MAX) {
        return false;
    }
    return true;
}
