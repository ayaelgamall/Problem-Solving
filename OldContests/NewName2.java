package OldContests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Stack;
import java.util.StringTokenizer;

public class NewName2 {
    public static void main(String args[]) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("name.in"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            HashSet names = new HashSet();
            for(int i =0 ; i<n;i++)
                names.add( br.readLine());

        loop:  for(int i =0 ; i<k;i++){
                st = new StringTokenizer(br.readLine());
                String x=st.nextToken();
                String y=st.nextToken();
                if(x.equals(y)){
                    System.out.println("Yes");continue ;
                }
                int d =0;
                for (int j = 0; j <x.length() ; j++) {
                    if(x.charAt(j) != y.charAt(j))d++;
                }
                Stack<String> xx = new Stack();
                xx.add(x);
                 Stack<String> nn = new Stack();
                while(d-->0) {
                    nn = new Stack<>();
                    while (!xx.isEmpty()){
                        String r = xx.pop();
                        for (int j = 0; j <x.length() ; j++) {
                        if(r.charAt(j) != y.charAt(j)){
                           String s;
                           if (j!=x.length()-1)
                            s= r.substring(0,j) + y.charAt(j)+r.substring(j+1);
                           else  s= r.substring(0,j) + y.charAt(j);
                           if (names.contains(s)){
                               if (s.equals(y)){
                                   System.out.println("Yes");
                                   continue loop;
                               }
                               nn.push(s);
                           }
                       }
                      }
                    }
                    xx=nn;
                }
                System.out.println("No");

            }
        }


    }


}

