package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Books3 {
    static int [] s;
    static int [] a;
    static int t;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        a= new int[n];
        s= new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <n ; i++)
            a[i]= Integer.parseInt(st.nextToken());
        s[0]=a[0];
        for (int i = 1; i <n ; i++) {
            s[i]=s[i-1]+a[i];
        }
        int ans=0;
        for (int i = 0; i < n; i++) {
           ans= Math.max(no(i),ans);
        }
        System.out.println(ans);




    }


    ///binary search
    private static int no(int i) {
        int low =0;
        int high = Math.min(t,n-i);
        int ans =0;
        ///1111100000
        while (low<high){
            int mid = (low+high+1)/2;
            if(okay(i,i+mid-1)){
                ans=Math.max(ans,mid);
                low=ans;
            }else
                high=mid-1;
        }
        return ans;
    }


    private static boolean okay(int i,int e) {
        int st=i==0?0:s[i-1];
        int sum =s[e]-st;
            if (sum<=t)return true;

        return false;
    }
}
