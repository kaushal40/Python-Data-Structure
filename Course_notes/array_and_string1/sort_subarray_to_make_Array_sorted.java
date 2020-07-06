// Start from 0. Find the first dip in value, call that ​start​.
// For example: [1,3,5,2,6,4,7,8,9] --> First dip starts at index 2.
// Next, start from the end of the array. Find the first bump in value, call that ​end​.
// For example: [1,3,5,2,6,4,7,8,9] --> First bump starts at index 5.

// sorting the inner array won't do the trick, we might need to include from number minumum on left than current dip
// also include number from right as well

public static Pair<Integer> shortestUnsortedSubarray(int[] a) {    
    if (a == null || a.length == 0)        
        return null    
        
    int start, end;    
    
    // find dip    
    for (start = 0; start < a.length - 1; start++) {        
        if (a[start + 1] < a[start])            
            break;    
    }    
    
    // no dip found, array is already sorted    
    if (start == (a.length - 1))        
        return null;    
        
    // find bump    
    for (end = a.length - 1; end > 0; end--) {        
        if (a[end - 1] > a[end])            
            break;    
    }    
    
    // find min and max of a[start..end]   
    int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;    
    for (int k = start; k <= end; k++) {        
        if (a[k] > max)            
            max = a[k];        
        if (a[k] < min)            
            min = a[k];    
    }    
    
    // expand start and end outward    
    while (start > 0 && a[start - 1] > min) {        
        start--;    
    }    
    while (end < (a.length - 1) && a[end + 1] < max) {        
        end++;
    }    
    return new Pair<Integer>(start, end);
}