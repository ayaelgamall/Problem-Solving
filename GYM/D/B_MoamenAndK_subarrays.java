package GYM.D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_MoamenAndK_subarrays {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- >0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            st =new StringTokenizer(br.readLine());
            long res=0;
            int prev= Integer.parseInt(st.nextToken());

            for (int i = 1; i <n ; i++) {
                int curr= Integer.parseInt(st.nextToken());
                if(prev>curr) res++;
                prev=curr;
            }
            res++;
            System.out.println(res<=k?"Yes":"No");
        }
    }

}
