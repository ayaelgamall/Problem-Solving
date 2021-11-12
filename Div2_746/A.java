package Div2_746;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while (t-- >0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int h=Integer.parseInt(st.nextToken());
            int a []= new int [n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i <n ; i++) {
               a[i]=  Integer.parseInt(st.nextToken());
            }
            Arrays.sort(a);
            int res=0;
            double l = a[n-1];
            double s = a[n-2];
            int x1 = (int) Math.ceil ((h-l)/(l+s));
            int x2 = (int) Math.ceil (h/(l+s));
            if(x1==x2){
                res=x2*2;
            }else res=x1*2+1;
            pw.println(res);

        }
        pw.close();

    }
}
