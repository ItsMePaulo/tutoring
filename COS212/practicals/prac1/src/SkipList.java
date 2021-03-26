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

        if (isEmpty()) {
            return false;
        }

        int lvl;


        SkipListNode<T>[] curr = new SkipListNode[maxLevel];
        SkipListNode<T>[] prev = new SkipListNode[maxLevel];

        curr[maxLevel - 1] = root[maxLevel - 1];
        prev[maxLevel - 1] = null;

        for (lvl = maxLevel - 1; lvl >= 0; lvl--) {

            while (curr[lvl] != null && curr[lvl].key.compareTo(key) < 0) {
                prev[lvl] = curr[lvl];
                curr[lvl] = curr[lvl].next[lvl];
            }

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

        boolean deleted = false;

        for (int i = 0; i < maxLevel; i++) {
            if (curr[i] != null && key.equals(curr[i].key)) {
                deleted = true;

                if (prev[i] == null) {
                    root[i] = curr[i].next[i];
                } else {
                    prev[i].next[i] = curr[i].next[i];
                }
            }
        }

        return deleted;
    }

    public T first() {
        return isEmpty() ? null : root[0].key;
    }

    public T search(T key) {
        int lvl;
        SkipListNode<T> prev, curr;

        // find the highest non null
        for (lvl = maxLevel - 1; lvl >= 0 && root[lvl] == null; lvl--) {
            // empty body
        }

        if (lvl < 0) {
            return null;
        }

        prev = curr = root[lvl];

        // I wouldn't usually make infinite loops like this
        while (true) {
            if (key.equals(curr.key)) {
                return curr.key;
            }
            // compare to next
            else if (key.compareTo(curr.key) < 0) {
                if (lvl == 0) {
                    System.out.println("Item not found in the list");
                    return null;
                }
                // still on root node
                else if (curr == root[lvl]) {
                    curr = root[--lvl];
                }
                // have moved a bit
                else {
                    curr = prev.next[--lvl];
                }
            } else {
                prev = curr;
                if (curr.next[lvl] != null) {
                    curr = curr.next[lvl];
                } else {
                    // find the highest non null from current lvl - 1
                    for (--lvl; lvl >= 0 && curr.next[lvl] == null; lvl--) {
                        // empty body
                    }
                    if (lvl >= 0) {
                        curr = curr.next[lvl];
                    } else {
                        System.out.println("Item not found in the list");
                        return null;
                    }
                }
            }
        }
    }

    public String getPathToLastNode() {
        // your code goes here

        int lvl;

        for (lvl = maxLevel - 1; lvl >= 0 && root[lvl] == null; lvl--) {
            // empty body
        }

        if (lvl < 0) {
            return "";
        }

        return getPath(lvl, root[lvl], "");
    }

    private String getPath(int lvl, SkipListNode<T> skipListNode, String result) {
        if (skipListNode == null) {
            return "";
        }

        result += "[" + skipListNode.key + "]";

        // look for next valid next value by lvl
        for (; lvl >= 0 && skipListNode.next[lvl] == null; lvl--) {
            // empty body
        }

        if (lvl >= 0) {
            result = getPath(lvl, skipListNode.next[lvl], result);
        }

        return result;
    }
}
