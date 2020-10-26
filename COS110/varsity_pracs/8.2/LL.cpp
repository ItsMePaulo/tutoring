#include "LL.h"
#include "item.h"
#include <iostream>

//constructor
template<class T>
LL<T>::LL(int rS) {
    size = 0;
    head = nullptr;
    randomSeed = rS;

    srand(randomSeed);
}

template<class T>
LL<T>::~LL() {
    while(head != nullptr) {
        auto tmp = head;
        head = tmp->next;

        delete(tmp);
    }

    delete head;
}

template<class T>
item<T> * LL<T>::getHead() const {
    return head;
}

template<class T>
void LL<T>::addItem(item<T> *newItem) {

    auto tmp = head;

    if (tmp == nullptr) {
        head = newItem;
        // not necessary but good practice since you do not have control of the creation of the item
        head->next = nullptr;
    } else {
        item<T> *smallest = head;

        // check if next is null will make tmp last element in the list when while loop terminates
        while (tmp->next != nullptr) {
            if (smallest->getData() > tmp->getData()) {
                smallest = tmp;
            }
            tmp = tmp->next;
        }

        // check last item in list
        if (smallest->getData() > tmp->getData()) {
            smallest = tmp;
        }

        if (newItem->getData() <= smallest->getData()) {
            // add to back
            tmp->next = newItem; // tmp points to last element
            // again not necessary but good practice since we have no control of item creation
            newItem->next = nullptr;
        } else {
            // add to front
            newItem->next = head;
            head = newItem;
        }
    }

    size++;
}

template<class T>
void LL<T>::randomShuffleList() {
    if (head == nullptr) {
        return;
    }

    auto index = rand() % size;

    auto tmpHead = head; // 51
    auto value = getItem(index); // 18

    head = value;

    auto tmp = head; // 18
    while (tmp->next != nullptr) {
        tmp = tmp->next;
    }

    tmp->next = tmpHead;

    while (tmp->next != head) {
        tmp = tmp->next;
    }
    tmp->next = nullptr;
}

template<class T>
void LL<T>::randomShuffleList(int i) {
    if (head == nullptr || i < 0 || i >= size) {
        return;
    }

    auto tmpHead = head; // 51
    auto value = getItem(i); // 18

    head = value;

    auto tmp = head; // 18
    while (tmp->next != nullptr) {
        tmp = tmp->next;
    }

    tmp->next = tmpHead;

    while (tmp->next != head) {
        tmp = tmp->next;
    }
    tmp->next = nullptr;
}


template<class T>
T LL<T>::minNode() {
    auto tmp = head;
    item<T> *smallest = head;

    // check if next is null will make tmp last element in the list when while loop terminates
    while (tmp != nullptr) {
        if (smallest->getData() > tmp->getData()) {
            smallest = tmp;
        }
        tmp = tmp->next;
    }

    return smallest->getData();
}

template<class T>
T LL<T>::maxNode() {
    auto tmp = head;
    item<T> *largest = head;

    // check if next is null will make tmp last element in the list when while loop terminates
    while (tmp != nullptr) {
        if (largest->getData() < tmp->getData()) {
            largest = tmp;
        }
        tmp = tmp->next;
    }

    return largest->getData();
}

template<class T>
item<T> *LL<T>::getItem(int i) const {
    auto tmp = head;
    int index = 0;

    while (tmp != nullptr && i != index) {
        tmp = tmp->next;
        index++;
    }

    if (tmp != nullptr) {
        return tmp;
    } else {
        return nullptr;
    }
}

template<class T>
int const LL<T>::getSize() {
    int count = 0;
    auto tmp = head;

    while (tmp != nullptr) {
        tmp = tmp->next;
        count++;
    }

    return count;
}

template<class T>
void LL<T>::printList() {

    auto tmp = head;

    if (tmp == nullptr) {
        return;
    }

    // finds the last value in the list but does not print the last value just yet
    while (tmp->next != nullptr) {
        std::cout << tmp->getData() << ",";
        tmp = tmp->next;
    }

    // now we can print the last value and the endline that is required in the spec
    std::cout << tmp->getData() << std::endl;
}

template<class T>
item<T> *LL<T>::pop() {
    if (head == nullptr) {
        return nullptr;
    }

    auto oldHead = head;
    head = head->next;

    size--;
    return oldHead;
}




