//
// Created by paul on 2/10/20.
//

#ifndef PRACTICAL_NOTES_PERSON_H
#define PRACTICAL_NOTES_PERSON_H

#include <iostream>
using namespace std;

class Person {

private:
    string name;
    int age;
public:

    // name
    string getName() const;
    void setName(string name);

    // age
    int getAge();
    void setAge(int age);
};


#endif //PRACTICAL_NOTES_PERSON_H
