#include <stdio.h>

#define mehrwertsteuer 0.2
#define zwei_prozent 0.02

int main() {
    float nettopreis, bruttopreis, rechnungsbetrag, mwst, skonto;

    printf("Nettopreis (in Euro): ");
    scanf("%f", &nettopreis);

    if ( nettopreis <= 0 ) {
        printf("Die Zahl soll positiv sein");
        return 1;
    }

    mwst = nettopreis * mehrwertsteuer;
    bruttopreis = nettopreis + mwst;
    skonto = bruttopreis * zwei_prozent;
    rechnungsbetrag = bruttopreis - skonto;

    printf("Nettopreis\t\t\tEuro %.2f\n", nettopreis);
    printf("+ 20%% MwSt\t\t\tEuro %.2f\n", mwst);
    printf("=============================================\n");
    printf("Bruttopreis\t\t\tEuro %.2f\n", bruttopreis);
    printf("- 2%% Skonto\t\t\tEuro %.2f\n", skonto);
    printf("=============================================\n");
    printf("Rechnungsbetrag\t\t\tEuro %.2f\n", rechnungsbetrag);

    return 0;
}

