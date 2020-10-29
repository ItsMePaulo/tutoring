//
// Created by sparta on 10/26/20.
//

#include "citem.h"
#include <iostream>

template<class T>
citem<T>::citem(T t) {
    data = t;
}

template<class T>
citem<T>::~citem() {
    std::cout << data <<" Deleted\n";
}

template<class T>
T citem<T>::getData() {
    return data;
}
