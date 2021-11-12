package OldContests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MarieCurie {
    public static void main(String args[]) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("mariecurie.in"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double b = 100.0/14.0;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int r = Integer.parseInt(br.readLine());
            System.out.println((int)(Math.floor(r*b)));
        }
    }
}
