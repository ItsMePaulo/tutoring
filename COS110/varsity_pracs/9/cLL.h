//
// Created by sparta on 10/26/20.
//

//cLL<T>
//-head:citem<T> *
//-size:int
//------------------------
//+cLL()
//+~cLL()
//+isEmpty():bool
//+getSize():int
//+push(newItem: citem<T>*):void
//+pop():item<T>*
//+removeAt(x:T):citem<T> *
//+printList():void

#ifndef INC_9_CLL_H
#define INC_9_CLL_H

#include "citem.h"

template<class T>
class cLL {
private:
    citem<T>* head;
    int size;

public:
    cLL();
    ~cLL();
    bool isEmpty();
    int getSize();
    void push(citem<T> * newItem);
    citem<T>* pop();
    citem<T>* removeAt(T x);
    void printList();
};


#include "cLL.cpp"
#endif //INC_9_CLL_H
