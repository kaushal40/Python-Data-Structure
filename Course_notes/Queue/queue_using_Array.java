class Queue{
    int a[];

    int length;
    int front;
    int back;

    public Queue(int size){
        a = new int[size];
        front = 0;
        back = 0;
        length = 0;
    }

    public void add(int item) throw QueueFullException {
        if (length == a.length){
            throw new QueueFullException();
        }
        a[back] = item;
        // this is very important circling property 
        back = (back + 1) % a.length;
        length++;
    }

    public int remove() throws QueueEmptyException {
        if (length == 0)            
            throw new QueueEmptyException();
        int result = a[front];
        front = (front + 1) % a.length;
        length--;
        return result;
    }
}

// helper code
public class QueueFullException extends Exception {    
    public QueueFullException() {    
    }
}

public class QueueEmptyException extends Exception {    
    public QueueEmptyException() {    
    }
}