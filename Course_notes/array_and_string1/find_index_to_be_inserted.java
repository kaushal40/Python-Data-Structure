// 1. If the input array is empty, return 0
// 2. If all elements are greater than target, return 0
// 3. If all elements are less than target, return a.length


public static int findInsertionIndex(int[] a, int target) {    
    if (a == null)        
        return -1;    
        
    // if array length is o can be insserted at first position    
    if (a.length == 0)        
        return 0;    
    
    int low = 0;    
    int high = a.length - 1;    
    
    while (low <= high) {        
        int mid = low + (high - low)/2 ;        
        
        
        if (a[mid] <= target) {
            // so if we reached at last element return the length
            if (mid == a.length - 1)                
                return a.length;            
            
            // else low = mid + 1
            low = mid + 1;
        } else {          
            // if mid - 1 element is target or less return, because current elemnt is  greater and previos less 
            if (mid == 0 || a[mid - 1] <= target)                
                return mid;            
                
            high = mid - 1;        
        }    
    }    
return -1; // should not happen, you can also throw an exception here
}