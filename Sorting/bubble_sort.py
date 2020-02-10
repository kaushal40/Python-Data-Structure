# for each element in dataset compare adjcent values
# if it next value is higher swap and continue until you reach at the end 
# Now do same theinf from i+1 to end and so on. 


def bubblesort(dataset):
    # we are going to loop till the 0 and decrease by -1
    for i in range(len(dataset) - 1, 0, -1):
        # loop to all elements and than i -1 so other set of elements
        for j in range(i):
            if dataset[j] > dataset[j+1]:
                temp =  dataset[j]
                dataset[j] = dataset[j+1]
                dataset[j+1] = temp
        print(dataset)
        
    
list1 = [6,20,8,19,56,23,87,41,49,53]
bubblesort(list1)
print(list1)



