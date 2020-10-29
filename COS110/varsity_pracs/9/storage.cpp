//
// Created by sparta on 10/26/20.
//

#include "storage.h"

template<class T>
storage<T>::storage(int rs) {
    randomSeed = rs;
    clist = nullptr;
    dlist = nullptr;
}

template<class T>
storage<T>::~storage() {
    delete clist;
    delete dlist;
}

template<class T>
void storage<T>::storeData(T data) {

    int value = static_cast<int>(data);
    if (value % 2 == 0) { // even
        // if list is empty
        if(clist == nullptr) {
            clist = new cLL<T>();
        }

        auto newItem = new citem<T>(data);
        clist->push(newItem);
    } else {
        // if list is empty
        if(dlist == nullptr) {
            dlist = new dLL<T>();
        }

        auto newItem = new ditem<T>(data);
        dlist->push(newItem);
    }
}

template<class T>
void storage<T>::printCList() {
    clist->printList();
}

template<class T>
void storage<T>::printDList() {
    dlist->printList();
}
