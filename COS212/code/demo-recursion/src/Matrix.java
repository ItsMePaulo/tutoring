public class Matrix {

    private int size;
    private double[][] matrix;

    public Matrix(int s) {
        size = s;
        matrix = new double[size][size];

        int counter = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = counter++;
            }
        }
    }

    public Double derive() {
        return deriveMatrix(this);
    }

    private double deriveMatrix(Matrix matrix) {

        /**
         *  if (matrix.size == 2) => call derive2By2
         *      else {
         *          subM = foreach col filterMatrix(0, col)
         *          matrix[0][col] * deriveMatrix(subM)
         *      }
         */

        return 0.0;
    }

    /**
     * Returns a smaller subset the matrix passed in without the row of the value passed in and without the column of the
     * value passed in. Smaller matrix is 1 less than the Matrix passed in
     */
    public double[][] filterMatrix(int row, int column) {
        double[][] subMatrix = new double[matrix.length - 1][matrix.length -1 ];

        for (int i =0; i < subMatrix.length; i++) {
            for (int j = 0; j < subMatrix.length; j++) {
                int tmpRow = (i >= row) ? i + 1 : i;
                int tmpCol = (j >= column) ? j + 1 : j;

                subMatrix[i][j] = matrix[tmpRow][tmpCol];
            }
        }

        return subMatrix;
    }

    public double derive2By2(Matrix matrix) {
        return (matrix.matrix[0][0] * matrix.matrix[1][1]) - (matrix.matrix[0][1] * matrix.matrix[1][0]);
    }

    void printMatrix() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(String.format("%-8s", matrix[i][j]));
            }
            System.out.println();
        }
    }

}
