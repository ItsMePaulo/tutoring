#include <iostream>
#include "list.h"
#include "stack.h"
#include "stack.cpp"
#include "queue.h"
#include "queue.cpp"

int main() {

    auto myStack = new stack<int>();

    auto n1 = new node<int>(1);
    auto n2 = new node<int>(2);
    auto n3 = new node<int>(3);
    auto n4 = new node<int>(4);

    std::cout << std::endl;

    myStack->push(n1);
    myStack->push(n2);
    myStack->push(n3);
    myStack->push(n4);

    myStack->print();
    std::cout << "Calling the pop: " << myStack->pop()->getItem() << std::endl;
    myStack->print();

    std::cout << "Calling the pop: " << myStack->pop()->getItem() << std::endl;
    std::cout << "Calling the pop: " << myStack->pop()->getItem() << std::endl;
    std::cout << "Calling the pop: " << myStack->pop()->getItem() << std::endl;

    std::cout << std::endl;
    myStack->print();

    std::cout << "##################### THE QUEUE #########################" << std::endl;
    auto myQueue = new queue<int>();

    myQueue->push(n1);
    myQueue->push(n2);
    myQueue->push(n3);
    myQueue->push(n4);

    myQueue->print();
    std::cout << "Calling the pop: " << myQueue->pop()->getItem() << std::endl;
    myQueue->print();

    std::cout << "Calling the pop: " << myQueue->pop()->getItem() << std::endl;
    std::cout << "Calling the pop: " << myQueue->pop()->getItem() << std::endl;
    std::cout << "Calling the pop: " << myQueue->pop()->getItem() << std::endl;

    myQueue->print();
    return 0;
}
