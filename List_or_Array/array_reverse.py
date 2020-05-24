# reverse array using swap 
# int() function to iterate only half, if you iterate full thn same array

def reverse_array(array_data):
    array_length = len(array_data) - 1
    for i in range(int(len(array_data)/2)):
        array_data[i], array_data[array_length] = array_data[array_length], array_data[i]
        i+=1
        array_length-=1

    return array_data

print(reverse_array([1,2,3,4,5]))