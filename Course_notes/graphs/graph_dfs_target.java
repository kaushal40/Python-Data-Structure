// Edge Cases: empty graph, null graph
// Base Cases: Graph with 1 node, graph with 2 nodes, graph with 2 disconnected nodes
// Regular Cases: Target in graph/not in graph, Target first element/deep in graph

// Time Complexity: O(V + E), where V is Vertices, and E is Edges
// Space Complexity: O(V) in worse case.

public static boolean dfs(Graph graph, int target) { 

    // we will traverse all the nodes in the graph if conenected it will be proccessed in single go but if disconnected we need to process the edges
    for(Node node : graph.getNodes()) {        
        if (node.getState() == State.UNVISITED && dfsVisit(node, target))            
            return true;    
        }    
    return false;
}


public static boolean dfsVisit(Node node, int target) {   
    // mark node as visiting
    node.setState(State.VISITING);    
    
    // processing the data of node any operation here we do comparison
    if (node.getData() == target)        
        return true;    
        
    // process neighbours and run dfsvisti on them
    for (Node neighbor: node.getNeighbors()) {
        // neighbour should be unvisited and 
        if (neighbor.getState() == State.UNVISITED && dfsVisit(neighbor,target))            
            return true;   
        }

    // mark current node as visted 
    node.setState(State.VISITED);
    return false;
}


/* * Helper Code. Ask interviewer before implementing. */
public enum State {    
    UNVISITED,    
    VISITING,    
    VISITED;
}

public class Graph {    
    List<Node> nodes;    
    public Graph(List<Node> nodes) {        
        super();        
        this.nodes = nodes;    
    }    
    
    public void addNode(Node node) {        
        nodes.add(node);    
    }    
    
    public List<Node> getNodes() {        
        return nodes;    
    }
}


public class Node {    
    List<Node> neighbors;    
    int data;    
    State state;    
    
    public Node(int data) {        
        super();        
        this.data = data;        
        state = State.UNVISITED;        
        neighbors = new ArrayList<Node>();    
    }

    public int getData() {        
        return data;    
    }    
    
    public void setData(int data) {        
        this.data = data;    
    }    
    
    public void setState(State state) {        
        this.state = state;    
    }    
    
    public State getState() {        
        return state;    
    }    
    
    public void addNeighbor(Node node) {        
        neighbors.add(node);    
    }    
    
    public List<Node> getNeighbors() {        
        return neighbors;    
    }
}