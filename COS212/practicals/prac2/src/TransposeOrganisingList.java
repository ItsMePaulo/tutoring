/**
 * Name:
 * Student Number:
 */

public class TransposeOrganisingList extends OrganisingList {

    ////// Implement the function below this line //////

    /**
     * Retrieve the node with the specified key and swap the
     * accessed node with its predecessor, then recalculate all data fields.
     *
     * @return The node with its data value before it has been moved,
     * otherwise 'null' if the key does not exist.
     */
    @Override
    public ListNode searchNode(Integer key) {

        //Your code goes here
        if (root == null || root.key.equals(key)) {
            return null;
        }

        // this is a safe assignment
        ListNode tmp = root.next, prev = root, prevPrev = null;

        while (tmp != null && !tmp.key.equals(key)) {

            prevPrev = prev; // need update prevPrev before we override prev
            prev = tmp; // need to update prev before tmp
            tmp = tmp.next;
        }

        if (tmp != null) {
            // check for?
            if (prevPrev == null) {
                prev.next = tmp.next;
                tmp.next = prev;
                root = tmp;
            } else {
                //      PP   P    T
                // 1 -> 2 -> 3 -> 4 -> 5 => before

                prevPrev.next = tmp;
                prev.next = tmp.next;
                tmp.next = prev;

                //      PP   T    P
                // 1 -> 2 -> 4 -> 3 -> 5 => After
            }
        }

        ListNode result =  (tmp != null) ? new ListNode(tmp.key, tmp.data) : null;
        calculateData();
        return result;
    }


}
