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
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gym5 {
    static ArrayList<Integer> sortedArray;
    static ArrayList<Integer>[] adjList;
    static edge a[];
    static int V;
    static long sum;
    static long c;
    static boolean vis[];

    static void dfs(int u) {
        vis[u] = true;

        for (int v : adjList[u]) {

            if (!vis[v]) {

                dfs(v);
                a[u].t = Math.max(a[v].t, a[u].t);
            }
        }
    }

    static void toposortBFS() {
        int[] p = new int[V];
        sortedArray = new ArrayList<Integer>(V);
        for (int i = 0; i < V; ++i)
            for (int v : adjList[i])
                ++p[v];
        PriorityQueue<edge> roots = new PriorityQueue<edge>(); // PriorityQueue for smallest lexiographical sorting

        for (int i = 0; i < V; ++i)
            if (p[i] == 0)
                roots.add(a[i]);
        while (!roots.isEmpty()) {
            edge u = roots.remove();
            sum = Math.max(u.t + c, sum);
            c++;
            sortedArray.add(u.idx);
            for (int v : adjList[u.idx])
                if (--p[v] == 0) {
                    roots.add(a[v]);
                }
        }

    }

    static class edge implements Comparable<edge> {
        int idx;
        int t;

        public edge(int i, int t) {
            this.idx = i;
            this.t = t;
        }

        @Override
        public int compareTo(edge e) {
            // TODO Auto-generated method stub
            return e.t - t;
        }

    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        V = sc.nextInt();
        a = new edge[V];
        adjList = new ArrayList[V];
        for (int i = 0; i < V; i++)
            adjList[i] = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            a[i] = new edge(i, sc.nextInt());
            int c = sc.nextInt();
            while (c-- > 0) {
                adjList[sc.nextInt() - 1].add(i);
            }

        }
        sum = 0;
        c = 0;
        for (int i = 0; i < V; i++) {
            vis = new boolean[V];
            dfs(i);
        }

        sortedArray = new ArrayList<Integer>();
        toposortBFS();
        pw.println(sum);
        pw.flush();

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