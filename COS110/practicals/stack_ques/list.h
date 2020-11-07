//
// Created by sparta on 11/5/20.
//

#ifndef STACK_QUES_LIST_H
#define STACK_QUES_LIST_H

#include "node.h"
#include <iostream>

template<class T>
class list {
public:

    list() {
        head = nullptr;
    }

    virtual node<T>* pop() = 0;

    virtual void push(node<T>* i) = 0;

    virtual void print() {
        if (head == nullptr) {
            return;
        }

        auto tmp = head;

        while (tmp->next != nullptr) {
            std::cout << tmp->getItem() << ", ";
            tmp = tmp->next;
        }

        std::cout << tmp->getItem() << std::endl;
    }

protected:
    node<T>* head;
};


#endif //STACK_QUES_LIST_H
