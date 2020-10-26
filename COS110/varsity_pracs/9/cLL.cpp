//
// Created by sparta on 10/26/20.
//

#include <iostream>
#include "cLL.h"

template<class T>
cLL<T>::cLL() {
    head = nullptr;
    size = 0;
}

template<class T>
cLL<T>::~cLL() {
    // TODO: delete circular list
}

//This receives a new citem and adds it to the circular linked list. If the value
//of the item is larger than the largest value of the citems in the list, then it should
//be added at the front of the list, in front of the head. Otherwise it should be added
//at the back.

template<class T>
void cLL<T>::push(citem<T> *newItem) {

    if (isEmpty()) {
        head = newItem;
        head->next = head;
    } else {

        auto tmp = head;
        auto largest = head;
        auto last = head;

        tmp = tmp->next;
        while (tmp != head) {
            if (tmp->getData() > largest->getData()) {
                largest = tmp;
            }
            last = tmp;
            tmp = tmp->next;
        }

        newItem->next = head;
        last->next = newItem;

        if (newItem->getData() > largest->getData()) {
            // add to front
            head = newItem;
        }
    }

    size++;
}

template<class T>
bool cLL<T>::isEmpty() {
    return head == nullptr;
}

template<class T>
int cLL<T>::getSize() {
    return size;
}

template<class T>
void cLL<T>::printList() {
    auto tmp = head;

    while(tmp->next != head) {
        std::cout << tmp->getData() << ", ";
        tmp = tmp->next;
    }

    if (tmp != nullptr) {
        std::cout << tmp->getData() << std::endl;
    }
}
