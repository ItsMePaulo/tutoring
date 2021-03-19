public class Main {

    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println("Goodbye");

        System.out.println("World!");

        Calculator calculator = new Calculator();

        System.out.println(calculator.add( 3, 5));

        System.out.println(calculator.multiply(7, 10));

        System.out.println(calculator.divide(4, 0));
        System.out.println(calculator.divide(4, 2));

    }
}
