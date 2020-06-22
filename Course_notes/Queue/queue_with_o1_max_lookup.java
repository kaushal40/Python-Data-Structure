// Implement a Queue with O(1) lookup of the Maximum element.

//We use a similar approach as stacks - keep two queues - a main queue and a max queue.
// The main queue contains the elements. The max queue contains the max elements. 
//The maxqueue is a double ended queue (deque) because we want to be able to remove elementsfrom both ends.


public class QueueWithMax {
    Queue<Integer> main;
    Deque<Integer> max;

    public QueueWithMax() {
        main = new LinkedList<>();
        max = new LinkedList<>();
    }

    public void enqueue(int item) {
        main.add(item);
        // we will remove last element if it is less thn current item
        while (!max.isEmpty() && max.getLast() < item)
            max.removeLast();
        max.add(item);
    }

    public void dequeue() throws QueueEmptyException {
        if (main.isEmpty())
            throw new QueueEmptyException();
        int item = main.remove();
        if (max.getFirst() == item)
            max.remove();
    }

    public int findMax() throws QueueEmptyException {
        if (max.isEmpty())
            throw new QueueEmptyException();
        return max.getFirst();
    }

}
