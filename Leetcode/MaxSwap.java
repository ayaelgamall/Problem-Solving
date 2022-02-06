package Leetcode;

public class MaxSwap {
    public int maximumSwap(int num) {

        char[]arr = Integer.toString(num).toCharArray();
        int lowIndex = -1, highIndex = -1;
        int  maxTillNow = arr.length - 1;


        for(int i = arr.length - 2 ; i>=0;--i){

            if(arr[i] < arr[maxTillNow]){
                lowIndex = i;
                highIndex = maxTillNow;
            }

            else if(arr[i] > arr[maxTillNow]){
                maxTillNow = i;
            }
        }

        //No swap needed
        if(lowIndex  == -1 || highIndex == -1) return num;

        //Swap the digits
        char temp = arr[lowIndex];
        arr[lowIndex] = arr[highIndex];
        arr[highIndex] = temp;

        return Integer.parseInt(String.valueOf(arr));
    }

    public static void main(String[] args) {
        MaxSwap m=new MaxSwap();
        System.out.println(m.maximumSwap(98239));
    }
}
