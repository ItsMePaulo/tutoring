#include <iostream>
#include "GridClass.h"

using namespace std;

void playTickTackToe(int, GridClass*);
int swapPlayer(int);

int main() {

    GridClass *gridClass = new GridClass();
    int player = 0;

    cout << "Who goes first player 1 or 2?: ";
    cin >> player;

    if(player > 2 || player < 1) {
        player = 1;
    }

    cout << "=======================================================================================" << endl;
    cout << "                                  Tick-Tack-Toe                                  " << endl;
    cout << "=======================================================================================" << endl;
    cout << endl;
    gridClass -> printGrid();

    playTickTackToe(player, gridClass);

    return 0;
}

void playTickTackToe(int player, GridClass* grid) {
    int round = 0;

    while (round < 9) {
        round++;

        int row;
        int column;
        cout << endl;
        cout << "Player " << player << " please enter a row from 1 - 3: ";
        cin >> row;

        cout << "Pleas enter a column from 1-3: ";
        cin >> column;

        if(player == 1) {
            grid -> drawX(row, column);
        } else {
            grid -> drawO(row, column);
        }

        player = swapPlayer(player);
    }
}

int swapPlayer(int currentPlayer) {
    return (currentPlayer == 1) ? 2 : 1;
}

