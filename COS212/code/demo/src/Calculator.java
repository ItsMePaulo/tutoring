public class Calculator {

    public int add(int x, int y) {
        System.out.println("Hello world");
        return x + y;
    }

    public int minus(int x, int y) {
        return x - y;
    }

    public int multiply(int x, int y) {
        return x * y;
    }

    public int divide(int x, int y) {
        if (y == 0) {
            return 0;
        } else {
            return x / y;
        }
        // return y == 0 ? 0 : x/y;
    }
}
