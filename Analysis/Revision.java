package Analysis;

public class Revision {
    public  boolean  subsetSum(int [] arr,int sum){
        int[][] memo=new int[arr.length][sum+1];
        return helperSum(arr,memo,0,0,sum);

    }

    private boolean helperSum(int[] arr,int[][]memo, int i, int sum,int target) {
        if(sum==target)return true;
        if(sum>target)return false;
        if(i== arr.length)return false;
        if(memo[i][sum]==0) {
            boolean take = helperSum(arr, memo, i + 1, sum + arr[i], target);
            boolean leave = helperSum(arr, memo, i + 1, sum, target);
            memo[i][sum]= take|leave?1:2;
        }


        return memo[i][sum]==1?true:false;
    }

    public int unboundedKnapsack(int w, int[]v,int []wt){
        int[] memo= new int[w+1];

        return helperKnaps(w,v,wt,memo);

    }

    private int helperKnaps(int w, int[] v, int[] wt,  int[] memo) {

        if(w==0)return 0;
        if(memo[w]==0){

            for (int i = 0;i< v.length; i++) {
                if( w-wt[i]>=0)
                    memo[w]=Math.max(memo[w],v[i]+ helperKnaps(w-wt[i],v,wt, memo));
            }
        }
     return memo[w];
    }



    public static void main(String[] args) {
        Revision r = new Revision();
        int [] arr= new int[]{3,2,5, 34, 4, 12, 10,6,4};
       // System.out.println(r.subsetSum(arr,9));
        System.out.println(r.unboundedKnapsack(3,new int[]{5,2},new int[]{3,1}));
    }
}
