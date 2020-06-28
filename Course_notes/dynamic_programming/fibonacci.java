// Fibonacci with sample recursion
public int fibonacci(int n){
    if (n == 1 || n == 2){
        return 1;
    }

    return fibonacci(n - 1) + fibonacci(n - 2); 
}


// Fibonnaci with recursion and memoization (top-down approach)
public int fibonacciWithMemo(int n, HashMap<Integer, Integer> map){
    if (n == 1 || n == 2){
        return 1;
    }

    if map.containsKey(n)
        return map.get(n);

    int result = fibonacci(n - 1) + fibonacci(n - 2);
    map.put(n, result)
    return n;
}


// Fibonacci with DP tabulation (bottum -up approach)
// in this peroblem we just need last two values so we only save two values at a time
public static int fibonacci(int n){
    if (n < 1){
        throw new IllegalArgumentException();
    }

    int nminus1element = 1, nminus2element = 1, nth = 1;
    for (int i =3: i <=n; i++){
        // finding current element is just as easy as summing last two elements
        nth =  nminus1element + nminus2element;
        // update previous elements
        nMinus2 = nMinus1;
        nMinus1 = nth; 
    }
    return nth;
}
