/**
 * Name:
 * Student Number:
 */

abstract class OrganisingList {

    public ListNode root = null;

    public OrganisingList() {

    }

    /**
     * Calculate the data field of all nodes in the list using the recursive functions.
     */
    public void calculateData() {
        if (root != null) {
            dataRec(root);
        }
    }

    ////// You may not change any code above this line //////

    ////// Implement the functions below this line //////


    //Recursive functions

    /**
     * Calculate the sum of keys recursively, starting with the given node until the end of the list
     *
     * @return The sum of keys from the current node to the last node in the list
     * NOTE: 'int' and not 'Integer' here because it cannot return 'null'
     */
    public static int sumRec(ListNode node) {

        //Your code goes here
        int sum = 0;

        if (node == null) {
            return 0;
        }

        return sum += node.key + sumRec(node.next);
    }

    /**
     * Calculate and set the data for the given node.
     *
     * @return The calculated data for the given node
     * NOTE: 'int' and not 'Integer' here because it cannot return 'null'
     */
    public static int dataRec(ListNode node) {

        //Your code goes here
        int result = 0;

        if (node.next == null) {
            node.data = node.key;
            return node.key;
        }

        node.data = result += node.key * sumRec(node) - dataRec(node.next);
        return result;
    }


    //Organising List functions

    /**
     * Retrieve the node with the specified key, move the node as required and recalculate all data fields.
     *
     * @return The node with its data value before it has been moved, otherwise 'null' if the key does not exist.
     * Implement only in specific subclass!
     */
    public abstract ListNode searchNode(Integer key);

    /**
     * Check if a key is contained in the list
     *
     * @return true if the key is in the list, otherwise false
     */
    public boolean contains(Integer key) {

        //Your code goes here
        if (isEmpty()) {
            return false;
        }

        ListNode tmp = root;
        while (tmp != null) {
            if (tmp.key.equals(key)) {
                return true;
            }
            tmp = tmp.next;
        }

        return false;
    }

    /**
     * Insert a new key into the linked list.
     * New nodes should be inserted at the back.
     * calculateData() should be called after insertion.
     * Duplicate keys should not be added.
     */
    public void insert(Integer key) {


        //Your code goes here
        if (isEmpty()) {
            root = new ListNode(key);
            calculateData();
            return;
        }

        if (root.key.equals(key)) {
            return;
        }

        ListNode tmp = root;

        while (tmp.next != null) {
            if (tmp.key.equals(key)) {
                return;
            }
            tmp = tmp.next;
        }

        tmp.next = new ListNode(key);
        calculateData();
    }

    /**
     * Delete the node with the given key.
     * calculateData() should be called after deletion.
     * If the key does not exist, do nothing.
     */
    public void delete(Integer key) {

        //Your code goes here
        ListNode tmp = root, prev = null;

        while (tmp != null && tmp.key.equals(key)) {
            prev = tmp;
            tmp = tmp.next;
        }

        if (tmp != null) {
            if (prev == null) {
                tmp = tmp.next;
                root = tmp;
            } else {
                prev.next = tmp.next;
            }
            calculateData();
        }
    }


    //Helper functions
    public boolean isEmpty() {
        return root == null;
    }


}
