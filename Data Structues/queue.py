# we can use list as queue but removing item from list will take o(n) because you need to shift all the other elements 
# instead use deque, it is optimized for adding and removing from both the sides

from collections import deque

queue = deque();

queue.append(1);
queue.append(2);
queue.append(3);
queue.append(4);

print(queue)

print(queue.popleft()); # popleft makes it first in first out

print(queue)


