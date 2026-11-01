class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int mid = nums[n/2];
        //System.out.println("mid = "+mid);
        int ans  = 0;
        for(int x : nums){
            ans += Math.abs(mid-x);
        }
        return ans;
    }
}