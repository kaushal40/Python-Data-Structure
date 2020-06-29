public static Pair<Integer> longestPalindrome(String a) {    
    if (a == null || a.isEmpty()) {        
        return null;    
    }    
    
    char[] ch = a.toCharArray();    
    int longest = 1;    
    
    Pair<Integer> result = new Pair<Integer>(0,0);

    //we expand from each charachter    
    // Odd    
    for (int i = 0; i < ch.length; i++) {        
        int offset = 0;     

        // it should be in valid range, if yes compare the two elements (expanding process) offset maintains how far we went
        while (isValidIndex(ch, i-1-offset) && isValidIndex(ch, i+1+offset) && ch[i-1-offset] == ch[i+1+offset]) {            
            offset++;        
        }        
        
        // if you multiply offset by two you get the longest
        int longestAtI = offset*2 + 1;        
        if (longestAtI > longest) {            
            longest = longestAtI;
            result = new Pair<Integer>(i-offset, i+offset);
        }
    }

    // Even    
    for (int i = 0; i < ch.length; i++) {        
        int offset = 0; 

        while (isValidIndex(ch, i-offset) && isValidIndex(ch, i+1+offset) && ch[i-offset] == ch[i+1+offset]) {            
            offset++;        
        }        
        
        int longestAtI = offset*2;        
        if (longestAtI > longest) {            
            longest = longestAtI;            
            result = new Pair<Integer>(i-offset+1, i+offset);        
            }    
        }    
        
        return result;
}

//helper to check if the index is valid

private static boolean isValidIndex(char[] a, int i) {    
    return i >= 0 && i < a.length;
}