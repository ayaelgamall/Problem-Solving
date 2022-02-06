package Leetcode;

import java.util.*;

public class MinimumWindowSubstring {
        //HashMap<Character,Integer> charToIdx =CreateMap();

        public String minWindow(String s, String t) {
            int i=0;int j=-1;int min = s.length()+1; int count =0;
            int begin=0;int end=-1;
            HashMap<Character,Integer> target=new HashMap();
            HashMap<Character,Integer> curr=new HashMap();

            for(int k =0;k<t.length();k++){
                int rep=1;
                if(target.containsKey(t.charAt(k)))rep+=target.get(t.charAt(k));
                target.put(t.charAt(k),rep);
            }
            int countMax=t.length();





           // TreeSet<Integer>[]  alpha=new TreeSet[('Z'-'A'+1)*2];

            //fill(s,alpha);

            while(j<s.length()){
                if(count!=countMax){
                    j++;
                    if(j!=s.length())
                        if(target.containsKey(s.charAt(j))){
                            int rep=curr.containsKey(s.charAt(j))? curr.get(s.charAt(j)) :0 ;
                            if(rep<target.get(s.charAt(j))){
                                count++;
                            }
                            curr.put(s.charAt(j),rep+1);
                        }
                }else{
                    if(j-i+1<min){
                        begin=i;end=j;min=j-i+1;
                    }

                    if(target.containsKey(s.charAt(i))){
                        int rep=curr.containsKey(s.charAt(i))? curr.get(s.charAt(i)) :0 ;rep--;
                        if(rep<target.get(s.charAt(i))){
                            count--;
                        }
                        curr.put(s.charAt(i),rep);
                    }
                    i++;
                }
            }
            return s.substring(begin,end+1);

        }
        public HashMap<Character,Integer> CreateMap(){
            HashMap<Character,Integer> res = new HashMap<Character,Integer>();
            for(int i =0 ; i<='z'-'a';i++){
                res.put((char)(i+'a'),i);
            }
            int dif =1+'z'-'a';
            for(int i = dif; i<='Z'-'A'+dif;i++){
                res.put((char)(i-dif+'A'),i);
            }
            return res;
        }

        public void fill(String s,TreeSet<Integer>[]alpha){
            for(int i =0;i<alpha.length;i++){
                alpha[i]=new TreeSet<Integer>();
            }
            for(int i=0;i<s.length();i++){
               // alpha[charToIdx.get(s.charAt(i))].add(i);
            }
        }



    public static void main(String[] args) {
        MinimumWindowSubstring m =new MinimumWindowSubstring();
        System.out.println(m.minWindow("ADOBECODEBANC","ABC"));
    }

}
