class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        Map<Integer,Integer> map  = new HashMap<>();
        int min = Integer.MAX_VALUE;
    
        if(n % groupSize != 0) return false;
        
        for(int x : hand){
            map.put(x,map.getOrDefault(x,0)+1);
            min = Math.min(min,x);
        }
        Arrays.sort(hand);
        int p = 0; //pointer

        int counter = n / groupSize;
        for(int i = 0 ; i < counter ; i++){
            int k = Integer.MAX_VALUE;
            for(int j = 0 ; j  < groupSize ; j++){
                if(map.containsKey(min+j)){
                    if(map.get(min+j) > 1) {
                        map.put(min+j,map.get(min+j)-1);
                        k = Math.min(min+j,k);
                    }
                    else map.remove( min+j);
                }else{
                    return false;
                }
                p++;
            }
            // System.out.println(map);
            min =(p < n && k == Integer.MAX_VALUE)? hand[p]:k;
            // System.out.println(min);
        }
        return true;
        
    }
}