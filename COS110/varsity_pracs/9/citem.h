//
// Created by sparta on 10/26/20.
//

#ifndef INC_9_CITEM_H
#define INC_9_CITEM_H

//citem <T>
//-data:T
//-------------------
//+citem(t:T)
//+~citem()
//+next: citem*
//+getData():T


template <class T>
class citem {
private:
    T data;
public:
    citem(T t);
    ~citem();
    citem<T>* next;
    T getData();
};


#include "citem.cpp"
#endif //INC_9_CITEM_H
