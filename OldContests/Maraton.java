package OldContests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Maraton {
    static HashSet<Plate>table=new HashSet<>();
    public static void main(String args[]) throws IOException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
       loop: while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean add = st.nextToken().equals("A");
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            int r=Integer.parseInt(st.nextToken());
            if(add){
                for (Plate p : table){
                    if((Math.pow((p.x-x),2)+Math.pow((p.y-y),2))<Math.pow(r+p.r,2)){
                        System.out.println("No");
                        continue loop;
                    }
                }
                Plate p = new Plate(x,y,r);
                table.add(p);
                System.out.println("Ok");
            }else
            {
                for (Plate p : table){
                    if(p.x==x && p.y==y && p.r==r){
                        System.out.println("Ok");
                        table.remove(p);
                        continue loop;
                    }
                }
                System.out.println("No");
            }

        }
    }
    static class Plate {
        int x;
        int y;
        int r;

        public Plate(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }
}
