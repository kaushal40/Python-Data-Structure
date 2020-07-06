// Every time we find a new mid, we are trying to move closer to the target.
// If we keep track of the closest mid we have encountered, that will give us closest element to the target.

// [1,2,4,5,7,8,9], target = 6
// In the first iteration of binary search, we reach 5. We then go to the secondhalf, since 6 is greater than 5. 
// We consider 5 as a candidate for closest element, but anything in the first half is not a candidate, because they are further away from 6 than 5 is.
// This applies to every iteration of the search. Hopefully this gives you an intuition of whywe only consider mids.


public static int closestElement(int[] a, int target) {    
    if (a == null) {        
        return -1;    
    }    
    
    int low = 0, high = a.length - 1;    
    int result = -1;    
    
    while (low <= high) {       
        int mid = low + ((high - low) >> 1);​ or // low + (high - low) / 2

        // record the mid elemnt, compares with previous resutl and keeps the result closest
        result = record(a, mid, result, target); 

        // normal binary search
        if (a[mid] > target) {            
            high = mid - 1;        
        } else if (a[mid] < target) {            
            low = mid + 1;        
        } else {            
            return mid;        
        }    
    }    
    return result;
}

// this function will record the colsest element,  by comparing mid with previous results 
private static int record(int[] a, int mid, int result, int target) {    
    if (result == -1 || Math.abs(a[mid] - target) < Math.abs(a[result] - target))        
        return mid;    
        
    return result;
}