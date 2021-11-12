package Codeforces710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class D_Epic2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            HashMap<Integer, Integer> tm = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int max =0;
            for (int i = 0; i < n; i++) {
                int k = Integer.parseInt(st.nextToken());
                int occur = 1;
                if (tm.containsKey(k)) {
                    occur = tm.remove(k) + 1;
                }
                tm.put(k, occur);
                if (occur>max)max=occur;
            }
            int res = (max>n/2)?max-(n-max):(n%2);
            System.out.println(res);
        }
    }
}
