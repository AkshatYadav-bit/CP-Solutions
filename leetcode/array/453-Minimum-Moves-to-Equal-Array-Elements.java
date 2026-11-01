class Solution {
    public int minMoves(int[] nums) {
        // incrementing n-1 numbers means decrementing any one number relatively
        // we have to decrement any number some times such that all elements are equal
        // so we have to get to min element at least
        int n = nums.length;
        int ans = 0;
        Arrays.sort(nums);
        int min = nums[0];
        for(int x : nums){
            if(x > min) ans += (x-min); 
        }
        
        //(n*k*log(n))
        return ans;
    }
}