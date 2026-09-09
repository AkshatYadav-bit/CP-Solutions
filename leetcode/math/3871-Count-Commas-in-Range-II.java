class Solution {
    public long countCommas(long n) {
        // 1,000 -> 999,999 ==> 1 commas (10^ 3 -> 10^6 - 1)
        // 1,000,000 -> 999,999,999 ==> 2 commas (10^ 6 -> 10^9 - 1)
        // 1,000,000,000 -> 999,999,999,999 ==> 3 commas (10^ 9 -> 10^12 - 1)
        // 1,000,000,000,000 -> 999,999,999,999,999 ==> 4 commas (10^12 -> 10^15 - 1)
        // 10^15  ==> 5 commas

        long count = 0;
        long c = (long)Math.floor(Math.log10(n) / 3.0);
        
        // we can have c = 5 for very large number thats why below condition to ensure correct c
        if(n <= (long)Math.pow(10,15)-1 && c == 5) c = 4;
        
        count += (c != 0)?(long)(n - Math.pow(10,3*c) + 1)*c  : 0;
        while(c > 1){
            count += (long)((long)Math.pow(10,3*c) - (long)Math.pow(10,3*(c-1)))*(c-1);
            c--;
        }
        return count;
    }
}