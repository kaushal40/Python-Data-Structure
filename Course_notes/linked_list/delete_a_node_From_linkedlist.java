public static class LinkedList {
    Node head;
    Node tail;

    public LinkedList(Node head, Node tail) {
        this.head = null;
        this.tail = null;
    }

    public void delete_a_node_given_previous_node(Node n; Node previous){
        //check if node to be dleted is null
        if (n == null){
            return;
        }
        //check if node to be deleted is head than you need to change the head
        if (n == head){
            head = head.next;
        }
        //check if yhe node is tail
        if (n == tail){
            tail = previous;
        }
        if (previous != null){
            previous.next = previous.next.next; // previous.next = n.next
        }
    }

    public void delete_node_without_previous(Node n){
        Node next = n.next;
        if (next == null){
            return;
        }
        n.data = next.data;
        //utilizing previous function delete node when we have previous and node to be deletd both
        // we need to delete next and keep n which we changed
        delete_a_node_given_previous_node(next, p);
    }
}