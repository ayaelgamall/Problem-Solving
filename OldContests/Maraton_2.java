package OldContests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Maraton_2 {


    public static void main(String[] args) throws IOException {
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        long[] a = new long[n] ;
        long[] sum = new long[n+1] ;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++){
            a[i]=Long.parseLong(st.nextToken());
        }
        long ans=0;
        for (int i=0;i<n;i++){
            ans+=a[i]*sum[i];
            sum[i+1]=a[i]+sum[i];
        }
        System.out.println(ans);
    }

}
