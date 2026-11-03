class Solution {
    public int minMoves(int[] nums) {
        int max = Arrays.stream(nums).max().orElse(-1);
        int n = nums.length;
        int s = Arrays.stream(nums).sum();
        return n * max - s;
    }
}