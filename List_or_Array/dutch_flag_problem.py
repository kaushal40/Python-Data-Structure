# Write a program that takes an array A and an index i into A, and
# rearranges the elements such that all elements less than A[i] (the pivot)
# appear first, followed by elements equal, then elements greater. 

# The problem is trivial with O(n) additional space, where n is the length of A.

# example lazy solution (wastes time going through array twice)

A = [0, 1, 2, 0, 2, 1, 1]
B = [9, 3, 1, 6, 3, 2, 3, 6, 9, 4]

def sortA(A, pivot_index):
    pivot = A[pivot_index]
    newList = []
    # iterates throgh the array and if the value is less than than use insert to add at front
    # if value is equal thn appended to end
    for item in A:
        if item < pivot:
            newList.insert(0, item)
        elif item == pivot:
            newList.append(item)
    # again iterate if the element is higher add it to end
    # you are iterating to elements already iterated again, not efficient
    for item in A:
        if item > pivot:
            newList.append(item)
    return newList

#------------------------------------------------------------------------------

# another lazy solution goes through array once but makes three sublists
def sortB(A, pivot_index):
    pivot = A[pivot_index]
    smallList = []
    equalList = []
    bigList = []
    for item in A:
        if item < pivot:
            smallList.append(item)
        elif item == pivot:
            equalList.append(item)
        elif item > pivot:
            bigList.append(item)
    return smallList + equalList + bigList

#-------------------------------------------------------------------------------

def dutchflag2(A, pivot_index):
    pivot = A[pivot_index]
    # First pass: group elements smaller than pivot
    smaller = 0
    for i in range(len(A)):
        if A[i] < pivot:
            A[i], A[smaller] = A[smaller], A[i]
            smaller += 1
    # smaller serves as our index here
    # Second pass: group larger elements
    larger = len(A) - 1
    for i in reversed(range(len(A))):
        if A[i] < pivot:
            break
        elif A[i] > pivot:
            A[i], A[larger] = A[larger], A[i]
            larger -= 1

            