**Concepts**

1. Arrays provide O(1) lookup by index
2. They are of fixed size, you specify the size during creation in python `lst = [None] * 5`
3. Resizing an array is an expensive operation
4. 2D array representation in memory

----
----
**2D array representation in memory**

![alt text](images/2d_representation.png "Title")

----
----

**Reverse traversal technique**
1. Replace all even numbers using same of two

![alt text](images/reverse_traversal.png "Title")

----
----

**Two pointer technique**
1. Reverse elements in array
2. Sorted array two sum problem
3. Sorted array non decreasing order, sqaures of each number non decreasing. 
4. Array fo integer, find a continuous subarray when sorterd makes entire array sorted


![alt text](images/traverse_both_ends.png "Title")
![alt text](images/sorted_array_squares.png "Title")
![alt text](images/find_subarray_which_makes_Array_sorted.png "Title")

----
----
**Partitioning Arrays**
1. Dutch Flag problem
2. Move all zeros to front
3. Move all zeros to back
4. Three way partitioning (Dutch Flag Problem)

![alt text](images/partition1.png "Title")

![alt text](images/partition2.png "Title")

![alt text](images/partition3.png "Title")


----
----
**Subarray Sum Problems**
- Understand the difference between subarray and subsets
- Subarray is always contiguous and subset is any elemants from the array

**Technique 1 (KADANE's algorithm)**
- Good to be used when it is contiguous

- *hint* : positive + negative number you can use KADANE's algorithm

1. Find the subarray with maximum sum 

![alt text](images/Kadane's_explaination.png "Title")
![alt text](images/Subarray_sum_kadanes.png "Title")

**Technique 2 Subarray Sliding window**
- Ask relavent question to array, +ve or -ve, sorted, null or empty, what result to return 
- sliding window only works on positive numbers otherwise you can't slide the window
- *hint* : see if all are positive number, sliding window might help, also unique charachter

1. subarray that sums to target

![alt text](images/sliding_window_1.png "Title")
![alt text](images/sliding_window_2.png "Title")

----

2. Find longest substring with unique charachters

![alt text](images/sliding_window_3.png "Title")


**Technique 3 Prefix sum**

- Ask relavent question, like what is return type and what if there are multiple results
- This has two properties, which can be utilized to find array with sum = X
- can be postive and negative both
- Kadane's can be used when there is single result

1. Find subarray which sums to zero

- if only one result KADANE will help as well, but there are two properties so you can missout on other one

![alt text](images/prefix_sum_1.png "Title")

![alt text](images/prefix_sum_2.png "Title")

----

2. Find subarray which sums to X

![alt text](images/prefix_sum_3.png "Title")


**Technique 4 MAX DIFF**

- The Max Diff is the maximum difference between two elements in an array, with the lesser element coming before the greater element.

![alt text](images/max_diff_1.png "Title")
![alt text](images/max_diff_2.png "Title")
![alt text](images/max_diff_3.png "Title")


**2D Arrays**

- Rotate array by 90 degrees

![alt text](images/matrix_rotate.png "Title")
![alt text](images/matrix_rotate_1.png "Title")
![alt text](images/matrix_rotate_2.png "Title")
![alt text](images/matrix_rotate_3.png "Title")


- Print array in zigzag order 

![alt text](images/array_zigzag.png "Title")

https://www.filepicker.io/api/file/jmoYEixvTmjury2XKtlB

- Print array in spiral order

![alt text](images/array_spiral.png "Title")

https://www.filepicker.io/api/file/jmoYEixvTmjury2XKtlB


**SPECIAL TRICKS**

- *Check if a string is trotation of another string*
- kaushal , shalkau is rotation of kaushal so simplay append these two and see if it substring.

![alt text](images/string_1.png "Title")

- *reverse words in the string*
-  1) first reverse the entire string and 2) thn reverse the individual words (this will do it in place)

![alt text](images/string_2.png "Title")

- *Longest palindrome in the string*
- abkayakcd --> longest palindrom is kayak. 
- You need to expand throgh bith the elemnts and the middle of each letter (and keep track of longest) start form the middle

![alt text](images/string_3.png "Title")
![alt text](images/longest_palindrom_substring.png "Title")


**BIG INTEGER ADDITION**

- 100 digit number will not fit in normal int
- simple technique of using carry result%10 and use it


![alt text](images/big_int_1.png "Title")
![alt text](images/big_int_2.png "Title")
![alt text](images/big_int_3.png "Title")
![alt text](images/bib_int_multiplication.png "Title")

