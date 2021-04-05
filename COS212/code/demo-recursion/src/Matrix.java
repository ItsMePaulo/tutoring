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

    /**
     * Constructor passes in both the size and the array, it is expected that the size of the two dimensional array is
     * equal to the array being passed in
     */
    public Matrix(int s, double[][] array) {
        size = s;
        matrix = new double[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = array[i][j];
            }
        }
    }

    public Double derive() {
        return deriveMatrix(this);
    }

    /**
     * Derives a matrix using Cramars rule, if a matrix comes in with a size greater than two filter the matrix creating a subMatrix
     * of size of Matrix - 1, keep calling derive Matrix on the new subMatrix until matrix size is equal to 2 then call the derive
     * by 2 method.
     * <p>
     * <p>
     * Base case: If size is equal to 2
     * Recursive Case: If Size is greater than 2
     */
    private double deriveMatrix(Matrix matrix) {

        if (matrix.size == 1) {
            return matrix.matrix[0][0];
        } else if (matrix.size == 2) {
            return derive2By2(matrix);
        }

        int negate = 1;
        double sum = 0;

        for (int i = 0; i < size; i++) {
            Matrix subMatrix = filterMatrix(matrix, 0, i);
            sum += matrix.matrix[0][i] * negate * deriveMatrix(subMatrix);

            negate *= -1;
        }


        return sum;
    }

    /**
     * <p>
     * Returns a smaller subset the matrix passed in without the row of the value passed in and without the column of the
     * value passed in. Smaller matrix is 1 less than the Matrix passed in.
     * for example: given a Matrix m, filtered on row = 0 and col = 2 would result in the following
     * m =
     * | 1 2 3 |    |_1_|2|_3_|
     * | 4 5 6 | => | 4 |5| 6 |
     * | 7 8 9 |    | 7 |8| 9 |
     *
     * </p>
     * subM =
     * | 4 6 |
     * | 7 9 |
     *
     * </p>
     */
    public Matrix filterMatrix(Matrix m, int row, int column) {
        double[][] subMatrix = new double[m.matrix.length - 1][m.matrix.length - 1];

        for (int i = 0; i < subMatrix.length; i++) {
            for (int j = 0; j < subMatrix.length; j++) {
                int tmpRow = (i >= row) ? i + 1 : i;
                int tmpCol = (j >= column) ? j + 1 : j;

                subMatrix[i][j] = m.matrix[tmpRow][tmpCol];
            }
        }

        return new Matrix(subMatrix.length, subMatrix);
    }

    /**
     * The derivative of a two by 2 matrix is equal to the difference of the diagonals multiplied ie in a matrix
     * <p>
     * | a b |
     * | c d |
     * <p>
     * the derivative is equal to (a * d) - (c * b)
     *
     * @return
     */
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
