# PROBLEM
# Compete Cell There is a colony of 8 cells arranged in a straight line where each day every 
# cell competes with its adjacent cells(neighbour). Each day, for each cell, if its neighbours 
# are both active or both inactive, the cell becomes inactive the next day, otherwise it becomes 
# active the next day. Assumptions: The two cells on the ends have single adjacent cell, so the 
# other adjacent cell can be assumed to be always inactive. Even after updating the cell state. 
# consider its previous state for updating the state of other cells. Update the cell information 
# of all cells simultaneously. Write a function cellCompete which takes takes one 8 element array 
# of integers cells representing the current state of 8 cells and one integer days representing 
# the number of days to simulate. An integer value of 1 represents an active cell and value of 0 
# represents an inactive cell.

# Input Format   
# Input will have 8 array values and the no of days   
# Constraints   
# array size is 8 integers   
# Output Format   
# print the array



def cellCompete(states, days):
    states = states[:]
    for _ in range(days):
        q = [0] * len(states)
        states.append(0)
        for index in range(len(q)):
            next_state = 0 if states[index - 1] == states[index + 1] else 1
            q[index] = next_state

        states = q
    return states

print(cellCompete([1,0,0,0,0,1,0,0], 1)) #Oupput: 0, 1, 0, 0, 1, 0, 1, 0
print(cellCompete([1,1,1,0,1,1,1,1], 2)) #Output: 0, 0, 0, 0, 0, 1, 1, 0