//
// Created by paul on 2/17/20.
//

#ifndef TICK_TACK_TOE_VALIDATIONCLASS_H
#define TICK_TACK_TOE_VALIDATIONCLASS_H

#include "GridElements.h"

class ValidationClass {
private:
    GridElements grid[3][3];

public:
    bool isValidNumber(int x);

};


#endif //TICK_TACK_TOE_VALIDATIONCLASS_H
