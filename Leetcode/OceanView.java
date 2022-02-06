package Leetcode;
import java.util.*;
public class OceanView {
    public int[] findBuildings(int[] heights) {
        LinkedList<Integer> list=new LinkedList<>();
        int min =0;
        for(int i=heights.length-1;i>=0;i--){
            if(heights[i]>min){
                min=heights[i];
                list.addFirst(i);
            }
        }
//        int [] res= new int[list.size()];
//        int i=0;
//        for(int a : list){
//            res[i++]=a;
//        }
        return list.stream().mapToInt(i ->i).toArray();
    }

    public static void main(String[] args) {
        OceanView o = new OceanView();
        int []a = new int[]{2,2,2,2};
        System.out.println(Arrays.toString(o.findBuildings(a)));
    }
}
