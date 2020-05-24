#Given a sentence, reverse the words of the sentence.
# For example,"i live in a house" becomes "house a in live i"

# Question : what about punctulations (nope), what about the capitalization (keep as it is)

def reverse_words_in_string(str):
    data =  str.split(" ")
    result = ""
    for word in reversed(data):
        result =  result + " " + word
    
    print(result.strip())

reverse_words_in_string("i live in a house")