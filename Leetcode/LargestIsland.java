package Leetcode;
import java.util.*;
public class LargestIsland {

        /*
        1 0
        0 1


        */
        int[] dx=new int[]{1,-1,0,0};
        int[]dy=new int[]{0,0,1,-1};
        int[][] visited;
        int[][] grid;
        int n;
        int size;
        public int largestIsland(int[][] grid) {
            int count=0;
            this.grid=grid;
            n=grid.length;
            HashMap<Integer,Integer> sizes=new HashMap();
            sizes.put(0,0);
            visited=new int [n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(grid[i][j]!=0 && visited[i][j]==0){
                        size=0;
                        dfs(i,j,++count);
                        sizes.put(count,size);
                    }
                }
            }
            //if(count<=1)
            return sizes.get(count);


        }
        public void dfs(int i,int j,int c){
            visited[i][j]=c;
            size++;
            for(int k=0;k<4;k++){
                if(i+dx[k]>=0 && i+dx[k]<n && j+dy[k]>=0 && j+dy[k]<n &&
                        grid[i+dx[k]][j+dy[k]]!=0 && visited[i+dx[k]][j+dy[k]]==0){
                    dfs(i+dx[k],j+dy[k],c);
                }
            }
        }

    public static void main(String[] args) {
        LargestIsland l =new LargestIsland();
        int [][] grid= new int[][]{{1,0},{0,1}};
        System.out.println(l.largestIsland(grid));
    }

}
