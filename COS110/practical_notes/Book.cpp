//
// Created by paul on 2/10/20.
//

#include "Book.h"
#include <iostream>

using namespace std;

string Person::getName() const {
    name = "Mary"; // this is not
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
