package Analysis;

import java.util.Arrays;

public class Knaps {
   static int[]weight;
   static int[]value;
   static int [][]memo;
   static int [][]trace;

    public int knapSack(int[]w,int[]v,int W){
        weight=w;
        value=v;
        memo=new int[w.length][W+1];
        trace=new int[w.length][W+1];
        return dp(0,W);
    }
    public int dp(int i,int w){
        if(i==weight.length)return 0;
        if(memo[i][w]==0){
            if(weight[i]<=w){
                int take = dp(i+1,w-weight[i])+value[i];
                int leave=dp(i+1,w);
                if(take>leave){
                    memo[i][w]=take;
                   // trace[i][w]=1;
                }
                else memo[i][w]=leave;
            }
            else memo[i][w]=dp(i+1,w);

        }
        return memo[i][w];

    }
    public static void main(String[] args) {
//        int[]w ={2,2,2,3,1,5};
//        int[]v={1,2,4,1,2,3};
        int[]w ={12,2,9,7,5};
        int[]v={7,1,10,3,2};


//        int[]w ={8,16,4,12,2};
//        int[]v={12,32,40,30,50};

        Knaps k=new Knaps();
        System.out.println(k.knapSack(w,v,15));
//        System.out.println(Arrays.toString(memo));
//        System.out.println(Arrays.toString(trace));
        print(w.length-1,15,trace);


    }

    private static void print(int n,int w,int[][] trace) {
        for (int i =  n-1; i>=0;i--) {
            if(trace[i][w]==1) {System.out.print(i +" ,");
            w-=weight[i];
            }
        }
    }
}
