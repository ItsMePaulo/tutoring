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

    auto tmp = head->next;
    while(tmp != head) {
        auto prev = tmp;
        tmp = tmp->next;

        delete(prev);
    }

    delete head;
}

/**
 * This receives a new citem and adds it to the circular linked list. If the value
 * of the item is larger than the largest value of the citems in the list, then it should
 * be added at the front of the list, in front of the head. Otherwise it should be added
 * the back.
 **/
// this we have to do
// loop till you find next value with head => tail
// tail next => newItem
// newItem next => head

// now how to determine if should be head or tail
// if (newItem > largest)
// we would have to find largest

// 5 -> 4 -> 1 -> 2 -> 3 -> head
// |-------------------|


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
    if(head == nullptr) {
        return;
    }

    auto tmp = head;

    while(tmp->next != head) {
        std::cout << tmp->getData() << ",";
        tmp = tmp->next;
    }

    if (tmp != nullptr) {
        std::cout << tmp->getData() << std::endl;
    }
}

template<class T>
citem<T> *cLL<T>::pop() {

    if (head == nullptr) {
        return nullptr;
    }
    else if (head->next == head) {
        auto oldHead = head;
        head = nullptr;
        size--;
        return oldHead;
    }

    auto oldHead = head;
    auto tail = head->next;

    while (tail->next != head) {
        tail = tail->next;
    }

    tail->next = head->next;
    head = head->next;
    size--;
    return oldHead;
}

template<class T>
citem<T> *cLL<T>::removeAt(T x) {

    auto tmp = head;

    if (head == nullptr) {
        return nullptr;
    } else if (head->getData() == x) {

        return pop();
    } else {
        auto previous = head;

        tmp = tmp->next;
        while(tmp != head) {
            if(tmp->getData() == x) {
                // remove
                previous->next = tmp->next;
                tmp->next = nullptr;
                size--;
                return tmp;
            }
            previous = tmp;
            tmp = tmp->next;
        }
    }

    return nullptr;
}
