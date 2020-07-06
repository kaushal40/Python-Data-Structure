// w h ​a t w h y​ w h e r e        
//     |       |

// exapand the window

// w h ​a t w h y w​ h e r e        
//     |         |

// now as w is alread y there we shrink the window to (previous encounter of W + 1)
// w h a t w​ h y w​ h e r e
//           |   |


public static Pair<Integer> allUnique(String input) {    
    if (input == null || input.isEmpty()) {        
        return null;    
    }    
    
    // to store the characheter and index
    HashMap<Character, Integer> map = new HashMap<>();

    // to maintian the largest window
    Pair<Integer> result = new Pair<Integer>(0, 0);    
    int start = 0, end = 0, longest = 1;    
    map.put(input.charAt(0), 0);    
    
    while (end < input.length() - 1) {        
        // expand end pointer        
        end++;        
        char toAdd = input.charAt(end); 

        // if char is in map shrink the wndow       
        if (map.containsKey(toAdd) && map.get(toAdd) >= start) 
        {            
            start = map.get(toAdd) + 1;        
        }        
        
        map.put(toAdd,  end);    

        // update result for whoever is longest      
        if (end - start + 1 > longest) {            
            longest = end - start + 1;            
            result.setFirst(start);            
            result.setSecond(end);        
        }    
    }    
    return result;
}