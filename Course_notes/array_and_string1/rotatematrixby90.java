public static void rotateMatrix(int[][] a]){
    // this is about rotatig a square matrix, so if the lenth of row and columns are not same we will return 
    if (a == null || a.length == 0 || a.length != a[0].length){
        return;
    }
    
    // we olny need half of the layers as other layers will be processed automatically
    for (int layer = 0; layer < a.length/2; layer++){
        // rotate (array, start, end), this will take us to the end
        rotate(a, layer, a.length-1-layer)
    }
}

// helper function shoudl beprivate and static 
private static void rotate(int[][] a, start, end){
    for (int current = 0; start+current < end; current++){
        int temp = a[start][start+current]; // save the top 
        a[start][start+current] = a[end-current][start]; // left to top moveing left elemnt to top
        a[end-current][start] = a[end][end-current]; // bottom element to left 
        a[end][end-current] = a[start+current][end]; // right element to bottom 
        a[start+current][end] = temp; // top elemrnt to right
    }
}