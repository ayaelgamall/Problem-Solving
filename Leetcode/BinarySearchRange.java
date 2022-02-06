package Leetcode;

import java.sql.Array;
import java.util.Arrays;

public class BinarySearchRange {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0)return new int []{-1,-1};
        if(nums.length==1 && nums[0]==target)return new int []{0,0};
        int i= BinarySearchFirst(nums,0,nums.length-1,target);
        int j= BinarySearchLast(nums,0,nums.length-1,target);

        return new int []{i,j};

    } //0111111
    // 1,9,9,9,9,9,
    public int BinarySearchFirst(int []nums,int i,int j, int target){
        if(i==j)return (nums[i]==target)? i:-1;

        int mid=(i+j)/2;

        if(nums[mid]>=target) return BinarySearchFirst(nums,i,mid,target);
        return BinarySearchFirst(nums,mid+1,j,target);

    }
    public int BinarySearchLast(int []nums,int i,int j, int target){
        if(i==j)return (nums[i]==target)? i:-1;

        int mid=(i+j+1)/2;

        if(nums[mid]<=target) return BinarySearchLast(nums,mid,j,target);
        return BinarySearchLast(nums,i,mid-1,target);

    }

    public static void main(String[] args) {
        BinarySearchRange b = new BinarySearchRange();
        System.out.println(Arrays.toString(b.searchRange(new int[]{5,7,7,8,8,10},8)));
    }
}
