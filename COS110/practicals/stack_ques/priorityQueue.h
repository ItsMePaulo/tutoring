//
// Created by sparta on 11/7/20.
//

#ifndef STACK_QUES_PRIORITYQUEUE_H
#define STACK_QUES_PRIORITYQUEUE_H


#include "list.h"

template <class T>
class priorityQueue : list<T> {

    // 1 -> 2 -> 3 -> 4 -> nullptr
    // 90 -> 70 -> 12 -> 5

    // 5 with order 63

public:
    void push(node<T>* n, int order) {

        // 5 will go in after 2
    }
};


#endif //STACK_QUES_PRIORITYQUEUE_H
