package OldContests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LastRobotics {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T =Integer.parseInt(br.readLine());
        while(T-->0){
            long n= Long.parseLong(br.readLine());
            int res=0;
            int power=0;
            int i=0;
            while (n>0){
                int p= (int) (Math.log(n)/(double) Math.log(2));
                power=p;
                n-=(long)Math.pow(2,(long)p);
                i++;
            }
            res+=power+i-1;
            String s=res%2==0?"Red":"Blue";
            System.out.println(s);

        }
    }
}
