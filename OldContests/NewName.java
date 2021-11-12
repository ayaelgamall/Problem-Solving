package OldContests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NewName {
    public static void main(String args[]) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("name.in"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            String[] names = new String[n];
            for(int i =0 ; i<n;i++)
                names[i]= br.readLine();

            for(int i =0 ; i<k;i++){
                st = new StringTokenizer(br.readLine());
                String x=st.nextToken();
                String y=st.nextToken();
                for (int b = 0; b < n && !(x.equals(y)) ; b++) {


                for (int j = 0; j <n &&!(x.equals(y)) ; j++) {
                    String t = names[j];
                    int d = 0;
                    Boolean f = false;
                    for (int l = 0; l < x.length()&& !x.equals(t)  ; l++) {
                        if (x.charAt(l)!=t.charAt(l)){
                            d++;
                            if(t.charAt(l)==y.charAt(l))f=true;
                        }
                    }
                    if(d==1 && f)x=t;

                }}
                if (x.equals(y)) System.out.println("Yes");
                else System.out.println("No");

            }
        }


        }


    }

