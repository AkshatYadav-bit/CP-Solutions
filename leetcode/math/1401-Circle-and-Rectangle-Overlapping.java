class Solution {
    public boolean checkOverlap(int r, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int g  = xCenter;
        int f = yCenter;
        // (g,f) is the center of circle

        boolean c1 = x1 <= g && g <= x2;
        boolean c2 = y1 <= f && f <= y2;

        if(c1 && c2){
            return true;
        }else if(c1 == true){
            int p_x  = ( f < y1)?(y1-f):(f-y2);
            if(p_x <= r) return true;
        }else if(c2 == true){
            int p_y  = ( g < x1)?(x1-g):(g-x2);
            if(p_y <= r) return true;
        }else{
            // check for distance from all extreme points

            int d1 = distance(x1,y1,g,f);
            int d2 = distance(x1,y2,g,f);
            int d3 = distance(x2,y1,g,f);
            int d4 = distance(x2,y2,g,f);
            int min_d = Math.min(Math.min(d1,d2),Math.min(d3,d4));
            if(min_d <= r*r) return true;
        }
        return false;
    }

    int distance(int a, int b, int g , int f){
        return (a-g)*(a-g)+(b-f)*(b-f);
    }
}