//
// Created by sparta on 10/26/20.
//

#ifndef INC_9_DITEM_H
#define INC_9_DITEM_H

//ditem <T>
//-data:T
//-------------------
//+ditem(t:T)
//+~ditem()
//+next: ditem*
//+prev: ditem*
//+getData():T


template <class T>
class ditem {
private:
    T data;
public:
    ditem(T t);
    ~ditem();
    ditem *next;
    ditem *prev;
    T getData();
};




#endif //INC_9_DITEM_H
