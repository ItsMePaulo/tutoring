//
// Created by paul on 2/15/20.
//

#include "NewPerson.h"

NewPerson::NewPerson(const std::string &name, int age) : name(name), age(age) {}

const std::string &NewPerson::getName() const {
    return name;
}

void NewPerson::setName(const std::string &name) {
    NewPerson::name = name;
}

int NewPerson::getAge() const {
    return age;
}

void NewPerson::setAge(int age) {
    NewPerson::age = age;
}

NewPerson::NewPerson() {

}
