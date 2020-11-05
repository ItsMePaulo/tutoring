//
// Created by sparta on 11/5/20.
//

#ifndef STACK_QUES_NODE_H
#define STACK_QUES_NODE_H

template<class T>
class node {
private:
    T item;
public:
    node(T i) {
        item = i;
        next = nullptr;
    }

    T getItem() {
        return item;
    }

    node<T>* next;
};


#endif //STACK_QUES_NODE_H
