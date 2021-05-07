import java.util.Random;

public class Test {
    static class NotEqualsException extends Exception {

        NotEqualsException(String message) {
            super(message);
        }

    }

    public static void main(String[] args) {
        // Write code to test your implementation here.

        System.out.println("======================= Testing the insert method: =======================================");

        try {
            testInsertMethods();
            System.out.println("\033[32mSUCCESSFULLY: Completed testInsert(), method passed all tests \033[0m");
        } catch (NotEqualsException e) {
            System.out.printf("\033[31mERROR: \033[0m Could not complete action test \"INSERT\" method failed with exception: %s%n", e);
        }

        System.out.println("======================= Testing the peek min method: ====================================");

        try {
            testPeekMin();
            System.out.println("\033[32mSUCCESSFULLY: Completed testInsert(), method passed all tests \033[0m");
        } catch (NotEqualsException e) {
            System.out.printf("\033[31mERROR: \033[0m Could not complete action test \"INSERT\" method failed with exception: %s%n", e);
        }


    }

    private static void testPeekMin() throws NotEqualsException {
        System.out.println("Testing Peek min on a Binary Heap");
        tesPeekMinInBinary();
        System.out.println("Testing Peek min on a Ternary Heap");
        tesPeekMinInTernary();
        System.out.println("Testing Peek min on a D Heap");
        tesPeekMinInD();
    }

    private static void tesPeekMinInD() throws NotEqualsException {
        testMinMethod(4);
        testMinMethod(8);
        testMinMethod(6);
        testMinMethod(10);
    }

    private static void tesPeekMinInTernary() throws NotEqualsException {
        testMinMethod(3);
    }

    private static void tesPeekMinInBinary() throws NotEqualsException {
        testMinMethod(2);
    }

    private static void testMinMethod(Integer order) throws NotEqualsException {
        MinMaxDHeap<Integer> testHeap1 = new MinMaxDHeap<>(order);

        assertNull(testHeap1.peekMin());

        testHeap1.insert(10, 10);
        assertEquals(10, testHeap1.peekMin());

        testHeap1.insert(4, 3);
        assertEquals(4, testHeap1.peekMin());

        testHeap1.insert(26, 26);
        assertEquals(4, testHeap1.peekMin());

        testHeap1.insert(100, 1);
        assertEquals(100, testHeap1.peekMin());
    }

    private static void testInsertMethods() throws NotEqualsException {
        System.out.println("Testing Insert on a Binary Heap");
        testInsertInBinary();
        System.out.println("Testing Insert on a Ternary Heap");
        testInsertInTernary();
        System.out.println("Testing Insert on a D Heap");
        testInsertInD();
    }


    private static void testInsertInBinary() throws NotEqualsException {

        MinMaxDHeap<Integer> testHeap1 = new MinMaxDHeap<>(2);

        Random rand = new Random(5);

        for (int i = 0; i < 12; i++) {
            int x = Math.abs(rand.nextInt() % 50);
            testHeap1.insert(x, x);
        }

        assertEquals("8,48,48,13,21,36,13,34,44,42,33,39", testHeap1.toString());

        MinMaxDHeap<Integer> testHeap2 = new MinMaxDHeap<>(2); // binary heap
        for (int i = 1; i <= 36; i++) {
            testHeap2.insert(i, i);
        }

        assertEquals("1,36,31,2,4,3,6,34,35,20,22,24,26,28,30,5,11,8,17,9,19,10,21,7,15,12,25,13,27,14,29,16,23,32,33,18", testHeap2.toString());
    }

    private static void testInsertInTernary() throws NotEqualsException {

    }

    private static void testInsertInD() throws NotEqualsException {

    }

    static <T extends Comparable<T>, A extends Comparable<A>> void assertEquals(T expected, A actual) throws NotEqualsException {

        if (expected.equals(actual)) {
            return;
        }

        throw new NotEqualsException(String.format("Fields not equal expected value: %s actual value: %s", expected, actual));
    }

    static <T> void assertNull(T expected) throws NotEqualsException {
        if (expected != null) {
            throw new NotEqualsException(String.format("Field: %s was expected to be null but was not null", expected));
        }
    }


}
