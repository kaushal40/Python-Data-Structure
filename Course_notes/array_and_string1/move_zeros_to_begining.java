
// you maintain the boundry and swap the elemnt when boundry is found
public static void moveZeroesToBeginning(int[] a) {    
    int boundary = 0;    
    
    for (int i = 0; i < a.length; i++) {        
        if (a[i] == 0) {            
            Utils.swap(a, i, boundary);            
            boundary += 1;        
        }    
    }
}


public static void moveZeroesToEnd(int[] a) {    
    int boundary = a.length - 1;    
    
    for (int i = a.length - 1; i >= 0; i--) {        
        if (a[i] == 0) {            
            Utils.swap(a, i, boundary);            
            boundary--;        
        }
    }
}