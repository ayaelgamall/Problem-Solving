package OldContests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Arithmetic2 {
    static int n;
    static int[] a;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n= Integer.parseInt(br.readLine());
        a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        HashSet<Pair> s= new HashSet<>();
        int res=2;

        for (int i = 0; i <n-2 ; i++) {
          loop:  for (int j = i+1; j <n ; j++) {
                int r=2;
                int d = a[j]-a[i];
                 int l= a[j];
                 boolean ok = true;
                for (int k = n-1; k >j ; k--) {
                    if((a[k]-a[i])%d==0){
                        if(ok){
                          if(s.contains(new Pair(d,a[k]))) break loop ;
                          ok=false;
                            l=a[k];
                        }
                        r++;

                    }
                }
                if (r>2){
                    s.add(new Pair(d,l));
                }
                if(res<r){
                    res=r;
                }
            }
        }
        System.out.println(res);

    }
    public static class Pair {
        int d;
        int l;

        public Pair(int x, int y) {
            this.d = x;
            this.l = y;
        }
    }
}
