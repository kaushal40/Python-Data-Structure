
// same as binary search just add one condition to check if the found element is first element

public static int firstOccurence(int[] a, int target) {    
    if (a == null) {        
        return -1;    
    }   

    int low = 0;    
    int high = a.length - 1;    
    
    while (low <= high) {        
        int mid = low + (high - low)/2 ;        
        
        // so if mid is grater than tarhet move high and also if ( mid is target and previous element is also target) move left as we want first occurence
        if (a[mid] > target || ​(a[mid] == target && mid > 0 && a[mid - 1] == target​)) {            
            high = mid - 1;        
        } else if (a[mid] < target) {            
            low = mid + 1;        
        } else {            
            return mid;        
        }    
    }    
    return -1;
}