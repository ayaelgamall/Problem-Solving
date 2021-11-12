package OldContests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Catwoman {
    public static void main(String args[]) throws IOException, IOException {
//        BufferedReader br = new BufferedReader(new FileReader("cat.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            PriorityQueue<Pair> r = new PriorityQueue<>();
            r.add(new Pair(m,0));
            while (n-->0){
                 st = new StringTokenizer(br.readLine());
                int h = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());


            }
        }
    }
    public static int gcf(int x,int y){
        for (int i = Math.min(x,y); i>1; i--) {
            if(x%i==0 && y%i==0)return i;
        }
        return 1;
    }
    public static int res(int x,int y){
        int r = gcf(x,y);
        return ((x/r)+(y/r));
    }
    static class Pair  {
        int x;
        int y;


        public Pair(int s, int d) {
            x = s;
            y = d;
        }

    }
}
