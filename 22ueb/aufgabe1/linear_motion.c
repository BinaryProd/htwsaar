#include "linear_motion.h"

WegLineareGleichfoermigeBewegung wegLineareGleichfoermigeBewegungBerechnen(double velocity, double time, double time0) {
    return velocity * (time - time0);
}

WegLineareBeschleunigteBewegung wegLineareBeschleunigteBewegungBerechnen(double velocity, double velocity0, double acceleration) {
    return ((velocity * velocity) - (velocity0 * velocity0)) / (2 * acceleration);
}

GeschwindigkeitLineareBeschleunigteBewegung geschwindigkeitLineareBeschleunigteBewegungBerechnen(double velocity0, double acceleration, double time, double time0) {
    return (acceleration * (time - time0)) + velocity0;
}