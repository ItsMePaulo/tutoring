#include <iostream>

#include "storage.h"
#include "storage.cpp"
#include "cLL.h"
#include "cLL.cpp"
#include "dLL.h"
#include "dLL.cpp"
#include "citem.h"
#include "citem.cpp"
#include "ditem.h"
#include "ditem.cpp"

int main() {


    auto* store1 = new storage<int>(5);
    auto* store2 = new storage<double >(2);

    std::cout << "Testing the list with int expected output" << std::endl;

    store1->storeData(1); // odd => dList
    store1->storeData(5); // odd => dList
    store1->storeData(-1); // odd => dList
    store1->storeData(3); // odd => dList
    store1->storeData(15); // odd => dList
    store1->storeData(-13); // odd => dList

    store1->storeData(2); // even => cList
    store1->storeData(2); // even => cList
    store1->storeData(18); //even => cList
    store1->storeData(16); //even => cList
    store1->storeData(-100); // even => cList
    store1->storeData(156); // even => cList

    std::cout << std::endl;
    printf("Printing the\x1B[34m DList \033[0min Storage\n");
    std::cout << "Expected output:\t\t -13, -1, 1, 5, 3, 15" << std::endl;
    std::cout << "Actual output:\t\t\t ";
    store1->printDList();
    std::cout << std::endl;


    printf("Printing the\x1B[34m CList \033[0min Storage \n");
    std::cout << "Expected output: \t\t 156, 18, 2, 2, 16, -100" << std::endl;
    std::cout << "Actual output: \t\t\t ";
    store1->printCList();
    std::cout << std::endl;

    std::cout << "Add and Print functions work on int types. Storage class is pretty much tested in full" << std::endl;
    std::cout << "======================================================================================" << std::endl;

    store2->storeData(1.0);
    store2->storeData(1.1);

    return 0;
}
