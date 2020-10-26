//
// Created by sparta on 10/23/20.
//

#ifndef INC_8_2_LL_H
#define INC_8_2_LL_H

#include "item.h"

template <class T>
class LL {
private:
    item<T>* head;
    int size;
    int randomSeed;

public:
    LL(int rS);
    ~LL();
    item<T>* getHead() const;
    void addItem(item<T>* newItem);
    void randomShuffleList();
    void randomShuffleList(int i);
    item<T>* pop();
    item<T>* getItem(int i) const;
    T minNode();
    T maxNode();
    int const getSize();
    void printList();
};


#endif //INC_8_2_LL_H
