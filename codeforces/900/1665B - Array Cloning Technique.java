import java.io.*;
import java.util.*;

public class Main {

    static class FastScanner {
        private final BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        private StringTokenizer st;

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        String nextLine() throws IOException {
            return br.readLine();
        }
        char nextChar() throws IOException {
            return next().charAt(0);
        }
    }

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();

        while (t-- > 0) {
            int n = fs.nextInt();
            Map<Integer,Integer> map = new HashMap<>();
            for(int i = 0 ;i < n ; i++){
                int x = fs.nextInt();
                map.put(x,map.getOrDefault(x,0 )+1);
            }
            int maxf = 0;
            for(int v : map.values()) maxf = Math.max(maxf,v);


            int equal_pos = maxf;// these how many elements are equal
            int ans = 0; 
            for(int i  = 0; i < n ;i++){
                if(equal_pos >= n) break;
                ans += 1 ; //copied the array
                ans += (n- equal_pos >= maxf)?maxf: n-equal_pos; //swapping the maxf elements
                equal_pos +=maxf;
                maxf = equal_pos;
            }
            out.append(ans).append('\n');
            
        } 

        System.out.print(out);
    }
}