package Leetcode;
import java.util.*;
public class treeToNode {
    static TreeNode prev;
    static TreeNode head;

    public TreeNode  buildLinkedList(TreeNode root) {
        if(root==null)
            return null;
        treeToList(root);
        prev.right=head;
        head.left=prev;
        return head;
    }
        public  void treeToList(TreeNode root) {

        if(root==null)
            return;
        treeToList(root.left);

        if(prev!=null){
            prev.right=root;
            root.left=prev;

        }
        else{
            head=root;
        }
        prev=root;
        treeToList(root.right);
    }
}

