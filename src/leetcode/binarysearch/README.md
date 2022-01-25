#How do we identify Binary Search?

As mentioned in earlier, Binary Search is an algorithm that divides the search space in 2 after every comparison. Binary Search should be considered every time you need to search for an index or element in a collection. If the collection is unordered, we can always sort it first before applying Binary Search.



3 Parts of a Successful Binary Search

Binary Search is generally composed of 3 main sections:

    Pre-processing - Sort if collection is unsorted.

    Binary Search - Using a loop or recursion to divide search space in half after each comparison.

    Post-processing - Determine viable candidates in the remaining space.



3 Templates for Binary Search

When we first learned Binary Search, we might struggle. We might study hundreds of Binary Search problems online and each time we looked at a developer's code, it seemed to be implemented slightly differently. Although each implementation divided the problem space in 1/2 at each step, one had numerous questions:

    Why was it implemented slightly differently?

    What was the developer thinking?

    Which way was easier?

    Which way is better?

After many failed attempts and lots of hair-pulling, we found 3 main templates for Binary Search. To prevent hair-pulling and to make it easier for new developers to learn and understand, we have provided them in the next chapter.