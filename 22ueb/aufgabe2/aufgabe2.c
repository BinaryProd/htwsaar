#include <stdio.h>
#include <string.h>

#define MAX_MARKE_LENGTH 20
#define MAX_SONDERAUSSTATTUNG 10
#define MAX_SONDERAUSSTATTUNG_LENGTH 100

typedef struct {
    char marke[MAX_MARKE_LENGTH + 1];
    int maxSpeed;
    int doors;
    int hasABS;
    char sonderausstattung[MAX_SONDERAUSSTATTUNG][MAX_SONDERAUSSTATTUNG_LENGTH+ 1];
    int zahl_sonderausstattung;
    struct {
        int ps;
        int zylinder;
        int hubraum;
    } Motor;
} Auto;

Auto createAuto(
        const char *marke, 
        int maxSpeed, int doors, int hasABS, 
        const char sonderausstattung[MAX_SONDERAUSSTATTUNG][MAX_SONDERAUSSTATTUNG_LENGTH + 1], 
        int zahl_sonderausstattung, int ps, int zylinder, int hubraum
    ) {
    Auto car;
    strncpy(car.marke, marke, MAX_MARKE_LENGTH);
    car.marke[MAX_MARKE_LENGTH] = '\0';
    car.maxSpeed = maxSpeed;
    car.doors = doors;
    car.hasABS = hasABS;
    car.zahl_sonderausstattung = zahl_sonderausstattung;
    for (int i = 0; i < zahl_sonderausstattung; i++) {
        strncpy(car.sonderausstattung[i], sonderausstattung[i], MAX_SONDERAUSSTATTUNG_LENGTH);
        car.sonderausstattung[i][MAX_SONDERAUSSTATTUNG_LENGTH] = '\0';
    }
    car.Motor.ps = ps;
    car.Motor.zylinder = zylinder;
    car.Motor.hubraum = hubraum;
    return car;
}

int estimateAutoValue(const Auto *car) {
    int value = car->maxSpeed * 50;
    value *= car->doors;
    if (car->hasABS) {
        value += 5000;
    }
    value += car->zahl_sonderausstattung * 3000;
    if (strcmp(car->marke, "Porsche") == 0) {
        value *= 2;
    }
    return value;
}

void printAuto(const Auto *car) {
    printf("Marke: %s\n", car->marke);
    printf("Max Speed: %d\n", car->maxSpeed);
    printf("Tuer: %d\n", car->doors);
    printf("ABS: %s\n", car->hasABS ? "Ja" : "Nein");
    printf("Sonderausstattung:\n");
    for (int i = 0; i < car->zahl_sonderausstattung; i++) {
        printf("- %s\n", car->sonderausstattung[i]);
    }
    printf("Motor:\n");
    printf("- Ps: %d\n", car->Motor.ps);
    printf("- Zylinder: %d\n", car->Motor.zylinder);
    printf("- Hubraum: %d\n", car->Motor.hubraum);
}

#define MAX_AUTO 100

Auto autoInventory[MAX_AUTO];
int numAutos = 0;

void addAuto(const Auto *car) {
    if (numAutos < MAX_AUTO) {
        autoInventory[numAutos++] = *car;
        printf("Auto wurde zum Inventar hinzugefuegt.\n");
    } else {
        printf("Inventar ist voll. Auto kann nicht hinzugefuegt werden.\n");
    }
}

void removeAuto(const Auto *car) {
    int foundIndex = -1;
    for (int i = 0; i < numAutos; i++) {
        if (&autoInventory[i] == car) {
            foundIndex = i;
            break;
        }
    }
    if (foundIndex != -1) {
        for (int i = foundIndex; i < numAutos - 1; i++) {
            autoInventory[i] = autoInventory[i + 1];
        }
        numAutos--;
        printf("Auto aus dem Inventar entfernt.\n");
    } else {
        printf("Auto nicht im Inventar gefunden.\n");
    }
}

int main() {
    Auto auto1 = createAuto(
            "Porsche", 
            280, 2, 1, 
            (const char[MAX_SONDERAUSSTATTUNG][MAX_SONDERAUSSTATTUNG_LENGTH + 1]){"Ledersitze", "Navigationssystem"}, 
            2, 400, 6, 4000);
    Auto auto2 = createAuto(
            "BMW", 
            240, 4, 1, 
            (const char[MAX_SONDERAUSSTATTUNG][MAX_SONDERAUSSTATTUNG_LENGTH + 1]){"Schiebedach"}, 
            1, 300, 6, 3500);
    Auto auto3 = createAuto(
            "Mercedes", 
            260, 4, 1, 
            (const char[MAX_SONDERAUSSTATTUNG][MAX_SONDERAUSSTATTUNG_LENGTH + 1]){"Rueckfahrkamera", "Park Assistent"}, 
            2, 350, 6, 3800);
    
    addAuto(&auto1);
    printf("Wert von auto 1: %d\n", estimateAutoValue(&auto1));
    addAuto(&auto2);
    printf("Wert von auto 2: %d\n", estimateAutoValue(&auto2));
    addAuto(&auto3);
    printf("Wert von auto 3: %d\n", estimateAutoValue(&auto3));
    
    printf("Auto Inventar:\n");
    for (int i = 0; i < numAutos; i++) {
        printf("Auto %d:\n", i+1);
        printAuto(&autoInventory[i]);
    }
    
    removeAuto(&auto2);
    
    printf("Auto Inventar nach der Entfernung:\n");
    for (int i = 0; i < numAutos; i++) {
        printf("Auto %d:\n", i+1);
        printAuto(&autoInventory[i]);
    }
    
    return 0;
}

