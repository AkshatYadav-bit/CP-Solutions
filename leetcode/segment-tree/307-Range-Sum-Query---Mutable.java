class NumArray {
    int[] blocks;
    int[] arr ;

    public NumArray(int[] nums) {
        int n = nums.length;
        this.blocks = new int[n+1];
        this.arr = new int[n];
        int[] pre = new int[n+1];
        
        for(int i = 1 ; i <= n ; i++){
            pre[i] = pre[i-1]+nums[i-1];
            arr[i-1] = nums[i-1];
        }
       System.out.println(Arrays.toString(pre));

        for(int i = 1; i <= n ; i++){
            int block_size = (i & -i);
            int left = i;
            int right = i+1-block_size;
            blocks[i] = pre[left] - pre[right-1];
        }
       System.out.println(Arrays.toString(blocks));
    }
    
    public void update(int index, int val) {
        int prev_value  = arr[index];
        int delta = val - prev_value;
        arr[index] = val;
        int n = arr.length;

        int i = index+1;
        while( i <= n){
            blocks[i] += delta;
            i += (i & -i);
        }
    }
    
    public int sumRange(int left, int right) {
        return preSum(right+1) - preSum(left);
    }

    private int preSum(int i){
        int sum = 0;
        while( i > 0){
            sum += blocks[i];
            i -= (i & -i);
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */