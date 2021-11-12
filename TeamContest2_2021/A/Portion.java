package TeamContest2_2021.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Portion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        if(n==1) System.out.println(0);
        else
            if(k>=n) System.out.println(-1);
            else{
                if(k==1) System.out.println(n-1);
                else
                    if(n%k==0||n%k==1)
                         System.out.println(((n)/k));
                    else
                        System.out.println((n/k)+1);

            }
    }
}
