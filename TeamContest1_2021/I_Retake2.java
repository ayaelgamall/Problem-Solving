package TeamContest1_2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class I_Retake2 {
    private static PrintWriter pw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans [] =new int[n];
        pw = new PrintWriter(System.out);
        // replace  "PriorityQueue<Tri> q = new PriorityQueue<>();"  with:
        ArrayList<Tri>[] q = new ArrayList[1000001];
        for (int i=0;i<q.length;i++)
            q[i] = new ArrayList<>();
        //

        // I changed the type here to be "Tri"
        PriorityQueue<Tri>ts = new PriorityQueue<>();

//        int min = 1200000; int max = 1;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            Tri x = new Tri(t,c,i);
            // replace "q.add(x);" with:
            q[t].add(x);
            //
//            if(t<min)min=t;
//            if(t>max)max=t;
        }


        // this for loop is what I mean
        int j =1;
        for (;j<q.length;j++){
            for (Tri tri:q[j])
                ts.add(tri);
            if (!ts.isEmpty())
                ans[ts.remove().idx] = j;
        }

        while (!ts.isEmpty()){
            ans[ts.remove().idx] = j;
            j++;
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