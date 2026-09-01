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
            long x = fs.nextLong();
            long n = fs.nextLong();
            long ans = x;
            if(x%2 == 0){
                long a = n % 4;
                if(a == 1) n = -1*n;
                if(a == 2) n = 1;
                if(a == 3) n = n + 1;
                if( a == 0) n = 0;
                ans = x +n;
            }else{
                long a = n % 4;
                if(a == 1) n = n + 1;
                if( a == 2) n = 0;
                if( a == 3) n = -1*n;
                if(a == 0 ) n = 1;
                ans = (x-1)+n;
            }

            out.append('\n');
            out.append(ans).append('\n');

            
        }

        System.out.print(out);
    }
}