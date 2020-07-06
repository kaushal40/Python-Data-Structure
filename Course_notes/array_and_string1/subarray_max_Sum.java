
/* * Brute force solution - using nested loop */

// for every element count the subarray sum
public static Integer maximumSumSubarrayBruteForce(int[] a) {    
    if (a == null || a.length == 0)        
        throw new IllegalArgumentException("Input array is empty or null");    
    
    int maxSum = a[0];    
    for (int i = 0; i < a.length; i++) {        
        int sum = 0;        
        for (int j = i; j < a.length; j++) {            
            sum = sum + a[j];            
            maxSum = Math.max(maxSum, sum);        
            }    
        }    
    return maxSum;
}

/* * Kadane's algorithm solution */

// max_sum_ending_at[i] = Max(max_sum_ending_at[i-1] + a[i], a[i])
// so at any elments maxsum can be previous element or the same element must be +ve or -ve both

public static Integer maximumSumSubarray(int[] a) {    
    if (a == null || a.length == 0)        
        throw new IllegalArgumentException("Input array is empty or null");

    int maxSum = a[0], maxEndingHere = a[0];
    for (int i = 1; i < a.length; i++) {       
        maxEndingHere = Math.max(maxEndingHere + a[i], a[i]);        
        maxSum = Math.max(maxSum, maxEndingHere);    
    }    
    return maxSum;
}