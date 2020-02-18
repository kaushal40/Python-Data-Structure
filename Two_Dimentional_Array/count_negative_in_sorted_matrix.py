# Problem: if array matrix is sorted count the number of negative elemnsts in the array 

# solution-1: 
# You can just iterate entire matrix and count which will be o(n)^2 

# solution-2 
# start form the right top as the array is sorteddatetime
# Move in the left direction, if you find the negative number stop and add the remaining cells on the left to the negative count
# Now Move below the found negative element which will be matrix[row+1][found_negative_index]
# Follow the same step again until you reach till the end of an array or last row
# O(2n)

input = [[-4, -3, -1, 0],
         [-2, -2,  1, 2],
         [-1,  1,  2, 3],
         [ 1,  2,  3, 4]
        ]

def count_negative_in_sorted_matrix(input2dMatrix):
    count = 0
    row_i = 0
    col_i = len(input2dMatrix[0]) - 1
    while col_i >= 0 and row_i < len(input2dMatrix):
        if input2dMatrix[row_i][col_i] >= 0:
            col_i -= 1
        else:
            row_i += 1
            count += (col_i + 1)

    print(count)

count_negative_in_sorted_matrix(input)

        







