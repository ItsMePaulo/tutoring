#include <iostream>

template<class T>
T max(T val1, T val2) {
//    paul = 0;

    return val1 > val2 ? val1 : val2;
}

template<class T, class U>
void functionWithTwoTemplateParams(T val1, U val2) {
    std::cout << "param1: " << val1 << std::endl;
    std::cout << "param2: " << val2 << std::endl;
}

template <typename T>
class Paul {
public:
    T type;
};



int main() {
    std::cout << max(1, 2) << std::endl;
    std::cout << max('a', 'x') << std::endl;
    std::cout << max(1.5, 1.5) << std::endl;

    functionWithTwoTemplateParams(23, "Paul");
    functionWithTwoTemplateParams("Paul", 23);
    functionWithTwoTemplateParams("Paul", "Paul");

    Paul<int> p;

    p.type;

//    max(paul, zelda);

    return 0;
}
