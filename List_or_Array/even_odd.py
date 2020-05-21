# good example of in-memory swapping
# Problem: keep even number first and odd numbers later

# 1. Take two indices first and last
# 2. Itrate while these two indices collides
# 3. if it is even keep as it is and increase the even counter
# 4. if odd, swap it with odd member and decrease counter of last

def even_odd(data):
    next_even, next_odd = 0, len(data) - 1
    while next_even < next_odd:
        if data[next_even] % 2 == 0:
            next_even += 1
        else:
            data[next_even], data[next_odd] = data[next_odd], data[next_even]
            next_odd -= 1
    return data

print(even_odd([1,4,3,5,2,6,35,7,2,5]))

# given an array A of n objects with boolean-valued keys, reorder the array so that obj 
# with the key false appear first.

E = [True, False, False, True, True, False]

def reorderBool(A):
    falses, trues = 0, len(A)
    while falses < trues:
        if A[falses] == False:
            falses += 1
        elif A[falses] == True:
            trues -= 1
            A[falses], A[trues] = A[trues], A[falses]