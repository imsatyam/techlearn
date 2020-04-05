### Kruskal's Algorithm
Kruskal’s algorithm is a Greedy algorithm. The Greedy Choice is to pick the smallest weight edge that does not cause a
 cycle in the MST constructed so far.


### How does Kruskal’s Algorithm Work?
It uses Union-Find algorithm to detect cycle.
 

### Algorithm
1. Sort all the edges in non-decreasing order of their weight.

2. Pick the smallest edge. Check if it forms a cycle with the spanning tree formed so far.
    If cycle is not formed, include this edge. Else, discard it.
    
3. Repeat step#2 until there are (V-1) edges in the spanning tree.

       
### Pseudocode
```java
KRUSKAL(G):
1 A = ∅
2 foreach v ∈ G.V:
3    MAKE-SET(v)
4 foreach (u, v) in G.E ordered by weight(u, v), increasing:
5    if FIND-SET(u) ≠ FIND-SET(v):
6       A = A ∪ {(u, v)}
7       UNION(FIND-SET(u), FIND-SET(v))
8 return A
```

### Time Complexity
O (E log V)


### References
 
 - https://www.geeksforgeeks.org/kruskals-minimum-spanning-tree-algorithm-greedy-algo-2/
 - https://www.techiedelight.com/kruskals-algorithm-for-finding-minimum-spanning-tree/
 - https://en.wikipedia.org/wiki/Kruskal%27s_algorithm

