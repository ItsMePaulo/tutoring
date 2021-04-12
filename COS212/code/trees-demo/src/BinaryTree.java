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

    public T deleteByMergingLeft(T elem) {

        // condition 1. root = null
        if (root == null) {
            return null;
        }

        BinaryNode<T> tmp = root, parent = null;

        while (tmp != null && tmp.key.equals(elem)) {
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
        BinaryNode<T> leftNodesRightMost = tmp.left;

        while (leftNodesRightMost.right != null) {
            leftNodesRightMost = leftNodesRightMost.right;
        }

        if (parent == null) {
            root = tmp.left;
        } else {
            removeMiddleChild(parent, tmp, tmp.left);
        }

        leftNodesRightMost.right = tmp.right;

        return tmp.key;
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

    private void removeMiddleChild(BinaryNode<T> parent, BinaryNode<T> middleChild, BinaryNode<T> newChild) {

        if (middleChild.key.compareTo(parent.key) < 0) {
            parent.left = newChild;
        } else {
            parent.right = newChild;
        }

    }

}
