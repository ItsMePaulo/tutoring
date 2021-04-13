public class NodeCollection<T extends Comparable<? super T>> {

    BinaryNode<T> parent;
    BinaryNode<T> child;

    public NodeCollection (BinaryNode<T> parentNode, BinaryNode<T> childNode) {
        parent = parentNode;
        child = childNode;
    }
}
