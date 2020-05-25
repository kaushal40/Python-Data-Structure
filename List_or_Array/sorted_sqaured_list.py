# Given a sorted array in non-decreasing order, return an array of squares of each number, 
# alsoin non-decreasing order. For example:[-4,-2,-1,0,3,5] -> [0,1,4,9,16,25]


def sortedSquares(A):
    # we will use two pointers
    # we will travrse negetive numbers in reverse direction, and positive in forward
    # for example [-4,-1,0,3,10] [-4 -1] from -1 and [0,3,10] from 0
    # now we will increase pointers and whatever is smaller add and change the pointers accordingly
    array_length = len(A)

    array_negative_last_index = 0
    while A[array_negative_last_index] < 0 and array_negative_last_index < array_length - 1:
        array_negative_last_index += 1

    # because we don't need positive index
    array_negative_last_index -= 1
    array_positive_first_index = array_negative_last_index + 1
    ans = []
    while array_negative_last_index >= 0 and array_positive_first_index < array_length:
        if A[array_negative_last_index]**2 < A[array_positive_first_index]**2:
            ans.append(A[array_negative_last_index]**2)
            array_negative_last_index -= 1
        else:
            ans.append(A[array_positive_first_index]**2)
            array_positive_first_index += 1

    # append remaining elements
    while array_negative_last_index >= 0:
        ans.append(A[array_negative_last_index]**2)
        array_negative_last_index -= 1

    while array_positive_first_index < array_length:
        ans.append(A[array_positive_first_index]**2)
        array_positive_first_index += 1

    return ans

print(sortedSquares([-4,-2,-1,0,3,5]))