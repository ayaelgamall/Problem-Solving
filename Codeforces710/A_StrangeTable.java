package Codeforces710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A_StrangeTable {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- >0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int rows = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            long x = Long.parseLong(st.nextToken());
            long rem = (x-1)%rows;
            long add = (long) Math.ceil(x/(double)rows);
            System.out.println(rem*col + add);
        }
    }
}
