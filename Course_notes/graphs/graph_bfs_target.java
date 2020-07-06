// we will maintain queue to process first in first out

// add the root node to queue
// pop the element from queue and process
//  add it's neighbour to the queue if unvisted and run bfsvist on them 
// change cureent node status to visted


public static boolean bfs(Graph graph, int target) {    
    
    for (Node node : graph.getNodes()) {  
        // this is required for discoonected componenet     
        if (node.getState() == State.UNVISITED && bfsVisit(node, target))            
            return true;    
        }    
    return false;
}

public static boolean bfsVisit(Node start, int target) {

    // creating queue using linked list    
    Queue<Node> q = new LinkedList<Node>();

    // add it to queue  and set status to visting  
    q.add(start);    
    start.setState(State.VISITING);    
    
    while(!q.isEmpty()) {
        // remove the element and process       
        Node current = q.remove();        
        if (current.getData() == target)            
            return true;        
            
        // for each neighbour, see if it is unvisited and if yes add it to queue
        for (Node neighbor : current.getNeighbors()) {            
            if (neighbor.getState() == State.UNVISITED) {                
                q.add(neighbor);                
                neighbor.setState(State.VISITING);            
            }        
        }

        // marak current node to visted        
        current.setState(State.VISITED);    
    }    
    return false;
}


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