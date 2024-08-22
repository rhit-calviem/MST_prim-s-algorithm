# MST_prim-s-algorithm
CSSE 230 Project										Matteo Calviello
												Garret Doolittle
Prim’s Algorithm
Code:













 The implementation of Prim’s algorithm utilizes the following data structures:
ArrayList<Node>: The ‘result’ ArrayList is used to store the nodes that form the minimum spanning tree (MST). Nodes are added to the list as they are selected during the execution of the algorithm. ArrayList is used for the ‘result’ list because it offers constant-time access and a fast time iteration time, making it efficient for adding nodes to the MST and iterating through it. Each Node contains an element and an ArrayList of edges.
PriorityQueue<Edge>: The ‘PQ’ minimum PriorityQueue is used to store the edges that connect the nodes in the MST. The PriorityQueue ensures that the edges with lowest value (cost) are always at the top of the structure (root), so that they can be polled first. This allows the algorithm to select the minimum value edge efficiently. PriorityQueue is suitable to store edges because it allows for efficient insertion and removal of edges in logarithmic time. Each Edge contains a value (cost) and the node from which it starts at (one) and the node that it reaches (two).
HashSet<Node>: The ‘visitedNodes’ HashSet is used to keep track of the nodes that have been visited and added to the MST. It is useful because it helps avoid revisiting nodes and therefore creating cycles in the graph. The use of a HashSet is of vital importance to the runtime of the algorithm as it has an efficient random-access runtime.
Runtime:
# nodes
All nodes connected to each other
All nodes in a line
10
0.000 s
0.000 s
100
0.002 s
0.000 s
1000
0.055 s
0.001 s
5000
0.740 s
0.004 s
10000
3.312 s
0.005 s
100000
Memory Overflow
0.040 s
1000000
Memory Overflow
0.298 s
10000000
Memory Overflow
3.237 s




The outer while loop runs at most (E-V-2) times. The polling of each Edge from the Priority Queue runtime is log(V) time because there are only at most (v-1)(v-2)2+1 edges in the Priority queue. This means that the poll function at most runs E-V-2*2log V  times. The add function at most runs 2E*log⁡(V) times. Adding these together you get
 4E-2V-4*log⁡(V). The big-O runtime of the algorithm is O((E)log(V)) or O(V2log⁡(V) in the worst case.


Graphs and Results
A small fully connected graph and the output of our algorithm:










A small sparse graph and the output of our algorithm:







A small sparse graph with a few more connections and the output of our algorithm:







Discoveries
As can be seen from the code snippet above, there are some repetitions of adding Nodes to both the HashSet ‘visitedNodes’ and the ArrayList ‘result’. This is because visitedNodes contains exactly the same nodes, in the same order, as result; the only difference is that the access time for a HashSet is faster compared to an ArrayList. This comes in very useful in the last ‘if’ and ‘for’ loop as it heavily reduces the time complexity of the algorithm. We tried to avoid this code duplication by setting ‘result’ as a HashSet<Node>  and removing ‘visitedNodes’ but, instead of the code running similar to before, we discovered that the runtime was slower. 
After some research we discovered that in certain scenarios, an ArrayList can be preferred over a HashSet as it has a faster iteration capability. HashSet excels in access time but iterating over its elements can sometimes be slower. This is due to the fact that a HashSet is implemented using a hash table, which relies on keys to organize and locate elements. During an iteration, the HashSet needs to traverse its internal data structure, typically hash buckets, to access each element. The traversal process requires additional hash code calculations, comparisons, and pointer manipulations, resulting in a higher iteration time. Therefore, when testing and analyzing specific properties of elements, such as ordering and accessing elements, ArrayList is a faster and better choice.
