# write a program to compare two strings which has integer number and compare  if the number is larger than first number


# Question
# what if the string is Empty? 
# Can the number be negative? 
# can I use int(str)? No

str1 = "1234"
str2 = "123"
str3 = "223"
# if the number are of different size, larger number is larger as easy as that
# if number are of same length, we just compare one by one and, if the first number's digit is larger return false else true

def is_larger(str1, str2): 
    if str1 == None or str2 == None: 
        return False;

    if len(str1) > len(str2):
        return False
    elif len(str2) > len(str1):
        return True
    else: 
        for i, j in zip(str1, str2):
            if i < j or i == j:
                continue
            else:
                return False
        return True

print(is_larger(str1, str2)) # False
print(is_larger(str2, str1)) # True
print(is_larger(str2, str3)) # True
print(is_larger(str3, str2)) # False