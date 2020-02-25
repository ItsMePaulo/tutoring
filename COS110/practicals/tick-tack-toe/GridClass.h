//
// Created by paul on 2/17/20.
//

#ifndef TICK_TACK_TOE_GRIDCLASS_H
#define TICK_TACK_TOE_GRIDCLASS_H

/*
 * #***#***#***#
 *
 *
 */

class GridClass {

private:
    char grid[17][17];

public:
    GridClass();
    void printGrid();

    void drawX(int row, int column);
    void drawO(int row, int column);

};


#endif //TICK_TACK_TOE_GRIDCLASS_H
