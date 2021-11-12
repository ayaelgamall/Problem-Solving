package OldContests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bombs {
    static  int res;
    public static void main(String args[]) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n==1|| n==2||n==3){
            System.out.println(1);
        }
        else{
        res = n/2;
        int m = n%2==0?res-2:res-1;
        q(m);}
    }

    private static void q(int m) {
        if (m <=0) System.out.println(res);
        else if (m==1) System.out.println(res+1);
         else if(m%2==0){
            res+=m/2;
            q(m/2);
        }
        else{
            int t = (int)Math.ceil(m/2.0);
            res+=t;
            q(t-1);
        }
    }
}
