import java.util.Random;

@SuppressWarnings("unchecked")
public class SkipList<T extends Comparable<? super T>> {

    public int maxLevel;
    public SkipListNode<T>[] root;
    private int[] powers;
    private Random rd = new Random();

    SkipList(int i) {
        maxLevel = i;
        root = new SkipListNode[maxLevel];
        powers = new int[maxLevel];
        for (int j = 0; j < i; j++)
            root[j] = null;
        choosePowers();
        rd.setSeed(202003); // do not modify this line
    }

    SkipList() {
        this(4);
    }

    public void choosePowers() {
        powers[maxLevel - 1] = (2 << (maxLevel - 1)) - 1;
        for (int i = maxLevel - 2, j = 0; i >= 0; i--, j++)
            powers[i] = powers[i + 1] - (2 << j);
    }

    public int chooseLevel() {
        int i, r = Math.abs(rd.nextInt()) % powers[maxLevel - 1] + 1;
        for (i = 1; i < maxLevel; i++) {
            if (r < powers[i])
                return i - 1;
        }
        return i - 1;
    }

    public boolean isEmpty() {
        return root[0] == null;
    }

    public void insert(T key) {
        SkipListNode<T>[] curr = new SkipListNode[maxLevel];
        SkipListNode<T>[] prev = new SkipListNode[maxLevel];

        curr[maxLevel - 1] = root[maxLevel - 1];
        prev[maxLevel - 1] = null;

        // go down the list
        for (int lvl = maxLevel - 1; lvl >= 0; lvl--) {

            // go across the list
            while (curr[lvl] != null && curr[lvl].key.compareTo(key) < 0) {
                prev[lvl] = curr[lvl];
                curr[lvl] = curr[lvl].next[lvl];
            }

            if (curr[lvl] != null && curr[lvl].key.equals(key)) {
                return;
            }

            // not a base node
            if (lvl > 0) {

                if (prev[lvl] == null) {
                    curr[lvl - 1] = root[lvl - 1];
                    prev[lvl - 1] = null;
                } else {
                    curr[lvl - 1] = prev[lvl].next[lvl - 1];
                    prev[lvl - 1] = prev[lvl];
                }

            }
        }
        // create a newNode
        // key holds nodes key, level holds how many next fields will have
        int lvl = chooseLevel();
        SkipListNode<T> newNode = new SkipListNode<T>(key, lvl + 1);

        for (int i = 0; i <= lvl; i++) {
            newNode.next[i] = curr[i];
            if (prev[i] == null) {
                root[i] = newNode;
            } else {
                prev[i].next[i] = newNode;
            }
        }
    }


    public boolean delete(T key) {
        // your code goes here

        return false;
    }

    public T first() {
        return isEmpty() ? null : root[0].key;
    }

    public T search(T key) {
        // your code goes here

        return null;

    }

    public String getPathToLastNode() {
        // your code goes here

        return "";
    }

}
