#include <iostream>
#include "Integer.h"

using namespace std;


int main() {

    int val;

    cout << "Please enter a value for a class: ";
    cin >> val;

    // the cake then the name of the cake
    Integer cake;
    // will fail without this
    cake.setVal(val);

    cout << "The factorial of the number is: " << cake.factorial() << endl;

    cout << "Is the number odd? " << boolalpha  << cake.isOdd() << endl;
    cout << "Play FIZZ_Bang = " << cake.getFizzBang() << endl;

    int addNumber;

    cout << "Enter a number to add: ";
    cin >> addNumber;

    cout << "adding " << addNumber << " to " << val << " equals " << cake.addNumber(addNumber) << endl;

    return 0;
}
