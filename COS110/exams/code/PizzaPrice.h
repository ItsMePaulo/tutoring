//
// Created by momo on 9/17/20.
//

#ifndef COS110_PIZZAPRICE_H
#define COS110_PIZZAPRICE_H


class PizzaPrice {
private:
    std::string name;
    float price;
public:
    PizzaPrice(std::string s, float p) {
        name = s;
        price = p;
    }

    std::string getName() const {
        return name;
    }

    float getPrice() const {
        return price;
    }

    void setPrice(float p) {
        price = p;
    }


    void showVariables() {
        std::cout << price << std::endl;
    }

    //ret name (params) {
        // body
    //}

    PizzaPrice operator*(const float rhs) {
        float newPrice = this->getPrice() * rhs;
        return PizzaPrice(this->getName(), newPrice);
    }
};

//PizzaPrice operator*(PizzaPrice p, float f) {
//    float newPrice = p.getPrice() * rhs;
//    return PizzaPrice(p.getName(), newPrice);
//}


// trick here was that the variable was on the left hand side so we needed to pass in both
PizzaPrice operator-(const float &lhs, const PizzaPrice &rhs) {
    float newPrice = lhs - rhs.getPrice();
    return PizzaPrice(rhs.getName(), newPrice);
}

#endif
