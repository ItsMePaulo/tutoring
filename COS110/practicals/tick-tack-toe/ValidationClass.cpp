//
// Created by paul on 2/17/20.
//

#include "ValidationClass.h"
#include <iostream>

using namespace std;

bool ValidationClass::isValidNumber(int x) {
    if(x > 0 && x <= 3) {
        return true;
    }
    else {
        cout << "Invalid number please  enter a number between 1 - 3" << endl;
        return false;
    }
}

