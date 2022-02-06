package TeamContest1_2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.*;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class I_Retakes {
    private static PrintWriter pw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans [] =new int[n];
        TreeSet<Tri> q = new TreeSet<>();
        TreeSet<Integer>ts = new TreeSet<>();
         pw = new PrintWriter(System.out);
        int min = 1200000; int max = 1;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            Tri x = new Tri(t,c,i);
            q.add(x);
            if(t<min)min=t;
            if(t>max)max=t;
        }
        max+=n;
        for (int i = min; i <= max; i++) {
            ts.add(i);
        }


        for (int i = 0; i <n ; i++) {
           Tri x = q.pollFirst();
           int t = ts.ceiling(x.t);
           ans[x.idx]= t;
           ts.remove(t);
        }


        printArr(ans);
        pw.close();
        pw.flush();
    }
    public static void printArr(int[] a ){
        for (int i = 0; i <a.length ; i++) {
            pw.print(a[i]+" ");
        }

    }
    public static class Tri implements Comparable{
        int t;
        int c;
        int idx;

        public Tri(int t, int c, int idx) {
            this.t = t;
            this.c = c;
            this.idx = idx;
        }

        @Override
        public int compareTo(Object o) {
            int res =(((Tri)o).c-((Tri)o).t)- (this.c-this.t);
            if(res==0)res= this.idx-((Tri) o).idx;
            return res;
        }

        @Override
        public String toString() {
            return "Tri{" +
                    "t=" + t +
                    ", c=" + c +
                    ", idx=" + idx +
                    '}';
        }
    }
}
