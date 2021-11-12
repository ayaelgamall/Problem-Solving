package OldContests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Kleptograph {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String kl = br.readLine();
        String bs = br.readLine();
        int [] k=new int[m];
        int [] a=new int[m];
        int [] b=new int[m];
        for (int i = 0; i <m ; i++) {
           b[i]=(int)bs.charAt(i)-97;
        }int c=n;
        for (int i = 0; i<n ; i++) {
            k[i]=(int)kl.charAt(i)-97;
            a[m-c]=(int)kl.charAt(i)-97;c--;
        }
        for (int i = m-1; i >n-1 ; i--) {
          k[i]=(b[i]-a[i]) >-1? b[i]-a[i]:b[i]-a[i]+26;
          a[i-n]=k[i];
        }
        String res="";
        for (int i = 0; i < m; i++) {
           res+=((char)(a[i]+97));
        }
        System.out.println(res);
    }
}
