package Div2_746;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
       loop: while (t-- >0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int x=Integer.parseInt(st.nextToken());
            int a []= new int [n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i <n ; i++) {
                a[i]=  Integer.parseInt(st.nextToken());
            }
            int b [] = Arrays.copyOf(a,n);
            Arrays.sort(b);
            int acc= n-((int) Math.ceil(n/2.0));
            int i =n/2;
            if(n%2!=0&&x>acc){
                if(b[i]!=a[i]){pw.println("NO");continue ;}
                i++;acc++;
            }
            while (x>acc){
                if(b[i]!=a[i]){pw.println("NO");continue loop;}
                if(b[n-i-1]!=a[n-i-1]){pw.println("NO");continue loop;}
                i++;acc++;
            }
            pw.println("YES");
        }
        pw.close();

    }
}
