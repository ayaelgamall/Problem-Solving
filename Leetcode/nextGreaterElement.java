package Leetcode;

public class nextGreaterElement {
    public int nextElement(int n) {
        //2 1 3 --231 ,, 1524--1542 ,,, 17547652 -- 17552467 ,,
        int[] nums= new int[ (""+n).length()];
        String[] a =(""+n).split("");

        for(int i =nums.length-1; i>=0;i--){
            nums[i]=n%10;
            n/=10;
        }
        int idx=-1;
        for(int i=nums.length-2 ; i>=0;i--){
            if(nums[i]<nums[i+1]){idx=i;break;}
        }

        if(idx==-1)return -1; //no greater

        int idxToBeSwaped=nums.length-1;
        for(int i =idx+1;i<nums.length;i++){
            if(nums[idx]>=nums[i]){idxToBeSwaped=i-1;break;}
        }

        swap(nums,idx, idxToBeSwaped);

        for(int i=idx+1,j=nums.length-1 ;i<j;i++,j-- ){
            swap(nums,i,j);
        }

        String res="";

        for(int i=0;i<nums.length;i++){
            res+=nums[i];
        }
        try{
            return Integer.parseInt(res);
        }
        catch(Exception e){
            return -1;
        }
    }
    public void swap(int[]arr,int i,int j){
        int temp= arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {
        nextGreaterElement n =new nextGreaterElement();
        System.out.println(n.nextElement(2147483647));
    }
}
