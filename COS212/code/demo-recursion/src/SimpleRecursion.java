import java.util.Random;

public class SimpleRecursion {

    private int[] array;

    static public void hello() {
        System.out.println("Hello");
    }


    public SimpleRecursion(int size) {

        array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = new Random().nextInt() % 20;
        }
    }


    // TODO convert this method to a recursive method
    public void simpleWhileLoop() {

        int i = 0;
        while (i < array.length) {
            System.out.println(array[i++]);
        }
    }

    public void simpleRecursiveFunc(int i) {
        if (i >= array.length) {
            return;
        }
        else {
            System.out.println(array[i]);
            simpleRecursiveFunc(i + 1);
        }
    }


    // TODO convert this method to a recursive method
    public int countVowels(String s) {
        int counter = 0;

        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                counter++;
            }
        }

        return counter;
    }

    public int countVowelsRecursive(String word, int i) {
        return (i >= word.length()) ? 0 : (isVowel(word.charAt(i)))
                ? 1 + countVowelsRecursive(word, i + 1) : countVowelsRecursive(word, i + 1);
    }


    // TODO convert this method to a iterative method
    public int method(int x, int y) {

        if ((y < x) && (x % y == 0)) {
            return y;
        }

        if (x < y) {
            return method(y, x); // x = 4; y= 15
        }

        return method(y, x % y);
    }


    public int methodIterative(int x, int y) {

        while ((y > x) || (x % y != 0)) {
            int tmp = x;
            if (x < y) {
                x = y;
                y = tmp;
            } else {
                x = y;
                y = tmp % y;
            }
        }

        return y;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

}
