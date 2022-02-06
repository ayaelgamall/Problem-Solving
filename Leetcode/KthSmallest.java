package Leetcode;

public class KthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        int[]index= new int [matrix.length];
        int count =0;
        int last=Integer.MAX_VALUE;
        int idx=-1;
        while(count<k){
            idx=-1;
            for(int i=0;i<index.length;i++){

                if(index[i] <matrix.length && (idx==-1 || matrix[i][index[i]]<last)){
                    idx=i;last=matrix[i][index[i]];
                }
            }
            count++;
            index[idx]++;
        }
        return last;
    }

    public static void main(String[] args) {
        KthSmallest k =new KthSmallest();
        int[][]matrix = new int[][] {{1,5,9},{10,11,13},{12,13,15}};
        System.out.println(k.kthSmallest(matrix,8));
    }
}
