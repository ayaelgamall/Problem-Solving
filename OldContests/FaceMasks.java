package OldContests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class FaceMasks {
    public static void main(String args[]) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("masks.in"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> s = new PriorityQueue();
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (n-->0){
                s.add( Integer.parseInt(st.nextToken()));
            }
            int m = Integer.parseInt(br.readLine());
            long r =0;
            while (m-->0){
                int x = s.poll();
                r+=x;
                s.add(++x);
            }
            System.out.println(r);
        }
    }
}
