package OldContests;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.io.*;
import java.util.*;

public class AutomaticControlMenna {

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner();
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt();
            BitSet[] test = new BitSet[m];
            for (int i = 0; i < m; i++) {
                test[i] = new BitSet(n);
                char[] x = sc.next().toCharArray();
                for (int j = 0; j < n; j++)
                    if (x[j] == '1') test[i].set(j);
            }
            BitSet best = new BitSet(n);
            for (int i = 0; i < n; i++)
                best.set(i);
            boolean found = false;
            int min = m;
            BitSet tested = new BitSet(n);
            for (int i = 0; i < 1 << m; i++) {
                for (int j = 0; j < m; j++)
                    if ((i & (1 << j)) != 0) tested.or(test[j]);
                if (tested.equals(best)) {
                    found = true;
                    min = Math.min(min, Integer.bitCount(i));
                }
                tested.clear(0, n);
            }
            out.println(found ? min : -1);

        }
        out.flush();
        out.close();
    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public Scanner(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(s));
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public int[] nextIntArray(int n) throws IOException {
            int[] ans = new int[n];
            for (int i = 0; i < n; i++)
                ans[i] = nextInt();
            return ans;
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public boolean ready() throws IOException {
            return br.ready();
        }


    }
}