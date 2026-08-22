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
            long max = Integer.MIN_VALUE;
            long min = Integer.MAX_VALUE;
            long ans = (n < 4 || n%2 == 1)?-1:0;
            if(ans != -1){
                n = n/2;
                // ceil(n/(double)3.0) == (n%3 != 0)?(n-n%3)/3+1:n/3
                // we ain't using Math.ceil
                // because double can lose precision when digits go upto 15-16
                // in given questions digits go upto 18-19
                if(n%2 == 0){
                    max = n/2; //maximize 2s , no 3s
                    min = (n > 4)?((n%3 != 0)?(n-n%3)/3+1:n/3):max; // maximize the 3s and one/two times 2s
                }else{
                    max = (n - 3)/2 + 1; // maximize the 2s and only one time 3s
                    min = (n>=3)?((n%3 != 0)?(n-n%3)/3+1:n/3):max; // maximize the 3s and one/two times 2s
                }
                out.append(min + " "+max).append('\n');

            }else{
                out.append(ans).append('\n');
            }
        }

        System.out.print(out);
    }
}