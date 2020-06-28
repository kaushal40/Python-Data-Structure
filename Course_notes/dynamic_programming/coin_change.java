// We are considering combinations and not permutations, correct? 

//The concept is simple - You create an array of the size -target amount + 1​.  Let's see how
// Here, we create an array A of size 6. Initially, all the values are 0. We set A[0] to 1, becauseif there are no coins, there is only 1 way to make 0 dollars. The array looks as follows
//[1,0,0,0,0,0]
// Now, let’s say we have only 1 dollar coins. How many ways are there to make $1? 1, of course. Ourarray becomes
// [1,1,0,0,0,0]
// numWays(N) = a[N] + a[N-Coin]

// Propagating this formula for our $1 denomination, 
// we keep calculating a[3], a[4] and a[5],
// a[3] = a[3] + a[3-1] = 1
// a[4] = a[4] + a[4-1] = 1
// a[5] = a[5] + a[5-1] = 1

// Now, let’s add 2 dollar coins.
// a[1] = a[1] + a[1-2] = Don't update because a[1-2] is out of range
// a[2] = a[2] + a[0] = 2
// a[3] = a[3] + a[1] = 2
// a[4] = a[4] + a[2] = 3
// a[5] = a[5] + a[3] = 3
 
// The array becomes:[1,1,2,2,3,3]

public static int waysToMake(int amount, int[] coins) {
    int[] a = new int[amount+1];
    a[0] = 1;

    // now for each coin apply the formula to propogate the array
    for (int coin : coins) {
        for (int i = coin; i <= amount; i++) {
            a[i] = a[i] + a[i-coin];
        }
    }
    return a[amount];
}