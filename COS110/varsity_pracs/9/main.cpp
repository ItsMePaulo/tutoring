#include <iostream>

#include "storage.h"
#include "cLL.h"
#include "dLL.h"
#include "citem.h"
#include "ditem.h"


template <class T>
citem<T>* makeCItem(T data) {
    return new citem<T>(data);
}

template <class T>
ditem<T>* makeDItem(T data) {
    return new ditem<T>(data);
}

int main() {

    auto* store1 = new storage<int>(5);
    auto* store2 = new storage<double >(2);
//
    std::cout << "Testing the list with int expected output" << std::endl;

    store1->storeData(1); // odd => dList
    store1->storeData(5); // odd => dList
    store1->storeData(-1); // odd => dList
    store1->storeData(3); // odd => dList
    store1->storeData(15); // odd => dList
    store1->storeData(-13); // odd => dList

    std::cout << std::endl;
    printf("Printing the\x1B[34m DList \033[0min Storage\n");
    std::cout << "Expected output:\t\t -13,-1,1,5,3,15" << std::endl;
    std::cout << "Actual output:\t\t\t ";
    store1->printDList();
    std::cout << std::endl;


    store1->storeData(2); // even => cList
    store1->storeData(2); // even => cList
    store1->storeData(18); //even => cList
    store1->storeData(16); //even => cList
    store1->storeData(-100); // even => cList
    store1->storeData(156); // even => cList

    printf("Printing the\x1B[34m CList \033[0min Storage \n");
    std::cout << "Expected output: \t\t\t\t 156,18,2,2,16,-100" << std::endl;
    std::cout << "Actual output: \t\t\t\t\t ";
    store1->printCList();
    std::cout << std::endl;

    std::cout << "Add and Print functions work on int types. Storage class is pretty much tested in full" << std::endl;
    std::cout << "======================================================================================" << std::endl;

    store2->storeData(1.0);
    store2->storeData(2.1);

    std::cout << std::endl;
    auto* circularList = new cLL<int>();

    circularList->push(makeCItem(8));
    circularList->push(makeCItem(22));
    circularList->push(makeCItem(6));
    circularList->push(makeCItem(19));
    circularList->push(makeCItem(5));

    std::cout << std::endl;
    std::cout <<"Testing the pop functions for circular list " << std::endl;
    std::cout << "======================================================================================" << std::endl;
    std::cout <<"The original list looks like this: \t\t ";
    circularList->printList();

    std::cout<<"Expected: \t\t\t\t\t\t\t\t 8,6,19,5" << std::endl;
    circularList->pop();
    std::cout<<"Actual: \t\t\t\t\t\t\t\t ";
    circularList->printList();


    std::cout << std::endl;
    auto* doubleLinkedList = new dLL<int>();

    doubleLinkedList->push(makeDItem(8));
    doubleLinkedList->push(makeDItem(22));
    doubleLinkedList->push(makeDItem(6));
    doubleLinkedList->push(makeDItem(19));
    doubleLinkedList->push(makeDItem(5));

    std::cout<<"Testing the getItem function for doubly linked list " << std::endl;
    std::cout << "======================================================================================" << std::endl;
    std::cout<<"We want to fetch the item at index: 3" << std::endl;
    std::cout<<"The original list looks like this: \t\t ";
    doubleLinkedList->printList();
    std::cout<<"Expected: \t\t\t\t\t\t\t\t 22" << std::endl;
    std::cout<<"Actual: \t\t\t\t\t\t\t\t " << doubleLinkedList->getItem(3)->getData() << std::endl;

    std::cout << std::endl;
    std::cout<<"Testing the pop functions for doubly linked list " << std::endl;
    std::cout << "======================================================================================" << std::endl;
    std::cout<<"The original list looks like this: \t\t ";
    doubleLinkedList->printList();
    std::cout<<"Expected: \t\t\t\t 6,8,22,19" << std::endl;
    doubleLinkedList->pop();
    std::cout<<"Actual: \t\t\t\t ";
    doubleLinkedList->printList();
    std::cout << std::endl;

    std::cout<<"Expected: \t\t\t\t 8,22,19" << std::endl;
    doubleLinkedList->pop();
    std::cout<<"Actual: \t\t\t\t ";
    doubleLinkedList->printList();
    std::cout << std::endl;

    std::cout<<"Expected: \t\t\t\t 22,19" << std::endl;
    doubleLinkedList->pop();
    std::cout<<"Actual: \t\t\t\t ";
    doubleLinkedList->printList();
    std::cout << std::endl;

    std::cout<<"Expected: \t\t\t\t 19" << std::endl;
    doubleLinkedList->pop();
    std::cout<<"Actual: \t\t\t\t ";
    doubleLinkedList->printList();
    std::cout << std::endl;

    std::cout<<"Expected: \t\t\t\t " << std::endl;
    doubleLinkedList->pop();
    std::cout<<"Actual: \t\t\t\t ";
    doubleLinkedList->printList();
    std::cout << std::endl;


    return 0;
}
