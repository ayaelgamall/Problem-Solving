package TeamContest1_2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class F_AspergerSyndrome {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        TreeSet<Integer> ts = new TreeSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = Integer.parseInt(st.nextToken());
        ts.add(root);map.put(root,1);
        for (int i = 1; i <n ; i++) {
            int x =  Integer.parseInt(st.nextToken());
            Object before = ts.floor(x);
            Object after = ts.ceiling(x);
            int res = before!=null && after !=null ? Math.max(map.get(before),map.get(after)):before==null? map.get(after): map.get(before);
            ans+=res;
            ts.add(x); map.put(x,res+1);
        }
        System.out.println(ans);
    }
}
