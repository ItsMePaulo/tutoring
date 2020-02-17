//
// Created by paul on 2/15/20.
//

#include "Integer.h"

using namespace std;

int Integer::getVal() {
    return val;
}

void Integer::setVal(int v) {
    val = v;
}

bool Integer::isOdd() {
    return getVal() % 2 == 1;
}

bool Integer::isEven() {
    return getVal() % 2 == 0;
}

int Integer::addNumber(int number) {
    return getVal() + number;
}

int Integer::minusNumber(int number){
    return getVal() - number;
}

string Integer::getFizzBang() {
    if ((val % 3 == 0) && (val % 5 == 0 )) {
        return "FIZZ_BANG";
    }
    if (val % 3 == 0) {
        return "FIZZ";
    } else if (val % 5 == 0) {
        return "BANG";
    } else {
        return "NEITHER";
    }
}

int Integer::factorial() {
    int total = 1;

    for(int i = val; i > 1; i--) {
        total *= i;
    }

    return total;
}
