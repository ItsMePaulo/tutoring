### Question 1

Consider the following Recursive Function

```java
public static int doSomething(int val1, int val2) {
    if (val2 <= 0) {
        return val2;
    } else {
        return val2 + doSomething(val1, val2 - val1);
    }
}
```

### Answer

> a. It is non-tail recursive function because a call to doSomething is not the last operation performed. 

### Question 2

SLL implementation 

```java
public class SLLNode<T> {
    
    public T info;
    public SLLNode<T> next;
    
    public SLLNode(T el, SLLNode<T> n) {
        info = el;
        next = n;
    }
}

public class SLL<T> {
    
    public SLLNode<T> head;
    public SLL() {
        head = null;
    }
    
    // additional functions
}
```
Assume that methods are provided to **ADD** values to a SLL. Implement a recursive function to delete a specific element in 
the SLL, given a node from which point on the value to be deleted might occur (it is posssiblt the value may be in the 
list but may not occur from this point, in which case nothing should be deleted). **YOUR FUNCTION MUST MAKE USE OF THE 
FOLLOWING SIGNATURE:**

```java
public void delete(T el, SLLNode<T> node)
```

Implement the **delete** method in a recursive fashion. You must use correct Java syntax, and your method must be recursive.
You may only use methods defined within SLL and SLL classes that are explicitly provided. You may not define any other than delete 

### Answer:
```java
public void delete(T el, SLLNode<T> node) {
    
    if (node == null) {
        return null;
    }
    
    // on this functions first entry, check if the node being sent in is equal to the element
    if (node.info.equals(el)) {
        if (node == head) {
            head = head.next;
        } else {
            // it is impossible to delete this item from the list: DO Nothing 
            // CCONDITION: node sent in to be delete on external function call is in the middle of the list and 
            // equal to the item we wish to delete
        }
        
        return; // no need to make a recursive funtion
    }
    
    if (node.next != null && node.next.info.equals(el)) {
        node.next = node.next.next;
    } else {
        delet(el, node.next);
    }
}
```

### Question 3

Assume the following tree was implemented as a double threading, how many **LEFT** threads would the resulting tree have

<img src="images/threaded_tree.png" alt="threaded tree">

### Answer 

> 7

### Question 4

Implement a recursive function that prints out every value **stored at on odd INDEX** in an array after a certain index,
followed by a space and a full stop. Your implementation should have the following signature:

`public static void printOddElements(int index, int[] arr)`

For example, if the following statements are executed:

`int[] myArr = {1,2,3,4,5};` <br />
`printOddElements(0, myArr);` <br />

the printout begins at index 0 in myArr (the value 1), the output should be: 

`1 3 5 .`

if the following statements are executed:

`int[] myArr = {1,2,3,4,5};` <br />
`printOddElements(1, myArr);` <br />

The printout begins at index 1 (the value 2), and the output should be:

`3 5 .`

You must use correct java syntax, and your solution must be recursive, you may not define any other methods other than 
`printOddElements`.

### Answer

```java
// you had to realise the question was asking to print values at on odd index not odd values, indices in this question also
// started at 1 not 0. 

public static void printOddElements(int index, int[] arr) {
    
    if (index >= arr.length()) {
        // if you used println you would add a new line after each character, make sure you made use of print
        System.out.print( "." );
        return;
    }
    
    // if odd index
    if ((index + 1) % 2 != 0) {
        // the final character will add the space needed between characters and the full stop
        System.out.print( arr[index] + " " );
    }
    
    // make sure you printed the characters at odd index before the recursive call, if after the elements 
    // would have been printed in repeat order starting with the full stop
    printOddElements(index + 1, arr);
}
```

### Question 5
A self-organising list stores objects representing customers of a large supply company. When an item is ordered 
the clients details must be looked up in the list. Almost all clients place a large number of separate orders in  
a batch, and then do not place orders for several weeks. The Computer has limited memory. Select the most appropriate 
self-organizing list to use

1. Count 
2. Move To Front 
3. Transpose 
4. Ordered List


