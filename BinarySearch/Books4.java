package BinarySearch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Books4 {
    static int[] a;
    static int t;
    static int n;

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("books.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(st.nextToken());

        //2 pointers
        int start=0;int end=0;
        int sum=a[0];
        int ans = 0;
        while(end<n){
            if(sum<=t){
                ans=Math.max(ans,end-(start-1));
                end++;
               if(end<n) sum+=a[end];
            }else {
                sum-=a[start++];

            }
        }
        System.out.println(ans);


    }


}