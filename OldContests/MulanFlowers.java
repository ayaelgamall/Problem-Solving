package OldContests;

import java.io.*;

public class MulanFlowers {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("mulan.in"));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            int x = Integer.parseInt(br.readLine());
            if(x%2==0)
                System.out.println("Bad news");
            else
                System.out.println("Good news");

        }
    }
}
