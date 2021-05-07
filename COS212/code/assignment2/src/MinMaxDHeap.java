/* Complete this class to implement a fully functional min-max d-heap. Read the comments to determine what each aspect of the class is supposed to do.
You must add any additional features (methods, references) which may aid you in your task,
BUT you are not allowed to remove or change the names or properties of any of the features you were given.

Importing Java's built in data structures will result in a mark of 0.
*/

public class MinMaxDHeap<T> {
    private int d; // The d-order of the min-max d-heap
    private Node<T>[] heap;

    @SuppressWarnings("unchecked")
    public MinMaxDHeap(int order) {
		/* Parameter d specifies the order of your min-max heap. If d = 2, you should construct a binary heap, 
		   if d = 3, you should construct a ternary heap, etc. You may implement this constructor to suit your 
		   needs, or you may add additional constructors. This is the constructor which will be used for marking. */
        d = order;
        heap = new Node[0];
    }

    /* Insertion */
    @SuppressWarnings("unchecked")
    public void insert(T data, int key) {
		/* Insert a Node object according to its key (priority).
			 The Node object has to be initialised with the given data/key values.
		   Refer to the assignment spec for insertion algorithm details. */

        int levelToInsert = fetchLevel(0, 1);

        if (levelToInsert % 2 == 0) {
            System.out.println("Even level should do a min heap insert");
        } else {
            System.out.println("Odd level should do a max heap insert");
        }

        heap = new Node[heap.length + 1];
        heap[heap.length - 1] = new Node<>(data, key);
    }

    private int fetchLevel(int level, int levelRange) {
        if (heap.length < levelRange) {
            return level;
        }

        return fetchLevel(++level, levelRange + pow(d, level));
    }

    private int pow(int base, int power) {
        if (power == 0) {
            return 1;
        }

        return base * pow(base, --power);
    }

    /* Read-only access */
    public T peekMin() {
        /* Return the data of the min priority Node. Min-max heap should not be modified by this function. */
        return heap[0].getData();
    }

    public T peekMax() {
        /* Return the data of the max priority Node. Min-max heap should not be modified by this function. */
        int max = 0;
        Node<T> maxNode = heap[0];
        for (int i = 1; i < heap.length && i < (d + 1); i++) {
            if (heap[i].key > max) {
                max = heap[i].key;
                maxNode = heap[i];
            }
        }

        return (maxNode != null) ? maxNode.data : null;
    }

    public String toString() {
		/* Return a breadth-first traversal representation of the Min-Max d-heap by constructing 
		   a comma-separated string of the data stored in the heap. To construct the string,
       iterate over the heap, and append each Node object by invoking the toString() method.
       NB: The output format should contain no spaces and/or new line characters. 
       Individual nodes must be comma-separated. Eg., if alphabetical characters A, B, and C 
       were stored in the min-max heap in this order, you should return the string "A,B,C" 
       */
        return "";
    }


    /* Deletion */
    public T deleteMin() {
		/* Remove the Node with the min priority, and return its data. 
			 Min-max heap has to be restructured accordingly: see spec for details. */
        return null;
    }

    public T deleteMax() {
		/* Remove the Node with the max priority, and return its data. 
			 Min-max heap has to be restructured accordingly: see spec for details. */
        return null;
    }

    /* Construction */
    public void construct(Node<T>[] arr) {
		/* Given an array of Node objects in arbitrary order, construct a min-max heap by 
       applying Floyd's algorithm modified for min-max d-heaps. */
    }

    public void changeD(int newD) {
        /* Given a new order d, restructure the current min-max d-heap such that it is a d-heap with d = newD. */

        d = newD;
        construct(heap);
    }

    /* Clearing */
    public void clear() {
        /* Clear the min-max heap by removing all nodes. */
    }
}
