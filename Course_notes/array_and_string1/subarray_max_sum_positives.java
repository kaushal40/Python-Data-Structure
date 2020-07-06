//sliding window 

//If the sum is less than ​X​, we advance ​end​ by 1 and add ​a[end]​ to the sum. If sum is greater than ​X​,we advance start by 1 and subtract ​a[start]​ from the sum. 
//Keep in mind ​start​ is always behind or equalto ​end​.

// no shrinking from left

public static Pair<Integer> subarraySum(int[] a, int target) {    
    if (a == null || a.length == 0)        
        return null;    
        
    int start = 0, end = 0, sum = a[0];    
    while (start < a.length) {        
        if (start > end) { 
            // start inched forward, bring end back to start            
            end = start;            
            sum = a[start];        
        }        
        
        if (sum < target) { 
            // expand to right            
            if (end == a.length - 1)                
                break; // reached end, cannot expand further            
            end++;            
            sum = sum + a[end];        
        } 
        
        else if (sum > target) { 
            // contract from left            
            sum = sum - a[start];            
            start++;        
        } else {            
            return new Pair<Integer>(start, end);        
        }   
    }    
    return null;
}