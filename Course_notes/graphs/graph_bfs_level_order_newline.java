// While traversing,​​how to figure out when a level has ended ?

// Approach1: UsingtwoQueues

// We keep two Queues - ​currentLevel​ and ​nextLevel​. We process all the nodesin ​currentLevel​ and put all the neighbors into ​nextLevel​


// Edge Cases: empty graph
// Base Cases: graph with 1 node, 2 nodes
// Regular Cases: graph with many nodes 
// Time Complexity:​ O(V+E) Space Complexity:​ O(V)


public void printLevels(Node root) { 

    // queue for maintainting current level 
    Queue<Node> currentLevel = new LinkedList<Node>();    
    
    // queue for maintining the next level (which are basically neighbours of curren levels)
    Queue<Node> nextLevel = new LinkedList<Node>();    
    
    // current node mark visting
    currentLevel.add(root)    
    root.setState(State.VISITING);    
    
    // run queue pop and process leafs
    while(!currentLevel.isEmpty()) {        
        Node current = currentLevel.remove();        
        
        System.out.println(current);        
        
        // now run bfsvisit on neighbours 
        for (Node neighbor: current.getNeighbors()) {            
            if (neighbor.getState() == State.UNVISITED) {  
                // adding it to next level instead of current level               
                nextLevel.add(neighbor);                
                neighbor.setState(State.VISITING);            
            }        
        }        
        
        current.setState(State.VISITED);        
        
        // now when current level is empty make nextleevl current and reinitialixe next level
        if (currentLevel.isEmpty()) {            
            System.out.println();            
            currentLevel = nextLevel;            
            nextLevel = new LinkedList<Node>();        
        }    
    }
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