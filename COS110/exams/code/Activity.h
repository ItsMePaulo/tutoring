//
// Created by momo on 9/17/20.
//

#ifndef CODE_ACTIVITY_H
#define CODE_ACTIVITY_H

#include <iostream>

class Activity {
private:
    std::string description;
    int priority;
public:
    Activity(const std::string &d, int p) {
        description = d;
        priority = p;
    }

    std::string getDescription() {
        return description;
    }

    int getPriority() {
        return priority;
    }

    Activity();
};


#endif //CODE_ACTIVITY_H
