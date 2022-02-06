package Leetcode;

import java.util.HashSet;

public class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        int i=0;int j=0;int max=1;

        HashSet<Character> hashSet = new HashSet<>();

        while(j<s.length()-1){
            j++;
            while(hashSet.contains(s.charAt(j))){
                hashSet.remove(s.charAt(i));
                i++;
            }
            hashSet.add(s.charAt(j));
            if(j-i+1>max)max= j-i+1;
        }
        return max;

    }

    public static void main(String[] args) {
        LongestSubString l =new LongestSubString();
        System.out.println(l.lengthOfLongestSubstring("abcabcbb"));
    }
}
