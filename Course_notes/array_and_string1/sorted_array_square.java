
// solu: traverse from both the end until end<=start and create new array and whouever's square is greateer put in array

public static int[] squares(int[] a) {    
    if (a == null)        
        return null;    

    int start = 0, end = a.length - 1;    
    int[] result = new int[a.length];    
    int resultIndex = result.length - 1;    
    
    while (start <= end) {        
        if (abs(a[start]) > abs(a[end])) {            
            result[resultIndex] = square(a[start]);            
            start++;        
        } else {            
            result[resultIndex] = square(a[end]);            
            end--;        
        }        
        resultIndex--;    
    }
    return result;
}

/* * Helper functions. Ask the interviewer if they want you to implement * these. */
public static int abs(int number) {    
    return number >= 0 ? number : -1 * number;
}

public static int square(int number) {    
    return number * number;
}
