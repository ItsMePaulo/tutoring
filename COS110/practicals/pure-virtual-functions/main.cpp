#include <iostream>


class Evil {
public:
    void attack() {
        std::cout << "I'm bad" << std::endl;
    }
};

class EnemyFactory {

public:
    virtual void attack() = 0;
};

class EasyEnemy : protected EnemyFactory, Evil {

public:
    void attack() override {
        std::cout << "Taking small damage" << std::endl;
    }
};

class EasyMonster : public EasyEnemy {

};

class MediumEnemy : public EnemyFactory {

public:

    void attack() override {
        std::cout << "Taking medium damage";
    }
};


int main() {

    EasyEnemy e;

    EasyMonster em;


    e.attack();

    return 0;
}
