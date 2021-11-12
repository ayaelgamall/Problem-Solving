package Codeforces710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_Replacemect {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- >0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            StringBuilder s = new StringBuilder(br.readLine());
            int res =0;
            int curr = -1;
            int added= -1;
            for (int i = 0; i <n ; i++) {
                if(s.charAt(i)=='*'){
                    if(curr==-1){ added=i;res++;}
                    else {
                       if (i-added==k){added=i;res++; }
                    }
                    curr=i;
                }else {
                    if(i-added==k && curr!= added){
                        added=curr;res++;
                    }
                }
            }if(curr!= added )res++;
            System.out.println(res);
        }
    }
}
