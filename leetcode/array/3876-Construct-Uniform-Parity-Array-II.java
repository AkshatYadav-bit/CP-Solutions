class Solution {
    public boolean uniformArray(int[] nums1) {
        int minOdd = Integer.MAX_VALUE;
        int minEven = Integer.MAX_VALUE;
        for(int x : nums1){
            if(x % 2 == 0){
                minEven = Math.min(minEven,x);
            }else{
                minOdd = Math.min(minOdd,x);
            }
        }
        // we can convert all evens to odds if minEven - minOdd >=1
        // or we have all evens already i.e.  minOdd == Integer.MAX_VALUE
        // we can't convert all odds to evens thats why it is false for such case
        // to make all evens, we can't do that unless all numbers are even already
        if(minEven - minOdd >=1 || minOdd == Integer.MAX_VALUE) {
            return true;
        }
        return false;
        
    }
}