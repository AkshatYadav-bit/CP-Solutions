class Solution {
    public int reverseDegree(String s) {
        int sum = 0;
        int i  = 1;
        for(int x : s.toCharArray()){
            sum  += (26-(x-'a'))*i;
            // System.out.println((26-(x-'a'))*i);
            i++;
        }
        return sum;
    }
}