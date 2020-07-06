// Technique: Finding K smallest elements with a Heap

// One solution is to use a ​Min Heap​. We can insert each element of the array into the ​Min Heap​. Then,we extract the top of the heap ​k​ times to find the ​k​ smallest elements. 
// Let’s see how efficient this is.

// Let's revisit Min Heaps:1. Lookups for Min element are ​O(1)​.
// 2. Insertions are ​O(log(N))​, where ​N​​ is the number of elements in the heap.
// 3. Extracting the top element takes ​O(log(N))​ time.

// min heap will take o(N) space and nlogn time which is worst than sorting so instead we should use max heap

// if we use max heap of size K and only keep 4 elements more effiecient
// everty time we iterate throgh element if elemnt is less than top element remove top and add new one

// Test Cases:
//Edge Cases: k > a.length, k=a.length, k=0, array empty, array null
// Base Cases: k=1, k=2, array length is 1
// Regular Cases: K is less than a.length
// Time Complexity: O(Nlog(K))
// Space Complexity: O(K)

public static void printKSmallest(int[] a, int k) {    
    if (k > a.length)        
        throw new IllegalArgumentException();    
        
    // In Java, the PriorityQueue class is a heap.​
    PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());    
    for (int i = 0; i < a.length; i++) {
        // add firat K elements to heap        
        if (i < k)            
            heap.add(a[i]);
        // if the new element is less thn top elemtnt in max heap swap    
        else if (a[i] < heap.peek()) {            
            heap.remove();            
            heap.add(a[i]);
        }    
    }    
    // print result    
    
    Iterator<Integer> iter = heap.iterator();    
    while (iter.hasNext()) {        
        System.out.println(iter.next());    
        }
}
    