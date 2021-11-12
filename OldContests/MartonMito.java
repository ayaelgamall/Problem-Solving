package OldContests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MartonMito {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        Pair curr = null;
        if(n==0)return;
        do{
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char ci = st.nextToken().charAt(0);
            if(ci=='M'){
                System.out.println("No");
                return;
            }
            Pair nxt =new Pair(t,ci);
            if(curr!=null ){
                if(curr.a!=nxt.a && nxt.c -curr.c<4){
                    System.out.println("No");
                    return;
                }
            }
            curr=nxt;
        }while (n-- > 1);
        System.out.println("Yes");

    }
    static class Pair implements Comparable{
        int c;
        char a;

        public Pair(int t, char e) {
            this.c = t;
            this.a = e;
        }

        public int compareTo(Object o) {
            return this.c-((Pair)o).c;
        }
    }
}
