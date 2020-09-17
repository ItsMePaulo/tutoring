//
// Created by momo on 9/9/20.
//
#include "iostream"

class Player {
private:
    int health;
public:
    explicit Player(int h) {
        health = h;
    }

    void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            std::cout << "I am dead" << std::endl;
        }
    }
};

// base class
class Enemy {
public:
    int attack(Player *player) {
        player->takeDamage(5);
    }
};


void enemyTakeDamage(Enemy *enemy, Player *player) {
    enemy->attack(player);
}

int test() {

    Player *player = new Player(100);

    return 0;
};


