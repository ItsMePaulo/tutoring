//
// Created by sparta on 11/5/20.
//

#include "queue.h"

template<class T>
node<T> *queue<T>::pop() {
    // 1 -> 2 -> 3 -> 4 -> nullptr
    // tmp => 1 -> nullptr


    if (this->head == nullptr) {
        return nullptr;
    } else if (this->head->next == nullptr) {
        auto tmp = this->head;
        this->head = nullptr; // list becomes empty when head is equal to null
        return tmp;
    } else {
        auto tmp = this->head;
        this->head = this->head->next;

        tmp->next = nullptr;
        return tmp;
    }
}

template<class T>
void queue<T>::push(node<T> *n) {

    // 1 -> 2 -> 3 -> 4 -> nullptr

    if (this->head == nullptr) {
        this->head = n;
    } else {
        auto tmp = this->head;

        while (tmp->next != nullptr) {
            tmp = tmp->next;
        }

        tmp->next = n;
    }
}
