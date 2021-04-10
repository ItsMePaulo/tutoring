public class BinaryNode<T extends Comparable<? super T>> {

    public T key;
    public BinaryNode<T> left;
    public BinaryNode<T> right;


    public BinaryNode(T k) {
        key = k;
        left = null;
        right = null;
    }
}
