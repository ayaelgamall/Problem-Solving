package Leetcode;

import java.util.*;

public class KClosest {
    /*
    * */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> kclosest = new PriorityQueue<>((a, b)->{
            int d1= a>x?a-x:x-a;
            int d2= b>x?b-x:x-b;
            return d2-d1;});
        kclosest.add(2);
        kclosest.add(5);
        kclosest.add(6);
        while(!kclosest.isEmpty())
        System.out.println(kclosest.poll());
        return null;
    }

    public static void main(String[] args) {
        KClosest k = new KClosest();
        k.findClosestElements(new int[]{1},2,5);
    }
}
