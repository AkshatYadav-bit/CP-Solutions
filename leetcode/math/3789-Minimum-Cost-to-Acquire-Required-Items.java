class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long maxneed = Math.max(need1,need2);
        long minneed = Math.min(need1,need2);
        long a = Math.min(cost1*(long)need1+cost2*(long)need2,costBoth*(maxneed));
        if( need1 < need2){
            a = Math.min(a,costBoth*minneed+(long)(need2-need1)*cost2);
        }else{
            a = Math.min(a,costBoth*minneed+(long)(need1-need2)*cost1);
        }
        return a;
    }
}