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
ditem<T> *dLL<T>::getHead() {
    return head;
}

template<class T>
ditem<T> *dLL<T>::getTail() {
    return tail;
}


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
    if (head == nullptr) {
        return 0;
    }

    auto tmp = head;
    auto smallest = head;

    tmp = tmp->next;
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
    auto tmp = head;

    while(tmp->next != nullptr) {
        std::cout << tmp->getData() << ", ";
        tmp = tmp->next;
    }

    if (tmp != nullptr) {
        std::cout << tmp->getData() << std::endl;
    }
}




