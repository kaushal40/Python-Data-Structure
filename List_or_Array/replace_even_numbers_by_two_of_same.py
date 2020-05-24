# Given an array of numbers, replace each even number with twoof the same number. 
# e.g, [1,2,5,6,8,None,None,None,None] -> [1,2,2,5,6,6,8,8].

# questions
# 1. how do you want me to return the result? 
# 2. what is empty elements in array contains of `None` 

# pseudocode
# we will use two pointers fisrt_pointer = endofactualelemnts, second_pointer =  endoflist
# Iterate from reveres to reach to fisrt_pointer length
# now once you find element iterate it in reverse and and as soon as you find even element add at 
# a[second_pointer] and reduce it --

# Base conditions
# 1. null or empty array

def replce_even_number_by_two(array_data):
    if array_data is None or len(array_data) <=0:
        return None
    # store the secon pointer location
    second_pointer = len(array_data) - 1
    
    # traverse array from reverse and if it is None skip or even skip, if even add at end
    for i in reversed(range(len(array_data))):
        if array_data[i] is None or array_data[i] % 2 != 0:
            pass
        else:
            array_data[second_pointer] = array_data[i]
            second_pointer-=1
        i-=1
       
    return array_data

print(replce_even_number_by_two([1,2,5,6,8,None,None,None]))
print(replce_even_number_by_two([]))