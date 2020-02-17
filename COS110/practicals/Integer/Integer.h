//
// Created by paul on 2/15/20.
//

#ifndef INTEGER_INTEGER_H
#define INTEGER_INTEGER_H

#include <string>

class Integer {
private:
    int val;
public:

    int getVal();

    void setVal(int v);

    bool isOdd();

    bool isEven();

    // take our number and add number passed in
    int addNumber(int number);

    int minusNumber(int number);

    //take our number and return factorial
    int factorial();

    std::string getFizzBang();
};


#endif //INTEGER_INTEGER_H
