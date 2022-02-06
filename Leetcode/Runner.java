package Leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Runner {
    private static int[][] matrix;


    public Runner(int[][] matrix) {
        this.matrix = matrix;
    }

    public int leftmostColumn() {
        ArrayList<Integer> dimention =  Runner.dimensions();
        //int [] row = new int [dimention.get(0)];
        boolean found=false;
        int end=dimention.get(1);
        int start=0;
//        while(start<end){
//            start=end+1;
//            for(int i=0;i<row.length;i++){
//                if(row[i]<end){
//                    start=row[i];
//                    int mid=(start+end)/2;
//                    if(Runner.get(i,mid)==1){
//                        found=true;
//                        end=mid;
//                    }else{
//                        row[i]=mid+1;
//
//                    }
//                }
//            }
//
//        }
        for (int i = 0; i < dimention.get(0); i++) {
            start=0;
            while(start<end){


                        int mid=(start+end)/2;
                        if(Runner.get(i,mid)==1){
                            found=true;
                            end=mid;
                        }else{
                            start=mid+1;

                        }



            }
        }
        if(!found)return -1;
        return end;
    }

    private static int get(int i, int j) {
        return matrix[i][j];
    }

    private static ArrayList<Integer> dimensions() {
        ArrayList<Integer> d=new ArrayList<>();
        d.add(matrix.length );
        d.add(matrix[0].length );
        return d;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- >0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int[][]arr=new int[m][n];
            for (int i = 0; i <m ; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j]=Integer.parseInt(st.nextToken());
                }
            }
            Runner r =new Runner(arr);
            System.out.println(r.leftmostColumn());
        }
    }

}
