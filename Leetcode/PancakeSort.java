package Leetcode;

import java.util.*;
public class PancakeSort {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res=new LinkedList();
        for(int j=arr.length;j>0;j--){
            for(int i=0;i<j;i++){
                if(arr[i]==j){
                    if(j==i+1)break;
                    if(i!=0){
                        res.add(i+1);
                        flip(arr,i);

                    }
                    res.add(j);
                    flip(arr,j-1);
                    break;
                }
            }
        }
        return res;
    }
    public void flip(int []arr,int k){
        for(int i=0;i<=k/2;i++){
            int temp=arr[k-i];
            arr[k-i]=arr[i];
            arr[i]=temp;
        }
    }

    public static void main(String[] args) {
        PancakeSort p=new PancakeSort();
        int[]arr=new int[]{3,2,4,1};
        System.out.println(p.pancakeSort(arr));
    }
}
