// Let’s say A = [4,5,6,1,2,3]
// Look at the last element in the array (3).

// 1. All elements that were rotated and came back around are > 3. We call these ​Group 2​. 
// All elements that moved right but didn't go back around are <= 3. We call these ​Group 1​.

// For any ​a[i] we encounter: if a[i] <= 3 (last element), it is in Group 1. We go left.
// If a[i] > 3, it is in Group 2. We go right.
// also if the a[i] left and right both greater than return 

public static int cyclicallySortedMin(int[] a) {    
    if (a == null) {        
        return -1;    
    }    
    
    int low = 0, high = a.length - 1, last_element = a[a.length - 1];    
    while (low <= high) {        
        int mid = low + (high - low) / 2; 

        // if left and right both are greater return
        if (a[mid] <= last_element && (mid == 0 || a[mid - 1] > a[mid])) {            
            return mid;        
        } else if (a[mid] > last_element) {            
            low = mid + 1;        
        } else {            
            high = mid - 1;        
        }    
    }    
    return -1;
}
