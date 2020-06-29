public static void printSpiral(int[][] a){
    if (a == null || a.length == 0)
        return;

    // taking outside layer by passing last row and last column
    for (int layer = 0; layer <= a.length/2 ; layer++) {
        printLayer(a, layer, a[0].length-1-layer, a.length-1-layer);
    }
}

private static void printLayer(int[][] a, int layer, int lastColumn, int lastRow) {
    // single element in layer, print separately because other cases won't handle it
    if (lastColumn == layer && lastRow == layer)
        System.out.print(a[layer][layer]);
    
    for(int current = layer; current < lastColumn; current++) { 
        // top row        
        System.out.print(a[layer][current]);    
    }

    for(int current = layer; current < lastRow; current++) {
        // right column
        System.out.print(a[current][lastColumn]);
    }

    for(int current = lastColumn; current > layer; current--) { 
        // bottom row        
        System.out.print(a[lastRow][current]);    
    }

    for(int current = lastRow; current > layer; current--) {    
        // left column        
        System.out.print(a[current][layer]);    
    }
}