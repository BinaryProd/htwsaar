#include <stdio.h>
#include "mechanics.h"
#include "linear_motion.h"

void printMenu() {
    printf("-------------------------\n");
    printf("Teste die Bibliotheken\n");
    printf("-------------------------\n");
    printf("1. Geschwindigkeit berechnen\n");
    printf("2. Beschleunigung berechnen\n");
    printf("3. Impuls berechnen\n");
    printf("4. Weg einer Linearen gleichfoermigen Bewegung berechnen\n");
    printf("5. Weg einer Linearen beschleunigten Bewegung berechnen\n");
    printf("6. Geschwindigkeit einer linearen beschleunigten Bewegung berechnen\n");
    printf("0. Exit\n");
    printf("-------------------------\n");
}

void calculateVelocity(double displacement, double time) {
    Geschwindigkeit velocity = geschwindigkeitBerechnen(displacement, time);
    printf("Geschwindigkeit: %lf\n", velocity);
}

void calculateAcceleration(double velocity, double time) {
    Beschleunigung acceleration = beschleunigungBerechnen(velocity, time);
    printf("Beschleunigung: %lf\n", acceleration);
}

void calculateImpulse(double mass, double velocity) {
    Impuls impulse = impulsBerechnen(mass, velocity);
    printf("Impuls: %lf\n", impulse);
}

void calculateUniformLinearMotion(double velocity, double time, double time0) {
    WegLineareGleichfoermigeBewegung displacement = wegLineareGleichfoermigeBewegungBerechnen(velocity, time, time0);
    printf("Weg: %lf\n", displacement);
}

void calculateAcceleratedLinearMotion(double velocity, double velocity0, double acceleration) {
    WegLineareBeschleunigteBewegung displacement = wegLineareBeschleunigteBewegungBerechnen(velocity, velocity0, acceleration);
    printf("Weg: %lf\n", displacement);
}

void calculateVelocityAcceleratedLinearMotion(double velocity0, double acceleration, double time, double time0) {
    GeschwindigkeitLineareBeschleunigteBewegung velocity = geschwindigkeitLineareBeschleunigteBewegungBerechnen(velocity0, acceleration, time, time0);
    printf("Geschwindigkeit: %lf\n", velocity);
}

int main() {
    int choice;
    double displacement, time, velocity, time0, mass, velocity0, acceleration;

    do {
        printMenu();
        printf("Gebe deine Wahl ein: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Gebe den Weg ein: ");
                scanf("%lf", &displacement);
                printf("Gebe die Zeit ein: ");
                scanf("%lf", &time);
                calculateVelocity(displacement, time);
                break;
            case 2:
                printf("Gebe die Geschwindigkeit ein: ");
                scanf("%lf", &velocity);
                printf("Gebe die Zeit ein: ");
                scanf("%lf", &time);
                calculateAcceleration(velocity, time);
                break;
            case 3:
                printf("Gebe die Masse ein: ");
                scanf("%lf", &mass);
                printf("Gebe die Geschwindigkeit ein: ");
                scanf("%lf", &velocity);
                calculateImpulse(mass, velocity);
                break;
            case 4:
                printf("Gebe die Geschwindigkeit ein: ");
                scanf("%lf", &velocity);
                printf("Gebe die Zeit ein: ");
                scanf("%lf", &time);
                printf("Gebe die Anfangszeit ein: ");
                scanf("%lf", &time0);
                calculateUniformLinearMotion(velocity, time, time0);
                break;
            case 5:
                printf("Gebe die Geschwindigkeit ein: ");
                scanf("%lf", &velocity);
                printf("Gebe die Anfangsgeschwindigkeit ein: ");
                scanf("%lf", &velocity0);
                printf("Gebe die Beschleunigung ein: ");
                scanf("%lf", &acceleration);
                calculateAcceleratedLinearMotion(velocity, velocity0, acceleration);
                break;
            case 6:
                printf("Gebe die Anfangsgeschwindigkeit ein: ");
                scanf("%lf", &velocity0);
                printf("Gebe die Beschleunigung ein: ");
                scanf("%lf", &acceleration);
                printf("Gebe die Zeit ein: ");
                scanf("%lf", &time);
                printf("Gebe die Anfangszeit ein: ");
                scanf("%lf", &time0);
                calculateVelocityAcceleratedLinearMotion(velocity0, acceleration, time, time0);
                break;
            case 0:
                printf("Auf Wiedersehen!\n");
                break;
            default:
                printf("Ungueltige Eingabe!\n");
        }

        printf("\n");
    } while (choice != 0);

    return 0;
}
