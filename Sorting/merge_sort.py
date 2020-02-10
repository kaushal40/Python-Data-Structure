# merge sort is divide and concur

# first we divide the array so that we can break the array in individual element of one each 

items = [6,20,8,19,56,23,87,41,49,53]

def mergesort(dataset):
    #braking condition
    if len(dataset) > 1:
        mid = len(dataset) // 2  # // gives rounded int
        leftarr =  dataset[:mid]
        rightarr = dataset[mid:]

        # recursively break down the array
        mergesort(leftarr)
        mergesort(rightarr)

        # now perform the merging of two arrays
        i=0 # index for left array 
        j=0 # index for right array
        k=0 # index for merged array 

        # now while both arrays have content
        while i < len(leftarr) and j < len(rightarr):
            if leftarr[i] < rightarr[j]:
                dataset[k] = leftarr[i];
                i += 1;
            else:
                dataset[k] = rightarr[j];
                j += 1;
            k += 1

        # now if you have element in left array still remaining add them to k
        while i < len(leftarr):
            dataset[k] = leftarr[i]
            i += 1
            k += 1

        # now if you have element in right array still remaining add them to k
        while j < len(rightarr):
            dataset[k] = rightarr[j]
            j += 1
            k += 1


print(items)        
mergesort(items)
print(items)
            
            








