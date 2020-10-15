<div align="center"><h1> Linked Lists </h1></div> 


## Problem: I don't know the Size of my Aarray!?
What if the size of the array is dynamic but you don't know what it is going to be at compile time. Lets say for example you wanted to store the number of blue jelly beans you get in a bag of jellies, every time you encounter a blue jelly bean you add value to the array. Simple but there is one problem

```c++

    int blueBeans[?] // if it was a static array 
    int blueBeans = new int[?] // or a dynamic heap array we still need to know the size

```

Some people would just assign a default value of an absurdly large number, that way the program has a buffer and its not likely that the program will ever need more than that much space so you solve the problem. 

```c++

    int blueBeans[5000];
    int blueBeans = new int[5000];

```

But this is really not pretty, what if you only ever need an array of size one, you will never need all that memory you've just allocated and you end up reserving a large part of the programs allocated memory for this array which will never need it. 

## Dynamic Arrays 
(Another kind of dynamic) this time we mean dynamic size. In this case instead of reserving a whole lot of memory that may or may not be used, adjust the size of the array when necessary. In C++ we can do this using the standard template library `<vector>`. Why is it called vector? ... It shouldn't be, there is nothing math related about this class, actually it behaves much more like an array list 

#### The Vector class
The vector class, is just that, a class provided to you by C++ which means it has functions and paramters which you can call as if you where calling one of your own predefined classes. So instead of including `"CustomClass.h"` you include `<vector>`. 
Lets say we want to create a vector of ints for our blue jelly bean example.


```c++
    vector<int> blueBeans;

```

Notice anything interesting? Do you remember the syntax `<typename>`? The vector class is actually a [template class](https://gitlab.com/Paul_Wood_96/tutoring/-/blob/master/COS110/notes/Templates.md#class-templates), that's because the logic behind the vector class remains the same regardless of type. This means we can replace `<int>` with absolutely anything `<*>`. All the vector class does for us is keep track of the arrays current size, and increases our array if new values are added and we don't have enough space for it. It actually does this by creating new arrays for us and copying over the old ones. At a high point that is all you should need to know about the vector class, but lets also look at some simple operations. 



```c++
    vertices.push_back(5); // adds a value 
    vertices.erase(vertices.begin() + 1); // removes a value (we need to pass in an iterator)

    vertices.size() // gets the size
    vertices.clear() // deletes the whole array
```

## Linked Lists 
vertices are cool but, there is one aspect to array insertion/deletion were vertices are not very perfermant. What happens when we want to perform an operation (insert or delete) at a specific index. Well if we use a vertex, all of the allocated memory shifts either up or down by one, which is not very effeciant. 
Linked list focus on the best of both worlds, improving the weaknesses of vectors. The concept behind a linked list is actually quite simple, hold data and point to the next piece of data. That's it really. 

We call the block in the linked list a `node`. Please get very used to the word node it is used to represent a block in almost all data structures that follow this one. 

Lets look at a classic template that we can use to make a linked list class 


```c++
    class NumberList {
    private :
        struct ListNode {
            int value;
            struct ListNode *next;
        }

        ListNode* head; // start 
    
    public :

        NumberList() {
            head = nullptr;
        }

        ~Destructor();

        // common functions
        void append(int);
        void insertNode(int);
        void deleteNode(int);
        void dsiplayList();

    }

```

Definition of `append` is to just add a node to the list. Here is the sudo code 

* create a new node from the data 
* first check if head is assigned if it is not assign the new node to head 
* else we need to move through the list until we find a nullptr (this signifies we are at the tail)
* add the new node to the tail of the list

Definition of `insertNode` is to add the node at any location in the array-
 array. Assuming the array is sorted we should add the node into the array if the next is smaller than the value being passed in, else we should keep moving untill we find a next that is smaller than the value being passes in or a nullptr. Here is the sudo code

* create a new node
* check if head is null; if true assign new created node as head 
* else loop through the array untill you find a smaller next OR a nullptr
* Keep track of your previous pointer, you will need it later
* if we find a bigger next we cant just put the node into the list at this point and set its next to the bigger node
* we also need to update the previous value in the list and make sure it points to the newly created node 

Definitions of `deleteNode` is to remove the node that has the value being passed in 

* Check if head is null: if true return error 
* Loop throuh the list keeping track of a previous node
* if you find the node with the value of the paramter passed in do the folloowing:
    * make a temp of that nodes next 
    * delete that node 
    * make sure to update the previous nodes next to the new temp

Definition of `dsiplayNode` is to oputput the list. Here is the sudo code 
* Check if head is null: if true return error 
* Loop throuh the list and output the nodes value

## Variations on a Linked ListNode

#### A Circular Linked List
This is a linked list where the tail always points back to the head. 
I want to start thinking about the above mentioned operations using a circular linked list approach. 

#### A Doubly Linked List
This is a linked list where we don't only have a reference to the next value but also to our previous. 
Again lets discuss how the implementations of that would look.  




