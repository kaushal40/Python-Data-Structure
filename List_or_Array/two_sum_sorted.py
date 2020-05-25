def twoSum(numbers, target):
    first_element = 0
    last_element = len(numbers) - 1
    while first_element < last_element:
        if numbers[first_element] + numbers[last_element] == target:
            return [first_element + 1, last_element + 1]
        elif numbers[first_element] + numbers[last_element] > target:
            last_element -= 1
        else:
            first_element += 1
    return None

print(twoSum([2,7,11,15],9))