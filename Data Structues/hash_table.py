#

items = dict({"key1" : 1, "key2": 2, "key3": 3})

print(items)


# create hash table progressively
items = {}

items["key1"] = 1; 
items["key2"] = 2; 
items["key3"] = 3; 

print(items)

print(items["key1"])

# iterate over hashmap 

for key, value in items.items():
    print("key:", key, " value ", value)

for k in items:
    print(items[k]);