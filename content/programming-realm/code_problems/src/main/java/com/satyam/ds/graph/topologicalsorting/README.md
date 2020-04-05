## Topological Sorting
In a directed acyclic graph, topological sorting is a linear ordering of vertices such that if (u, v) in E, 
then u appears somewhere before v. (Certainly not like sorting numbers.)

- Topological Sorting for a graph is not possible if the graph is not a DAG.

- The **first vertex** in topological sorting is always a vertex with in-degree as 0.

##### TOPOLOGICAL-SORT(V, E)

 - Call DFS(V, E) to compute finishing times f[v] for all v in V
 - Output vertices in order of decreasing finish times

##### Example
The following figure gives an example that arises when Professor Bumstead gets dressed in the morning. 
The DAG of dependencies for putting clothing is given. 

(a) The discovery and finishing times from depth-first search are shown next to each vertex. 

(b) Then the same DAG shown topologically sorted.

![DAG](../../../../../../../../../images/ds-algo-prob/ds/graph/topological-sort/prof_dressing_topo_sort.png)

## References
##### Good Read(s)
 - http://www.personal.kent.edu/~rmuhamma/Algorithms/MyAlgorithms/GraphAlgor/topoSort.htm
 - https://en.wikipedia.org/wiki/Topological_sorting
