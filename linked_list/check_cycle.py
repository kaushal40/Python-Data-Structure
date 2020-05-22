class Node():
    def __init__(self, data=0, next_node=None):
        self.data = data
        self.next = next_node

class LinkedList():
    def __init__(self, head=None):
        self.head = head
        self.count = 0

    def get_count(self):
        return self.count

    def insert(self, data):
        new_node = Node(data)
        new_node.next = self.head
        self.head = new_node
        self.count += 1

    def insert_at_end(self, data):
        new_node = Node(data)
        temp = self.head
        while (temp.next !=  None):
            temp = temp.next

        temp.next = new_node
        self.count += 1

def has_cycle (head):
    fast = slow = head
    while fast and fast.next and fast.next.next:
        # There is a cycle.
        slow, fast = slow.next, fast.next.next
        if slow is fast:
        # Tries to find the start of the cycle.
            slow = head
            # Both pointers advance at the same time.
            while slow is not fast:
                slow , fast = slow.next , fast.next
                 # slow is the start of cycle.
                return slow
        # No cycle.
        return None