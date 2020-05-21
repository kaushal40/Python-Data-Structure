def is_palindromic(s):
    first, last = 0, len(s) - 1
    while first <= last:
        if s[first] != s[last]:
            print("not palindrome")
            return 
        else: 
            first+= 1 
            last -= 1     
    print("palindrome")

is_palindromic("kaushal")
is_palindromic("123321")
is_palindromic("12321")