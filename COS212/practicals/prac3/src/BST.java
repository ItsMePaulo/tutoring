@SuppressWarnings("unchecked")
public class BST<T extends Comparable<? super T>> {

    protected BSTNode<T> root = null;

    public BST() {
    }

    public void clear() {
        root = null;
    }

    // returns a verbose inorder string of the BST
    public String inorder(BSTNode<T> node) {
        boolean verbose = true;
        if (node != null) {
            String result = "";
            result += inorder(node.left);
            if (verbose) {
                result += node.toString() + "\n";
            } else {
                result += node.element.toString() + " ";
            }
            result += inorder(node.right);
            return result;
        }
        return "";
    }

    ////// You may not change any code above this line //////

    ////// Implement the functions below this line //////

    public boolean isEmpty() {
        return root == null;
    }

    public BSTNode<T> clone() {
        // Your code goes here

        return clone(root);
    }

    // to visit every node use a traversal method, like pre order depth first  
    private BSTNode<T> clone(BSTNode<T> node) {

        if (node == null) {
            return null;
        }

        BSTNode<T> newNode = new BSTNode<>(node.element);

        newNode.left = clone(node.left);
        newNode.right = clone(node.right);

        return newNode;
    }

    public BSTNode<T> mirror() {
        return mirror(root);
    }

    // pre order or post order depth first traversal will work but not inorder
    private BSTNode<T> mirror(BSTNode<T> node) {

        if (node == null) {
            return null;
        }

        BSTNode<T> newNode = new BSTNode<>(node.element);

        newNode.left = mirror(node.right);
        newNode.right = mirror(node.left);

        return newNode;
    }

    public void insert(T elem) {
        // Your code goes here

        // Condition 1. root = null
        if (root == null) {
            root = new BSTNode<>(elem);
            return;
        }

        BSTNode<T> tmp = root, parent = null;

        while (tmp != null) {

            // Condition 2. element already exists
            if (tmp.element.equals(elem)) {
                return;
            }

            parent = tmp;
            // if tmp element is smaller than element coming in, sel left else set right
            tmp = (tmp.element.compareTo(elem) < 0) ? tmp.right : tmp.left;
        }

        // Condition 3. add the new node either on the left or right
        if (parent.element.compareTo(elem) < 0) {
            // if parent is less than the element being added go right
            parent.right = new BSTNode<T>(elem);
        } else {
            // if parent is greater than the element being added go left instead
            parent.left = new BSTNode<T>(elem);
        }
    }


    // we will assume delete by merge on the predecessor node
    public boolean deleteByMerge(T elem) {
        // condition 1. tree is empty
        if (root == null) {
            return false;
        }

        BSTNode<T> nodeToDelete = root, parent = null;

        while (nodeToDelete != null && !nodeToDelete.element.equals(elem)) {
            parent = nodeToDelete;
            nodeToDelete = (nodeToDelete.element.compareTo(elem) < 0) ? nodeToDelete.right : nodeToDelete.left;
        }

        // condition 2. node was not found
        if (nodeToDelete == null) {
            return false;
        }

        // condition 3. node only has one child
        if (nodeToDelete.left == null || nodeToDelete.right == null) {
            removeNonCompleteNode(nodeToDelete, parent);
            return true;
        }

        // condition 4. node has both children
        BSTNode<T> pred = getPredecessor(nodeToDelete);

        if (parent == null) {
            // condition 5. we need to update root
            root = nodeToDelete.left;
        } else {
            removeMiddleChild(parent, nodeToDelete, nodeToDelete.left);
        }

        if (pred != null) {
            pred.right = nodeToDelete.right;
        }

        return true;
    }
    
    // we will assume delete by copying the predecessor node
    public boolean deleteByCopy(T elem) {
        // condition 1. tree is empty
        if (root == null) {
            return false;
        }

        BSTNode<T> nodeToDelete = root, parent = null;

        while (nodeToDelete != null && !nodeToDelete.element.equals(elem)) {
            parent = nodeToDelete;
            nodeToDelete = (nodeToDelete.element.compareTo(elem) < 0) ? nodeToDelete.right : nodeToDelete.left;
        }

        // condition 2. node was not found
        if (nodeToDelete == null) {
            return false;
        }

        // condition 3. node only has one child:
        // NB! Up to this point the two delete algorithms are the same
        if (nodeToDelete.left == null || nodeToDelete.right == null) {
            removeNonCompleteNode(nodeToDelete, parent);
            return true;
        }

        // condition 4. node has both children
        BSTNode<T> pred = nodeToDelete.left, predParent = nodeToDelete;

        // find both pred and the parent, cant call getPredecessor method
        while (pred.right != null) {
            predParent = pred;
            pred = pred.right;
        }

        // pred is now removed from the tree but we still hold pred
        removeNonCompleteNode(pred, predParent);

        nodeToDelete.element = pred.element;

        return true;
    }

    public T search(T element) {
        // Your code goes here

        BSTNode<T> node = searchForNode(element);
        return (node != null) ? node.element : null;
    }

    public T getPredecessor(T element) {
        // Your code goes here

        BSTNode<T> node = searchForNode(element);

        if (node != null) {
            BSTNode<T> pred = getPredecessor(node);

            return (pred != null) ? node.element : null;
        }

        return null;
    }

    public T getSuccessor(T element) {
        // Your code goes here

        BSTNode<T> node = searchForNode(element);

        if (node != null) {
            BSTNode<T> succ = getSuccessor(node);

            return (succ == null) ? node.element : null;
        }

        return null;
    }


    // helper functions
    private BSTNode<T> getPredecessor(BSTNode<T> node) {
        if (node.left == null) {
            return null;
        }

        BSTNode<T> tmp = node.left;

        while (tmp.right != null) {
            tmp = tmp.right;
        }

        return tmp;
    }

    private BSTNode<T> getSuccessor(BSTNode<T> node) {
        if (node.right == null) {
            return null;
        }

        BSTNode<T> tmp = node.right;

        while (tmp.left != null) {
            tmp = tmp.left;
        }

        return tmp;
    }

    private BSTNode<T> searchForNode(T elem) {

        // Condition 1. root = null
        if (root != null) {
            BSTNode<T> tmp = root;

            // if the while loop breaks we run down to the final return statement and return null
            while (tmp != null) {

                // Condition 2. element is found
                if (tmp.element.equals(elem)) {
                    return tmp;
                }

                tmp = (tmp.element.compareTo(elem) < 0) ? tmp.right : tmp.left;
            }
        }

        return null;
    }

    private void removeNonCompleteNode(BSTNode<T> child, BSTNode<T> parent) {

        // condition 3.1. only 1 or no children
        BSTNode<T> newNode = (child.left == null) ? child.right : child.left;

        if (parent == null) {
            // condition 5. we need to update root
            root = newNode;
        } else {
            removeMiddleChild(parent, child, newNode);
        }
    }

    private void removeMiddleChild(BSTNode<T> parent, BSTNode<T> nodeToDelete, BSTNode<T> newChild) {

        if (nodeToDelete.element.compareTo(parent.element) < 0) {
            parent.left = newChild;
        } else {
            parent.right = newChild;
        }
    }
    
}
