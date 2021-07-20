[comment]: <> (<div align="center"><h1> COS 212 Exam 1 </h1></div>)

[comment]: <> (<div align="center"><h4> Spanning Tree & Topological Sort; Graph Coloring </h4></div>)

[comment]: <> (## Question 1: [Spanning Trees]&#40;https://gitlab.com/Paul_Wood_96/tutoring/-/tree/master/COS212/notes/GraphsPart5&#41;)

[comment]: <> (For all questions that follow assume the following Graph. During traversal if at any point you must make a choice of)

[comment]: <> (where to move next chose the next vertex alphabetically.)

[comment]: <> (![img.png]&#40;../images/spanning_tree.png&#41;)

[comment]: <> (1.1&#41; Using Kruskal's eager Algorithm identify the list of edges that will be part of the spanning tree. Only identify)

[comment]: <> (the list of edges that will be part of the resulting spanning tree in the format AB, AC, AD in the case of edges between)

[comment]: <> (AB, AC and AD being a part of the spanning tree.)

[comment]: <> (![img.png]&#40;../images/spanning_tree_answer.png&#41;)

[comment]: <> (1.2&#41; For each of the following statements indicate whether the provided statement is true or false, provide a reason for)

[comment]: <> (your answer:)

[comment]: <> (1.2.1&#41;)

[comment]: <> (```text)

[comment]: <> (Dijkstra's Spanning Tree Algorithm will never look at every edge within the graph before terminating.)

[comment]: <> (```)

[comment]: <> (```text)

[comment]: <> (FALSE: Dijkstra's algorithm is lazy &#40;does not sort the edges before traversal&#41; and will look at every edge within the graph and ensure to remove the greatest edge in a cycle once )

[comment]: <> (it is detected.)

[comment]: <> (```)

[comment]: <> (1.2.2&#41;)

[comment]: <> (```text)

[comment]: <> (Kruskal Algorithm has the potential to look at every edge within the graph)

[comment]: <> (```)

[comment]: <> (```text)

[comment]: <> (TRUE: The stopping condition for Kruskal algorithm is; when the number of edges added in the spanning tree is )

[comment]: <> (equal to 1 less than the number of vertices in the graph. This is not a condition that will always result in fewer )

[comment]: <> (iterations than edges. A scenario in which the greatest value edge is the only path to a Vertex will result in )

[comment]: <> (a situation where every edge will being visited when applying Kruskals algorithm. )

[comment]: <> (```)

[comment]: <> (1.2.3&#41;)

[comment]: <> (```text)

[comment]: <> (In Dijkstra's algorithm complexity is added in determining the lowest values in cycles)

[comment]: <> (```)

[comment]: <> (```text)

[comment]: <> (TRUE: When detecting a cycle within the spanning tree, the edges which make up that cycle will have to be sorted )

[comment]: <> (in order to remove the largest weighted edge and keep the lowest weighted edges. Sorting algorithms can add )

[comment]: <> (complexity to the algorithm. )

[comment]: <> (```)

[comment]: <> (#### For All questions to Follow)

[comment]: <> (Assume the following Graph, if at any point you must make a choice of which vertex to select, chose the next vertex)

[comment]: <> (alphabetically.)

[comment]: <> (![img.png]&#40;../images/topological_sort.png&#41;)

[comment]: <> (1.3&#41; Apply the topological sorting algorithm on the graph below, provide the order for each vertex in the graph.)

[comment]: <> (| Vertex | TS |)

[comment]: <> (| --- | --- |)

[comment]: <> (| A |  4 |)

[comment]: <> (| B | 9 |)

[comment]: <> (| C | 5 |)

[comment]: <> (| D | 8 |)

[comment]: <> (| E | 12 |)

[comment]: <> (| F | 7 |)

[comment]: <> (| G | 10 |)

[comment]: <> (| H | 1 |)

[comment]: <> (| J | 3 |)

[comment]: <> (| P | 6 |)

[comment]: <> (| X | 11 |)

[comment]: <> (| Z | 2 |)

[comment]: <> (![img.png]&#40;../images/topological_sort_answer.png&#41;)

[comment]: <> (## Question 2: [Graph Coloring]&#40;https://gitlab.com/Paul_Wood_96/tutoring/-/blob/master/COS212/notes/GraphsPart6/README.md&#41;)

[comment]: <> (For all questions that follow assume the following Graph and color table, and answer the questions that follow.)

[comment]: <> (![img.png]&#40;images/graph_coloring.png&#41;)

[comment]: <> (2.1&#41; Assuming the Brelaz coloring algorithm was applied to the graph, indicate the selected color for each vertex after)

[comment]: <> (having applied the coloring algorithm. Use the color index provided in the image.)

[comment]: <> (| Vertex | Color |)

[comment]: <> (| --- | --- |)

[comment]: <> (| A |   |)

[comment]: <> (| B |   |)

[comment]: <> (| C |   |)

[comment]: <> (| D |   |)

[comment]: <> (| E |   |)

[comment]: <> (| F |   |)

[comment]: <> (| G |   |)

[comment]: <> (| H |   |)

[comment]: <> (## Question 3: [Sorting]&#40;https://gitlab.com/Paul_Wood_96/tutoring/-/blob/master/COS212/notes/Sorting/README.md&#41;)

[comment]: <> (3.1&#41; Insertion sort works by intuitively sorting a list, placing elements in order at each iteration. The algorithm is)

[comment]: <> (made up using a combination of an inner and outer loop. The outer loop iterates through the elements in the list from)

[comment]: <> (left to right, the inner loop sorts the array up until the counter of the outer loop selecting the element to place at)

[comment]: <> (each index.)

[comment]: <> (Implement a recursive implementation of the insertion sort outer loop which will created a sorted. Your implementation)

[comment]: <> (should explore the elements going from the back of the list first.)

[comment]: <> (```kotlin)

[comment]: <> (fun insertSort&#40;array: Int[], index: Int&#41; {)

[comment]: <> (})

[comment]: <> (```)

[comment]: <> (3.2&#41; For each of the following stamens select the statement that is correct)

[comment]: <> (.1&#41;)

[comment]: <> (```text)

[comment]: <> (    i. Only Radix sort has the potential to have a complexity of `O&#40;n&#41;`)

[comment]: <> (    ii. Only Count sort has the potential to have a complexity of `O&#40;n&#41;`)

[comment]: <> (    iii. Neither Radix sort nor Count sort has the potential to have a complexity of `O&#40;n&#41;`)

[comment]: <> (    iv. Both Radix sort and Count sort have the potential to have a complexity of `O&#40;n&#41;`)

[comment]: <> (```)

[comment]: <> (2. When sorting identical elements, which of the following algorithms will **NOT** guarantee that the identical elements)

[comment]: <> (   order in the list will remain unchanged after the algorithm has been applied.)

[comment]: <> (```text)

[comment]: <> (    i. Selection sort & Insertion sort)

[comment]: <> (    ii. Heap sort and Count sort)

[comment]: <> (    iii. Merge sort and Radix sort)

[comment]: <> (    iv. Comb sort and Shell sort)

[comment]: <> (```)

[comment]: <> (3. If swap operations are expensive which of the following algorithms is the least efficient on average?)

[comment]: <> (```text)

[comment]: <> (    i. Shell sort)

[comment]: <> (    ii. Count sort)

[comment]: <> (    iii. Selection sort)

[comment]: <> (    iv. Quick sort)

[comment]: <> (```    )

[comment]: <> (4. Which of the following algorithms is the most efficient for sorting a list that is in order)

[comment]: <> (```text)

[comment]: <> (    i. Insertion sort)

[comment]: <> (    ii. Radix sort)

[comment]: <> (    iii. Count sort)

[comment]: <> (    iv. Quick sort)

[comment]: <> (```    )

[comment]: <> (#### For each of the following)

[comment]: <> (Please specify the algorithm that was used to result in the following output.)

[comment]: <> (3.3&#41;)

[comment]: <> (.1 ![img.png]&#40;images/merge_sort.png&#41;)

[comment]: <> (```text)

[comment]: <> (```)

[comment]: <> (.2 ![img.png]&#40;images/heap_sort.png&#41;)

[comment]: <> (```text)

[comment]: <> (```)

[comment]: <> (.3 ![img.png]&#40;images/shell_sort.png&#41;)

[comment]: <> (```text)

[comment]: <> (```)

[comment]: <> (4. ![img.png]&#40;images/radix_sort.png&#41;)

[comment]: <> (```text)

[comment]: <> (```)

[comment]: <> (5. ![img.png]&#40;images/bubble_sort.png&#41;)

[comment]: <> (```text)

[comment]: <> (```)

[comment]: <> (6. ![img.png]&#40;images/selection.png&#41;)

[comment]: <> (```text)

[comment]: <> (```)

[comment]: <> (## Question 4: [Hashing]&#40;https://gitlab.com/Paul_Wood_96/tutoring/-/blob/master/COS212/notes/Hashing/README.md&#41;)

[comment]: <> (Assume the following data:)

[comment]: <> (> 122 14 16 17 5 8 35 27 13)

[comment]: <> (Assume that Coalesced Hashing with a cellar was being applied to the data above using the following Hash function:)

[comment]: <> (`H&#40;K&#41; = 2k % 7 + 3`.)

[comment]: <> (4.1.1&#41; Insert the following table where each row indicates the fields value and coalesced pointer. Insert the data and)

[comment]: <> (indicate the pointer values for each collision you encounter, in the case of multiple collision you should make use of)

[comment]: <> (Quadratic Probing. The cellar starts at index 8)

[comment]: <> (<img src="images/hashing.png" alt="hashing" width="20%">)

[comment]: <> (4.1.2&#41; Assume the element 8 was deleted, describe the steps needed to perform this operation)

[comment]: <> (4.1.3&#41; Assume element 27 was deleted, show the table after this operation has been performed)

[comment]: <> (## Question 4.2: [Hashing Cichelli’s]&#40;https://gitlab.com/Paul_Wood_96/tutoring/-/blob/master/COS212/notes/Cichellis/README.md&#41;)

[comment]: <> (Given the following words, in no particular order.)

[comment]: <> (> January February March April May June July)

[comment]: <> (4.2.1&#41; Perform Cichelli's algorithm to perfectly hash the following words into a table. for each greek letter indicate)

[comment]: <> (the correct response)

[comment]: <> (|  |  |)

[comment]: <> (| --- | ---|)

[comment]: <> (| 0 | i |)

[comment]: <> (| 0 | ii |)

[comment]: <> (| 0 | iii |)

[comment]: <> (| 0 | iv |)

[comment]: <> (| 0 | v |)

[comment]: <> (| 0 | vi |)

[comment]: <> (4.2.2&#41; Give the offset values for each letter used after applying Cichelli's algorithm)

[comment]: <> (## Question 5: [Encoding]&#40;https://gitlab.com/Paul_Wood_96/tutoring/-/blob/master/COS212/notes/Encoding/README.md&#41;)

[comment]: <> (5.1&#41; Assume the following string needed to be encoded in a way that would best make use of memory, while still being)

[comment]: <> (able to decoded.)

[comment]: <> (> Sassy Susy sells seashells)

[comment]: <> (.1&#41; Which encoding algorithm would be best suited to encode this string and why?)

[comment]: <> (```text)

[comment]: <> (```)

[comment]: <> (.2&#41; Name a few disadvantages of Adaptive Huffman over regular Huffman)

[comment]: <> (```text)

[comment]: <> (```)

[comment]: <> (5.2.1&#41; Assume the following records were kept which tracked the recorded percentages of rain fall in each month of a)

[comment]: <> (given year. You may assume that no rain fell in months that are not recorded. You are required to encode this data using)

[comment]: <> (Huffman encoding please provide the Huffman tree once you have finished encoding each of the specified months)

[comment]: <> (|January | February | June | September |October | November | December |)

[comment]: <> (| --- | --- | --- | --- | --- | --- | --- |)

[comment]: <> (| 0.17 | 0.12 | 0.02 | 0.25 | 0.11 | 0.11 | 0.22 |)

[comment]: <> (5.2.2&#41; Please fill in the Huffman encoding values for each month in the table below)

[comment]: <> (|January | February | June | September |October | November | December |)

[comment]: <> (| --- | --- | --- | --- | --- | --- | --- |)

[comment]: <> (| | | | | | | |)

[comment]: <> (5.3&#41;)

[comment]: <> (The adaptive huffman is an extension to the regular Huffman tree which does not require the probability of each value to)

[comment]: <> (be known beforehand. Assume the following string)

[comment]: <> (> abeebac)

[comment]: <> (Please apply the adaptive huffman to the input string above but please read all questions first before moving on from)

[comment]: <> (this point, you may assume the following alphabet node)

[comment]: <> (![img.png]&#40;images/alphabet_node.png&#41;)

[comment]: <> (5.3.1&#41; Provide the encoded text for the String after the 4 input chapter has been added)

[comment]: <> (```text)

[comment]: <> (```)

[comment]: <> (5.3.2&#41; What is the encoded value for the letter b after it has been inserted the second time)

[comment]: <> (```text)

[comment]: <> (```)

[comment]: <> (5.3.2&#41; If you were to add the letter `f` to the encoded string after all the values had been added, what would you add)

[comment]: <> (to the Encoded String after the letter `f` has been placed in the huffman tree.)

[comment]: <> (```text)

[comment]: <> (```)

[comment]: <> (## Question 6: [String Matching]&#40;https://gitlab.com/Paul_Wood_96/tutoring/-/blob/master/COS212/notes/StringMatching/README.md&#41;)

[comment]: <> (Assume you were applying the Knuth-Morris-Pratt algorithm for the pattern `cacctaca`)

[comment]: <> (fill in the values below for the next array)

[comment]: <> (|Ptt: | c | a | c | c | t | a | c | a |)

[comment]: <> (| --- | --- | --- | --- | --- | --- | --- | --- | --- |)

[comment]: <> (| j | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 |)

[comment]: <> (| next | | | | | | |)
