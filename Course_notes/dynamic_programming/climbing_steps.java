//bottom up tabulation

public static int waysToClimb(int n){
    int[] a = new int[n+1];
    a[0] = 1;

    // so from any index check where (1,3,5) you can go and update that in teble by increasing count relationship (cunnentcount + newcount coming from index)
    for (int i = 0; i < n; i++){
        // just to check if you are not going out of table
        if (i+1 < a.length)
            a[i + 1] += a[i];
        
        if (i + 3 < a.length)                
            a[i + 3] += a[i];

        if (i + 5 < a.length)                
            a[i + 5] += a[i];
    }
}


//top down
// at any location you can come from -3, -5 or -1 location
// a[i] = a[i-1] + a[i-3] + a[i-5]

public static int waysToClimb(int n){
    int[] a = new int[n+1];
    a[0] = 1;

    for(int i =1; i < a.length; i++){
        // now see if you have subprolem results from -3 index -5 and -1 and add
        int nMinus1 = i-1 < 0 ? 0 : a[i-1]; 
        int nMinus3 = i-3 < 0 ? 0 : a[i-3];
        int nMinus5 = i-5 < 0 ? 0 : a[i-5];

        a[i] = nMinus1 + nMinus3 + nMinus5;
    } 
    return a[n];
}
