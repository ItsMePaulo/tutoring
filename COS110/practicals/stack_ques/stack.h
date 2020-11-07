//
// Created by sparta on 11/5/20.
//

#ifndef STACK_QUES_STACK_H
#define STACK_QUES_STACK_H


#include "list.h"

template <class T>
class stack : public list<T> {
public:

    stack() : list<T>() {}

    node<T>* pop() override;
    void push(node<T>* n) override;
};




#endif //STACK_QUES_STACK_H
