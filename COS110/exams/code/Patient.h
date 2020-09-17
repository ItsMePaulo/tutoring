//
// Created by momo on 9/17/20.
//

#ifndef COS110_PATIENT_H
#define COS110_PATIENT_H

#include <iostream>

class Patient {
private:
    std::string name;
    int days;

public:

    Patient(const std::string &basicString, int i = 10) {
        name = basicString;
        days = i;
    }

    // added copy constructor for question four
    Patient(const Patient& p) {
        name = p.name;
        days = p.days;
    }

    int getDays() {
        return days;
    }

    std::string getName() {
        return name;
    }
};

#endif //COS110_PATIENT_H
