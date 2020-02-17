//
// Created by paul on 2/17/20.
//

#include "GridClass.h"
#include <iostream>

using namespace std;

GridClass::GridClass() {
    for(int x = 0; x < sizeof(grid[0]); x++) {
        for(int y = 0; y < sizeof(grid[0]); y++) {
            if(x == 4 || y == 4 || x == 8 || y == 8) {
                grid[x][y] = '#';
            } else {
                grid[x][y] = ' ';
            }
        }
    }
}

void GridClass::printGrid() {
    for(int x = 0; x < sizeof(grid[0]); x++) {
        for(int y = 0; y < sizeof(grid[0]); y++) {
           cout << grid[x][y] << " ";
        }
        cout << endl;
    }
}
