package OldContests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.StringTokenizer;

public class Maraton2 {
    public static void main(String args[]) throws IOException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long res=0;
        long [] h = new long[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i <n; i++) {
            long  x = Long.parseLong(st.nextToken());
            for (int j = 0; j <i ; j++) {
                res+=h[j]*x;
            }
           
            h[i]=x;

        }
        System.out.println(res);


    }
}
