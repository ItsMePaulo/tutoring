//
// Created by sparta on 11/5/20.
//

#ifndef STACK_QUES_QUEUE_H
#define STACK_QUES_QUEUE_H


#include "list.h"

template <class T>
class queue : public list<T> {

    node<T> pop() override;
    void push(node<T> n) override;
};



#endif //STACK_QUES_QUEUE_H
