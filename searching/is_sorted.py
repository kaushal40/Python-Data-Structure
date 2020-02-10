items1 = [6, 8, 19, 20, 23, 41, 49, 53, 56, 87]
items2 = [6, 20, 8, 19, 56, 23, 87, 41, 49, 53]

def is_sorted(itemList):
    for i in range(len(itemList) - 1):
        if itemList[i] > itemList[i+1]:
            return False
    
    return True;


def is_sorted_comprehension(itemList):
    return all(itemList[i] <= itemList[i+1] for i in range(len(itemList) - 1))


print(is_sorted(items1))
print(is_sorted(items2))
print(is_sorted_comprehension(items1))
print(is_sorted_comprehension(items2))