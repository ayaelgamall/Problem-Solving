package GoogleHash;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class level5 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("level5_2.in"));
        PrintWriter pw=new PrintWriter("Level5_2.out");
        int maxp= Integer.parseInt(br.readLine());

        long maxelecbill= Long.parseLong(br.readLine());
        int maxtask= Integer.parseInt(br.readLine());
        int n= Integer.parseInt(br.readLine());
        PriorityQueue<Pair>arr = new PriorityQueue<>();
        int mp[]=new int [n];//maxpower
        int mt[]= new int[n];
        Arrays.fill(mt,maxtask);
        Arrays.fill(mp,maxp);
        for(int i=0;i<n;i++) {
            arr.add(new Pair( Integer.parseInt(br.readLine()),i));
        }
        int m= Integer.parseInt(br.readLine());
        Tuple[] t=new Tuple[m];



        pw.println(m);
        ArrayList<Integer> ans []=new ArrayList[m+1];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            t[i]=new Tuple(id,p,s,end);
            ans[i]= new ArrayList<>();
        }
        ans[m]=new ArrayList<>();
        Arrays.sort(t);
        while (!arr.isEmpty()){
            int idx=arr.poll().idx;
            PriorityQueue<Tuple>min = new PriorityQueue<>();
            for (int i = 0; i <t.length ; i++) {
                Tuple a = t[i];
                if(a.end>=idx && a.s<=idx&& a.p>0){
                    min.add(a);
                }
            }
            int tmp=maxp;
            int tmt= maxtask;
            while (tmt>0&&tmp>0&& !min.isEmpty()){
                Tuple b = min.poll();
                int p=b.p;
                int id = b.id;
                int mn=Math.min(tmp,p);
                ans[id].add(idx); ans[id].add(mn);
                tmp-=mn;p-=mn;tmt--;
            }
        }

        for (int i = 1; i < ans.length; i++) {
            pw.print(i); pw.print(" ");
            for(int no:ans[i]){
                pw.print(no);pw.print(" ");
            }pw.println();
        }
        pw.println();
        pw.flush();
        }






    static class Tuple implements Comparable<Tuple>{
        int id;
        int p;
        int s;
        int end;

        public Tuple (int i,int pp, int ss,int ee) {
            id=i;
            p=pp;
            s=ss;
            end=ee;
        }
        public int compareTo(Tuple o) {
            return o.p-p;
        }

    }
    static class Pair implements Comparable <Pair>{
        int pr;
        int idx;

        public Pair(int p,int i){
            pr=p;
            idx=i;
        }

        public int compareTo(Pair o) {

            return pr-o.pr;
        }
    }
    static class Pair2 {
        int tasks;
        int power;

        public Pair2(int p,int i){
            power=p;
            tasks=i;
        }
    }
}