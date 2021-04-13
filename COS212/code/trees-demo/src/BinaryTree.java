import java.util.ArrayList;

public class BinaryTree<T extends Comparable<? super T>> {

    private BinaryNode<T> root;

    public BinaryTree() {
        root = null;
    }

    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(BinaryNode<T> node) {

        if (node == null) {
            return 0;
        }

        int left = 1 + getHeight(node.left);
        int right = 1 + getHeight(node.right);

        return (left > right) ? left : right;
    }

    public T search(T elem) {

        // Condition 1. root = null
        if (root != null) {
            BinaryNode<T> tmp = root;

            // if the while loop breaks we run down to the final return statement and return null
            while (tmp != null) {

                // Condition 2. element is found
                if (tmp.key.equals(elem)) {
                    return tmp.key;
                }

                tmp = (tmp.key.compareTo(elem) < 0) ? tmp.right : tmp.left;
            }
        }

        return null;
    }

    public void add(T elem) {

        // Condition 1. root = null
        if (root == null) {
            root = new BinaryNode<>(elem);
            return;
        }

        BinaryNode<T> tmp = root, parent = null;

        while (tmp != null) {

            // Condition 2. element already exists
            if (tmp.key.equals(elem)) {
                return;
            }

            parent = tmp;
            // if tmp element is smaller than element coming in, sel left else set right
            tmp = (tmp.key.compareTo(elem) < 0) ? tmp.right : tmp.left;
        }

        // Condition 3. add the new node either on the left or right
        if (parent.key.compareTo(elem) < 0) {
            // if parent is less than the element being added go right
            parent.right = new BinaryNode<>(elem);
        } else {
            // if parent is greater than the element being added go left instead
            parent.left = new BinaryNode<>(elem);
        }
    }

    public void addAlternate(T elem) {

        // Condition 1. root = null
        if (root == null) {
            root = new BinaryNode<>(elem);
            return;
        }

        BinaryNode<T> tmp = root;
        while (true) {

            // Condition 2. element already exists
            if (tmp.key.equals(elem)) {
                return;
            }

            if (tmp.key.compareTo(elem) < 0) {
                if (tmp.right == null) {
                    // add the left child
                    tmp.right = new BinaryNode<>(elem);
                    return;
                } else {
                    // move to the left child
                    tmp = tmp.right;
                }
            } else {
                if (tmp.left == null) {
                    // add the right child
                    tmp.left = new BinaryNode<>(elem);
                    return;
                } else {
                    // move to the right child
                    tmp = tmp.left;
                }
            }
        }
    }

    /**
     * Delete by left merge predecessor finds a node in a tree, if the node is found in the tree and is a complete node
     * performs the delete by merge operation. In this case the left node is selected to take the position of
     * the node deleted and the right node is moved to the right child of the nodes predecessor.
     * <p>
     * Complete function with duplicate code for readability, deleteByMergingSuccessor makes use of helper functions
     * to reduce code duplication:
     *
     * @param elem the element we want to delete
     * @return the element removed from the tree, null if not found
     */
    public T deleteByMergingPredecessor(T elem) {

        // condition 1. root = null
        if (root == null) {
            return null;
        }

        BinaryNode<T> tmp = root, parent = null;

        while (tmp != null && !tmp.key.equals(elem)) {
            parent = tmp;
            tmp = (tmp.key.compareTo(elem) < 0) ? tmp.right : tmp.left;
        }

        // condition 2. element was not in the tree
        if (tmp == null) {
            System.out.println("Element not found");
            return null;
        }

        // condition 3.1. only 1 or no children
        if (tmp.left == null) {
            if (parent == null) {
                root = tmp.right;
            } else {
                removeMiddleChild(parent, tmp, tmp.right);
            }

            return tmp.key;
        }
        // condition 3.2. only 1 child
        if (tmp.right == null) {
            if (parent == null) {
                root = tmp.left;
            } else {
                removeMiddleChild(parent, tmp, tmp.left);
            }

            return tmp.key;
        }

        // condition 4. tmp has both children
        BinaryNode<T> pred = getPredecessor(tmp);

        if (parent == null) {
            root = tmp.left;
        } else {
            removeMiddleChild(parent, tmp, tmp.left);
        }

        if (pred != null) { // will always be true
            pred.right = tmp.right;
        }

        return tmp.key;
    }

    public T deleteByMergingSuccessor(T elem) {

        if (root == null) {
            return null;
        }

        NodeCollection<T> nodes = findNodeAndParent(elem);

        if (nodes.child == null) {
            System.out.println("Element not found");
            return null;
        }

        if (nodes.child.left == null || nodes.child.right == null) {
            removeNonCompleteNode(nodes.child, nodes.parent);
            return nodes.child.key;
        }

        BinaryNode<T> succ = getSuccessor(nodes.child);

        if (nodes.parent == null) {
            root = nodes.child.right;
        } else {
            removeMiddleChild(nodes.parent, nodes.child, nodes.child.right);
        }

        if (succ != null) {
            succ.left = nodes.child.left;
        }

        return nodes.child.key;
    }

