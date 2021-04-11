public class Main {

    public static void main(String[] args) {

        int[] testArray = new int[8];

        for (int i = 0; i < 8; i++) {
            testArray[i] = i + 1;
        }


        print(0, testArray);
        System.out.println();
        reverse(0, testArray);

        System.out.println();

        System.out.println(pow(2, 4));
        System.out.println(fact(4));


        // set a break point here to debug simple Recursion class, part 1 of recursion
        SimpleRecursion sr = new SimpleRecursion(7);
        sr.simpleRecursiveFunc(0);

        System.out.println("All the vowels" + sr.countVowelsRecursive("hello world", 0));

        sr.method(4, 15);
        sr.methodIterative(4, 15);


        // set a break point here to debug the Matrix recursion demo part 2 of recursion
        System.out.println();
        Matrix matrix = new Matrix(4);
        matrix.printMatrix();

        System.out.println("The Matrix derived is: " + matrix.derive());

        // set a break point here to debug the queen recursion demo, part 3 of recursion
        Queens queens = new Queens();
        System.out.println();
        queens.putQueen(0);
    }

    static public void print(int index, int[] array) {
        if (index >= array.length) {
            return;
        }

        System.out.print(array[index] + ", ");
        print(index + 1, array);
    }

    static public void reverse(int index, int[] array) {
        if (index >= array.length) {
            return;
        }

        reverse(index + 1, array);
        System.out.print(array[index] + ", ");
    }


    static public int pow(int base, int power) {
        if (power == 0) {
            return 1;
        }

        return base * pow(base, power - 1);
    }


    static public int fact(int base) {
        if (base == 0) {
            return 1;
        }

        return base * fact(base - 1);
    }
}
