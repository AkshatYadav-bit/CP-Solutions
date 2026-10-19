class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int start = 0;
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] < target){
                start++;
            }else if(nums[i] == target){
                count++;
            }
        }
        for(int i = start ; i < start+count ; i++){
            ans.add(i);
        }
        return ans;
        
    }
}