//There is no explicit need to modify this file. But if you do, do not modify the existing method signatures
public class BPlusNode {

    public int keyTally; /* how many keys are currently in this node */
    public BPlusNode branches[];
    public int keys[];
    public boolean leaf; /* true if the node is a leaf*/
    public BPlusNode parent; /* refers to the parent node of this node. Use this if you feel it will assist you */
    protected BPlusNode next; /* refers to the next node only if this node is a leaf node. The last leaf has a next of null. */

    /* constructor */
    public BPlusNode(int m, boolean isLeaf) {
        keys = new int[m - 1];
        branches = new BPlusNode[m]; // order m
        keyTally = 0;
        leaf = isLeaf;
        parent = null;
        next = null; // initialize next to null
    }

    /* returns true if full and false otherwise */
    public boolean isFull() {
        return keyTally == keys.length;
    }

    /* returns a string representation of the node. DO NOT modify */
    public String toString() {
        String o = "[";
        for (int i = 0; i < this.keyTally - 1; i++) {
            o += this.keys[i] + " | ";
        }
        if (this.keyTally - 1 >= 0) {
            o += this.keys[this.keyTally - 1];
        }
        o += "]";
        return o;
    }

    public void insert(int key, int index) {
        keys[index] = key;
        keyTally++;
    }

    public void clear() {
        for (int i = 0; i < keyTally; i++) {
            keys[i] = 0;
        }

        keyTally = 0;
    }

    public void clearChildren() {
        for (int i = 0; i < branches.length; i++) {
            branches[i] = null;
        }
    }
}
