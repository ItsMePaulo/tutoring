//
// Created by paul on 2/10/20.
//

#include "Person.h"
#include <iostream>

using namespace std;

string Person::getName() const {
    return name;
}

void Person::setName(string newName) {
    name = newName;
}

int Person::getAge() {
    return age;
}

void Person::setAge(int ag) {
    age = ag;
}
