# Java Algorithms and Data Structures
This repo is a collection of basic Java algorithms and data structures.

## Sorting Algorithms
 - **Bubble Sort**: Simple sort that compares an element to the element directly beside it, then swaps if necessary. Very
 simple, and can work not terribly if the data set is small and/or is nearly sorted - its best case time complexity
  is only Ω(n). On the other hand, its worst case time complexity is O(n<sup>2</sup>).
 - **Exchange Sort**: Also a simple sort comparison algorithm, exchange sort takes an element and compares it to every 
 other element of the collection, before moving on to the next element. It is the same complexity as bubble sort.
 - **Insertion Sort**: Works similar to how a person sorts a hand of cards. Insertion sort builds the final sorted collection 
 one element at a time by inserting the next element into its proper spot among the previously sorted elements. Works 
 best when it the collection is mostly sorted, with a worst case of O(n<sup>2</sup>).
 - **Selection Sort**: Selection sort searches an entire collection, finds the minimum value, places that in the first index
 and then repeats. Then it does the same thing for the remaining elements/indices. It is slow because it has to 
 evaluate all remaining elements of the collection every swap, so even in the **best** case scenario has a time complexity
  of O(n<sup>2</sup>).
 - **Merge Sort**: More efficient than all of the previous sorts, merge sort uses divide-and-conquer recursion to compare
  parts of the collection then merges them back together to sort the total collection. It has a time complexity of 
  O(n log n).
 - **Quick Sort**: Similar to merge sort, quick sort also uses a recursive divide-and-conquer methodology. It selects a 
 pivot, then partitions all elements less than the pivot before it, and elements greater after it. It then recursively
 applies those steps to each subgroup, creating more subgroups as needed until the collection is sorted. It has an 
 average time complexity of Θ(n log n), although in worst case it can be O(n<sup>2</sup>).

## Search Algorithms
 - Binary Search
 - Recursive Binary Search

## Data Structures
  - Linked List
  - Doubly Linked List
  - **Queue**
  - Stack
  - Hash map
  - Binary Search Tree
