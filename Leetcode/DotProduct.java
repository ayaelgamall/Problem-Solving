package Leetcode;

import java.util.*;

public class DotProduct {
    public int dotProduct(List<int[]> v1, List<int[]> v2) {
        int res=0;
        int i=0,j=0;
        while(i<v1.size()&&j<v2.size()){
            int[] v1Value=v1.get(i);
            int[] v2Value=v2.get(j);
            if(v1Value[1]==v2Value[1]){
                res+=v1Value[0]*v2Value[0]*v1Value[1];i++;j++;
            }
            else if(v1Value[1]>v2Value[1]){
                res+=v1Value[0]*v2Value[0]*v2Value[1];j++;
                v1Value[1]-=v2Value[1];
            }else {
                res+=v1Value[0]*v2Value[0]*v1Value[1];i++;
                v2Value[1]-=v1Value[1];
            }
        }
        return res;
    }
    public List<int[]>compress(int[] arr){
        ArrayList<int[]> compressed = new ArrayList<>();//[[value,repetition],..]
        int value= arr[0];int counter=1;
        for (int i = 1; i <arr.length ; i++) {
            if(arr[i]==value)counter++;
            else{
                compressed.add(new int[]{value,counter});
                value=arr[i];counter=1;
            }
        } compressed.add(new int[]{value,counter});
        return compressed;
    }

    public static void main(String[] args) {
        DotProduct d= new DotProduct();
        int []a= {1, 1, 4, 4, 4, 4, 7, 7, 7, 7, 7, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
        int []b = {2, 2, 5, 5, 5, 5, 5, 5, 5, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        
        System.out.println(d.dotProduct(d.compress(a),d.compress(b)));
    }
}
