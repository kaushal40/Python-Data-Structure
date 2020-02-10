items = ["apple", "pear", "orange", "banana", "apple",
         "orange", "apple", "pear", "banana", "orange",
         "apple", "kiwi", "pear", "apple", "orange"]


def create_hashtable(items):
    hash_table = dict()

    for item in items:
        hash_table[item] = 0

    result = set(hash_table.keys())
    print(result)


create_hashtable(items)


def add_values_hashtable(items):
    hash_table = dict()

    for item in items:
        if (item in hash_table.keys()):
            hash_table[item] = hash_table[item] + 1
        else: 
            hash_table[item] = 1;

    print(hash_table)


add_values_hashtable(items)

