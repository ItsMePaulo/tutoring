#include <iostream>

class Person {
public:
    std::string name;
    int age;

    virtual void sayHello() {
        std::cout << "Hello " << name << std::endl;
    }
};

class Student : public Person  {
public:
    void goToClass() {
        std::cout << "I am going to class" << std::endl;
    }

    void sayHello() override {
        std::cout << "Hello I am a student and my name is " << name << std::endl;
    }
};


class Adult : public Person {
public:
    void sayHello() override {
        std::cout << "Hello I am an adult and my name is " << name << std::endl;
    }

    void payTaxes() {
        std::cout << "Paying taxes" << std::endl;
    }
};

void printHello(Person* person) {
    person->sayHello();
}


int main() {
    Student* student = new Student();
    Adult* adult = new Adult();

    student->name = "Zelda";
    adult->name = "Paul";

    printHello(student);
    printHello(adult);

//    student->name = "Paul";
//    student->sayHello();

    return 0;
}
