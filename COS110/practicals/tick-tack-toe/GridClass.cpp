//
// Created by paul on 2/17/20.
//

#include "GridClass.h"
#include <iostream>

using namespace std;

int getOffset(int);

GridClass::GridClass() {

    for (int x = 0; x < sizeof(grid[0]); x++) {
        for (int y = 0; y < sizeof(grid[0]); y++) {
            if (x == 5 || y == 5 || x == 11 || y == 11) {
                grid[x][y] = '#';
            } else {
                grid[x][y] = ' ';
            }
        }
    }
}

void GridClass::printGrid() {

    for (int x = 0; x < sizeof(grid[0]); x++) {
        for (int y = 0; y < sizeof(grid[0]); y++) {
            // format the grid add blank spaces to leftmost fields
            if (y == 0) {
                cout << "\t\t\t\t\t\t" << grid[x][y] << " ";
            } else {
                cout << grid[x][y] << " ";
            }
        }
        cout << endl;
    }
}

/**
 * Prints a 3x3 X given player input: Drawing an X can be done in any 3x3 matrix given the following condition: 
 * co-ordinates x && y != 1 but if they are they equal 1 they are = at the same time. 
 * This condition returns true for positions at the corners of the 3x3 matrix and the centre position.
 * But the player will not always select the first block in the grid. We must move the X to the 
 * right co-ordinates in the grid by adding the offsets at the right positions. 
 * 
 * @param row: The player selected row 
 * @param column:  The player selected column 
 */
void GridClass::drawX(int row, int column) {
    int xOffest = getOffset(row);
    int yOffest = getOffset(column);

    // start at xOffset end at offset + 3
    for (int x = xOffest; x < (xOffest + 3); x++) {
        // start at yOffset end at offset + 3 result is a 3x3 matrix
        for (int y = yOffest; y < (yOffest + 3); y++) {
            
            //condition holds for offsets + 1 
            if ((x != (xOffest + 1) && y != (yOffest + 1)) || (x == (xOffest + 1) && y == (yOffest + 1))) {
                grid[x][y] = 'X';
            } else {
                grid[x][y] = ' ';
            }
        }
    }


    printGrid();
}

/**
 * Prints a 3x3 O given player input. Drawing a 3x3 0 matrix given the following condition: 
 * if(x == 1) then y != 1 => when position is not at x == 1 and y == 1 
 * This results in a circle being drawn around the centre. But we must add the player offset to draw 
 * the circle in the right place
 * 
 * @param row: The player selected row 
 * @param column:  The player selected column 
 */

void GridClass::drawO(int row, int column) {

    int xOffset = getOffset(row);
    int yOffset = getOffset(column);

    // start at xOffset end at offset + 3
    for (int x = xOffset; x < (xOffset + 3); x++) {
        // start at yOffset end at offset + 3 result is a 3x3 matrix
        for (int y = yOffset; y < (yOffset + 3); y++) {

            //condition holds for offsets + 1
            if (x == (xOffset + 1) && y == (yOffset + 1)) {
                grid[x][y] = ' ';
            } else {
                grid[x][y] = '0';
            }
        }
    }

    printGrid();
}

int getOffset(int val) {
    return (val - 1) * 6 + 1;
}