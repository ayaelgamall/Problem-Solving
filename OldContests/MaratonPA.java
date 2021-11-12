package OldContests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MaratonPA {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long s = Long.parseLong(st.nextToken());
        long res=0;
        PriorityQueue<Pair> p = new PriorityQueue<>();
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            p.add(new Pair(t,e));
        }
        while (!p.isEmpty()){
            Pair curr = p.remove();
            s+= curr.t;
            res+= (s- curr.e);
        }
        System.out.println(res);

    }
    static class Pair implements Comparable{
        int t;
        int e;

        public Pair(int t, int e) {
            this.t = t;
            this.e = e;
        }

        @Override
        public int compareTo(Object o) {
            return this.t-((Pair)o).t;
        }
    }
}
