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
            int[] arr = new int[n+1];
            for(int i = 1 ; i  <= n ; i++){
                arr[i] = fs.nextInt();
            }
            long sum = 0;
            int s = n;
            int i = k ;
            int j = n - k +1;
            while (s >= k) {
                // out.append(" i = "+arr[i]+" and j = "+arr[j]+" ");
                if(i == j){
                    // out.append("i == j "+arr[i]).append('\n');
                    sum += arr[i];
                    arr[i] = 0;
                    while ( i <= n && arr[i] == 0) i++;
                    while (j >=1 && arr[j] == 0) j--;
                }else if(arr[i] > arr[j]){
                    // out.append("arr[i] > arr[j]"+arr[i]).append('\n');
                    sum += arr[i];
                    arr[i] = 0;
                    if( j < i){
                        i++;
                        j--;
                    }else{
                        i++;
                    }
                }else{
                    // out.append("arr[i]< arr[j]"+arr[j]).append('\n');
                    sum += arr[j];
                    arr[j] = 0;
                    if( j < i){
                        i++;
                        j--;
                    }else{
                        j--;
                    }
                }
                s--;
                
            }
            out.append(sum).append('\n');
            
        }

        System.out.print(out);
    }
}