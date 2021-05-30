<div align="center"><h1> Graphs </h1></div>

By now we know how to effectively store and retrieve data in efficient data structures called Trees. Trees work very
well for organised data, by that I mean data that we can easily compare with or sort into some kind of hierarchy. But
what happens when we deal with *"Chaotic"* data, data that we cannot organise in any logical way?

When we encounter data that can not be organised as left or right, greater than or equal to, we need a new data
structure to help map out this sort of relational data. A good example of data that cannot be organised in a Tree like
fashion is Mapping data. Imagine we wanted to map out a city, and map out specific landmarks and the distance from one
landmark to another, to do this we should represent each landmark as a Node and its distance from each other landmark as
well. If we do this we get something like this;

Notice how the data has no hierarchy, no *"Root"* or clear starting point, the data is just laid out all jumbled waiting
for us to use it. This is a Graph, and it is a very useful data-structure, used in algorithms like Google Maps, Social
Media (map out relationships), and also many AI algorithms.

### There are two parts to every graph.

1. The Vertices (You used to call these Nodes)
2. The Edges (These used to be imaginary)

More on Edges and vertices in a bit, first lets look at some Graph examples.

## Different Graphs

1. Simple graph
    * just represents a bunch of edges and the vertices and their relationships. Important to note that edge (i , j) is
      equal to edge (j , i)


2. Directed graph
    * One where each edge has only one direction thus if we can go `from i to j` we cannot go back `from j to i`


3. Multi-directed graph
    * Multiple edges from one node the another can exist. Thus one may travel back and forth


4. Pseudograph
    * Vertices may reference themselves.


5. Complete graphs
    * Every vertex references every other vertex.


6. Weighted graph
    * Graph where the edges have weights

The weighted graph is important, **edges** between **vertices** have a value, this is unique to Graphs we have not seen
this pattern in Trees before. Before, in Trees, we only imagined the connectors between Nodes but now those connectors
can hold a value (just like the Nodes themselves) Because of this, Graphs are composed of 2 Node like classes.

Both Edges and Vertices are classes and they would look something like this

```java
// The vertex class will be expanded as we look at more algorithms
class Vertex<T> {
    T value;
    Edge[] edges;

    public Vertex(T v) {
        value = v;
    }
}
```

```java
class Edge {

    Number weight;
    Vertex from; // the Node this is attached to 
    Vertex to; // the Node this edge points to, not always bi-directional. You may only be able to traverse from and to
}
```

## Graph Traversal

As always before we learn how to make a graph we learn how to traverse one, Graph traversal is relatively tricky. Unlike
Trees there is no hierarchy, and we run a risk of visiting the same Vertices twice (this could never happen in a tree).
To solve this we need some way of identifying if a Vertex has been visited, well we could use a boolean `visited` and
set it to true if we wanted sure... But actually if we used a counter instead... we could also get the order in which
the Nodes were visited. This could be far more useful.

### Add a counter to the Vertex

```java
class Vertex<T> {
    T value;
    Edge[] edges;
    Int counter; // newly added

    public Vertex(T v) {
        value = v;
    }
}
```

Now we can use recursion to traverse the Graph using a stack and updating the counter variable only if a Node does not
have a counter already assigned. We can set all the Vertices counter variable to an invalid number like infity or -1
initially to indicate that it has not been visited, then when we loop through the

```java
class Graph {

    private Vertex[] vertices; // you will need an array with all vertices for most algorithms

    void visitGraph() {

        for (Vertex v : vertices) {
            v.counter = -1; // set counter to -1
        }

        traverseVertex(vertices[0], 0);
    }

    private void traverseVertex(Vertex v, int counter) {
        if (v.counter == -1) {
            return;
        }

        v.counter = counter++; // visit

        for (Edge edge : v.edges) {
            traverseVertex(edge.to, counter);
        }
    }
}
```

You can also use a Queue and visit each Vertex in a *Breadth* First manner instead of a *Depth* first manner, the above
algorithms is using a Depth First approach. The order in which vertices are visited will differ when using a depth first
search vs a Breadth first search. In a Breadth first search add all the vertices neighbors to a queue and then pop
them off one by one and assign them the counter **IF** they don't already have a counter.

