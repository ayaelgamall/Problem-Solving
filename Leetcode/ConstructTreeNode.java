package Leetcode;

import java.util.HashMap;

public class ConstructTreeNode {
    public TreeNode buildTree(int[] preorder, int[] inorder) {


        HashMap<Integer,Integer> inIdx = new HashMap();
        fill(inIdx,inorder);

        TreeNode root = new TreeNode(preorder[0]);
        buildTree(root,preorder,inIdx,0,inorder.length-1,1);
        System.out.println(root);
        return root;

    }
    public int buildTree(TreeNode root, int[] preorder,HashMap<Integer,Integer> inIdx,int i,int j,int start){
        if(i>j)return start;
        if(root==null)return start;

        int idx= inIdx.get(root.val);
        int leftrange=idx-i;
        int rightrange=j-idx;

        TreeNode left=null ;
        if(leftrange!=0)
            left=new TreeNode(preorder[start++]);

        root.left=left;

        start =buildTree(left,preorder,inIdx,i,idx-1,start);

        TreeNode right=null ;
        if(rightrange!=0)
            right=new TreeNode(preorder[start++]);

        root.right=right;

        return buildTree(right,preorder,inIdx,idx+1,j,start);

    }

    public void fill(HashMap<Integer,Integer> Idx,int[]arr){
        for(int i=0;i<arr.length;i++){
            Idx.put(arr[i],i);
        }

    }

    public static void main(String[] args) {
        ConstructTreeNode c=new ConstructTreeNode();
        System.out.println(c.buildTree(new int []{3,9,20,15,7},new int []{9,3,15,20,7}));
    }
}
