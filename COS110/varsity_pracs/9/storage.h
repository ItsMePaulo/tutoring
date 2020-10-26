//
// Created by sparta on 10/26/20.
//

//storage<T>
//-clist: cLL<T>*
//-dlist: dLL<T>*
//-randomSeed:int
//----------------------------
//+storage(rS:int)
//+~storage()
//+storeData(data:T):void
//+printCList():void
//+printDList():void

#ifndef INC_9_STORAGE_H
#define INC_9_STORAGE_H


#include "cLL.h"
#include "dLL.h"

template <class T>
class storage {

private:
    cLL<T>* clist;
    dLL<T>* dlist;
    int randomSeed;
public:
    storage(int rs);
    ~storage();
    void storeData(T data);
    void printCList();
    void printDList();
};




#endif //INC_9_STORAGE_H
