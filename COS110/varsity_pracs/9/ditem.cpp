//
// Created by sparta on 10/26/20.
//

#include "ditem.h"
#include <iostream>

template<class T>
ditem<T>::ditem(T t) {
    data = t;
}

template<class T>
T ditem<T>::getData() {
    return data;
}

template<class T>
ditem<T>::~ditem() {
    std::cout << data <<" Deleted";
}
