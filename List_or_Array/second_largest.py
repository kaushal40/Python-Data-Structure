from heapq import heappop, heappush


# heapq is binary heap with O(log n) push and pop
# complexity of this code will be (n log n) 
# could this array be empty
# could this will have only one element 

def second_smallest_n_log_n(item_list):
    items_heap =  []
    for item in item_list:
        heappush(items_heap, item)

    heappop(items_heap)
    print(heappop(items_heap))
    

item_list = [1,3,4,5,0,2]
second_largest_n_log_n(item_list)
item_list = [1,3,4,5,2]
second_largest_n_log_n(item_list)




def second_largest_n(item_list):

    if len(item_list) == 1 or len(item_list) == 0:
        return None

    largest = 0
    second_largest = 0
    for item in item_list: 
        if largest > item:
            continue
        else:
            temp  = largest
            largest =  item
            second_largest = temp

    print(second_largest)

    
item_list = [1,3,4,5,0,2]
second_largest_n(item_list)
item_list = [1,3,4,5,2]
second_largest_n(item_list)