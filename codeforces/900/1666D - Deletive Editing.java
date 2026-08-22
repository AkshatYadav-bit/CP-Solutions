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
            String s = fs.next();
            String tg = fs.next();
            HashMap<Character,Integer> map = new HashMap<>();
            int j = s.length()-1;
            int i = tg.length()-1;
            String ans = "YES";
            while (i >= 0 && j >= 0) {
                //out.append("map = "+map).append('\n');
                //out.append("i = "+tg.charAt(i)+" j = "+s.charAt(j)).append('\n');
                if(tg.charAt(i) == s.charAt(j)){
                    if(!map.containsKey(s.charAt(j))){
                        i--;
                        j--;
                        // don't update map
                    }else{
                        //out.append("#"+map.containsKey(s.charAt(j))).append('\n');
                        ans = "NO";
                        break;
                    }
                }else{
                    map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0 )+1);
                    j--;
                }
            }
            //out.append("ans = "+ans).append('\n');
            ans = ((i == -1)&& ans.equals("YES"))?"YES":"NO";
            out.append(ans).append('\n');


            
        }

        System.out.print(out);
    }
}