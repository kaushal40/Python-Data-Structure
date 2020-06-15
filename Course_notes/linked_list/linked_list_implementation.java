public class Node{
    Node next; 
    int data;

    public Node(Node next, int data){
        this.next = next;
        this.data = data; 
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {        
        this.next = next;    
    }

    public int getData() {        
        return data;    
    }    
    
    public void setData(int data) {        
        this.data = data;    
    }
}


public class LinkedList {    
    Node head;    
    Node tail;   

    public LinkedList() {        
        head = null;        
        tail = null;
    }    
    
    public Node getNth(int n, Node head){
        Node curr = head;
        for (int i = 0; i < n-1; i++){
            if (curr != null){
                curr = curr.next
            } else {
                throw new Exception("Index out of bound exception")
            }
            return curr;
        }
    }
}