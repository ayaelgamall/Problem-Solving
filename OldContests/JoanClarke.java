package OldContests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class JoanClarke {
    public static void main(String args[]) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("joan.in"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] d = new int[26];
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            Arrays.fill(d,0);
            int dic = Integer.parseInt(br.readLine());
            while (dic-->0){
                String in = br.readLine();
                int c = in.charAt(0);
                d[c-65]++;
            }
            int a = Integer.parseInt(br.readLine());
         loop:   while (a-->0){
                boolean c = false;
                String b = br.readLine();
                for (int i = 0; i < b.length(); i++) {
                    if (d[b.charAt(i)-65]==0){
                        System.out.println("Oops");
                        continue loop;
                    }
                    else if (d[b.charAt(i)-65]!=1) c=true;
                }
                if(c) System.out.println("Confusing");
                else System.out.println("Unique");
            }
        }
    }
}

