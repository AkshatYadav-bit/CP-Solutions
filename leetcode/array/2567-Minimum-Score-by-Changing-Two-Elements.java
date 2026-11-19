class Solution {
    public int minimizeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int ans = 0;
        if(nums.length == 3){
            return 0;
        }
        return Math.min(Math.min(nums[n-1]-nums[2],nums[n-3]-nums[0]),nums[n-2]-nums[1]);
    }
}