#include <stdio.h>

int main() {
    float nettopreis, bruttopreis, rechnungsbetrag, mwst, skonto;

    printf("Nettopreis (in Euro): ");
    scanf("%f", &nettopreis);
    mwst = nettopreis * 0.2;
    bruttopreis = nettopreis + mwst;
    skonto = bruttopreis * 0.02;
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

