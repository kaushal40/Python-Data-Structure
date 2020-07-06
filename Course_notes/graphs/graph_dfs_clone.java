
// Edge Cases: empty graph
// Base Cases: single node, 2 nodes in graph
// Regular Cases: graph has cycle, graph has no cycles,
// Time Complexity:​ O(V+E)
// Space Complexity:​ O(V)

public Node cloneGraph(Node root) {    
    if (root == null)        
        return null;    
    
    // map to check if the node is already there in the map, if it is there we will not create new node so cycle is detected
    HashMap<Node, Node> map = new HashMap<>();

    // creating copy of root node
    Node rootCopy = new Node(root.getData());
    // adding it to map, so that it won't be created again    
    map.put(root, rootCopy);    
    
    dfsVisit(root, map);    
    return rootCopy;
}

public void dfsVisit(Node root, HashMap<Node, Node> map) {    
    
    // set the status to visting
    root.setState(State.VISITING);    
    

    // now for every neighbour add it to root neighbout if doesen't exist in map create new node 
    for (Node neighbor: root.getNeighbors()) {        
        // if neighbor doesn't exist in cloned graph, add it        
        if (!map.containsKey(neighbor)) {            
            map.put(neighbor, new Node(neighbor.getData()));        
        }        
        
        // add connection in cloned graph        
        Node rootCopy = map.get(root);        
        Node neighborCopy = map.get(neighbor);        
        
        rootCopy.getNeighbors().add(neighborCopy);        
        
        // now run dfsvisit on all unvisted node
        if (neighbor.getState() == State.UNVISITED)           
            dfsVisit(neighbor, map);    
    }   

    // mark node as visited     
    root.setState(State.VISITED);
}
    


/* * Helper Code: Ask the interviewer if they want you to implement these. */

public enum State {    
    UNVISITED,    
    VISITING,    
    VISITED;
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