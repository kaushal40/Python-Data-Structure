// Word Ladder Problem: You are given 2 words A and B, both of the same length. Your task is totransform one word  to another - changing only one letter at a time. 
// Each intermediate wordshould be a valid word in the dictionary. Print out the length of the path.

// Q. Can we assume dictionary is provided? 
// A. Yes, you can assume that.
// Q. What to return if not found?
// A. Return -1
// Q. Can we assume all lowercase alphabets?
// A. Yes
// Q. What is the word and the result are the same string?
// A. Return 0

// This problem can be modeled as a graph. Each word is a node, and all its adjacent words are neighbors. 
// We want to find the shortest path to a destination node

// we need to return the ​length​ of the shortest path.To do this, when we visit a node, we need to store it's level. 
// It's level is ​1 + levelof its parent node​


// Test Cases:
// Edge Cases: empty strings, strings are different length
// Base Cases: single character, both strings are same
// Regular Cases: valid path exists, no path exists

// Time Complexity and space: O(26^​N​), because in the worst case, you will go through every word of size n.


public static int wordLadder(String start, String end) {    
    
    Queue<String> q = new LinkedList<String>();    
    // will be used to store the level of the current node, so that can be used to calcualte the neighbours level by current + 1
    HashMap<String, Integer> visitedWords = new HashMap<>();​ //[word -> depth]    
    q.add(start);    
    
    visitedWords.put(start, 0); // depth = 0 

    while (!q.isEmpty()) {        
        String current = q.remove();        
        
        // if current word is same as actual word return the level
        if (current.equals(end))            
            return visitedWords.get(current);        
            
        List<String> neighbors = getNeighbors(current);        
        for (String neighbor: neighbors) {           
             if (!visitedWords.containsKey(neighbor)) {                
                 q.add(neighbor);                
                 visitedWords.put(neighbor, visitedWords.get(current) + 1);            
            }        
        }    
    }    
    return -1;
}


// get the neighbours of word from dictionary 

public static List<String> getNeighbors(String word) {    
    List<String> result = new ArrayList<String>();    
    
    char[] wordArray = word.toCharArray();    
    for (int i = 0; i < wordArray.length; i++) {        
        for (char ch = 'a'; ch <= 'z'; ch++) {   
            // all one letter change words         
            if (word.charAt(i) != ch) {                
                wordArray[i] = ch;                
                String candidate = new String(wordArray);                
                if(Dictionary.hasWord(candidate)) {                    
                    result.add(candidate);                
                }            
            }        
        }
        wordArray[i] = word.charAt(i);    
    }    
    return result;
}