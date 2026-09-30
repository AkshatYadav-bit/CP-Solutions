class Solution {
    public int climbStairs(int n) {
        int[] t = new int[n+1];
        // we are starting from 0th position
        if(n == 1) return 1;
        t[0] = 1;
        t[1] = 1; // no. of distinct ways to reach top 1st position
        // t[2] = 2; // no. of distinct ways to reach top 2nd position

        for(int i = 2 ; i <= n ; i++){
            t[i] =  t[i-1] + t[i-2]; // no. of distinct way to reach ith position
            // cause  set ( permutation_set(t[i-1]) + set(1) ) ==> contains t[i-1] elements
            // and    set ( permutation_set(t[i-2 ]) + set(2)  ) ==> contains t[i-2] elements
        }
        return t[n];
            
    }
}