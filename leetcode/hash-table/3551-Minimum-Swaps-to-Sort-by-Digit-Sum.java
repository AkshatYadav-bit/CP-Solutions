class Solution {
    public int minSwaps(int[] nums) {
        List<Integer> lst = new ArrayList<>();
        for(int x : nums) lst.add(x);

        Collections.sort(lst, (a,b) ->{
            int a_s = digsum(a);
            int b_s = digsum(b);
            if(a_s != b_s){
                return Integer.compare(a_s,b_s);
            }else{
                return Integer.compare(a,b);
            }
        });
        // System.out.println(lst);
        Map<Integer,Integer> map  = new HashMap<>();
        for(int i = 0 ; i < nums.length ;  i++){
            map.put(nums[i],i);
        }
        // System.out.println(map);
        int count = 0;
        for(int i = 0; i < nums.length ; i++){
            if(lst.get(i) != nums[i]){
                int k = map.get(lst.get(i));
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
                count++;

                // update the new index in nums
                map.put(nums[i],i);
                map.put(nums[k],k);
                // System.out.println(map);
            }
            // System.out.println(Arrays.toString(nums));
        }
        return count;
    }

    int digsum(int n){
        int s = 0;
        while(n > 0){
            s += n % 10;
            n /= 10;
        }
        return s;
    }
}