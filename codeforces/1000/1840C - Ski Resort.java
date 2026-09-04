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
            int q = fs.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++){
                arr[i] = fs.nextInt();
            }
            long ans = 0;
            int i = 0;
            int j = 0;
            while (j < n) {
                if(arr[j] <= q){
                    i = j ;
                    while (j < n && arr[j] <= q) {
                        j++;
                    }
                    int len = j - i ;
                    //out.append("len = "+len).append('\n');
                    if(len >= k){
                        long c = len - k;
                        ans += ((c +1)*(c+2))/2;
                    }
                }else{
                    j++;
                }
            }
            out.append(ans).append('\n');


            
        }

        System.out.print(out);
    }
}