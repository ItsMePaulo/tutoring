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
            testDeleteByMergePredecessor();
            System.out.println("\033[32mSUCCESSFULLY: Completed testByDeleteMergePredecessor(), method passed all tests \033[0m");
        } catch (NotEqualsException e) {
            System.out.printf("\033[31mERROR: \033[0m Could not complete action test \"DELETE_BY_MERGING_PRED\" method failed with exception: %s%n", e);
        }

        try {
            testDeleteByMergingSuccessor();
            System.out.println("\033[32mSUCCESSFULLY: Completed testByDeleteMergeSuccessor(), method passed all tests \033[0m");
        } catch (NotEqualsException e) {
            System.out.printf("\033[31mERROR: \033[0m Could not complete action test \"DELETE_BY_MERGING_SUCC\" method failed with exception: %s%n", e);
        }

        try {
            testDeleteByCopyingPredecessor();
            System.out.println("\033[32mSUCCESSFULLY: Completed testByDeleteCopying(), method passed all tests \033[0m");
        } catch (NotEqualsException e) {
            System.out.printf("\033[31mERROR: \033[0m Could not complete action test \"DELETE_BY_COPYING\" method failed with exception: %s%n", e);
        }
    }

    private static void testDeleteByCopyingPredecessor() throws NotEqualsException {
        BinaryTree<Integer> tree = new BinaryTree<>();

        Integer returnedValue = tree.deleteByCopyingPredecessor(12);
        assertNull(returnedValue);

        tree.add(10);
        tree.add(5);
        tree.add(3);
        tree.add(8);
        tree.add(7);
        tree.add(9);
        tree.add(20);
        tree.add(15);
        tree.add(30);
        tree.add(25);
        tree.add(45);
        tree.add(32);

        String breadthFirst = tree.breadthFirst();
        assertEquals("10,5,20,3,8,15,30,7,9,25,45,32", breadthFirst);

        returnedValue = tree.deleteByCopyingPredecessor(10);
        breadthFirst = tree.breadthFirst();
        assertEquals("9,5,20,3,8,15,30,7,25,45,32", breadthFirst);


    }

    private static void testDeleteByMergePredecessor() throws NotEqualsException {
        BinaryTree<Integer> tree = new BinaryTree<>();

        Integer returnedValue = tree.deleteByMergingPredecessor(12);
        assertNull(returnedValue);

        tree.add(10);
        tree.add(5);
        tree.add(3);
        tree.add(8);
        tree.add(7);
        tree.add(9);
        tree.add(20);
        tree.add(15);
        tree.add(30);
        tree.add(25);
        tree.add(45);
        tree.add(32);

        String breadthFirst = tree.breadthFirst();
        assertEquals("10,5,20,3,8,15,30,7,9,25,45,32", breadthFirst);

        returnedValue = tree.deleteByMergingPredecessor(10);
        breadthFirst = tree.breadthFirst();
        assertEquals(10, returnedValue);
        assertEquals("5,3,8,7,9,20,15,30,25,45,32", breadthFirst);

        returnedValue = tree.deleteByMergingPredecessor(9);
        breadthFirst = tree.breadthFirst();
        assertEquals(9, returnedValue);
        assertEquals("5,3,8,7,20,15,30,25,45,32", breadthFirst);

        tree.deleteByMergingPredecessor(45);
        breadthFirst = tree.breadthFirst();
        assertEquals("5,3,8,7,20,15,30,25,32", breadthFirst);

        returnedValue = tree.deleteByMergingPredecessor(45);
        breadthFirst = tree.breadthFirst();
        assertNull(returnedValue);
        assertEquals("5,3,8,7,20,15,30,25,32", breadthFirst);

        tree.deleteByMergingPredecessor(8);
        breadthFirst = tree.breadthFirst();
        assertEquals("5,3,7,20,15,30,25,32", breadthFirst);

        returnedValue = tree.deleteByMergingPredecessor(3);
        breadthFirst = tree.breadthFirst();
        assertEquals(3, returnedValue);
        assertEquals("5,7,20,15,30,25,32", breadthFirst);

        returnedValue = tree.deleteByMergingPredecessor(5);
        breadthFirst = tree.breadthFirst();
        assertEquals(5, returnedValue);
        assertEquals("7,20,15,30,25,32", breadthFirst);

        tree.deleteByMergingPredecessor(7);
        tree.deleteByMergingPredecessor(20);
        tree.deleteByMergingPredecessor(15);
        tree.deleteByMergingPredecessor(30);
        tree.deleteByMergingPredecessor(25);
        tree.deleteByMergingPredecessor(32);

        assertNull(tree.getRoot());
    }

    private static void testDeleteByMergingSuccessor() throws NotEqualsException {
        BinaryTree<Integer> tree = new BinaryTree<>();

        Integer returnedValue = tree.deleteByMergingPredecessor(12);
        assertNull(returnedValue);

        tree.add(10);
        tree.add(5);
        tree.add(3);
        tree.add(8);
        tree.add(7);
        tree.add(9);
        tree.add(20);
        tree.add(15);
        tree.add(30);
        tree.add(25);
        tree.add(45);
        tree.add(32);

        String breadthFirst = tree.breadthFirst();
        assertEquals("10,5,20,3,8,15,30,7,9,25,45,32", breadthFirst);

        returnedValue = tree.deleteByMergingSuccessor(10);
        breadthFirst = tree.breadthFirst();
        assertEquals("20,15,30,5,25,45,3,8,32,7,9", breadthFirst);
        assertEquals(10, returnedValue);

        returnedValue = tree.deleteByMergingSuccessor(30);
        breadthFirst = tree.breadthFirst();
        assertEquals("20,15,45,5,32,3,8,25,7,9", breadthFirst);
        assertEquals(30, returnedValue);

        returnedValue = tree.deleteByMergingSuccessor(8);
        breadthFirst = tree.breadthFirst();
        assertEquals("20,15,45,5,32,3,9,25,7", breadthFirst);
        assertEquals(8, returnedValue);

        tree.deleteByMergingSuccessor(45);
        tree.deleteByMergingSuccessor(32);
        tree.deleteByMergingSuccessor(25);
        tree.deleteByMergingSuccessor(25);

        breadthFirst = tree.breadthFirst();
        assertEquals("20,15,5,3,9,7", breadthFirst);

        tree.deleteByMergingSuccessor(20);
        breadthFirst = tree.breadthFirst();
        assertEquals("15,5,3,9,7", breadthFirst);

        tree.deleteByMergingSuccessor(15);
        tree.deleteByMergingSuccessor(5);
        breadthFirst = tree.breadthFirst();
        assertEquals("9,7,3", breadthFirst);

        tree.deleteByMergingSuccessor(9);
        tree.deleteByMergingSuccessor(7);
        tree.deleteByMergingSuccessor(3);

        assertNull(tree.getRoot());
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

    static <T> void assertNull(T expected) throws NotEqualsException {
        if (expected != null) {
            throw new NotEqualsException(String.format("Field: %s was expected to be null but was not null", expected));
        }
    }

}
