

// Tgrowing an Exception
if (x == 0 && power <= 0) {        
    throw new ArithmeticException("undefined");    
}

// Calculating Abs value of something that
Math.abs(-16) = 16;

// Pair class JAVA
Pair[] points = {  
    new Pair(i+1,j),            
    new Pair(i-1,j),            
    new Pair(i,j+1),            
    new Pair(i,j-1)        
};

for (Pair point : points) {        
    if (pathExists(a, point.getFirst(), point.getSecond(), memo)) 
    {            
        return true;        
    }    
}

// ENUM class in java for redability 

public enum State {    
    UNVISITED,    
    VISITING,
    NO_PATH_FOUND;
}

//initialize two dimensional array and Fill it with initial values 

State[][] memo = new State[a.length][a[0].length];    
for (State[] states: memo)        
    Arrays.fill(states, State.UNVISITED);


if(isOperand(c)){
    operand.push(ch-'0');
}