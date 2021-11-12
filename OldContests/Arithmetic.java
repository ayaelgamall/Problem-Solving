package OldContests;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Arithmetic {
    static int n;
    static int[] a;
    static HashSet<Pair> s= new HashSet<>();
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        int rs=bf(0,0,0);
        System.out.println(rs);
    }
    private static int bf(int idx, int r,int f) {
        if (idx==n)
            return r;
        int b = a[idx];
        idx++;
        if (r==0)
            return Math.max(bf(idx, 1, b), bf(idx, 0, f));
        else
            return Math.max(cont(idx,f,b), bf(idx, 1, f));



    }

    private static int cont(int idx, int f, int l) {
       int res=2;
        int d= l-f;
        for (Pair j : s)
            if (j.x==d&&(j.y-f)%d==0) return res;

        HashSet k = new HashSet();
        k.add(f);k.add(l);
        for (int i = idx; i < n; i++) {
           int  b=a[i];
            if(b-l==d){
                k.add(b);
                res++;
                l=b;
            }
        }
        if(res>2)s.add(new Pair(d,l));
        return res;

    }
    public static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
