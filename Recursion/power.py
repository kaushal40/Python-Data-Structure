# power of a function is 2^4= 2*2*2*2

def power(num, pwr):
    # what if the power is 0 it always gives 1
    if pwr == 0: 
        return 1;
    else:
        return num * power(num, pwr-1)

print(power(2,4))
    