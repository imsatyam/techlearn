### Prim's Algorithm
Prim’s algorithm is a Greedy algorithm. It starts with an empty spanning tree. The idea is to maintain two sets of vertices. 
The first set contains the vertices already included in the MST, the other set contains the vertices not yet included.


### How does Prim’s Algorithm Work?
The idea behind Prim’s algorithm is simple, a spanning tree means all vertices must be connected. So the two disjoint
 subsets (discussed above) of vertices must be connected to make a Spanning Tree. And they must be connected with the
 minimum weight edge to make it a Minimum Spanning Tree.
 

### Algorithm
1. Create a set mstSet that keeps track of vertices already included in MST.
 2. Assign a key value to all vertices in the input graph. Initialize all key values as INFINITE.
 3. Assign key value as 0 for the first vertex so that it is picked first.
 4. While mstSet doesn't include all vertices
    
    a. Pick a vertex u which is not there in mstSet and has minimum key value.
    
    b. Include u to mstSet.
    
    c. Update key value of all adjacent vertices of u. To update the key values, iterate through all adjacent vertices.
       For every adjacent vertex v, if weight of edge u-v is less than the previous key value of v, update the key value as weight of u-v
       
### Pseudocode
```java
Queue <- V
Key[v] <- infinite for each vertex v in V
key[s] <- 0, \\ a random vertex to start with.
while Q is NOT EMPTY
    u <- Q.exractMIN
    for each v IN adjacency list of u
       if v is still in Q and key[v] > weight(u,v)
           key[v] <- weight(u,v)
           P[v] <- u
```

### Time Complexity
The time complexity of Prim's algorithm depends on the data structures used for the graph and for ordering the edges by 
weight, which can be done using a priority queue:

 - Adjacency Matrix:  O(V^2)
 - Binary Heap and Adjacency list: O((V + E) log V) = O (E log V)


### References
 
 - https://www.programiz.com/dsa/prim-algorithm
 - https://www.geeksforgeeks.org/prims-minimum-spanning-tree-mst-greedy-algo-5/
 - http://theoryofprogramming.com/2015/03/27/prims-algorithm/
 - http://techieme.in/minimum-spanning-tree-prims-algorithm/
 - https://en.wikipedia.org/wiki/Prim%27s_algorithm

