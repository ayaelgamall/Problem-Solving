package Analysis;

import java.util.*;

public class SquidGames {
    public static String naive (int k, int[] l){


       long max= bf(k,l,0,0);
        return getString(k, l, max);
    }

    private static String getString(int k, int[] l, long max) {
        StringBuilder sb =new StringBuilder();
        sb.append(max);
        long sum= max +1;
        int count=0;
        for (int i = 0; i < l.length; i++) {
            sum+= l[i];
            if(sum> max || count+ l.length-i== k){ //||count+l.length-i+1>k
                sum= l[i];
                sb.append(';');count++;
            }else
                    sb.append(',');
            sb.append(l[i]);

        }

        return sb.toString();
    }

    public static long bf(int k, int[] a, int i,long sum){
        if(i==a.length){
            if(k>1)return Long.MIN_VALUE;
            return 0;
        }
        if(k==1)return a[i]+ bf(k,a,i+1,sum);
        long stop =Math.max(a[i]+sum,bf(k-1,a,i+1,0));
        long con=bf(k,a,i+1,sum+a[i]);

        if(stop>0 && con>0)return Math.min(stop,con);
        return Math.max(stop,con);
    }


    public static String efficient (int k, int[] l){
        HashMap<Long,Long>[][] memo=new HashMap[l.length][k+1];
        long max = dp(k,memo,l,0,0);
        return getString(k,l,max);
    }


    private static long dp(int k, HashMap<Long,Long>[][] memo, int[] a, int i, long sum) {
        if(i==a.length){
            if(k>1)return Integer.MIN_VALUE;
            return 0;
        }
        if(memo[i][k]==null || !memo[i][k].containsKey(sum)){
            if(memo[i][k]==null)memo[i][k]=new HashMap<>();
            if(k==1)memo[i][k].put(sum,a[i]+ dp(k,memo,a,i+1,sum));
            else {
                long stop = Math.max(a[i] + sum, dp(k - 1, memo, a, i + 1, 0));
                long con = dp(k, memo, a, i + 1, sum + a[i]);

                if (stop > 0 && con > 0)memo[i][k].put(sum,  Math.min(stop, con));
                else memo[i][k].put(sum,Math.max(stop, con));
            }
        }
        return memo[i][k].get(sum);
    }

    public static void main(String[] args) {
        int k2 = 3 ;
        int [] l2 = {50,30,10,20,35,25,30,15,20,30,48,77,15,20,20};
        System.out.println(naive(k2,l2));
    }
}
