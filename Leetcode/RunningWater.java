package Leetcode;

public class RunningWater {

    public int trap(int [] height){
        if(height.length==0)return 0;
        int result=0;
        int[] max=new int[height.length];
        max[height.length-1]= height[height.length-1];
        for(int i = height.length-2; i>=0; i--){
            max[i]=Math.max(height[i],max[i+1]);
        }

        int start= height[0];
        for(int i = 0; i< height.length; i++){
            start=Math.max(start, height[i]);
            result+=Math.min(start,max[i])- height[i];
        }
    return result;
    }
}
