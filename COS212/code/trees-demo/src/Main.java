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

        try {
            testHeight();
            System.out.println("\033[32mSUCCESSFULLY: Completed testHeight(), method passed all tests \033[0m");
        } catch (NotEqualsException e) {
            System.out.printf("\033[31mERROR: \033[0m Could not complete action test \"GET_HEIGHT\" method failed with exception: %s%n", e);
        }

        try {
            testDeleteByMergeLeft();
            System.out.println("\033[32mSUCCESSFULLY: Completed testByDeleteMerge(), method passed all tests \033[0m");
        } catch (NotEqualsException e) {
            System.out.printf("\033[31mERROR: \033[0m Could not complete action test \"GET_HEIGHT\" method failed with exception: %s%n", e);
        }

    }

    private static void testDeleteByMergeLeft() throws NotEqualsException {
        BinaryTree<Integer> tree = new BinaryTree<>();

        Integer returnedValue = tree.deleteByMergingLeft(12);
        assertEquals(null, returnedValue);

        tree.add(10);
        tree.add(5);
        tree.add(3);
        tree.add(8);
        tree.add(20);
        tree.add(15);
        tree.add(30);
        tree.add(25);
        tree.add();

    }

    private static void testHeight() throws NotEqualsException {
        BinaryTree<Integer> tree = new BinaryTree<Integer>();

        assertEquals(0, tree.getHeight());

        tree.add(10);
        assertEquals(1, tree.getHeight());

        tree.add(5);
        assertEquals(2, tree.getHeight());

        tree.add(15);
        assertEquals(2, tree.getHeight());

        tree.add(12);
        tree.add(20);
        assertEquals(3, tree.getHeight());

        tree.add(35);
        tree.add(27);
        assertEquals(5, tree.getHeight());

        tree.add(8);
        tree.add(25);
        tree.add(30);
        assertEquals(6, tree.getHeight());
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
