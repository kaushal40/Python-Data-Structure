// The median element is the middle element

// Q. What is the median if there are even number of elements?
// A. Make it the average of the two middle numbers.

// sol: we will use two heaps, one will be min heap and one will be max heap,  we keep same elements or one elment more in min heap if it is odd
// now if you want to find median, if even pop one from min + one form max/ 2, if odd pick the top from min heap

// So when we add a new element, we ensure:
// 1.The heaps are equal in size, or
// 2.high​ is one larger than ​low​

// Insert: O(logn)
// Median Lookup: O(1)
// Space Complexity: O(n)

public static class RunningMedian {    
    private static PriorityQueue<Integer> low;    
    private static PriorityQueue<Integer> high;    
    
    public RunningMedian() {        
        low = ​new PriorityQueue<Integer>(Collections.reverseOrder());​ // max heap       
        high = new PriorityQueue<Integer>(); // min heap    
    }


    public static double getMedian() throws EmptyDatasetException {        
        if (low.size() == 0 && high.size() == 0)            
            throw new EmptyDatasetException();        
        
        // if the heaps are same size
        if (low.size() == high.size())            
            return (low.peek() + high.peek())/2.0; 

        // else return the min heaps element as we keep one element more in mean heap, if odd       
        return high.peek();    
    }

    public static void insert(int number) {        
        
        // first enter in high
        if (high.isEmpty()) {            
            high.add(number);            
            return;        
        }        
        
        // if both sizes are equal
        if (low.size() == high.size()) { 
            // if number is less than low           
            if (number < low.peek()) {  
                // remove low element and add it to high (minimum element should ho in mean heap)             
                high.add(low.remove());
                // add new element to low                
                low.add(number);            
            } else {
                // eles add it to high                 
                high.add(number);            
            }        
        } // if not equal size 
        else {            
            if (number > high.peek()) {                
                low.add(high.remove());                
                high.add(number);            
            } else {                
                low.add(number);            
            }        
        }    
    }
}

public static class EmptyDatasetException extends Exception {
    
}