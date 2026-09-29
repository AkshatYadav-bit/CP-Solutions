class Solution {
    public boolean isUgly(int n) {
        while( n != 0 && n % 2 == 0){
            n /= 2;
        }
        // System.out.println(n);
        while(n != 0 && n % 3 == 0){
            n /= 3;
        }
        // System.out.println(n);
        while(n != 0 && n % 5 == 0){
            n /= 5;
        }
        // System.out.println(n);
        if (n == 1) return true;
        return false;
    }
}