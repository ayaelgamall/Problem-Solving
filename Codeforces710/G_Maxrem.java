package Codeforces710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

public class G_Maxrem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            ArrayList<Integer> alpha[]= new ArrayList[26];
            for (int i = 0; i < alpha.length ; i++) {
                alpha[i]=new ArrayList<>();
            }
            int[] ans = new int[26];
            Arrays.fill(ans,-1);
            StringBuilder s = new StringBuilder(br.readLine());
            for (int i = 0; i <s.length() ; i++) {
                alpha[s.charAt(i)-97].add(i);
            }
        }
    }
}
