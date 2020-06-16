public static Node findMedian(Node head) {    
    if (head == null){  
        return null;
    }        
    Node fast = head, slow = head;    
    while(fast.next != null) {        
        fast = fast.next;        
        if (fast.next != null) {            
            fast = fast.next;            
            slow = slow.next;        
        }    
    }    
    return slow;
}