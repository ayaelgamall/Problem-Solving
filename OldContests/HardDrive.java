package OldContests;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HardDrive {
    static int broken;
    static int bitChanges;
    static int n;
    static int arr[];


    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n ];
        Arrays.fill(arr, -1);
        bitChanges = sc.nextInt();
        PrintWriter pw = new PrintWriter(System.out);

        broken = sc.nextInt();
        for (int i = 0; i < broken; i++) {
            int idx = sc.nextInt();
            arr[idx-1] = 0;
        }
        int bc=0;
        int l =0;
        int r =0;
        int i=0;
        boolean f =false;
        if(bc==bitChanges-1)arr[0]=1;
        else
        for ( i = n-2; i >-1 ; i--) {
            if(bc==bitChanges){ f= true;break;}
            r=arr[i+1];
            l=i>0?arr[i-1]:-2;

            if(arr[i]==-1){
                if(r==0){
                    arr[i]=1;bc+=1;if(l==0)bc+=1;

                    else if(bc==bitChanges-1){arr[i-1]=0;bc+=1;}

                }

                else {arr[i]=0;
                bc+=1;}


                if(bc==bitChanges-1){arr[0]=1;break;}
            }}
        for (int j = 0; j < n; j++) {
            pw.print((arr[j]==1)?1:0);
        }
        pw.flush();
        }

    static class Scanner
    {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s){    br = new BufferedReader(new InputStreamReader(s));}

        public String next() throws IOException
        {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {return Integer.parseInt(next());}

        public long nextLong() throws IOException {return Long.parseLong(next());}

        public String nextLine() throws IOException {return br.readLine();}



    }
}