//
// Created by sparta on 10/26/20.
//

#include "dLL.h"
#include <iostream>

template<class T>
dLL<T>::dLL() {
    head = nullptr;
    tail = nullptr;
    size = 0;
}

template<class T>
dLL<T>::~dLL() {
    //TODO: finish the destructor

}

template<class T>
ditem<T>* dLL<T>::getHead() {
    return head;
}

template<class T>
ditem<T>* dLL<T>::getTail() {
    return tail;
}

// This adds a new ditem to the doubly linked list. If the value of the item is
// smaller than the smallest of the ditems in the list, then it should be added at the
// front of the list. Otherwise it should be added at the back.

//  newItem -> <- 1 -> 2 -> 3
// and head updated to newItem

// add to back newItem <- tail
// tail -> newItem
// and tail = newItem


template<class T>
void dLL<T>::push(ditem<T> *newItem) {

    if (head == nullptr) {
        head = newItem;
        tail = newItem;
        head->next = nullptr;
        head->prev = nullptr;
    } else {

        auto smallest = minNode();

        if (newItem->getData() < smallest) {
            // add to front
            newItem->next = head;
            newItem->prev = nullptr;
            head->prev = newItem;
            head = newItem;
        } else {
            // add to back
            newItem->next = nullptr;
            newItem->prev = tail;
            tail->next = newItem;
            tail = newItem;
        }
    }

    size++;
}

template<class T>
T dLL<T>::minNode() {


    auto tmp = head;
    auto smallest = head;

    // 1 -> 2 -> 3 -> 4 -> nullptr
//    tmp = tmp->next;
    while (tmp != nullptr) {

        if (tmp->getData() < smallest->getData()) {
            smallest = tmp;
        }

        tmp = tmp->next;
    }

    return smallest->getData();
}

template<class T>
void dLL<T>::printList() {
    if (head == nullptr) {
        return;
    }

    // 1 -> 2 -> 3 -> 4 -> nullptr
    //1,2,3,4\n
    auto lastItem = head;

    while(lastItem->next != nullptr) {
        std::cout << lastItem->getData() << ",";
        lastItem = lastItem->next;
    }

    std::cout << lastItem->getData() << std::endl;
}

template<class T>
ditem<T> *dLL<T>::pop() {

    if (head == nullptr) {
        return nullptr;
    }

    auto tmp = head;

    if (head->next == nullptr) {
        head = nullptr;
    }
    else {
        head->next->prev = nullptr;
        head = head->next;
    }

    return tmp;
}

template<class T>
ditem<T>* dLL<T>::getItem(int i) {

    // 0 -> 1 -> 2 -> 3 -> 4 => index
    // 5 -> 3 -> 6 -> 1 -> -8 -> nullptr => list

    // we have size soooo => we can check
    // simple >= size return null

    // index = 3
    // counter int keep ++ in the loop
    // while(counter != i) => keep going through

    if (i >= size) {
        return nullptr;
    } else {

        auto tmp = head;
        auto counter =  0;

        while (counter != i) {
            tmp = tmp->next;
            counter++;
        }

        return tmp;
    }
}

template<class T>
int dLL<T>::getSize() {
    return size;
}




