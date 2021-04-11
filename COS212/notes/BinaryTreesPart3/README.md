<div align="center"><h1> Binary Trees Part 3: Tree Operations </h1></div>

## search()

Searching a tree can be done quite easily, start from the top of the tree and them move from left to right depending on
the relationship of the element being searched, to the element stored in the Node.

```java 
class BinaryTree {
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
}
```

## add()

Iterate through the tree in a similar method to search, if you already find the key do not add the element a second
time. Iterate through the tree until you find an empty space, then add the element in that space.

```java
class BinaryTree {
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
}
```

## getHeight()

The get height algorithm is slightly tricky, it is much easier to tackle it using recursion. Each visited non-null node
should be counted as a node, but we should only reference one node per level. Therefore, to calculate the longest branch
each visited left and right subtree must be compared, and the largest subtree selected as the path to reach the largest
branch in the tree.

```java
class BinaryTree {
    private int getHeight(BinaryNode<T> node) {

        if (node == null) {
            return 0;
        }

        int left = 1 + getHeight(node.left);
        int right = 1 + getHeight(node.right);

        return (left > right) ? left : right;
    }
}

```

## Delete

Deleting a Node in a tree is a challenge because...branches are not linear. If, a Node only had one child the delete
operation would be simple, just make that nodes parent point to it's only child, however we can't do that if there are
two children.

<img src="images/simple_delete.png" alt="simple delete with single child">

When there are two children we can't simply move both of them up as we did before.

<img src="images/complex_delete.png" alt="complicated delete scenario with multiple children">
