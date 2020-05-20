# The greatest common divisor (GCD), also called the highest common factor (HCF) of N numbers 
# is the largest positive integer that divides all numbers without giving a remainder.

# Write an algorithm to determin the GCD of N positive integers

def generalizedGCD(num, arr):
    gcd = 1
    pos_copy = [abs(a) for a in arr]
    if len(arr) == 1:
        return pos_copy[0]
    for j in range(len(arr)-1):
        curr_gcd = gcd_aux(pos_copy[j], pos_copy[j+1])
        if curr_gcd > gcd:
            gcd = curr_gcd
               
    return gcd
    
def gcd_aux(a, b):
    if a == 0:
        return b
    elif b == 0:
        return a
    elif a == b:
        return a
    else:
        if a > b:
            return gcd_aux(a-b, b)
        else:
            return gcd_aux(a, b-a)


print(generalizedGCD(5, [2,4,6,8,10]))
print(generalizedGCD(5, [10,8,6,4,-2]))
print(generalizedGCD(3, [5, 5, 10]))
print(generalizedGCD(1, [10])