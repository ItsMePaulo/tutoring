public class Trie {	
	protected char[] letters;
	protected Node root = null;
	private int numPtrs;

	public Trie(char[] letters) {
		this.letters = letters;
		this.numPtrs = letters.length + 1;
	}


	//Provided Helper functions
	
	private int index(char c) {
		for (int k = 0; k < letters.length; k++) {
			if (letters[k] == (c)) {
				return k+1;
			}
		}
		return -1;
	}
	
	private char character(int i) {
		if (i == 0) {
			return '#';
		} else {
			return letters[i-1];
		}
	}
	
	private String nodeToString(Node node, boolean debug) {
		if (node.isLeaf) {
			return node.key;
		}
		else {
			String res = "";
			for (int k = 0; k < node.ptrs.length; k++) {
				if (node.ptrs[k] != null) {
					res += " (" + character(k) + ",1) ";
				} else if (debug) {
					res += " (" + character(k) + ",0) ";
				}
			}
			return res;
		}
	}

	public void print(boolean debug) {
		Queue queue = new Queue();
		Node n = root;
		if (n != null) {
			n.level = 1;
			queue.enq(n);
			while (!queue.isEmpty()){
				n = queue.deq();
				System.out.print("Level " + n.level + " [");
				System.out.print(nodeToString(n, debug));
				System.out.println("]");
				for (int k = 0; k < n.ptrs.length; k++) {
					if (n.ptrs[k] != null) {
						n.ptrs[k].level = n.level+1;
						queue.enq(n.ptrs[k]);
					}
				}
			}
		}
	}


	////// You may not change any code above this line //////

	////// Implement the functions below this line //////

	
	// Function to insert the given key into the trie at the correct position.
	public void insert(String key) {
		if (root == null) {
			root = new Node(numPtrs);

			int index = index(key.charAt(0));
			root.ptrs[index] = new Node(key, numPtrs);
			return;
		}

		Node p = root;
		int i = 0;


		while (true) {

			int characterIndex = index(key.charAt(i));

			if (i == key.length()) {
				p.ptrs[0] = new Node(key, numPtrs);
				p.endOfWord = true;
				return;
			}
			else if (p.ptrs[characterIndex] == null) {
				p.ptrs[characterIndex] = new Node(key, numPtrs);
				return;
			}
			else if (p.ptrs[characterIndex].isLeaf) {

				String k_l = p.ptrs[characterIndex].key;
				do {

					characterIndex = index(key.charAt(i));
					p.ptrs[characterIndex] = new Node(numPtrs);
					p = p.ptrs[characterIndex];

				} while ((++i < key.length() && i < k_l.length()) && key.charAt(i) == k_l.charAt(i));

				if (i == key.length()) {
					p.endOfWord = true;
					p.ptrs[0] = new Node(key, numPtrs);
					p.ptrs[index(k_l.charAt(i))] = new Node(k_l, numPtrs);
				} else if (i == k_l.length()) {
					p.endOfWord = true;
					p.ptrs[0] = new Node(k_l, numPtrs);
					p.ptrs[index(key.charAt(i))] = new Node(key, numPtrs);
				} else {
					p.ptrs[index(key.charAt(i))] = new Node(key, numPtrs);
					p.ptrs[index(k_l.charAt(i))] = new Node(k_l, numPtrs);
				}

				return;
			}
			else {
				p = p.ptrs[index(key.charAt(i++))];
			}
		}

	}
	

	// Function to determine if a node with the given key exists.
	public boolean contains(String key) {

		// Your code goes here

		return false;
	}

	
	// Function to print all the keys in the trie in alphabetical order.
	public void printKeyList() {

		// Your code goes here

	}

	
	//Helper functions

}
