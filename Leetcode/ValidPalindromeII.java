package Leetcode;

import java.util.LinkedList;

public class ValidPalindromeII {

        //"aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"
        public boolean validPalindrome(String s) {
            boolean del=false;
            boolean secondTime=false;
            int iEquals=-1;
            int i=0;int j = s.length()-1;
            while(i<j){
                if(s.charAt(i)!=s.charAt(j)){
                    if(iEquals!=-1 && !secondTime ){
                        secondTime=true;
                        i=iEquals;j= s.length()-iEquals;
                    }
                    else{
                        if(del)return false;
                        del=true;
                        if(s.charAt(i)==s.charAt(j-1) &&s.charAt(i+1)==s.charAt(j)){
                            iEquals=i; i--;
                        }else if(s.charAt(i)==s.charAt(j-1))i--;
                        else j++;}
                }
                j--;i++;

            }
            return true;
        }

    public static void main(String[] args) {
        ValidPalindromeII v=new ValidPalindromeII();
        System.out.println(v.validPalindrome("lcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupucul"));
    }

}
