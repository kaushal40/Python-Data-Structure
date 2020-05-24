# if the pyada collide with each other in any row
# input will be a mattrix with 0 and 1


def rooks_are_safe(input):
    # row by row traversing
    for i in range(len(input)): # column length
        rowCount = 0
        for j in range(len(input[i])): # row length
            if input[i][j] == 1:
                rowCount += 1
                if rowCount > 1:
                    return False
                else:
                    continue
            
    for i in range(len(input[0])): # row length
        rowCount = 0
        for j in range(len(input)): # column length
            if input[j][i] == 1: # fix the column increase the row
                rowCount += 1
                if rowCount > 1:
                    return False
                else:
                    continue

    return True


print(rooks_are_safe(input_no_collision))
print(rooks_are_safe(input_collision))

    



        