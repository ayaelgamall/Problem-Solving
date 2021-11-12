package XCPC;

import java.io.*;
import java.math.BigInteger;

public class G {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("pair.in"));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while (t-- >0){
            StringBuilder a = new StringBuilder( br.readLine());
            int k = Integer.parseInt(br.readLine());
            long mod = 0;
            for (int i = 0; i <a.length() ; i++) {
               mod= mod*10+(a.charAt(i) -'0');
               mod%=k;
            }

            if(mod==0)pw.println("YES");
            else pw.println("NO");

        }
        pw.close();

    }
}
