//To generate hash codes, we use polynomials. We set x to a prime number, e.g, 31, 53 or 101.

//hash("boat") -> 'b'.x^3 + 'o'.x^2 + 'a'.x + 't'

public static int hash(String str) {
    char[] ch = str.toCharArray();
    int hash = 0, x = 53;
    for (int i = 0; i < ch.length; i++) {
        // becuse you are multiplying x everytime it will be x, x2, x3 and polynomial
        hash = hash * x + ch[i];
    }
}