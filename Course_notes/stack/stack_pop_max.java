// Solution#1:When you insert a number A, Store a Pair of numbers on the stack. 
// The first is A. The second is the Max element on the stack. It is simple to calculate this max.
// insert(A) 
// max = Maximum of A and the current max    
// push(Pair<A,max>)

// max()    
// return the max on the top of the stack

// pop()    
// pop the pair on top, return value


// Solution#2
// Every time you encounter a new max, put it on a separate Max Stack. 
// For example:Main: ​3​,1,​4​,2,​4​,​6​,3
// Max:  ​3​,​4​,​4​,​6

// Here, the current max is 6 - the top of the Max stack. If you insert 8,that is the new max. 
// Now it looks as follows:
// Main: 3,1,4,2,4,6,3,8
// Max:  3,4,4,6,8

// If we do a pop(), we remove 8 from both Main and Max if the elements are same.
// Main: 3,1,4,2,4,6,3
// Max:  3,4,4,6

// If we do a pop() again, we remove 3 from the Main stack, but since it isnot the max, we dont touch the Max stack.
// Main: 3,1,4,2,4,6
// Max:  3,4,4,6



public class StackWithMax {    
    Stack<Integer> main;    
    Stack<Integer> max;

    // Constructor
    public StackWithMax() {        
        main = new Stack<>();        
        max = new Stack<>();    
    }

    // Add new element, compare with max in max stack and if less than add if not leave
    public void push(int a) {        
        main.push(a);        
        if (max.isEmpty() || a >= max.peek())            
            max.push(a);    
        }

    // finding max is just peeking element from max
    public int max() throws EmptyStackException {        
        if (max.isEmpty())            
            throw new EmptyStackException();        
        return max.peek();    
    }

    // now if you pop the element max get's updated if it is same as pooped item or else leve it
    public int pop() throws EmptyStackException {        
        if (main.isEmpty())            
            throw new EmptyStackException();        
        int item = main.pop();        
        if (max.peek() == item)            
            max.pop();        
        return item;    
    }
}