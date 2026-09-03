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
            int k = fs.nextInt();
            int ans = Integer.MAX_VALUE;
            int evens = 0;
            for(int i = 1 ; i <= n ; i++){
                int x = fs.nextInt();
                if(x%k != 0)ans = Math.min(k-x%k,ans);
                else ans = 0;

                if(x % 2 == 0) evens++;
            }
            // if k == 4 then we need at least two even numbers
            // because maximum value of ans for k = 4 can be 3
            // and we can get less ans = 2 if we can make two even numbers (just find two odd numbers)
            if(k == 4){
                int odds = n - evens;
                if(evens >= 2){
                    ans  = 0;
                }else if(evens == 1 && odds >=1){
                    ans = Math.min(ans,1);
                }else if(odds >=2){
                    ans = Math.min(ans,2);
                }
            }


            out.append(ans).append('\n');
        }

        System.out.print(out);
    }
}