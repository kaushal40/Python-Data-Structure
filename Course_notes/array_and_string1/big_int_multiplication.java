// big int multiplication will use the bigint addition as part of it

public static int[] multiply(int[] a, int[] b) {    
    if (a == null || b == null) {        
        throw new IllegalArgumentException("Input is null");    
    }    
    
    int[] result = {0};    
    int zeroCount = 0; 
    
    // number of zeroes to add to the end    
    for (int i = a.length - 1; i >= 0; i--) {        
        int[] product = new int[1 + b.length + zeroCount];        
        int carry = 0;        
        for (int j = b.length - 1; j >= 0; j--) {            
            int p = a[i] * b[j] + carry;            
            carry = p / 10;            
            product[j + 1] = p % 10;        
            }        
            product[0] = carry;        
            result = add(result, product);        
            zeroCount++;    
        }    
        return result;
    }
}

public static int[] add(int[] a, int[] b) {    
    if (a == null || b == null) {        
        throw new IllegalArgumentException("Input is null");    
    }

    // Decide which array is larger to keep it on top
    int[] larger = a.length > b.length ? a : b;
    int[] smaller = larger == a ? b : a;

    // make smaller array as large as larger so it becomes easier for addition
    smaller = resizeWithZeroes(smaller, larger.length);

    // make a result array one size bigger than the larger for example 999 + 999 = 1998
     int[] result = new int[1 + larger.length];

     int carry = 0;

     // you can use smaller.length as well as both are of same length
     for (int i = larger.length - 1; i >= 0; i--) {
         int sum = larger[i] + smaller[i] + carry;
         carry = sum / 10;
         // add it to the very end and as the result array is one larger
         result[i+1] = sum % 10;
     }
     result[0] = carry;

     // ask if this rquired
     result = trimBeginningZeroes(result);
     return result;
}

//helper function
public static int[] resizeWithZeroes(int[] a, int size) {    

    if (size < a.length)        
        throw new IllegalArgumentException("Can only expand size");

    // this will assign the array to bigger arra
    int[] result = new int[size];
    int aIndex = a.length - 1, resultIndex = result.length - 1;

    while (aIndex >= 0) {        
        result[resultIndex] = a[aIndex];        
        resultIndex--;        
        aIndex--;    
    }    
    
    return result;
}
