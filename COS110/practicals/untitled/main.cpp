#include <iostream>


template <class T*>
class Traveler {
    T** inventory;
    int size;
public:
    Traveler(int size);
    ~Traveler();
    T* getItem(int i);
    bool contains(const T* item);
};



int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}
