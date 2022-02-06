package Leetcode;
import java.util.*;
public class SlidingWindowMax {
        public int[] maxSlidingWindow(int[] nums, int k) {
            LinkedList<Pair> sorted = new LinkedList<>();
            for(int i=0;i<k-1;i++){
                sorted.add(new Pair(i,nums[i]));
            }
            Collections.sort(sorted);
            int[] ans=new int[nums.length-k+1];

            for(int i=k-1;i<nums.length;i++){
                int min= sorted.peekFirst().idx;
                while(!sorted.isEmpty()&&(min<=i-k|| nums[min]<=nums[i])){
                    sorted.pollFirst();
                    if(!sorted.isEmpty())min= sorted.peekFirst().idx;
                }
                sorted.addFirst(new Pair(i,nums[i]));
                int max = sorted.peekLast().idx;
                while(max <=i-k){
                    sorted.pollLast();
                    max = sorted.peekLast().idx;
                }
                ans[i-k+1]=nums[max];
            }
            return ans;

        }

    public static void main(String[] args) {
        SlidingWindowMax s =new SlidingWindowMax();
        System.out.println(Arrays.toString(s.maxSlidingWindow(new int[]{1,3,1,2,0,5},3)));
    }
}
        class Pair implements Comparable{
            int idx;
            int value;

            public Pair(int idx, int value) {
                this.idx = idx;
                this.value = value;
            }


            public int compareTo(Object o) {
                return this.value-((Pair)o).value;
            }
        }
