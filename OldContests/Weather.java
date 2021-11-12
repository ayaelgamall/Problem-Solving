package OldContests;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Weather {
    public static void main(String args[]) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet h = new HashSet();
        h.add("NW");h.add("NE");h.add("SW");h.add("SE");
        int mod = (int) (1e9)+7;
       PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));
        String s= br.readLine();
        int r =0;
        for (int i = 0; i < s.length()-1; i++) {
            String temp = s.substring(i,i+2);
            if(h.contains(temp))r++;
        }
        long res=1;
        for (int i = 0; i < r ; i++) {
            res=(res*2)%mod;
        }


//        System.out.println(res);

        pw.println(res);
        pw.flush();
    }


    public String lucky(int n , int m) {
        int n1=0;int n2=0;int m1=0;int m2=0;
        for (int i = 0; i <3 ; i++) {
            n2+=n%10;n/=10;
        }
        for (int i = 0; i <3 ; i++) {
            n1+=n%10;n/=10;
        }
        for (int i = 0; i <3 ; i++) {
            m2+=m%10;m/=10;
        }
        for (int i = 0; i <3 ; i++) {
            m1+=m%10;m/=10;
        }
        if(n1==m2)return "AT";
        if (m1==n2)return "TA";
        return "";
    }
}