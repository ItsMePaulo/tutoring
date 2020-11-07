//
// Created by sparta on 11/5/20.
//

#include "stack.h"
#include "list.h"

template<class T>
node<T> *stack<T>::pop() {
    // 1 -> 2 -> 3 -> 4 -> nullptr
    //          prev tmp
    if (head == nullptr) {
        return nullptr;
    } else if (head->next == nullptr) {
        auto tmp = head;
        head = nullptr;
        return tmp;
    } else {
        auto tmp = head->next;
        auto prev = head;

        while (tmp->next != nullptr) {
            prev = tmp;
            tmp = tmp->next;
        }

        prev->next = nullptr;
        return tmp;
    }
}

template<class T>
void stack<T>::push(node<T> *n) {

    // 1 -> 2 -> 3 -> 4 -> nullptr

    if (head == nullptr) {
        head = n;
    } else {
        auto tmp = head;

        while (tmp->next != nullptr) {
            tmp = tmp->next;
        }

        tmp->next = n;
    }
}
