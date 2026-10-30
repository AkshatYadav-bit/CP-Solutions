class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        HashMap<Integer,int[]> map = new HashMap<>();
        for(int x : arr){
            int d = sumDig(x);
            if(map.containsKey(d)){
                int[] drr = map.get(d);
                Arrays.sort(drr);
                if(drr[2] == 0) drr[2] = x;
                else if(drr[1] == 0) drr[1] = x;
                else if(drr[0] == 0) drr[0] = x;
                Arrays.sort(drr);
                drr[0] = 0;
               // System.out.println(" d = "+d+" and drr = "+Arrays.toString(drr));
            }else{
                map.put(d,new int[3]);
                map.get(d)[2] = x;
            }

        }
        int max = -1;
        for(int[] drr : map.values()){
            if(drr[1] != 0) max = Math.max(max,drr[2]+drr[1]);
        }
        return max;

    }

    int sumDig(int n){
       int s = 0;
       while(n > 0){
         s += n%10;
         n /= 10;
       }
       return s;
    }
}