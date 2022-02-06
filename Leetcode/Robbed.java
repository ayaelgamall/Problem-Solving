package Leetcode;

import java.util.Arrays;

public class Robbed {
    int [] N;
    int [] memo;
    public int rob(int[] nums) {
        memo=new int[nums.length];
        Arrays.fill(memo,-1);
        N=nums;
        int max1= robbedlast(0);
        Arrays.fill(memo,-1);
        return Math.max(max1,robbedlast(1));

    }

    public int robbedfirst(int i){
        if(i>=N.length-1)return 0;



        if(memo[i]==-1){
            memo[i]= Math.max(robbedfirst(i+2)+N[i],robbedfirst(i+1));

        }
        return memo[i];

    }
    public int robbedlast(int i){
        if(i>=N.length)return 0;



        if(memo[i]==-1){
            memo[i]= Math.max(robbedlast(i+2)+N[i],robbedlast(i+1));

        }
        return memo[i];

    }

    public static void main(String[] args) {
        Robbed r = new Robbed();
        int []n=new int[]{2,3,2};
        System.out.println(r.rob(n));
    }



}
