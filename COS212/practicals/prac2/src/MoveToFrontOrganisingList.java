/**
 * Name:
 * Student Number:
 */

public class MoveToFrontOrganisingList extends OrganisingList {

    ////// Implement the function below this line //////

    /**
     * Retrieve the node with the specified key and move the accessed node
     * to the front, then recalculate all data fields.
     *
     * @return The node with its data value before it has been moved to the front,
     * otherwise 'null' if the key does not exist.
     */
    @Override
    public ListNode searchNode(Integer key) {

        //Your code goes here
        ListNode tmp = root;
        ListNode prev = null;

        // no need to check for an empty list
        while (tmp != null && !tmp.key.equals(key)) {

            prev = tmp; // need to update prev before tmp
            tmp = tmp.next;
        }

        if (tmp != null && prev != null) {
            prev.next = tmp.next;
            tmp.next = root;
            root = tmp;

        }

        ListNode result =  (tmp != null) ? new ListNode(tmp.key, tmp.data) : null;

        calculateData();
        return result;
    }


}
