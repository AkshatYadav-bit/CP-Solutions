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
            char[] arr = fs.next().toCharArray();
            Set<Character> set = new HashSet<>();
            int[] suff = new int[n];
            for(int i = n-1 ; i >= 0 ; i--){
                suff[i] = set.size();
                set.add(arr[i]);
            }
            int max = set.size(); // size of set with all unique elements from string
            set.clear();
            for(int i = 0 ;  i < n ; i++){
                int a = suff[i];
                set.add(arr[i]);
                int b = set.size();
                max = Math.max(max,a+b);
            }
            out.append(max).append('\n');

            
        }

        System.out.print(out);
    }
}