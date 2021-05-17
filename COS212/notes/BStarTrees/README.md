<div align="center"><h1> B* Trees</h1></div>

### Pronounced B-Star Trees

B Trees are very efficient, and always maintain a perfect balance, the benefit of B-Trees over regular Binary Trees is
that they can load in entire blocks of memory at a time, not just small snippets of data. The problem, then, comes in
when the block of data being loaded in is only half full.

Imagine inserting 1 to 8 into a BTree of order 5, what would your result be?

In this scenario the middle child will never become full (assuming only whole numbers), because the keys already fill
out the range between its two parent dividers. This means whenever we load this node from memory we are only loading in
half of what we could be.

## B* Trees

The solution is B* which are a family to regular BTrees but with 2 primary differences. Firstly Instead of being only
50% full, Nodes now need to be 60% full or 2/3rds full. This condition will create a few problems for us down the line.
The second condition is that we must delay Node creation as long as we can.

## A New Root

If we maintain the condition that Nodes must be at least 2/3rds full we very quickly encounter a small problem. Assume
we were to insert 1-5 into a B* Tree of order 5, our resulting split would look like this.

This leaves us with a problem, both of these children are only 50% full. To fix this `we will increase the size of root`

> Root must be size = 2 * the minimum # of nodes needed to be 2/3rd full + 1

To calculate how many elements you need to fill 2/3rd of an array, you could calculate the 66% of order m, but an easier
solution which will not require %

> i = (2 * m - 1)/ 3

**NB!!!** This tells you how many elements you need not the index, the index would be that minus 1

Therefore, our formula for calculating the root size becomes:

> rSize = 2((2 * m - 1) / 3) + 1

Lets see that for order 5

```text

rSize = 2((2 * (5) - 1)/3) + 1
rSize = 2(3) + 1
rSize = 7
```

So now when we insert 1-8 we get the following:

Now both children are now 60% full.

## Delaying Splitting

Remember when we were discussing Splitting in regular BTrees that Splitting is what caused, new nodes to be created, in
the case of B* tress we need to delay splitting as much as possible, this is because we want to make sure that after the
split all new nodes will be 60% full.

We follow a similar approach that we used when deleting in regular B trees, where before we checked if a sibling node
could borrow us one of their elements, we now look if one of our siblings can take one of our elements.

### Taking Left

Same as before we insert into a Node that would have 1 element more than the available keys and make sure that array was
ordered, then we pass the leftmost element to the parent and move the parent to the rightmost position of the left
sibling array.

### Taking Right

As before, insert into an ordered array of one size larger, take the rightmost element and push it to parent and move
the parent down and place it at the leftmost position of the right sibling.

### Siblings can't take Anymore

When either both siblings or either of your available siblings are full (remember the edge case) then we can split. We
can use the following steps.

* Take the `overflowing node`, the `parent value`, **AND** a `sibling node`
* Insert them all into and ordered array of size (2 * (m - 1)) + 1
* Then calculate the positions of the 2 new parents for the 3 new nodes

> 1stParent = (2 * m - 1) / 3 <br />
> 2ndParent = 2*1st + 1

If we do that with the following B* tree this is what we get.

The problem is the final Node, it is not 2/3rd full. This is because not all orders of m will be valid orders of a B*
tree

### Calculating Valid M values for B*

The logic is simple we need to take 2 full capacity arrays + 1 from parent and make 3 nodes that have min capacity with
2 dividers. Therefore, if 2 * max is not greater than 3 * min we cannot use order m

> Where max = m - 1 <br />
> & min = (2 * m - 1) / 3

Using m = 5

```text
max = (2(5 - 1)) + 1 = 9
min = (3(2 * 5 - 1) / 3) + 2 = 11  
```

9 is not greater tha 11 and thus we see we cannot make a B* tree of order 5, lets try with 7

```text
max = 2 (7 - 1) + 1 = 13
min = (3(2 * 7 - 1/ 3)) + 2 = 13
```

13 is equal to 13 thus a B* tree with order 7 is a valid B* tree

## Deleting

Deleting works largely the same except for merging, when we perform delete by merging we merge with both the left and
right sibling like so