### Motivation & Answer 
The computer has limited memory so Count method would not be suitable as it adds memory, to store count variables.
Ordered List is not self organising and should not be considered as a valid option, so in that regard 1 and 4 should 
be invalid.

Between Transpose and MTF, both will use about the same memory so both could be possible solutions BUT the questions says 
> Almost all clients place a large number of separate orders in a batch, and then do not place orders for several weeks

This favors the MTF algorithm as moving clients orders closer to the front will speed search operations up significantly 
if they have not placed orderes in several weeks, whereas the Transpose method would only slowly move the client 
closer the front, and it may not even get there by the time the batch finishes

Therefore I would answer: 
> 2: Move to Front

<img src="images/question_6.png" alt="question 6">

### Answer 

> d

<img src="images/question_7.png" alt="question 7">

### Answer 

2<sup>n</sup> - 1 = total Nodes in a binary tree (where n = height)<br />
In a Complete tree all non-terminal nodes will have both children, we can reduce height by 1 to get all 
non-terminal nodes. <br />
All non-terminal nodes will have a left and right child, therefore we can divide by 2 to find all left children

> dividing by 2 => subtracting a power

> (2 <sup> 17 </sup> - 1) = 131071

<img src="images/question_8.png" alt="question 8">

### Answer

> 1 -> 4 -> 6 -> 8 -> 7 -> 9 -> 5 -> 3 -> 13 -> 14 -> 12 -> 50 -> 24 -> 15 -> 11

<img src="images/question_9.png" alt="question 9">

### Answer 
**Motivation for not an array**: Most customers are not going to go to every restaurant, therefore it is likely
that the data will be sparse

> b. sparse table, because it is quicker to grow the number of rows and columns <br />

<img src="images/question_10.png" alt="question 10">

The recursive function must have the following signature 
```java
public Node deleteOddLeaves(Node n) {}
```

### Answer

```java
public Node deleteOddLeaves(Node n) {
    if (n == null) {
        return null;
    }
    
    // Preorder traversal visit the node first
    // check if the nodes left and right child are leaf nodes
    if (n.left != null && && n.left.left == null && n.left.right == null) {
        // left child is a leaf node 
        if (n.left.data % 2 != 0) { // left is an odd leaf node
            // I could have added this to the outer if but this is just so many conditions
            n.left = null;
        }
    }

    if (n.right != null && n.right.left == null && n.right.right == null) {
        // right child is a leaf node 
        if (n.right.data % 2 != 0) { // right is an odd leaf node
            // I could have added this to the outer if but this is just so many conditions
            n.right = null;
        }
    }
    
    (n.left != null) ? deleteOddLeaves(n.left) : n;
    (n.right != null) ? deleteOddLeaves(n.right) : n;
    
    return n // for some reason;
}
```

### I am missing a question 11

<img src="images/question_12.png" alt="question 12">

### Answer
 **Motivation for not a Sparse table**, it is likely that every coordinate indicated in the question is
 going to need an associated value for each longitude and latitude value therefore, our data is not
 sparse.

> a. A two-dimensional array because a sparse table would take up too much data in memory <br />

<img src="images/question_13.png" alt="question 13">

### Answer 

> b

<img src="images/question_14.png" alt="question 14">

### Answer 

**deleted by COPYING with SUCCESSOR**

> 6

<img src="images/question_15.png" alt="question 15">

**deleted by MERGING with PREDECESSOR**

### Answer 

<img src="images/question_15_answer.png" alt="question 15 answer" width="40%">

> 7

<img src="images/question_16.png" alt="question 16">

### Answer 

> d. High likelihood

<img src="images/question_17.png" alt="question 17">

### Answer
> for (m = i -2; m <= i; m++) // I hope you noticed this

> d. O(n<sup>3</sup>)


### I am missing question 18

<img src="images/question_19.png" alt="question 19">

> d. O(2<sup>n</sup>)

### I am missing question 20

<img src="images/question_21.png" alt="question 21">

> b. O(n)

