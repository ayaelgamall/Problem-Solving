package Leetcode;

public class RotadedArray {

        public int search(int[] nums, int target) {
            if(nums.length==0)return -1;
            return binarySearch(nums,0,nums.length-1,target);

        }
        public int binarySearch(int [] nums,int i ,int j,int target){
            if(i==j){
                if(nums[i]==target)return i;
                return -1;
            }
            int mid = (i+j)/2;

            if(nums[i]<nums[mid]){
                if(target>=nums[i] && target<=nums[mid])return binarySearch(nums,i,mid,target);
                return binarySearch(nums,mid+1,j,target);
            }
            else{
                if(target<=nums[mid] || target>=nums[i] )return binarySearch(nums,i,mid,target);
                return binarySearch(nums,mid+1,j,target);
            }

        }

    public static void main(String[] args) {
        RotadedArray r =new RotadedArray();
        int[]arr=new int[] {1,3};
        System.out.println(r.search(arr,3));
    }
}
