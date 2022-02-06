package Leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
//    static void gen(int[] cur, int[] a, int msk, int idx) {//cur current permutation , //a the input, idx the current idx,//msk Taken positions in cur
//        if (idx == a.length) {
//           // print(Clone(cur));
//            return;
//        }
//
//        for (int i = 0; i < a.length; i++) {
//            if ((msk & (1 << i)) == 0) {//0 not taken else taken
//                cur[i] = a[idx];
//                gen(cur, a, msk | 1 << i, idx + 1);
//            }
//        }
//    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new LinkedList<>();
        generate(result,nums,new int[nums.length],0,0);
        return result;
    }
    public void generate(List<List<Integer>> result, int[]arr, int[]curr, int msk, int idx){
        if(idx==arr.length){
            result.add((List)Arrays.asList(curr));
            return;
        }
        for(int i=0;i<arr.length;i++){
            if((msk & 1<<i) ==0){
                curr[i]=arr[idx];
                generate(result,arr,curr,msk | 1 << i,idx+1);
            }
        }
    }

    public static void main(String[] args) {
        Permutations p= new Permutations();
        System.out.println(p.permute(new int[]{1,2,3}));
    }
}
