## DFS Applications

- Minimum Spanning Tree

- Detecting cycle in a graph
    - A graph has cycle if and only if we see a back edge during DFS. So we can run DFS for the graph and check for back edges

- Path Finding
   - We can specialize the DFS algorithm to find a path between two given vertices u and z.
     
     - Call DFS(G, u) with u as the start vertex.
     - Use a stack S to keep track of the path between the start vertex and the current vertex.
     - As soon as destination vertex z is encountered, return the path as the contents of the stack

- Topological Sorting
    - Mainly used for scheduling jobs from the given dependencies among jobs. In computer science, 
    applications of this type arise in instruction scheduling, ordering of formula cell evaluation when recomputing formula values in spreadsheets, logic synthesis, determining the order of compilation tasks to perform in makefiles, data serialization, and resolving symbol dependencies in linkers.

- To test if a graph is bipartite
    - In the mathematical field of graph theory, a bipartite graph (or bigraph) is a graph whose vertices can be divided into two disjoint and independent sets U and V such that every edge connects a vertex in U to one in V. 
    Vertex sets U and V are usually called the parts of the graph. Equivalently, a bipartite graph is a graph that does not contain any odd-length cycles.

- Finding strongly connected components of a graph
   
   - A directed graph is called strongly connected if there is a path from each vertex in the graph to every other vertex.

- Solving puzzles with one solution, such as mazes.


## BFS Applications
- Shortest Path and Minimum Spanning Tree for unweighted graph

- Peer to Peer Networks
    - In Peer to Peer Networks like BitTorrent, Breadth First Search is used to find all neighbor nodes.

- Crawlers in Search Engines
    - Crawlers build index using Breadth First. The idea is to start from source page and follow all links from source and keep doing same. Depth First Traversal can also be used for crawlers, but the advantage with Breadth First Traversal is, depth or levels of the built tree can be limited.
    
- Social Networking Websites
    - In social networks, we can find people within a given distance ‘k’ from a person using Breadth First Search till ‘k’ levels.
    
- GPS Navigation systems
    - Breadth First Search is used to find all neighboring locations.
    
- Broadcasting in Network
    - In networks, a broadcasted packet follows Breadth First Search to reach all nodes.
    
- In Garbage Collection
    - Breadth First Search is used in copying garbage collection using Cheney’s algorithm.

- In Ford–Fulkerson algorithm

- Finding all nodes within one connected component
    - We can either use Breadth First or Depth First Traversal to find all nodes reachable from a given node.
