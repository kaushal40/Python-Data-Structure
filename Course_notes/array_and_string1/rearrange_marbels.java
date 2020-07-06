// partition array three ways by using high and low bnoundries

public static void redWhiteBlue(Marble[] a) {    
    if (a == null)        
        return;    
        
    int low_boundary = 0, high_boundary = a.length - 1;    
    int i = 0;    
    while (i <= high_boundary) {        
        Color color = a[i].getColor();        
        if (color == Color.RED) {            
            Utils.swap(a, i, low_boundary);            
            low_boundary++;            
            i++;        
        } else if (color == Color.BLUE) {            
            Utils.swap(a, i, high_boundary);            
            high_boundary--;        
        } else if (color == Color.WHITE){            
            i++;        
        } else {            
            throw new IllegalArgumentException("Unknown Color: " + color);        
        }    
    }
}

/***** Helper Code *****//* Ask the interviewer if you need to implement this. */
public static enum Color {    
    RED(0),    
    WHITE(1),    
    BLUE(2);    
    private final int colorId;

    Color(int colorId) {        
        this.colorId = colorId;    
    }

    public int getValue() {        
        return colorId;    
    }
}

public static class Marble {    
    Color color;    
    int data;    
    
    public Marble(Color color) {        
        super();        
        this.color = color;        
        this.data = 0;    
    }    
    
    public Marble(Color color, int data) {        
        super();        
        this.color = color;        
        this.data = data;    
    }    
    
    public Color getColor() {        
        return color;    
    }    
    
    public int getData() {        
        return data;    
    }    
    
    public String toString() {        
        return color.toString() + ": " + data;    
    }
}