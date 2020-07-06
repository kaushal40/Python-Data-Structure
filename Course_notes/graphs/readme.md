**GRAPHS BASICS AND SEARCH**

- Graphs are any combination of nodes and edges. A single node is a graph.
- A *directed graph* has edges that only apply one way, i.e, if there is an edge from A to B, that does not mean that there is an edge from B to A
- An *undirected graph* has double sided edges, i.e, an edge from A to B also implied an edge from B to A
- You should clarify with the interviewer if the graph is directed or undirected.
- A clique is when each node has an edge to every other node in the graph.
- Graphs are represented in memory in 2 ways - *adjacency list and adjacency matrix*
- In adjacency list, each node maintains a list of neighbors. e.g, A -> [B, C] & B -> [A, D]
- In adjacency matrix, a square matrix maps the edges between nodes.
- Unless specified otherwise, adjacency list is the de facto method used to represent graphs.


![alt text](images/graphs_1.png "Title")




**DFS**

- For DFS, it is standard for each node to have a State - ​UNVISITED​, ​VISITING​ and ​VISITED​. We storethat state as the Node’s property.

```
dfsVisit(Node)    
     mark Node VISITING     
     process node     
     Run dfsVisit() on each unvisited neighbor     
     mark Node VISITED
```

**DFSundirected**

- with undirected graphs, while traversing make sure you keep map of the nodes neighbours so that cycles can be detected



**BFS**

- Breadth First Search (BFS) is implemented using a Queue.
- In BFS, we start at a node, then process all the nodes at a distance 1 from the node, followedby distance 2 from the node, and so on.
- We implement a ​bfsVisit() ​function, where we run a loop, popping elements from the Queue andinserting their neighbors to its back.

```
bfsVisit(StartNode, Target)     
    Q = empty queue     
    Q.enqueue(StartNode)     
    StartNode.State = VISITING     
    
    while (Q is not empty)         
        Node = q.dequeue()         
        If Node = Target // Process Node             
            return true 

        For all Node's neighbors:             
            if neighbor is UNVISITED                 
                add it to the back of Q, set its State to VISITING         
        
        Node.State = VISITED    
    
    Reached End, not found, return false
```

-  maintain two queus for graph level order traversal


**TOPOLOGICAL SORT - DFS _ SCHEDULING PROBLEMS**

- Topological Sort, is very useful in scheduling problems, or when you need to arrange a graph in order. Topological sorting arranges the nodes in order such that all edges are pointing forward. Take a look at the image below.

