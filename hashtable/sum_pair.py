# find pair that sums to target value for the array

# Questions to ask
# 1: Can there be any negatives in the array? 
# 2: Can there be decimals? 
# 3: What if there are two pairs which add up to the target? 
# 4: What if there is no pair found? 

# Test Cases:
# Edge Case: empty array and null array
# Base case:  single element or only two elements
# regular cases:  more thn two elements


input = [3, 4, 1, 2, 9]

def sum_pair(inputArray, target):
    pair_dict = dict()
    for i in inputArray:
        if (target - i) in pair_dict.keys():
            print("{}, {}".format(i, (target - i)))
            return
        else:
            pair_dict[i] = 1

    print("no pair found")

    
sum_pair(input, 7)