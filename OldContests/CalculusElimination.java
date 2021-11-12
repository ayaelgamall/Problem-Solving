package OldContests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class CalculusElimination {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long u = Long.parseLong(st.nextToken());
//        ArrayList<Pair> ans= new ArrayList<>();
        HashSet<Pair> a = new HashSet<>();
        a.add(new Pair(1,n));
        while(u-->0){
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            HashSet<Pair>t=new HashSet<>();
            for (Pair r:a) {
                if(r.s<=y && x<=r.e){
                    if(x<=r.s){
                        if(y<r.e){
                            t.add(new Pair(y+1,r.e));}}
                    else{
                        t.add(new Pair(r.s,x-1));
                        if(y<r.e)
                            t.add(new Pair(y+1,r.e));
                    }
                }else{
                    t.add(r);
                }
            }
            a=t;
        }
        Pair res=new Pair(0,0);
        for (Pair r:a) {
            res=r;
        }
        System.out.println(res.s);


    }
    static class Pair {
        long s;
        long e;


        public Pair(long start, long end) {
            s = start;
            e = end;
        }
    }
}
