// A topological sort is an ordering of nodes.
// Topological Sort is only possible if the Graph has no cycles.
// To implement Topological sort, you simply add 1 line to Depth First Search (DFS).At the end of the ​dfsVisit()​ function call, 
// simply add the visited node to a stack.
// at the end stack will be in topological sort 

// same as DFS just add the visted nodes to stack
public static Stack<Node> topoSort(Graph graph) {    
    
    Stack<Node> stack = new Stack<>();

    // this one for disconnected or remaining nodes    
    for(Node node : graph.getNodes()) {        
        if (node.getState() == State.UNVISITED)            
            dfsVisit(node, stack);    
        }    
    return stack;
}

public static void dfsVisit(Node node, Stack<Node> stack) {
    // set status to visting    
    node.setState(State.VISITING);    
    
    // no processing required

    // go to neighbours and run dfsvisti on them
    for (Node neighbor: node.getNeighbors()) {
        if (neighbor.getState() == State.UNVISITED)            
        dfsVisit(neighbor, stack);    
    }    
    
    // mark node visted and add it to stack
    node.setState(State.VISITED);    
    stack.push(node);
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