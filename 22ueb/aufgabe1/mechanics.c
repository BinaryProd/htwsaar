#include "mechanics.h"

Geschwindigkeit geschwindigkeitBerechnen(double displacement, double time) {
    return displacement / time;
}

Beschleunigung beschleunigungBerechnen(double velocity, double time) {
    return velocity / time;
}

Impuls impulsBerechnen(double mass, double velocity) {
    return mass * velocity;
}