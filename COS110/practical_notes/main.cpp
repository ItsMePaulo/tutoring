#include <iostream>
#include "Book.h"

using namespace std;


int main() {

    Person person;

    person.setName("Paul");
    person.setAge(23);

    cout << person.getName() << " is " << person.getAge() << " years old" << endl;

    string name = person.getName();
    name = "Mary"; // this is fine

    person.setName(name); // you can set a different name or change the get returned name

    return 0;
}
