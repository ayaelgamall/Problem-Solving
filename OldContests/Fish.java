package OldContests;

import java.io.*;
import java.util.StringTokenizer;

public class Fish {
    public static void main(String args[]) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int r;
        if(n<k)r =2;
        else if(n%k==0) r=2*(n/k);
        else if(n%k<=k/2) r=2*(n/k)+1;
        else r= (int) (2*Math.ceil((double)n/k));
//        System.out.println(r);

        pw.println(r);
        pw.flush();
    }
}
