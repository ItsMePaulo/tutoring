#include <iostream>

class NumberList {
private :
    struct SListNode {
        int value;
        struct SListNode *next;
    };

    struct DListNode {
        int value;
        struct DListNode *next;
        struct DListNode *previous;
    };

    struct CListNode {
        int value;
        struct CListNode *next;
    };

    SListNode *head = nullptr; // start
    DListNode *dHead = nullptr; // start
    CListNode *cHead = nullptr; // start

public :

    NumberList() {
        head = nullptr;
    }

    void appendD(int v) {
        auto *newNode = new DListNode;
        newNode->value = v;
        newNode->next = NULL;
        newNode->previous = NULL;

        if(dHead == nullptr) {
            dHead = newNode;
        } else {
            DListNode* tmp = dHead;

            while (tmp->next != nullptr) {
                tmp = tmp->next;
            }

            tmp->next = newNode;
            newNode->previous = tmp;
        }
    }

    void displayD() {
        std::cout << "[ ";
        DListNode *tmp = dHead;

        if (tmp == NULL) {
            std::cout << "List is equal to null" << std::endl;
            return;
        }

        while (tmp->next != NULL) {
            std::cout << tmp->value << ", ";
            tmp = tmp->next;
        }

        std::cout << tmp->value << " ";
        std::cout << "]";
    }


    void appendC(int v) {
        auto *newNode = new CListNode;
        newNode->value = v;
        newNode->next = NULL;

        if (cHead == nullptr) {
            cHead = newNode;
            newNode->next = cHead;
        } else {
            CListNode* tmp = cHead;

            while (tmp->next != cHead) {
                tmp = tmp->next;
            }

            tmp->next = newNode;
            newNode->next = cHead;
        }
    }


    void displayC() {
        std::cout << "[ ";
        CListNode *tmp = cHead;

        if (tmp == NULL) {
            std::cout << "List is equal to null" << std::endl;
            return;
        }

        while (tmp->next != cHead) {
            std::cout << tmp->value << ", ";
            tmp = tmp->next;
        }

        std::cout << tmp->value << " ";
        std::cout << "]" << std::endl;
    }


    // common functions
    // adds to the end
    void append(int value) {
        auto *endNode = new SListNode;
        endNode->value = value;
        endNode->next = NULL;

        if (head == NULL) {
            head = endNode;
        } else {
            SListNode *tmp = head;
            while (tmp->next != NULL) {
                tmp = tmp->next;
            }

            tmp->next = endNode;
        }
    }

    // adds to the front
    void prepend(int value) {
        auto *newHead = new SListNode;
        newHead->value = value;
        newHead->next = head;

        head = newHead;

//        if (head == NULL) {
//            head = newHead;
//        } else {
//            newHead->next = head;
//            head = newHead;
//        }
    }

    void insertNode(int value) {
        // 3 -> 4 -> 5 -> 6 -> 8 -> null
        // 3 -> 4 -> 5 -> 6 -> 8 -> |
        // | <----------------------|
        // 2           <- 6
        // 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> null
        // tp

        // 2 -> 2 -> 2 -> 2.....

        auto *newNode = new SListNode;
        newNode->value = value;
        newNode->next = nullptr;

        if (head == nullptr) {
            head = newNode;
        } else if (newNode->value < head->value) {
            // prepend(newNode->value)
            newNode->next = head;
            head = newNode;
        } else {
            SListNode *tmp = head;
            SListNode *previous = nullptr;

            while (tmp != nullptr && tmp->value < newNode->value) {
                previous = tmp;
                tmp = tmp->next;
            }

            previous->next = newNode;
            newNode->next = tmp;
        }
    }

    void deleteNode(int value) {
        //      87
        // 3 -> 4 -> null
        //      p    tp

        if (head == nullptr) {
            std::cout << "There is nothing you need to delete" << std::endl;
        } else {
            SListNode *tmp = head;
            SListNode *previous = nullptr;

            if (tmp->value == value) {
                head = head->next;
                delete tmp;
            } else {
                while (tmp != nullptr && tmp->value != value) {
                    previous = tmp;
                    tmp = tmp->next;
                }

                if (tmp != nullptr && tmp->value == value) {
                    previous->next = tmp->next;
                    delete tmp;
                } else {
                    std::cout << "The value: "<< value <<" is not found in the list" << std::endl;
                }
            }
        }
    }


    void displayList() {
        std::cout << "[ ";

        SListNode *tmp = head;

        if (tmp == NULL) {
            std::cout << "List is equal to null" << std::endl;
            return;
        }

        while (tmp->next != NULL) {
            std::cout << tmp->value << ", ";

            tmp = tmp->next;
        }

        std::cout << tmp->value << " ";
        std::cout << "]";
    }

    // [4,5,6,7,8,9]
    // append(7) // adds at the end
    // prepend(0)
    // [0,1,2,3,4,5,6,7]
};


int main() {

    NumberList numList;

    numList.append(4);
    numList.append(5);
    numList.append(5);
    numList.append(6);
    numList.append(8);
    numList.prepend(3);

    numList.insertNode(7);
    numList.insertNode(9);
    numList.insertNode(9);
    numList.insertNode(2);
    numList.displayList();
    std::cout << std::endl;
    numList.deleteNode(2);
    numList.deleteNode(6);
    numList.deleteNode(97);
    numList.displayList();
    std::cout << std::endl;

    numList.appendD(4);
    numList.appendD(5);
    numList.appendD(6);
    numList.appendD(7);

    numList.displayD();
    std::cout << std::endl;

    numList.appendC(6);
    numList.appendC(7);
    numList.appendC(2);
    numList.appendC(1);

    numList.displayC();

//        auto *newNode = new ListNode;
//        newNode->value = value;
//        newNode-> next = nullptr;

//        auto *tmp = head;
//        ListNode* previous = nullptr;
//
//        while (tmp != nullptr && tmp->value < newNode->value) {
//            previous = tmp;
//            tmp = tmp->next;
//        }

//        previous->next = newNode;
//        newNode->next = tmp;
}
