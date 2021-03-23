// Do not modify this file

public class SkipListNode<T>
{
	public T key;
	public SkipListNode<T>[] next;

	// "n" here is all the pointers this node will have, the higher the nodes
	// level the more pointers it will have
	@SuppressWarnings("unchecked")
	SkipListNode(T i, int n)
	{
		key = i;
		next = new SkipListNode[n];

		for (int j = 0; j < n; j++)
			next[j] = null;
	}
}
