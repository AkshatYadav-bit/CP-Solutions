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
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int[] arr = new int[n];
            int ans = 0;
            for(int i = 0 ; i < n ; i++){
                arr[i] = fs.nextInt();
                max = Math.max(max,arr[i]);
                min = Math.min(min,arr[i]);
            }
            for(int i =0 ; i <= n -2 ; i++) ans = Math.max(ans,arr[i]-arr[i+1]);
            ans = Math.max(arr[n-1]-min,ans);
            ans = Math.max(max-arr[0],ans);
            out.append(ans).append('\n');

            
        }

        System.out.print(out);
    }
}