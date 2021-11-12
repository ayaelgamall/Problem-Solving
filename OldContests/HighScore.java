package OldContests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class HighScore {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            long a=sc.nextLong();
            long b=sc.nextLong();
            long c=sc.nextLong();
            long d=sc.nextLong();
            long max=0;
            long min=0;
            long mid=0;
            max=Math.max(Math.max(a, b),c);
            min=Math.min(Math.min(a, b), c);
            int count=0;
            if(a==max)count++;
            if(b==max)count++;
            if(c==max)count++;
            if(count==1)
            {
                count=0;
                if(a==min)count++;
                if(b==min)count++;
                if(c==min)count++;
                if(count==1)
                {
                    if((a>=b&&a<=c)||(a>=c&&a<=b))mid=a;
                    if((b>=c&&b<=a)||(b<=c&&b>=a))mid=b;
                    if((c>=a&&c<=b)||(c<=a&&c>=b))mid=c;
                }else
                    mid=min;

            }else mid=max;

            long ans=min*min+(max+d)*(max+d)+mid*mid+min*7;
            if((d+max)>=7) {
                ans=min*min+(max+d)*(max+d)+mid*mid+min*7;
            }
            else {
                if(min+d<mid) {
                    mid+=d;
                    d=0;
                }else {
                    d-=(mid-min);
                    min=mid;

                    if(d/2+min<max)
                    {
                        if(d/2>0) {
                            min+=d/2;
                            mid+=d/2;}else {
                            max+=d;
                        }
                        d=0;
                    }else {
                        d-=(max-mid)*2;
                        min=max;
                        mid=max;

                        if(d/3>0)
                        {
                            max+=d/3;
                            min+=d/3;
                            mid+=d/3;
                            d=d%3;

                        }
                        max+=d;
                    }

                }
                ans=Math.max(ans,Math.min(min, Math.min(max, mid))*7+mid*mid+min*min+max*max);
            }
            pw.println(ans);



            pw.flush();

        }






    }

    static class Scanner {

        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream system) {
            br = new BufferedReader(new InputStreamReader(system));
        }

        public Scanner(String file) throws Exception {
            br = new BufferedReader(new FileReader(file));
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public char nextChar() throws IOException {
            return next().charAt(0);
        }

        public Long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public boolean ready() throws IOException {
            return br.ready();
        }

        public void waitForInput() throws InterruptedException {
            Thread.sleep(3000);
        }
    }

}