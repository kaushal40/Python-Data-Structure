
//solu: traverse array from both end and calculate sum if the sum is greater end-- and sum less thn start++

public static Pair<Integer> twoSum(int[] a, int target) {    
    if (a == null)        
        return null;
        
    int start = 0, end = a.length - 1;    
    while (start < end) {        
        int sum = a[start] + a[end];        
        if (sum < target)            
            start++;        
        else if (sum > target)            
            end--;        
        else            
            return new Pair<Integer>(a[start], a[end]);    
        }    
    return null;
}