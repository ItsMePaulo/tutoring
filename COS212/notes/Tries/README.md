A form of an M way tree that helps with storing strings by using prefixes
better than bit trees. Stores primitive building blocks of prefixes yay that
means nothing!!!! The building blocks in a string is its character.Lets say you want to store the words interc eption and
interc ommunication
They share the common prefix inter + c so the building blocks will be
I – N – T – E – R – C then the remaining suffix of each word would
appear underneath the nodes.
Each node would contain all the letters one could expect or for simplicity
all the letters of the alphabet. The word will be built from these nodes
and corresponding letters for example if we look at the above example.

Notice how wherever there is a constant prefix there is a new node and
the suffixes of the word are all that left at the end. Also note that I
skipped out a lot of the letters each node would have to contain the
entire alphabet or the alphabet of the letters used in the scenario well a
standard trie there is a version of a trie where only the references letters
are shown at each node.Also notice the height of a trie is = one larger than the highest prefix...
(They love this question I mean really love this question)
A couple more important things what if a word exists in a prefix like the
word pre in prefix... in cases like this we need to also add a character to
signify an end of word case for instances like this.

In this example a # symbol was used(generally we will always use this
symbol). Notice how the word bee exists in the word beer but we mark it
by referring to the # symbol for that word. Also in this example the entire
word was used at the bottom is this really necessary.

Implementing it like so saves space and is more efficient.
I want you guys to use the example above and insert the following words
Barber, Add, Adder, Dread.
1 more thing A tergo is a trie in reverse, So instead of searching for the
largest prefix you would search for the largest suffix and insert words in
reverse.
They love tricking people in exams by asking them what is the height of
a tergo and very naively everyone just rushes in and counts the prefixes
when they should be looking at the maximum suffix instead just
something to keep in mind for when we go over questions.
