#include <iostream>
#include "Patient.h"
#include "PizzaPrice.h"
#include "Ward.h"

int main() {

    // Question2 overload the multiply operator
    PizzaPrice today("Something meaty", 40.90);
    PizzaPrice nextYear = today * 1.6;
    std::cout << nextYear.getPrice() << std::endl;

    // Question3 overload the && operator to return a boolean
    Ward fieldHospital;
    fieldHospital.addPatient("Paul");

    if (fieldHospital && "Paul") {
        std::cout << "Paul has been admitted to the ward" << std::endl;
    } else {
        std::cout << "Paul is nowhere to be found" << std::endl;
    }

    return 0;
}
