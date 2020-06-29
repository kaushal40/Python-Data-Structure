public static void printZigZag(int[][] a) {
    int row = 0; column = 0;
    boolean up = true;

    while(true) {
        System.out.println(a[row][column]);

        // if you are on any bowndry, left, right, bottom or top , shift to next diagonal and change direction
        // row boundry ( row = 0 || row == a.length -1 ) 
        // column boundry (column == a[0].length - 1) 

        //this one is for row boundry, than increase the column and change direction
        if((row = 0 || row == a.length -1) && column != a[0].length - 1) {
            column++;
            System.out.print(a[row][column]);
            up = !up;
        } // this one is for column boundry thn go to next row
        else if (column == 0 || column == a[0].length - 1) {
            row++;
            System.out.print(a[row][column]);
            up = !up;
        }

        // tf we reached at the end so exist rthe while loop 
        if (row == a.length - 1 && column == a.length - 1)            
            break;

        // going up means going up in row number, so if up row- if down row+
        row = up ? row - 1: row + 1;
        // for colum going up is + means you go on right side
        column = up ? column + 1 : column - 1;
    }
}