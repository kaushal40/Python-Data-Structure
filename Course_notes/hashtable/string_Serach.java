// Questions to Clarify:
// Q. If T occurs multiple times in A, do you want just the first index?
// A. Yes 
// Q. If T doesn't exist in A, can I return -1?
// A. Yes
// Q. If T is empty, does that mean it exists in A?
// A. Yes, empty strings exist in any non-null string.
// Q. What if S or T are null?
// A. Throw a null pointer exception.


// solution will consider sliding window of size T
// calculate hashcode for the window and iterate throgh string if hashcode matches than string dfound


// hash(T:"ello") => 'e'.x​3​ + 'l'.x​2​ + 'l'.x + 'o'
// W => 'h'.x​3​ + 'e'.x​2​ + 'l'.x + 'l' (first step)
// W => ​[(​'h'.x​3​ + 'e'.x​2​ + 'l'.x + 'l') -​ 'h'.x​3​].x​ + 'o'  => 'e'.x​3​ + 'l'.x​2​ + 'l'.x + 'o'   (second step)


// Time Complexity: O(n)
// Space Complexity: O(1)

public static int search(String str, String target) {
    //base case
    if (str == null || target == null)
        throw new NullPointerException();
    
    // if target is zero than found
    if (target.isEmpty())
        return 0;

    // if target is greater thn actaul 
    if (target.length() > str.length())        
        return -1;

    int x = 53; // a prime number

    // hash of target
    int hashT = 0;

    // running hash for window
    int hash = 0;
    
    for (int i = 0; i < target.length(); i++) {
        hashT = hashT * x + target.charAt(i);
        // for efficeiency calculate the hash of first lenth from string tohgathet
        hash = hash * x + str.charAt(i);
    }

    // found match in first substring    
    if (hashT == hash && target.equals(str.substring(0, target.length())))        
        return 0;

    // now do the running search for hash comparison
    for (int i = target.length(); i < str.length(); i++) {  
        // removal charachter      
        int toRemove = str.charAt(i - target.length());
        // multiply by X and add        
        hash = ((hash - toRemove * xPow) * x + str.charAt(i));        
        if (hash == hashT  && target.equals(str.substring(i - target.length() + 1, i + 1))) 
        {            
            return i - target.length() + 1;        
        }    
    }    
    return -1; // not found
}