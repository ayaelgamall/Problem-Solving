package OldContests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class LengthofBundleRope {
    public static void main(String args[]) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> a= new PriorityQueue<Integer>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i <n ; i++) {
                a.add(Integer.parseInt(st.nextToken()));
            }
            long ans=0;
            while(a.size()>1){
                int temp = a.remove() + a.remove();
                ans+=temp;
                a.add(temp);
            }
            System.out.println(ans);

        }
    }
}
