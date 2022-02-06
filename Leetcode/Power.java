package Leetcode;

import java.util.*;
public class Power {
    public static double myPow(double x, int n) {
        if(n==0)return 1;
        if(n<0)return
                1.0/pow(x,(long)-1*n);
        return pow(x,n);
    }
    public static double pow(double x, long n){
        if(n<0)n=-n;
        double res =1;
        while(n>0){
            if(n%2!=0)
                res*=x;
            x*=x;
            n>>=1;
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(myPow(2,-2147483648));

    }
}
