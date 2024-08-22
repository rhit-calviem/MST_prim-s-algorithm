# CSSE 230 Project

## Authors
- Matteo Calviello
- Garret Doolittle

## Prim’s Algorithm

### Data Structures Used

- **ArrayList<Node>**: The `result` ArrayList stores the nodes that form the minimum spanning tree (MST). Nodes are added to this list as they are selected during the algorithm's execution. `ArrayList` is chosen because it offers constant-time access and fast iteration, making it efficient for adding nodes and iterating through them. Each `Node` contains an element and an `ArrayList` of edges.

- **PriorityQueue<Edge>**: The `PQ` (minimum PriorityQueue) stores the edges connecting nodes in the MST. It ensures that edges with the lowest value (cost) are always at the top of the structure, so they can be polled first. This allows the algorithm to efficiently select the minimum value edge. `PriorityQueue` is ideal for storing edges as it allows efficient insertion and removal in logarithmic time. Each `Edge` contains a value (cost), the starting node (`one`), and the ending node (`two`).

- **HashSet<Node>**: The `visitedNodes` HashSet tracks nodes that have been visited and added to the MST. It is crucial for avoiding cycles in the graph. The `HashSet` is important for the runtime efficiency of the algorithm, as it provides efficient random access.

### Runtime Analysis

| # Nodes   | All Nodes Connected to Each Other | All Nodes in a Line |
|-----------|-----------------------------------|---------------------|
| 10        | 0.000 s                           | 0.000 s             |
| 100       | 0.002 s                           | 0.000 s             |
| 1,000     | 0.055 s                           | 0.001 s             |
| 5,000     | 0.740 s                           | 0.004 s             |
| 10,000    | 3.312 s                           | 0.005 s             |
| 100,000   | Memory Overflow                   | 0.040 s             |
| 1,000,000 | Memory Overflow                   | 0.298 s             |
| 10,000,000| Memory Overflow                   | 3.237 s             |

The outer `while` loop runs at most `(E-V-2)` times. The polling of each `Edge` from the PriorityQueue has a runtime of `log(V)` because there are at most `(v-1)(v-2)/2 + 1` edges in the PriorityQueue. This means that the `poll` function runs at most `(E-V-2) * log(V)` times. The `add` function runs at most `2E * log(V)` times. Therefore, the overall time complexity of the algorithm is `O((E)log(V))` or `O(V^2log(V))` in the worst case.

### Graphs and Results

#### A small fully connected graph and the output of our algorithm:

![Fully Connected Graph](C:\Users\calviem\OneDrive - Rose-Hulman Institute of Technology\Desktop\fully_connected.png)

#### A small sparse graph and the output of our algorithm:

![Sparse Graph](C:\Users\calviem\OneDrive - Rose-Hulman Institute of Technology\Desktop\sparse_graph1.png)

#### A small sparse graph with a few more connections and the output of our algorithm:

![Sparse Graph with More Connections](C:\Users\calviem\OneDrive - Rose-Hulman Institute of Technology\Desktop\sparse_graph2.png)

### Discoveries

During the implementation, we noticed some redundancy when adding `Nodes` to both the `HashSet` `visitedNodes` and the `ArrayList` `result`. The `visitedNodes` contains exactly the same nodes in the same order as `result`, with the only difference being the access time. While `HashSet` is faster for access, it turned out that using an `ArrayList` for `result` resulted in a faster runtime for iteration, particularly in the final `if` and `for` loops. 

After some research, we found that in certain scenarios, an `ArrayList` can be preferred over a `HashSet` due to its faster iteration capabilities. This is because a `HashSet` is implemented using a hash table, which relies on keys to organize and locate elements. During iteration, the `HashSet` needs to traverse its internal data structure, which involves additional hash code calculations, comparisons, and pointer manipulations, leading to higher iteration times. Therefore, when the task requires specific properties like ordering and fast iteration, `ArrayList` is a better choice.
