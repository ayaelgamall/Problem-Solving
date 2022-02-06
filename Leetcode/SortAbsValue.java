package Leetcode;
import java.io.*;
import java.util.*;

public class SortAbsValue {





        static int[] absSort(int[] arr) {
            // your code goes here
//    AbsValue []temp=new AbsValue[arr.length];
//    for(int i=0;i<arr.length;i++){
//      temp[i]= new AbsValue(arr[i]);
//    }


   // Arrays.sort(arr, Comparator.comparingInt(Math::abs));
//                        Integer[]temp=new Integer[arr.length];
//            for(int i=0;i<arr.length;i++){
//                temp[i]= (arr[i]);
//            }
//            Arrays.sort(temp,(x,y) ->{
//
//      if(Math.abs((Integer) x)!=Math.abs((Integer) y))
//        return Math.abs((Integer) x)-Math.abs((Integer) y);
//      return ((Integer) x).compareTo((Integer)y);
//    });
//            //Arrays.sort(temp);
//            int []result= new int[arr.length];
//            for(int i=0;i<arr.length;i++){
//                result[i]= temp[i];
//            }
//            return result;

            Integer[] temp = Arrays.stream(arr).boxed().toArray(Integer[]::new);
//            Arrays.sort(temp,(x,y) ->{
//
//                if(Math.abs((Integer) x)!=Math.abs((Integer) y))
//                    return Math.abs((Integer) x)-Math.abs((Integer) y);
//                return ((Integer) x).compareTo((Integer)y);
//            });
            Arrays.sort(temp, Comparator.comparingInt(Math::abs));
           //Collections.sort(temp,Comparator.comparingInt(Math::abs));

            return  Arrays.stream(temp).mapToInt(Integer::intValue).toArray();
        }


        public static void main(String[] args) {

        }
 static class AbsValue implements Comparable{
    int val;
    public AbsValue(int v){
      val=v;
    }
    public int compareTo(Object o){
      AbsValue a= (AbsValue)o;
      int myval =Math.abs(this.val);
      int other = Math.abs(a.val);
      if(myval!=other)return myval-other;
      return this.val-a.val;
    }

  }


}
