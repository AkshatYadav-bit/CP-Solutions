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
            int a = fs.nextInt();
            int b = fs.nextInt();
            int c = fs.nextInt();
            int d1 = b -a;
            int d2 = c - b;
            //out.append(b-d2 + " "+ (b-d2)%a +" ");
            String ans = "NO";
            if( (a+c)%2 == 0 && ((a+c)/2) % b == 0) {
                ans = "YES";
            }else if( (b-d2)%a == 0 && (b-d2) > 0){
                ans = "YES";
            } else if( (b+d1)%c == 0 && (b+d1) > 0) {
                ans = "YES";
            }
            out.append(ans).append('\n');

            
        }

        System.out.print(out);
    }
}