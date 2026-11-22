class Solution {
    public int minRange(int a, int b, int c) {
        if(a > b + c){
            a = b + c;
        }else if( b > a + c){
            b = a + c;
        }else if( c > a + b){
            c = a + b;
        }
        int max = Math.max(Math.max(a,b),c);
        int min = Math.min(Math.min(a,b),c);
        return max-min;
    }
}