//
// Created by momo on 9/17/20.
//

#ifndef CODE_WARD_H
#define CODE_WARD_H

#include "Patient.h"
#include <iostream>

class Ward {
private:
    Patient **patient;
    int capacity;
    int numBeds;
public:
    Ward(int c = 20) {
        capacity = c;
        patient = new Patient *[capacity];
    }

    Ward(const Ward &other);

    Ward operator=(const Ward &other);

    void addPatient(std::string name) {
        Patient *newPatient = new Patient(name, 1);
        for (int i = 0; i < capacity; i++) {
            if (patient[i] == NULL) {
                patient[i] = newPatient;
                numBeds++;
                return;
            }
        }
    }

    bool operator&&(std::string patientName) {
        for (int i = 0; i < capacity; i++) {
            if (patient[i]->getName() == patientName && patient[i]->getDays() > 0) {
                return true;
            }
        }

        return false;
    }
};


#endif //CODE_WARD_H
