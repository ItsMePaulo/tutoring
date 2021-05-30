<div align="center"><h1> Graphs Part2: Shortest Path </h1></div>

Throughout the next few lessons we will mostly be looking at algorithms on Graphs not so much creating Graphs. The
important thing to note is that if you understand the algorithms you will very easily be able to answer the questions on
them in your exams, so from this point on practice each of the following algorithms, and you will be fine.

## 4 Different algorithms

There are 4 different algorithms for Shortest Path, be very sure you know which one they are asking you for in the exam
therefore, READ THE QUESTION.

The four algorithms are as follows:

1. Dijsktra’s algorithm
2. Ford algorithm
3. Dijsktra’s (Fixed)
4. Shortest Path ALL to ALL (unique)

## The Shortest Path

There are two things we want to know when want to find the shortest Path, the total distance and the path we took to get
there. Therefore, we need to add 2 variables to the Vertex class, a `previous` field and a `distance` field.

```java
class Vertex<T> {
    T value;
    Edge[] edges;
    Vertex<T> prev; // newly added
    Int dist; // newly added

    public Vertex(T v) {
        value = v;
        prev = null;
        dist = MATH.INFINITY;
    }
}
```

We are going to use the `prev` field to highlight the path back from the shortest path and we are going to use
the `dist` field to calculate the shortest path.

## Dijsktra (The God of Datascience)

Dijsktra proposed an algorithm that visits every Node once and selects the *"closest"* neighbour first from a priority
queue. Here is the sudo code

````kotlin

import java.util.*

fun dijsktra(start: Vertex) {

    foreach(v in vertices) {
        v.dist = Math.INFINITY;
    }

    start.prev = null;
    start.dist = 0;

    val unvisited: PriorityQueue<Vertex> // in this case a Min Heap would work very well
    unvisited[0] = start;

    while (unvisited.isEmpty().not()) {
        val curr = unvisited[0] // the NEXT LOWEST/CLOSEST neighbor by dist

        unvisited.remove(curr) // visited so we don't need to look at it again right??


        for (neighbor: Vertext in curr.nighbors) { // you will have to traverse the edges to get the neighbors here
            val dist = curr + curr.edgeBetweenThemWeght
            
            if (dist < neighbor.dist) {
                neighbor.dist = dist
                neighbor.prev = curr // to make a path
            }
        }
    }
}
````

### There was a flaw in my Approach (yes I like Overwatch)

Dijsktra does now work well with negative numbers. Example


## Bellman-Fords Algorithm 

Instead of looking at all the Vertices look at all the Edges.
