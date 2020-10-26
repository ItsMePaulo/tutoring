#ifndef INC_8_2_ITEM_H
#define INC_8_2_ITEM_H

template <class T>
class item {

private:
    T data;

public:
    item(T t);
    ~item();
    item* next;
    T getData();
};


#endif //INC_8_2_ITEM_H
