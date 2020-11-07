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
    node<T>* head;
    virtual node<T>* pop() = 0;

    virtual void push(node<T>* i) = 0;

    virtual void print() {
        if (head == nullptr) {
            return;
        }

        auto tmp = head;

        while (tmp->next != nullptr) {
            std::cout << tmp->getItem() << ", ";
        }

        std::cout << tmp->getItem() << std::endl;
    }
};


#endif //STACK_QUES_LIST_H
