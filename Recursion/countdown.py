def countdown(x):
    if x==0:
        print("Done");
    else:
        print(x)
        countdown(x-1);

        # what if we put the statement below this 
        # function returns in reverse order so you will get 1, 2, 3, 4, 5
        print("wow ", x)

countdown(5);