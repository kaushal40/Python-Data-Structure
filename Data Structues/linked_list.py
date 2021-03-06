 #Linked list example


# the Node class
class Node(object):
    def __init__(self, val):
        self.val = val
        self.next = None

# creating linked list node to be 
class ListNode():
    def __init__(self, data=0, next_node=None):
        self.data =  data
        self.next = next_node

# serach in the linked list
def search_linke_list(L, data):
    while L and L.data is data:
        L = L.next
    return L

# insert node after some node
def insert_after(node, new_node):
    # current node's next will be new node's next
    new_node.next =  node.next
    # node's next will be new  node
    node.next = new_node

# delete the node past some node
def delete_after(node):
    node.next =  node.next.next




# the LinkedList class
class LinkedList(object):
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

    def find(self, val):
        item = self.head
        while (item != None):
            if item.val == val:
                return item
            else:
                item = item.next
        return None

    def deleteAt(self, idx):
        if idx > self.count:
            return
        if self.head == None:
            return
        else:
            tempIdx = 0
            node = self.head
            while tempIdx < idx-1:
                node = node.next
                tempIdx += 1
            node.next = node.next.next
            self.count -= 1

    def dump_list(self):
        tempnode = self.head
        while (tempnode != None):
            print("Node: ", tempnode.val)
            tempnode = tempnode.next


# create a linked list and insert some items
itemlist = LinkedList()
itemlist.insert(38)
itemlist.insert(49)
itemlist.insert(13)
itemlist.insert(15)

itemlist.dump_list()

# exercise the list
print("Item count: ", itemlist.get_count())
print("Finding item: ", itemlist.find(13))
print("Finding item: ", itemlist.find(78))

# delete an item
itemlist.deleteAt(3)
print("Item count: ", itemlist.get_count())
print("Finding item: ", itemlist.find(38))
itemlist.dump_list()