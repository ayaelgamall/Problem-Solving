package Leetcode;

import java.util.Arrays;

public class DiagonalTraverse {

        public int[] findDiagonalOrder(int[][] mat) {
            int R = mat.length;//no of Rows
            int C = mat[0].length;//no of Columns
            int[] diagonal = new int [R*C];
            int idx =0;//index of result
            int r=0;
            int c=1;
            while(idx <diagonal.length){

                int i = (r<R)?r:R-1;
                for(;i>=0&& (r-i)< C;i--)
                    diagonal[idx++]=mat[i][r-i];


                i = (c<C)?0:c-C+1;
                int limit = Math.min(R-1,c);
                for(;i<=limit;i++)
                    diagonal[idx++]=mat[i][c-i];


                c+=2; r+=2;

            }
            return diagonal;
        }

    public static void main(String[] args) {
        DiagonalTraverse d =new DiagonalTraverse();
        int [][] a ={{1,2,6,7}, {3, 5 ,8 ,13}, {4, 9 ,12, 14},{10, 11, 15, 16}};
        System.out.println(Arrays.toString(d.findDiagonalOrder(a)));
    }
}
