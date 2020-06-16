public class ArrayStack{
    int[] a;
    int s1;
    int s2;

    // initialize ArrayStack datastructure with size of array and initial pointers
    public ArrayStack(int arraySize){
        a = new int[arraySize];
        s1 = 0;
        s2 = arraySize - 1; 
    }

    // this push will except the stack number to be pushed and the value
    public void push(int stackNumber, int item) throws StackFullException {
        //check for invalid value
        if (stackNumber != 1 && stackNumber != 2)            
            throw new IllegalArgumentException("Invalid stack number.");

        if (s1>s2){
            throw new StackFullException();
        }

        if (stackNumber == 1){
            a[s1] = item;
            s1++;
        } else {
            a[s2--] = item;
        }
    }

    // now popoing
    public int pop(int stackNumber) throws StackEmptyException {
        if (stackNumber != 1 && stackNumber != 2){
            throw new IllegalArgumentException("Invalid stack number.");
        }

        if (stackNumber == 1 && s1 > 0)
            return a[--s1];
        else if (stackNumber == 2 && s2 < a.length - 1)
            return a[++s2];

        throw new StackEmptyException();
    }
}

public class StackFullException extends Exception {    
    public StackFullException() {    
    }
}

public class StackEmptyException extends Exception {    
    public StackEmptyException() {    
    }
}

