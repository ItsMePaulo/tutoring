//
// Created by paul on 2/15/20.
//

#ifndef PERSON_NEWPERSON_H
#define PERSON_NEWPERSON_H


#include <string>

class NewPerson {
private:
    std::string name;
    int age;

public:
    NewPerson();
    NewPerson(const std::string &name, int age);

    // name
    const std::string &getName() const;
    void setName(const std::string &name);

    // age
    int getAge() const;
    void setAge(int age);
};


#endif //PERSON_NEWPERSON_H
