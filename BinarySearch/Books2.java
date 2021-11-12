package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Books2 {
    static int [] a;
    static int t;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        a= new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <n ; i++)
            a[i]= Integer.parseInt(st.nextToken());

        int low =0;
        int high = Math.min(t,n);
        int ans=0;
        ///1111100000
        while (low<high){
            int mid = (low+high+1)/2;
            if(okay(mid)){
                ans=Math.max(ans,mid);
                low=ans;
            }else
                high=mid-1;
        }
        System.out.println(ans);


    }
    ///sliding window

    private static boolean okay(int k) {
        int sum=0;
        for (int i = 0; i < k; i++) {
            sum+=a[i];
        }
        if (sum<=t)return true;
        for (int i = k; i <n ; i++) {
            sum+=a[i];sum-=a[i-k];
            if (sum<=t)return true;
        }
        return false;
    }
}
