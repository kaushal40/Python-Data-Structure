public static int search(int[] a, int target) {    
    if (a == null || target == null) {        
        return -1;    
    }    
    
    int low = 0, high = a.length - 1;    
    while (low <= high) {        
        int mid = low + (high - low)/2;        
        
        if (a[mid] < target) {            
            low = mid + 1;        
        } else if (a[mid] > target) 
        {            
            high = mid - 1;       
        } else 
        {            
            return mid;        
        }    
    }    
    return -1;
}