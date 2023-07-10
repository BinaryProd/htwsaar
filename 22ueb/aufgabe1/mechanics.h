#ifndef MECHANICS_H
#define MECHANICS_H

typedef double Geschwindigkeit;
typedef double Beschleunigung;
typedef double Impuls;

Geschwindigkeit geschwindigkeitBerechnen(double displacement, double time);
Beschleunigung beschleunigungBerechnen(double velocity, double time);
Impuls impulsBerechnen(double mass, double velocity);

#endif