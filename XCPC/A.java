package XCPC;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class A {



        public static void main(String[] args) throws IOException {
            PrintWriter pw = new PrintWriter(System.out);
//        BufferedReader br = new BufferedReader(new FileReader("min.in"));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int n=Integer.parseInt(br.readLine());
            StringTokenizer st=new StringTokenizer(br.readLine());
            int a[]=new int[n];
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(st.nextToken());
            Arrays.sort(a);
            int wSize=n/2;
            long sum=0;
            for(int i=0;i<wSize-1;i++)
                sum+=a[i+1]-a[i];
            long res=sum;
            for (int i=wSize;i<n;i++)
            {
                sum+=a[i]-a[i-1];
                sum-=a[i-wSize+1]-a[i-wSize];
                res=Math.min(res,sum);
            }
            pw.println(res);
            pw.flush();

        }

}
