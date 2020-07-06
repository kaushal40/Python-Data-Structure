// Given an array of integers A, find the sum of each sliding window of size K.
// Variation:​ Instead of an array, what if you were presented with a ​stream​ of numbers. 
// A new number can be added anytime. You want to find the sum of the last K elements.

// Sol - We will use queue to add and remove the data we will return the sum as soon as the queue reaches size 3
// if 4th element or new element is added we remove the last element, deduct it from the sum
// add the new element and update the sum


public static void slidingWindowSum(int[] a, int k){
    if (a == null || k == 0 || a.length == 0)        
        return;
    
    // LinkedList implements Queue interface in Java
    Queue<Integer> q = new LinkedList<>();
    int sum = 0;
    for (int i = 0; i < a.length; i++) {
        //if quue size is equal to given size, remove old element and substract it from sum      
        if (q.size() == k) {            
            int last = q.remove();            
            sum -= last;        
        }
        // add new element and add it to the sum        
        q.add(a[i]);        
        sum += a[i];        
        if (q.size() == k) {           
             System.out.println(sum);        
        }    
    }
}
