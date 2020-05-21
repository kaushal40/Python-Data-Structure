import random

# interconvert string to int anf int to string
print(int("42"))
print(str(42))
print(float("3.14"))

# random numbers
print(random.randrange(28))
print(random.randint(8,16))
print(random.choice([1,10,14,24]))

#array
# 1. Insted of deleting an entry see if you can replace it as removing requires moving of all entries to right
# 2. When doing 2D arrays use parallel logic
A = []
B = [[1,2,3],[4,5,6]]
C = [1,2,3,4]

list(range(100))
A.append(42)
A.append(43)
A.append(44)
len(A)
A.remove(42) #removes values by name
del A[0] #removes value by index also can use slices del A[2:4]
A.pop(0) #removes and prints the value
print(A)
print(2 in C) # check if the value id in array
D = C # it refers to same copy called shallow copy copy.copy(C)
D = list(C) # This creates deep copy, modification of one will not affect other copy
D.reverse() # inplace
A.sort() # inplace

A = [1, 6, 3, 4, 5, 2, 7]
A[2:4] # is [3, 4]
A[2:] # [3, 4, 5, 2, 7]
A[:4] # [1, 6, 3, 4]
A[:-1] # [1, 6, 3, 4, 5, 2] (- values does it from back)
A[-3:] # [5, 2, 7]
A[-3:-1] # [5, 2]
A[::-1] # [7, 2, 5, 4, 3, 6, 1] (reverse)
A[2:] + A[:2] # rotate by 2


#Python list comprehension
print([a**2 for a in range(6)])
print([x**2 for x in range(6) if x % 2 == 0])


#pyhtin array itrate
A = [1, 6, 3, 4, 5, 2, 7]
#0, 1, 2, 3, 4, 5, 6 iteration throgh index
for i in range(len(A)) : pass
# 6,5,4,3,2,1,0 iteration in reverse order
for i in reversed(range(len(A))): pass

# String
s = "kaushal"
t = "prajapati"
print(s[3])
print(len(s))
print(s + " " + t)
print(s[2:4])
print(s.strip())
print(s.startswith("kau"))
print(s.endswith("kau"))
print('Euclid,Axiom 5,Parallel Lines'.split(','))
print(s.upper())
print(t.lower())

