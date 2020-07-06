// Diameter of a Graph: Given a directed graph, find the length of the longest path in the graph.For example,


//So in short, you want to process each parent node before processing the node. 
// This is perfectfor topological sort - because all the parents come before the child.
// Here is the formula we come up with:©​ 2017 Interview Camp (interviewcamp.io)

// longest-path(A) = max(longest-path(parents))


public static int diameter(Node start) {    
    
    if (start == null)        
        return 0;    

    // stack will return the topological sorting of the graph     
    Stack<Node> topoSort = topoSort(start);    
    
    int diameter = 0;

    // now until stack is not empty, we pop the last elemnt and calculate the diametet    
    while(!topoSort.isEmpty()) {        
        Node current = topoSort.pop();

        // diameter is calcualted d=iameter and longetpath
        diameter = Math.max(diameter, current.getLongestPath());        
        
        for (Node neighbor: current.getNeighbors()) {            
            if (current.getLongestPath() + 1 > neighbor.getLongestPath())                
                neighbor.setLongestPath(current.getLongestPath() + 1);        
            }    
        }    
    return diameter;
}

public static Stack<Node> topoSort(Node node) {    
    Stack<Node> stack = new Stack<>();    
    
    dfsVisit(node, stack);    
        return stack;}
        
    public static void dfsVisit(Node node, Stack<Node> stack) {    
        node.setState(State.VISITING);    
        
        for (Node neighbor: node.getNeighbors()) {        
            if (neighbor.getState() == State.UNVISITED)            
                dfsVisit(neighbor, stack);    
            }    
            
        node.setState(State.VISITED);    
        stack.push(node);
}


/* * Helper Code. Ask interviewer before implementing. */
public enum State {    
    UNVISITED,    
    VISITING,    
    VISITED;
}

public class Node {
    List<Node> neighbors;    
    int data;    
    State state;    
    int longestPath;    
    
    public Node(int data) {        
        super();        
        this.data = data;        
        state = State.UNVISITED;        
        this.longestPath = 0;        
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
    
    public int getLongestPath() {        
        return longestPath;    
    }    
    
    public void setLongestPath(int longestPath) {        
        this.longestPath = longestPath;    
    }    
    
    public void addNeighbor(Node node) {        
        neighbors.add(node);    
    }    
    
    public List<Node> getNeighbors() {        
        return neighbors;    
    }
}