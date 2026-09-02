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
            long n = fs.nextLong();
            long x  = fs.nextLong();
            long max_ans = 0;
            long min_ans = 0;
            long sum  = 0;
            for(int i = 1 ; i <= n ;i++){
                int num  = fs.nextInt();
                max_ans += (long)Math.ceil(num/(double)x);
                sum +=num;
            }
            min_ans =(long) Math.ceil(sum/(double)x);
            out.append(min_ans+" ").append(max_ans).append('\n');
            
        }

        System.out.print(out);
    }
}