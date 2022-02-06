package Leetcode;






public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValidHelper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean isValidHelper(TreeNode root, long low, long high){
        if(root==null)return true;

        if(root.val<low|| root.val>high)return false;

        return isValidHelper(root.left,low,(long)root.val-1) && isValidHelper(root.right,root.val+1,high);
    }

    public static void main(String[] args) {
        ValidBST v= new ValidBST();
        TreeNode root=new TreeNode(-2147483648);root.left=new TreeNode(-2147483648);
        System.out.println(v.isValidBST(root));
    }
}
