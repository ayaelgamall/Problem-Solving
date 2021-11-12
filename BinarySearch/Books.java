package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Books {
    static int [] s;
    static int t;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        int [] a= new int[n];
        s= new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <n ; i++)
            a[i]= Integer.parseInt(st.nextToken());
        s[0]=a[0];
        for (int i = 1; i <n ; i++) {
            s[i]=s[i-1]+a[i];
        }

        //////Binary Search

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
    ///cumulative sum

    private static boolean okay(int k) {
        int st=0;
        int e=k-1;
        if (s[e]<=t)return true;
        for (int i = 1; i+e <n ; i++) {
            if (s[i+e]-s[st+i-1]<=t)return true;
        }
        return false;
    }
}