    /**
     * Delete by copying predecessor finds a node in a tree, if the node found is a complete node performs a delete by
     * copying operation. In this scenario finds a nodes predecessor and copies the predecessors value into the
     * value of the node to delete, then performs a delete on the predecessor node which will not be a complete node
     * <p>
     * Complete function with duplicate code for readability deleteByCopyingSuccessor makes use of helper functions
     * to reduce code duplication
     *
     * @param elem the element to be deleted
     * @return the element deleted from the tree, null if not found
     */
    public T deleteByCopyingPredecessor(T elem) {

        if (root == null) {
            return null;
        }

        BinaryNode<T> tmp = root, parent = null;

        while (tmp != null && !tmp.key.equals(elem)) {
            parent = tmp;
            tmp = (tmp.key.compareTo(elem) < 0) ? tmp.right : tmp.left;
        }

        // condition 2. element was not in the tree
        if (tmp == null) {
            System.out.println("Element not found");
            return null;
        }

        // condition 3.1 only 1 or no children
        if (tmp.left == null) {
            if (parent == null) {
                root = tmp.right;
            } else {
                removeMiddleChild(parent, tmp, tmp.right);
            }

            return tmp.key;
        }

        // condition 3.2 only 1 child
        if (tmp.right == null) {
            if (parent == null) {
                root = tmp.left;
            } else {
                removeMiddleChild(parent, tmp, tmp.left);
            }

            return tmp.key;
        }

        // condition 4. tmp has both children
        BinaryNode<T> pred = tmp.left, predParent = tmp;

        // find predecessor and predecessor parent so we can remove pred
        while (pred.right != null) {
            predParent = pred;
            pred = pred.right;
        }

        // check to make sure predecessor is on the right side of it's paret
        if (pred.key.compareTo(predParent.key) < 0) {
            predParent.left = null;
        } else {
            predParent.right = null;
        }

        // overwrite the old value of tmp
        T oldKey = tmp.key;
        tmp.key = pred.key;

        return oldKey;
    }

    public T deleteByCopyingSuccessor(T elem) {

        if (root == null) {
            return null;
        }

        NodeCollection<T> nodes = findNodeAndParent(elem);

        if (nodes.child == null) {
            System.out.println("Element not found");
            return null;
        }

        if (nodes.child.left == null || nodes.child.right == null) {
            removeNonCompleteNode(nodes.child, nodes.parent);
            return nodes.child.key;
        }

        BinaryNode<T> succ = nodes.child.right, succParent = nodes.child;

        while (succ.left != null) {
            succParent = succ;
            succ = succ.left;
        }

        removeNonCompleteNode(succ, succParent);
        T oldKey = nodes.child.key;
        nodes.child.key = succ.key;

        return oldKey;
    }

    public BinaryNode<T> getRoot() {
        return root;
    }

    public String inOrderTraversal(BinaryNode<T> node) {

        if (node == null) {
            return "";
        }
        String result = "";

        result += inOrderTraversal(node.left);
        result += node.key;
        return result += inOrderTraversal(node.right);
    }

    public String breadthFirst() {

        if (root == null) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        ArrayList<BinaryNode<T>> queue = new ArrayList<BinaryNode<T>>();

        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryNode<T> tmp = queue.remove(0);

            result.append(tmp.key).append(",");

            if (tmp.left != null) {
                queue.add(tmp.left);
            }
            if (tmp.right != null) {
                queue.add(tmp.right);
            }
        }

        // remove the last comma
        return result.delete(result.length() - 1, result.length()).toString();
    }

    // helper functions
    private BinaryNode<T> getPredecessor(BinaryNode<T> node) {
        if (node.left == null) {
            return null;
        }

        BinaryNode<T> tmp = node.left;

        while (tmp.right != null) {
            tmp = tmp.right;
        }

        return tmp;
    }

    private BinaryNode<T> getSuccessor(BinaryNode<T> node) {
        if (node.right == null) {
            return null;
        }

        BinaryNode<T> tmp = node.right;

        while (tmp.left != null) {
            tmp = tmp.left;
        }

        return tmp;
    }

    // removing a node that is missing at least one child is simple and is consistent
    // in both algorithms
    private void removeNonCompleteNode(BinaryNode<T> child, BinaryNode<T> parent) {

        // condition 3.1. only 1 or no children
        BinaryNode<T> newNode = (child.left == null) ? child.right : child.left;

        if (parent == null) {
            root = newNode;
        } else {
            removeMiddleChild(parent, child, newNode);
        }
    }

    private NodeCollection<T> findNodeAndParent(T elem) {
        BinaryNode<T> tmp = root, parent = null;

        while (tmp != null && !tmp.key.equals(elem)) {
            parent = tmp;
            tmp = (tmp.key.compareTo(elem) < 0) ? tmp.right : tmp.left;
        }

        return new NodeCollection<T>(parent, tmp);
    }


    private void removeMiddleChild(BinaryNode<T> parent, BinaryNode<T> middleChild, BinaryNode<T> newChild) {

        if (middleChild.key.compareTo(parent.key) < 0) {
            parent.left = newChild;
        } else {
            parent.right = newChild;
        }
    }
}
