public class Queens {

    private final boolean available = true;
    private final int squares = 4, norm = squares - 1;
    private int[] positionInRow = new int[squares];

    private boolean[] column = new boolean[squares];
    private boolean[] leftDiagonal = new boolean[squares * 2 - 1];
    private boolean[] rightDiagonal = new boolean[squares * 2 - 1];

    private int howMany = 0;


    public Queens() {

        for (int i = 0; i < squares; i++) {
            positionInRow[i] = -1;
            column[i] = available;
        }

        for (int i = 0; i < squares * 2 - 1; i++) {
            leftDiagonal[i] = rightDiagonal[i] = available;
        }
    }

    private void printBoard() {
        for (int i = 0; i < squares; i++) {
            for (int j = 0; j < squares; j++) {
                if (j == positionInRow[i]) {
                    System.out.print("👑 ");
                } else {
                    System.out.print("⬜ ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * The put queen algorithm works it's way down the chess board attempting to add a queen at each row, if the
     * Queen can be added at the row places the queen and updates all fields where a queen can no longer be added.
     * In the case that no Queen can be added at any of the column backtracks to the previous queen and moves the
     * queen at that row to it's next valid space
     */
    public void putQueen(int row) {
        for (int col = 0; col < squares; col++) {

            if (column[col] == available && leftDiagonal[row + col] == available && rightDiagonal[row - col + norm]) {

                positionInRow[row] = col;
                column[col] = !available;
                leftDiagonal[row + col] = !available;
                rightDiagonal[row - col + norm] = !available;

                if (row < squares - 1) {
                    printBoard();
                    putQueen(row + 1);
                } else {
                    printBoard();
                }

                positionInRow[row] = -1;
                column[col] = available;
                leftDiagonal[row + col] = available;
                rightDiagonal[row - col + norm] = available;
            }
        }
    }
}
