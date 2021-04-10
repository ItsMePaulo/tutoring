public class Main {

    public static void main(String[] args) {

        try {
            testInsert();
            System.out.println("\033[32mSUCCESSFULLY: Completed testInsert(), method passed all tests \033[0m");
        } catch (NotEqualsException e) {
            System.out.printf("\033[31mERROR: \033[0m Could not complete action test \"INSERT\" method failed with exception: %s%n", e);
        }


        try {
            testAlternateInsert();
            System.out.println("\033[32mSUCCESSFULLY: Completed testAlternateInsert(), method passed all tests \033[0m");
        } catch (NotEqualsException e) {
            System.out.printf("\033[31mERROR: \033[0m Could not complete action test \"ALTERNATE_INSERT\" method failed with exception: %s%n", e);
        }

    }


    static void testInsert() throws NotEqualsException {
        BinaryTree<Integer> testAdd = new BinaryTree<Integer>();

        testAdd.add(5);
        testAdd.add(10);
        testAdd.add(12);
        testAdd.add(2);
        testAdd.add(4);

        testTreeInsert(testAdd);
    }

    static void testAlternateInsert() throws NotEqualsException {
        BinaryTree<Integer> testAdd = new BinaryTree<Integer>();

        testAdd.addAlternate(5);
        testAdd.addAlternate(10);
        testAdd.addAlternate(12);
        testAdd.addAlternate(2);
        testAdd.addAlternate(4);

        testTreeInsert(testAdd);
    }

    static <T extends Comparable<T>> void testTreeInsert(BinaryTree<T> testAdd) throws NotEqualsException {
        BinaryNode<T> root = testAdd.getRoot();
        assertEquals(5, root.key);
        assertEquals(10, root.right.key);
        assertEquals(12, root.right.right.key);
        assertEquals(2, root.left.key);
        assertEquals(4, root.left.right.key);
    }

    static <T extends Comparable<T>, A extends Comparable<A>> void assertEquals(T expected, A actual) throws NotEqualsException {

        if (expected.equals(actual)) {
            return;
        }

        throw new NotEqualsException(String.format("Fields not equal expected value: %s actual value: %s", expected, actual));
    }

}
