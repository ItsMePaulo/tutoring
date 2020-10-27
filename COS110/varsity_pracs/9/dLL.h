//
// Created by sparta on 10/26/20.
//

#ifndef INC_9_DLL_H
#define INC_9_DLL_H


//dLL<T>
//-head: ditem<T>*
//-tail: ditem<T>*
//-size: int
//----------------------------
//+dLL()
//+~dLL()
//+getHead(): ditem<T>*
//+getTail(): ditem<T>*
//+push(newItem:ditem<T>*):void
//+pop():ditem<T>*
//3+getItem(i:int):ditem<T>*
//+minNode():T
//+getSize():int
//+printList():void

#include "ditem.h"

template <class T>
class dLL {
private:

    ditem<T>* head;
    ditem<T>* tail;
    int size;

public:
    dLL();
    ~dLL();
    ditem<T>* getHead();
    ditem<T>* getTail();
    void push(ditem<T>* newItem);
    ditem<T>* pop();
    ditem<T>* getItem(int i);
    T minNode();
    int getSize();
    void printList();
};


#include "dLL.cpp"
#endif //INC_9_DLL_H
