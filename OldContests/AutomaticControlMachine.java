package OldContests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AutomaticControlMachine {
    static int n;
    static int k;
    static int r;
    static int m;
    static int[][] a;
    static int [][]dp;
    public static void main(String args[]) throws IOException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m=Integer.parseInt(st.nextToken());
            dp=new int [m][1<<m];
            for(int[] x :dp)
                Arrays.fill(x, -1);
            k= (int) Math.ceil(n/30.0);
            a= new int[m][k];
            r= n-((k-1)*30);
            for (int i = 0; i <m ; i++) {

                String temp= br.readLine();
                int rem=30;
                for (int j = 0; j < k; j++) {
                    if(j==k-1)rem=r;
                    for (int l = 0; l <rem ; l++) {
                      if((temp.charAt(j*30+l)) =='1')a[i][j] |= (1<<l);
                    }
                }
            }
            int res= bf(0,0);
            if(res==m+1)res=-1;
            System.out.println(res);
        }
    }
    static int bf(int mask,int idx){
        if(idx==m){
            return check(mask);
        }
        if(dp[idx][mask]!=-1)return dp[idx][mask];
        int take = mask | (1<<idx);
        return dp[idx][mask]=Math.min(bf(take,idx+1),bf(mask,idx+1));
    }
    public static int check(int msk)

    {
        int c=0;
        int[] res =new int [k];
        for(int i=0;i<m;i++)
        {
            if((msk&(1<<i))!=0)
            {
                c++;
                for(int j=0;j<k;j++)
                    res[j] |= a[i][j];
            }
        }
        for(int i=0;i<k;i++)
        {
            if(i==k-1) {
                if(res[i]!=(1<<r)-1) return m+1;
            }
            else
            if(res[i]!=(1<<30)-1)
                return m+1;
        }

         if(c==-0)return -1;
            return  c;
    }
}