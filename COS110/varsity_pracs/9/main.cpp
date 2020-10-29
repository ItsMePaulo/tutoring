#include <iostream>

#include "storage.h"
#include "cLL.h"
#include "dLL.h"
#include "citem.h"
#include "ditem.h"


template<class T>
citem<T> *makeCItem(T data) {
    return new citem<T>(data);
}

template<class T>
ditem<T> *makeDItem(T data) {
    return new ditem<T>(data);
}

int main() {

    auto *store1 = new storage<int>(5);
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

    std::cout << std::endl;
    auto *circularList = new cLL<int>();
    circularList->push(makeCItem(8));
    circularList->push(makeCItem(22));
    circularList->push(makeCItem(6));
    circularList->push(makeCItem(19));
    circularList->push(makeCItem(5));


    std::cout << "Testing some circular list functions " << std::endl;
    std::cout << "######################################################################################" << std::endl;
    std::cout << "Original circular list looks like this: \t\t ";
    circularList->printList();

    std::cout << "Testing get size:" << std::endl;
    std::cout << "Expected: \t\t\t\t\t\t\t\t 5" << std::endl;
    std::cout << "Actual: \t\t\t\t\t\t\t\t " << circularList->getSize() << std::endl;

    std::cout << std::endl;
    std::cout << "Testing the pop functions for circular list " << std::endl;
    std::cout << "======================================================================================" << std::endl;
    std::cout << "The original list looks like this: \t\t ";
    circularList->printList();

    std::cout << std::endl;

    std::cout << "Expected: \t\t\t\t\t\t\t 8,6,19,5" << std::endl;
    circularList->pop();
    std::cout << "Actual: \t\t\t\t\t\t\t ";
    circularList->printList();

    std::cout << "Expected Size:\t\t\t\t\t\t 4" << std::endl;
    std::cout << "Actual Size: \t\t\t\t\t\t " << circularList->getSize() << std::endl;


    std::cout << std::endl;

    std::cout << "Expected: \t\t\t\t\t\t\t 6,19,5" << std::endl;
    circularList->pop();
    std::cout << "Actual: \t\t\t\t\t\t\t ";
    circularList->printList();

    std::cout << "Expected Size: \t\t\t\t\t\t 3" << std::endl;
    std::cout << "Actual Size: \t\t\t\t\t\t " << circularList->getSize() << std::endl;

    std::cout << std::endl;

    std::cout << "Expected: \t\t\t\t\t\t\t 19,5" << std::endl;
    circularList->pop();
    std::cout << "Actual: \t\t\t\t\t\t\t ";
    circularList->printList();

    std::cout << "Expected Size: \t\t\t\t\t\t 2" << std::endl;
    std::cout << "Actual Size: \t\t\t\t\t\t " << circularList->getSize() << std::endl;

    std::cout << std::endl;

    std::cout << "Expected: \t\t\t\t\t\t\t 5" << std::endl;
    circularList->pop();
    std::cout << "Actual: \t\t\t\t\t\t\t ";
    circularList->printList();

    std::cout << "Expected Size: \t\t\t\t\t\t 1" << std::endl;
    std::cout << "Actual Size: \t\t\t\t\t\t " << circularList->getSize() << std::endl;

    std::cout << std::endl;

    std::cout << "Expected: \t\t\t\t\t\t\t " << std::endl;
    circularList->pop();
    std::cout << "Actual: \t\t\t\t\t\t\t \n";
    circularList->printList();

    std::cout << "Expected Size: \t\t\t\t\t\t 0" << std::endl;
    std::cout << "Actual Size: \t\t\t\t\t\t " << circularList->getSize() << std::endl;


    circularList->push(makeCItem(8));
    circularList->push(makeCItem(22));
    circularList->push(makeCItem(6));
    circularList->push(makeCItem(19));
    circularList->push(makeCItem(5));

    std::cout << std::endl;
    std::cout << "Testing remove at function for circular list " << std::endl;
    std::cout << "======================================================================================" << std::endl;
    std::cout << "Original circular list looks like this: \t\t ";
    circularList->printList();

    std::cout << "Removing 3 (no action required 3 is not in the list)" << std::endl;
    circularList->removeAt(3);
    std::cout << "Expected: \t\t\t\t\t\t\t 22,8,6,19,5" << std::endl;
    std::cout << "Actual: \t\t\t\t\t\t\t ";
    circularList->printList();
    std::cout << std::endl;


    std::cout << "Removing 6" << std::endl;
    circularList->removeAt(6);
    std::cout << "Expected: \t\t\t\t\t\t\t 22,8,19,5" << std::endl;
    std::cout << "Actual: \t\t\t\t\t\t\t ";
    circularList->printList();
    std::cout << std::endl;

    std::cout << "Removing 5 (removing tail)" << std::endl;
    circularList->removeAt(5);
    std::cout << "Expected: \t\t\t\t\t\t\t 22,8,19" << std::endl;
    std::cout << "Actual: \t\t\t\t\t\t\t ";
    circularList->printList();
    std::cout << std::endl;

    std::cout << "Removing 22 (removing head)" << std::endl;
    circularList->removeAt(22);
    std::cout << "Expected: \t\t\t\t\t\t\t 8,19" << std::endl;
    std::cout << "Actual: \t\t\t\t\t\t\t ";
    circularList->printList();
    std::cout << std::endl;

    std::cout << "Expected Size: \t\t\t\t\t\t 2" << std::endl;
    std::cout << "Actual Size: \t\t\t\t\t\t " << circularList->getSize() << std::endl;

    std::cout << std::endl;
    std::cout << "Finished testing Circular List functions" << std::endl;
    std::cout << std::endl;
    std::cout << "######################################################################################" << std::endl;
    std::cout << "Testing Double Linked List functions" << std::endl;
    std::cout << "######################################################################################" << std::endl;
    std::cout << std::endl;
    auto *doubleLinkedList = new dLL<int>();

    doubleLinkedList->push(makeDItem(8));
    doubleLinkedList->push(makeDItem(22));
    doubleLinkedList->push(makeDItem(6));
    doubleLinkedList->push(makeDItem(19));
    doubleLinkedList->push(makeDItem(5));

    std::cout << "Testing the getItem function for doubly linked list " << std::endl;
    std::cout << "======================================================================================" << std::endl;
    std::cout << "The original list looks like this: \t\t ";
    doubleLinkedList->printList();
    std::cout << std::endl;

    std::cout << "Fetching item at index: 3" << std::endl;
    std::cout << "Expected: \t\t\t\t\t\t\t\t 22" << std::endl;
    std::cout << "Actual: \t\t\t\t\t\t\t\t " << doubleLinkedList->getItem(3)->getData() << std::endl;

    std::cout << std::endl;

    std::cout << "Fetching item at index: 6" << std::endl;
    std::cout << "Expected: \t\t\t\t\t\t\t\t 0" << std::endl; // output a null pointer and you get 0
    std::cout << "Actual: \t\t\t\t\t\t\t\t " << doubleLinkedList->getItem(6) << std::endl;

    std::cout << std::endl;

    std::cout << "Fetching item at index: 0" << std::endl;
    std::cout << "Expected: \t\t\t\t\t\t\t\t 5" << std::endl;
    std::cout << "Actual: \t\t\t\t\t\t\t\t " << doubleLinkedList->getItem(0)->getData() << std::endl;

    std::cout << std::endl;

    std::cout << "Testing the pop functions for doubly linked list " << std::endl;
    std::cout << "======================================================================================" << std::endl;
    std::cout << "The original list looks like this: \t\t ";
    doubleLinkedList->printList();

    std::cout << "Expected Size: \t\t\t 5" << std::endl;
    std::cout << "Actual Size: \t\t\t " << doubleLinkedList->getSize() << std::endl;

    std::cout << "Expected: \t\t\t\t 6,8,22,19" << std::endl;
    doubleLinkedList->pop();
    std::cout << "Actual: \t\t\t\t ";
    doubleLinkedList->printList();
    std::cout << std::endl;

    std::cout << "Expected: \t\t\t\t 8,22,19" << std::endl;
    doubleLinkedList->pop();
    std::cout << "Actual: \t\t\t\t ";
    doubleLinkedList->printList();
    std::cout << std::endl;

    std::cout << "Expected: \t\t\t\t 22,19" << std::endl;
    doubleLinkedList->pop();
    std::cout << "Actual: \t\t\t\t ";
    doubleLinkedList->printList();
    std::cout << std::endl;

    std::cout << "Expected: \t\t\t\t 19" << std::endl;
    doubleLinkedList->pop();
    std::cout << "Actual: \t\t\t\t ";
    doubleLinkedList->printList();
    std::cout << std::endl;

    std::cout << "Expected: \t\t\t\t " << std::endl;
    doubleLinkedList->pop();
    std::cout << "Actual: \t\t\t\t ";
    doubleLinkedList->printList();
    std::cout << std::endl;
    std::cout << std::endl;

    std::cout << "Expected Size: \t\t\t 0" << std::endl;
    std::cout << "Actual Size: \t\t\t " << doubleLinkedList->getSize() << std::endl;

    std::cout << std::endl;

    delete store1;
    std::cout << std::endl;
    delete circularList;
    std::cout << std::endl;
    delete doubleLinkedList;

    return 0;
}
