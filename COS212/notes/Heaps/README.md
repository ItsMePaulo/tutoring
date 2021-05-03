<div align="center"><h1> Heaps and Treaps </h1></div>

## Heaps

First heaps are ***NOT*** trees, they are arrays we draw as trees. Heaps are smart ways of writing perfectly balanced
trees, a Heap will always be perfectly balanced as long as their are no gaps in the array. The following array can be
turned into a Binary Heap as follows:

> 1, 2, 3, 4, 5, 6, 7, 8, 9

The same array can be turned into a ternary (3) heap as follows

What's important to notice here is we are just drawing out the array in a clever way, but there are no connectors
between elements in the array. Elements in the array do not hold references to their children and children do not hold
references to their parents. From an implementation level this mean nodes in the array do not need to hold a left and
right field. Instead, to find a Nodes immediate descendent you use the following formula.

> ch = (k * d) + n

Where:

* `ch` is the descendent or child you want to find
* `k` is the current index of the parent
* `d` is the number of children each parent is allowed to have (binary heap has 2 children)
* `n` the child number you are looking for, ie looking for your first child => +1

If we take our first array example and fill in some values in the formula we can see how it works. We will first assume
the binary tree example, therefore `d` will be set to 2.

> `(index, key)`
> [(0, 1), (1, 2), (2, 3), (3, 4), (4, 5), (5, 6), (6, 7), (7, 8), (8, 9)]

Find the second child of 1:

```text
ch = (k * d) + n
ch = (0 * 2) + 2
ch = 2 (this is the index hence value is 3)
``` 

Find the first child of 4

```text
ch = (k * d) + n 
ch = (3 * 2) + 1
ch = (7 this is the index hence the value is 8)
```

The formula hold if we increase the number of children a node can have, ie imagine a ternary tree

Find the third child of 2 

```text
ch = (k * d) + n 
ch = (1 * 3) + 3
ch = (6 this is the index hence the value is 7
```

To find the parent given the child's index we can use the following formula:

> k = (ch-1)/d -- floored

where: 

* `k` is the index of the parent we are trying to find
* `ch` is the index of the child 
* `d` is the number of children each parent in the heap is allowed to have

Find the parent of 3 in a binary heap

```text
k = (ch - 1) /d -- floored
k = (2 - 1) / 2 -- floored
k = 0 
``` 

Find the parent of 6 in a ternary heap 

```text
k = (ch - 1) /d -- floored
k = (4 - 1) / 3 -- floored
k = 1
``` 

## Min and Max Heaps 


