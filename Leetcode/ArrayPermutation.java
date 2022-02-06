package Leetcode;

import java.util.Arrays;

public class ArrayPermutation {

    public boolean isPerm( int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]> arr.length|| arr[i]<1)return false;
            int a=arr[i];

            while(arr[i]!=i+1){
                int a2 = swap(arr, a);
                if(a2>arr.length||a2<1|| a==a2)return false;
                a=a2;
            }

        }
        return true;
    }

    private int swap(int[] arr, int i) {
        int temp = arr[i-1];
        arr[i-1]=i;
        return temp;
    }

    public static void main(String[] args) {
        ArrayPermutation a=new ArrayPermutation();
        int[]arr = new int[]{5,4,0,1,3};
        System.out.println(a.isPerm(arr));
    }
}
