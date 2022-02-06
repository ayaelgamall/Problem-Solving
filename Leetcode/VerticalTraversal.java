package Leetcode;
import java.util.*;
public class VerticalTraversal {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */

    /*


     */
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            int [] minMax={0,0};
            HashMap traversal = new HashMap<>();
            traverse(root,minMax,traversal,0,0);
            List<List<Integer>> result= new LinkedList<>();

            for(int i=minMax[0];i<=minMax[1];i++){
                List<Integer> list=new LinkedList<Integer>();
                PriorityQueue<int[]> q = (PriorityQueue<int[]>) traversal.get(i);
                while(!q.isEmpty()){
                    list.add(q.poll()[0]);
                }
                result.add(list);
            }
            return result;
        }

        public void traverse(TreeNode root,int[]minMax,HashMap traversal,int row,int  col){
            if(root==null)return;
            if(traversal.containsKey(col)){
                traversal.put(col,new PriorityQueue<int[]>((x,y)->{if(x[1]!=y[1])return x[1]-y[1];return x[0]-y[0];}));
            }
            PriorityQueue<int[]> q = (PriorityQueue<int[]>) traversal.get(col);
            q.add(new int[]{root.val,row});
            if(col<minMax[0])minMax[0]=col;
            if(col>minMax[1])minMax[1]=col;
            traverse(root.left,minMax,traversal,row+1,col-1);
            traverse(root.right,minMax,traversal,row+1,col+1);
        }

    public static void main(String[] args) {

    }

}
