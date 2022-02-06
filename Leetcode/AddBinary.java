package Leetcode;

import java.util.HashSet;

public class AddBinary {
    public String addBinary(String a, String b) {
//        long a1=Long.parseLong(a,2);
//        long b1 =Long.parseLong(b,2);
//
//        long res = a1 +b1;
//
//        return Long.toBinaryString(res);

        char[] res =new char[Math.max(a.length(),b.length())];
        int i =a.length()-1;int j = b.length()-1;
        int idx = res.length-1;


        char one ='1'; char zero='0';
        boolean carry =false;

        while(i>=0 ||j>=0){
            char c1 =(i>=0)?a.charAt(i):zero;
            char c2 =(j>=0)?b.charAt(j):zero;

            char value=zero;

            if(c1==zero && c2==one && !carry || c1==one && c2==one && carry || c2==zero && c1==one && !carry)value=one;
            else if(c1==one && c2==one && !carry)carry=true;
            else if(c1==zero && c2==zero &&carry){value=one;carry =false;}

            res[idx]=value;

            idx--;j--;i--;
        }
        HashSet<Integer> []v =new HashSet[26];
        return String.valueOf(res);


    }

    public static void main(String[] args) {
        AddBinary a = new AddBinary();
        System.out.println(a.addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101"
               , "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
    }
}
