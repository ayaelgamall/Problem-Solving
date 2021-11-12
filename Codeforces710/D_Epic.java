package Codeforces710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D_Epic {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            TreeMap<Integer, Integer> tm = new TreeMap<>();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int k = Integer.parseInt(st.nextToken());
                int occur = 1;
                if (tm.containsKey(k)) {
                    occur = tm.remove(k) + 1;
                }
                tm.put(k, occur);
            }
            int res = 0;
            PriorityQueue<Integer>p = new PriorityQueue<>();
            for (int i : tm.keySet()){
                p.add(tm.get(i));
            }
                if (tm.size() % 2 == 0) {
                int prev = 0;
                for (int i : tm.keySet()) {
                    int curr = tm.get(i);
                    int temp = prev - curr;
                    if (temp < 0) {
                        res += prev;
                        prev = temp * -1;
                    } else {
                        res += curr;
                        prev = temp;
                    }
                }
            } else {

            }
            System.out.println(n - res * 2);

        }
    }
}
