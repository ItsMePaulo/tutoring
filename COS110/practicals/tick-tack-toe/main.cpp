#include <iostream>
#include "ValidationClass.h"
#include "GridElements.h"
#include "GridClass.h"

using namespace std;


int getEntry(ValidationClass *validationClass, string field);


int main() {

    ValidationClass *validationClass = new ValidationClass();
    GridClass *gridClass = new GridClass();


    cout << "===========================================================================" << endl;
    cout << "                            Tick Tack Toe                                  " << endl;
    cout << "===========================================================================" << endl;

//    int x = getEntry(validationClass, "row");
//    int y = getEntry(validationClass, "column");

    gridClass -> printGrid();

    return 0;
}

int getEntry(ValidationClass *validationClass, string field) {
    int val;
    do {
        cout << "Player 1 please enter a " << field << " number from 1-3: " << endl;
        cin >> val;

    } while (!validationClass->isValidNumber(val));
}
