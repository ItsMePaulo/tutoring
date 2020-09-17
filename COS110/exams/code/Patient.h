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

    Patient(std::string &basicString, int i) {
        name = basicString;
        days = 1;
    }

    int getDays() {
        return days;
    }

    std::string getName() {
        return name;
    }


};

#endif //COS110_PATIENT_H
