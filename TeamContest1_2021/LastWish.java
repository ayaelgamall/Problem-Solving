package TeamContest1_2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LastWish {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s= br.readLine();
        if (s.length()>26) System.out.println("IMPOSSIBLE");
        else {
            LinkedList<Character> alpha= new LinkedList<>();
            int a = 'a';
            for (int i = 0; i < 26; i++) {
                alpha.add((char) (a+i));
            }
            boolean[] keep = new boolean[s.length()];
            HashSet<Character> exists = new HashSet<>();
            for (int i = 0; i < keep.length ; i++) {
                char c = s.charAt(i);
                if(!exists.contains(c)){
                    keep[i]=true;
                    exists.add(c);
                    alpha.remove((Character) c);
                }
            }

            StringBuilder res= new StringBuilder();
            for (int i = 0; i < keep.length ; i++) {
                if (keep[i]) res.append(s.charAt(i));
                else {
                    res.append(alpha.remove());
                }
            }
            System.out.println(res);
        }
    }
}
