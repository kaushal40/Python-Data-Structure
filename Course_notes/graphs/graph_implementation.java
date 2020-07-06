
// Adjecency list implementation
// Space Complexity​: O(V + E)
// Here,​V​ is the number of vertices (nodes) and ​E​ is the number of edges in the graph. This is commonnotation.

// each node contains list of neighbours
public class Node {    
    List<Node> neighbors;    
    int data;    
    // constructors, getters and setters
}
    
/* * In most questions that use Graph Search or Traversal, you will be given a * node(s) to start from, instead of a list of nodes. 
Otherwise, it would be * too easy to iterate through all the nodes. */

// graph contains list of nodes
public class Graph {    
    List<Node> nodes;    
    // constructors, getters and setters
}



// Adjecency matrix implementation

// lookup O(1)
// space complexity O(v)^2

public class Node {    
    int data;    // constructors, getters and setters
}

public class Graph {    
    List<Node> nodes;    
    int[][] matrix;    
    // constructors, getters and setters
}