class Solution {
    public boolean uniformArray(int[] nums1) {
        int minOdd = Integer.MAX_VALUE;
        int secminOdd = Integer.MAX_VALUE;
        int minEven = Integer.MAX_VALUE;
        for(int x : nums1){
            if(x % 2 == 0){
                minEven = Math.min(minEven,x);
            }else{
                if(x < minOdd){
                    minOdd = x;
                }else if(x < secminOdd){
                    secminOdd = x;
                }
            }
        }
        // if((secminOdd - minOdd >= 1 && secminOdd != Integer.MAX_VALUE)|| minEven == Integer.MAX_VALUE){
        //     return true;
        // }
        if(minEven - minOdd >=1 || minOdd == Integer.MAX_VALUE) {
            return true;
        }
        return false;
        
    }
}