#include <stdio.h>
#include <limits.h>

int main() {

    char char_max = 0;
    char char_min = 0;
    while (char_max <= 0) {
        char_max--;
    }
    while (char_min >= 0) {
        char_min++;
    }
    printf("char: Min = %d, Max = %d\n", char_min, char_max);
    printf("limit char: Min = %d, Max = %d\n\n", CHAR_MIN, CHAR_MAX);

    short short_max = 0;
    short short_min = 0;
    while (short_max <= 0) {
        short_max--;
    }
    while (short_min >= 0) {
        short_min++;
    }
    printf("short: Min = %d, Max = %d\n", short_min, short_max);
    printf("limit short: Min = %d, Max = %d\n\n", SHRT_MIN, SHRT_MAX);
    
    unsigned char uchar_max = 0;
    while (uchar_max <= 0) {
        uchar_max--;
    }
    printf("unsigned char: Min = 0, Max = %d\n", uchar_max);
    printf("limit unsigned char: Min = 0, Max = %u\n\n", UCHAR_MAX);
    

    unsigned short ushort_max = 0;
    while (ushort_max <= 0) {
        ushort_max--;
    }
    printf("unsigned short: Min = 0, Max = %d\n", ushort_max);
    printf("limit unsigned short: Min = 0, Max = %u\n\n", USHRT_MAX);

    unsigned int uint_max = 0;
    while (uint_max <= 0) {
        uint_max--;
    }
    printf("unsigned int: Min = 0, Max = %u\n", uint_max);
    printf("limit unsigned int: Min = 0, Max = %u\n\n", UINT_MAX);

    //int int_max = 0;
    //int int_min = 0;
    //while (int_max <= 0) {
    //    int_max--;
    //}
    //while (int_min >= 0) {
    //    int_min++;
    //}
    //printf("int: Min = %u, Max = %d\n", int_min, int_max);

    printf("limit int: Min = %d, Max = %d\n", INT_MIN, INT_MAX);

    return 0;
}
