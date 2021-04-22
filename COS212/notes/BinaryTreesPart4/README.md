<div align="center"><h1> Binary Trees Part 4: Balancing a Binary Tree </h1></div>

## A Balanced Tree

A tree is considered balanced if the sum of the height between left and right sibling sub-trees is no less than -1 and
no greater than 1. To calculate the sum of the sibling sub-trees we take the height of the left sub-tree and minus it
from the right sub-tree.

The benefit of having a balanced tree is fewer operations when searching for elements within the tree. To understand
this it is important to understand how many nodes will exist in a perfect tree. In a perfect tree each node has both of
its children, the number of nodes on each level doubles the number of nodes on the level that came before it. <br />
The max number of Nodes then is easy to calculate given a perfect tree of height 14 (because it doubles every time we
can just use powers of 2 and because we started at 1 we just -1 from our answer), we just say `2<sup>14</sup> - 1`. This
creates a perfect tree that can store a maximum of `16 384`, BUT in the worst case scenario will only perform at most 14
comparisons, compare that with the linear linked list which would have to explore all 16 000 elements. Ergo we want to
keep the tree balanced

### Rotations

Before we start looking at balancing a Tree we first need to understand *rotations*. Rotations occur when we swap a
child with its parent, we rotate the child around the parent to be more accurate. The direction in which the child moves
towards the parent is the direction of the rotation. The following is an example of a right rotation.

In this example child `ch` was rotated around parent `p`. To perform a rotation move the child vertically up attach it
to the parent and move that new sub-tree into place. There is unfortunately a scenario in which this is not as
straightforward and that is whenever our child has a right child.

In this scenario, the parent adopts the child's right subtree as its new left subtree. It is really important you guys
start practicing these rotations, here are a few more examples.

A rule of thumb anything above the 2-3 nodes being rotated will remain the same, you only need to worry about a right
rotation if the child node has a right child, and you only need to worry about a left rotation if the child node has a
left child.


## The DSW Algorithm 

