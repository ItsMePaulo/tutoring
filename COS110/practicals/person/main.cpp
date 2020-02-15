#include <iostream>
#include "NewPerson.h"

int main() {

    std::cout << "Person class with new knowledge of Clion" << std::endl;

    NewPerson person;

    person.setName("Paul");
    std::cout << "The Person created is" << person.getName() << std::endl;

    person.setAge(23);
    std::cout << "The Person is: " << person.getAge() << std::endl;

    return 0;
}
