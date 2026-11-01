class Solution {
    public int minMoves(int[] nums) {
        // incrementing n-1 numbers means decrementing any one number relatively
        // we have to decrement any number some times such that all elements are equal
        // so we have to get to min element at least
        int n = nums.length;
        int ans = 0;
        int min = Arrays.stream(nums).min().orElse(-1); // if length of array is zero then return -1 else return min element
        for(int x : nums){
            if(x > min) ans += (x-min); 
        }
        return ans;
    }
}