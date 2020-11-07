//
// Created by sparta on 11/5/20.
//

#ifndef STACK_QUES_STACK_H
#define STACK_QUES_STACK_H


#include "list.h"

template <class T>
class stack : public list<T> {
private:
    node<T>* head;

public:
    node<T>* pop() override;
    void push(node<T>* n) override;

    void print() {
        if (head == nullptr) {
            std::cout << "Empty List" << std::endl;
            return;
        }

        auto tmp = head;

        while (tmp->next != nullptr) {
            std::cout << tmp->getItem() << ", ";
            tmp = tmp->next;
        }

        std::cout << tmp->getItem() << std::endl;
    }
};




#endif //STACK_QUES_STACK_H
