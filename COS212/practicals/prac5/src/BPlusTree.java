/*
	You may not change the signatures of any of the given methods.  You may 
	however add any additional methods and/or field(s) which you may require to aid 
	you in the completion of this practical.
 */

public class BPlusTree {
    int order;
    int minKeys;
    int maxKeys;
    BPlusNode root; // do not modify

    public BPlusTree(int m) {
		/*
		The constructor.  Creates a BPlusTree object of order m,
		where m is passed as a parameter to the constructor. 
		You may assume that m >= 3.
		*/
        order = m;
        minKeys = (int) Math.ceil(m / 2.0) - 1;
        maxKeys = order - 1;
        root = new BPlusNode(m, true); /* root starts as leaf node and root's parent is null */
    }

    /* insert an element into the BPlusTree, you may assume duplicates will not be inserted. */
    public void insertElement(int element) {
        // your code goes here
        BPlusNode tmp = root;

        while (!tmp.leaf) {
            for (int i = 0; i < order; i++) {
                if (i >= tmp.keys.length || tmp.keys[i] == 0 || tmp.keys[i] > element) {
                    tmp = tmp.branches[i];
                    i = order;
                }
            }
        }

        insert(element, tmp);
    }

    private BPlusNode insert(int element, BPlusNode node) {

        int[] tmpArray = new int[order];

        for (int i = 0; i < tmpArray.length; i++) {

            if (i >= node.keys.length || node.keys[i] == 0) {
                tmpArray[i] = element;
                break;
            }

            if (node.keys[i] > element) {
                tmpArray[i] = element;

                while (i < node.keys.length) {
                    tmpArray[i + 1] = node.keys[i++];
                }

                break;
            }


            tmpArray[i] = node.keys[i];
        }

        if (tmpArray[tmpArray.length - 1] != 0) {
            return splitNode(tmpArray, node);
        } else {
            copyTmpToNode(tmpArray, node);
            return null;
        }
    }

    private BPlusNode splitNode(int[] tmpArray, BPlusNode node) {
        BPlusNode newRightNode = new BPlusNode(order, node.leaf);

        int newDividerIndex = tmpArray.length / 2;

        copyLeft(node, tmpArray, newDividerIndex);
        copyRight(newRightNode, tmpArray, newDividerIndex);

        if (node == root) {
            BPlusNode newRoot = new BPlusNode(order, false);
            newRoot.insert(tmpArray[newDividerIndex], 0);

            root = newRoot;

            root.branches[0] = node;
            root.branches[1] = newRightNode;

            newRightNode.parent = newRoot;
            node.parent = newRoot;

        } else {
            BPlusNode[] newChildrenAtCurrentLevel = generateBranchesArrayWithNewNode(node, newRightNode);
            BPlusNode newRightParent = insert(tmpArray[newDividerIndex], node.parent);

            // if true this means our parent split and we need to split the branchesArray between the two new parents
            if (newRightParent != null) {
                divideChildrenBetweenParents(newChildrenAtCurrentLevel, node.parent, newRightParent);
            } else {
                assignChildArrayToParent(node.parent, newChildrenAtCurrentLevel);
            }
        }

        if (node.leaf) {
            node.next = newRightNode;
        }

        return newRightNode;
    }

    private void divideChildrenBetweenParents(BPlusNode[] newChildrenAtCurrentLevel, BPlusNode parent, BPlusNode newRightParent) {
        int dividingIndex = parent.keyTally + 1;

        copyLeftChildren(parent, newChildrenAtCurrentLevel, dividingIndex);
        copyRightChildren(newRightParent, newChildrenAtCurrentLevel, dividingIndex);
    }


    // Copies the filled child array to the single parent and makes sure the newly created node
    // has the correctly set parent
    private void assignChildArrayToParent(BPlusNode parent, BPlusNode[] children) {
        for (int i = 0; children[i] != null && i < order; i++) {
            parent.branches[i] = children[i];
            children[i].parent = parent;
        }
    }

    // Creates a temporary array of the parents Branches array including the new node to be added must be size + 1
    private BPlusNode[] generateBranchesArrayWithNewNode(BPlusNode node, BPlusNode newRightNode) {
        BPlusNode[] tmpArray = new BPlusNode[order + 1]; // one size bigger than the reference array
        BPlusNode[] parentBranches = node.parent.branches;

        for (int i = 0; i < order; i++) {
            if (parentBranches[i] == node) {
                tmpArray[i++] = node;
                tmpArray[i++] = newRightNode;

                while (i < order && parentBranches[i] != null) {
                    tmpArray[i + 1] = parentBranches[i++];
                }

                break;
            }

            tmpArray[i] = parentBranches[i];
        }

        return tmpArray;
    }

    private void copyRight(BPlusNode node, int[] fullArray, int index) {
        int startingIndex = (node.leaf) ? index : index + 1;

        // set i (startingIndex) outside the for loop
        for (int i = 0; startingIndex < fullArray.length; startingIndex++, i++) {
            node.insert(fullArray[startingIndex], i);
        }
    }

    private void copyLeft(BPlusNode node, int[] tmpArray, int newRootIndex) {
        node.clear();

        for (int i = 0; i < newRootIndex; i++) {
            node.insert(tmpArray[i], i);
        }
    }

    private void copyLeftChildren(BPlusNode parent, BPlusNode[] newChildrenAtCurrentLevel, int dividingIndex) {
        parent.clearChildren();

        for (int i = 0; i < dividingIndex; i++) {
            parent.branches[i] = newChildrenAtCurrentLevel[i];
            parent.branches[i].parent = parent;
        }
    }

    private void copyRightChildren(BPlusNode newRightParent, BPlusNode[] newChildrenAtCurrentLevel, int dividingIndex) {

        for (int i = 0; dividingIndex < newChildrenAtCurrentLevel.length; i++, dividingIndex++) {
            newRightParent.branches[i] = newChildrenAtCurrentLevel[dividingIndex];
            newRightParent.branches[i].parent = newRightParent;
        }
    }

    private void copyTmpToNode(int[] tmpArray, BPlusNode node) {
        node.clear();
        for (int i = 0; i < node.keys.length; i++) {
            if (tmpArray[i] == 0) {
                return;
            }
            node.insert(tmpArray[i], i);
        }
    }

    /*
        This method should return the left-most leaf node in the tree.
        If the tree is empty, return null.
     */
    public BPlusNode getFirstLeaf() {
        // your code goes here
        BPlusNode tmp = root;

        while (tmp != null && !tmp.leaf) {
            tmp = tmp.branches[0];
        }

        return tmp;
    }
}
