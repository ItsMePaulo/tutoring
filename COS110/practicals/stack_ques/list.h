//
// Created by sparta on 11/5/20.
//

#ifndef STACK_QUES_LIST_H
#define STACK_QUES_LIST_H

#include "node.h"

template<class T>
class list {

protected:
    node<T> head;
public:
    virtual node<T> pop() = 0;

    virtual void push(node<T> i) = 0;
};


#endif //STACK_QUES_LIST_H
