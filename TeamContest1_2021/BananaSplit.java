package TeamContest1_2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BananaSplit {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        char[][]arr=new char[n][m];

        for(int i=0;i<n;i++)
            arr[i]= br.readLine().toCharArray();

        int t=Integer.parseInt(br.readLine());
        outer: for(int i=0;i<t;i++){
            st = new StringTokenizer(br.readLine());
            int r1=Integer.parseInt(st.nextToken())-1;
            int c1=Integer.parseInt(st.nextToken())-1;
            int r2=Integer.parseInt(st.nextToken())-1;
            int c2=Integer.parseInt(st.nextToken())-1;

            boolean YES=true;
            if(arr[r1][c2]!='#'){
                int fixedR=r1;
                int fixedC=c2;
                int rMin=Math.min(r1,r2);int rMax=Math.max(r1,r2);


                for(int i1=Math.min(r1,r2);i1<=Math.max(r1,r2);i1++)
                    if(arr[i1][fixedC]=='#')
                        YES=false;

                for(int i1=Math.min(c1,c2);i1<=Math.max(c1,c2);i1++)
                    if(arr[fixedR][i1]=='#')
                        YES=false;

                if(YES) {
                    System.out.println("YES");
                    continue;
                }
            }

            YES=true;
            if(arr[r2][c1]!='#')
            {
                int fixedR=r2;
                int fixedC=c1;

                for(int i1=Math.min(r1,r2);i1<=Math.max(r1,r2);i1++)
                    if(arr[i1][fixedC]=='#')
                        YES=false;

                for(int i1=Math.min(c1,c2);i1<=Math.max(c1,c2);i1++)
                    if(arr[fixedR][i1]=='#')
                        YES=false;
            }
            System.out.println(YES?"YES":"NO");
        }

    }



}



