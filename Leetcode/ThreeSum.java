package Leetcode;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        //1,3,-3,2,-4 ,0,-1
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i =0; i<nums.length-2;i++){
            for(int j = i+1;j<nums.length-1;j++){
                int key =(nums[i]+nums[j])*-1;
                int idx = Arrays.binarySearch(nums,j+1,nums.length,key);

                if(idx>0){
                    ArrayList<Integer> tri =new ArrayList();
                    tri.add(nums[i]);tri.add(nums[j]);tri.add(nums[idx]);
                    if(!res.contains(tri))
                    res.add(tri);
                }
            }

        }
        return res;

    }

    public static void main(String[] args) {
        ThreeSum s=new ThreeSum();
        System.out.println(s.threeSum(new int[]{0,0,0}));
    }
}
