//We keep 2 boundaries - ​low​ and ​high​. ​
// Low​ starts at 0, ​High​ starts at the end of the array.
//Low​ contains numbers less than pivot. ​High​ contains numbers greater than pivot.
//iterate and update boundries

// when we put high and low boundry middle elements will automatically be sorted
public static void dutchNationalFlag(int[] a, int pivot) {    
    int low_boundary = 0, high_boundary = a.length - 1;    
    int i = 0;    while (i <= high_boundary) {        
        if (a[i] < pivot) {            
            Utils.swap(a, i, low_boundary);            
            low_boundary++;            
            i++;        
        } else if (a[i] > pivot) {            
            Utils.swap(a, i, high_boundary);            
            high_boundary--;        
        } else {           
            i++;        
        }    
    }
}