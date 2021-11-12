package OldContests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HumanComputer {
    public static void main(String args[]) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("computer.in"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int p =0;
            String n = br.readLine();
            for (int i = 0; i < n.length(); i++) {
              if (n.charAt(i)=='1')p++;
            }
            double r= Math.pow(2,p);
            System.out.println(1/r);
        }
    }
}
