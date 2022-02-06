package Leetcode;
import java.util.*;
public class PathSum {
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

        static int count=0;
        public int pathSum(TreeNode root, int targetSum) {
            HashMap<Integer,Integer> freq=new HashMap<>();
            helper(root,targetSum,0,freq);
            return count;
        }
        public void helper(TreeNode root, int target,int sum,HashMap<Integer,Integer> freq){
            if(root==null)return;

            sum=sum +root.val;

            if(sum==target)count++;
            if(freq.containsKey(sum-target))count+=freq.get(sum-target);

            int rep=freq.getOrDefault(sum,0);
            freq.put(sum,rep+1);

            helper(root.left,target,sum,freq);
            helper(root.right,target,sum,freq);

            if(rep==0)freq.remove(sum);
            else freq.put(sum,rep);

        }

    public static void main(String[] args) {
        PathSum p=new PathSum();
        TreeNode root=new TreeNode(5);
        TreeNode n1=new TreeNode(4);root.left=n1;
        TreeNode n2=new TreeNode(8);root.right=n2;
        TreeNode n3=new TreeNode(11);n1.left=n3;
        TreeNode n4=new TreeNode(13);n2.left=n4;
        TreeNode n5=new TreeNode(4);n2.right=n5;
        TreeNode n6=new TreeNode(7);n3.left=n6;
        TreeNode n7=new TreeNode(2);n3.right=n7;
        TreeNode n8=new TreeNode(5);n5.left=n8;
        TreeNode n9=new TreeNode(1);n5.right=n9;
        System.out.println(p.pathSum(root,22));
    }

}
