#include "item.h"
#include <iostream>

template<class T>
item<T>::item(T i) {
    data = i;
}

template<class T>
item<T>::~item() {
    std::cout << data << " Deleted" << std::endl;
}

template<class T>
T item<T>::getData() {
    return data;
}

