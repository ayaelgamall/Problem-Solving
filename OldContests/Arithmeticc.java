package OldContests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Arithmeticc {
    static int n;
    static int[] a;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        System.out.println(bf(0,0,0));
    }
    private static int bf(int idx, int r,int nb) {
        if (idx==n)
            return r;
        int b = a[idx];
        idx++;
        if (r==0)
            return Math.max(bf(idx, r+1, b), bf(idx, r, nb));
        else
            return Math.max(cont(idx,b, b-nb), bf(idx, r, nb));



    }

    private static int cont(int idx, int nb, int d) {
        int res=2;
        for (int i = idx; i < n; i++) {
            int  b=a[i];
            if(b-nb==d){
                res++;
                nb=b;
            }
        }
        return res;

    }

}