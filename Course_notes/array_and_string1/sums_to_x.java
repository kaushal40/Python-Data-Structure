// We use the technique of prefix sums. 

// For all elements, we first calculate the sum ​s[i]​ - whichis the sum of all numbers from ​a[0]​ to ​a[i]​. 
// An interesting property emerges: 

// If any ​s[i]​ is 0,then ​a[0]​ to ​a[i]​ sums to 0, so the subarray ​[0..i]​ is the answer.
// If there is no ​s[i]​ that equals zero, we try to find two ​s[i]​'s that have the same value.
// For any ​j​ and ​k​, if ​s[j]​and ​s[k]​ have the same value, then the sum of subarray ​[j+1..k]​ is 0.

public static Pair<Integer> targetSumSubarray(int[] a, int target) {    
    if (a == null || a.length == 0)        
        return null;    
        
    int sum = 0;

    // ti check if total sum - target is there
    HashMap<Integer, Integer> map = new HashMap<>();    
    for (int i = 0; i < a.length; i++) {        
        sum += a[i];

        if (sum == target) {            
            return new Pair<Integer>(0,i);        
        }        
        
        // For any ​j​ and ​k​, if ​s[j]​ and ​s[k]​ have the same value, then the sum of subarray ​[j+1..k]​ is 0.
        if (map.containsKey(sum - target)) {            
            return new Pair<Integer>(map.get(sum - target) + 1, i);        
        }        
        
        map.put(sum, i);    
    }  

    return null; // not found
}