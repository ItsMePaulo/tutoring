<div align="center"><h1> Bit Trees </h1></div>

Searching a B+ Tree sequentially is rather inefficient, so in order to search the leaf level faster a more efficient
searhing algorithm is required.

Bit trees are really good for searching prefixes in strings or for finding numbers as
well. Yet they only work in binary so I hope you remember how to convert 7 to

0111

Bit trees look for what is called a distinction bit, what this means is it compares 2 binary strings and looks for the
first leftmost bit that’s different. ie. Lets say we had the 2 binary strings 0010 = 2 0100 = 4 The bits at index 1 are
different. (Remember index’s start at zero so the second bit actually represents index 1)
Using these bits and the differences between them we can drastically limit a search by stopping after a certain point is
reached in the search loop. But how??? First there is one more important thing about bit searches. Keys are stored in
ascending order. This means a change in left most bit will ALWAYS ALWAYS result in the changed bit being a 1. You can
try it out here are the following binary strings for the numbers 2, 3, 5, 6, 8 respectively. Compare each pair moving
down the list and find the index of the distinction bit. Check what that bit is.
