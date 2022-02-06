package Leetcode;
import  java.util.*;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class NodeDistanceK {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        LinkedList<Character> path =new LinkedList<>();
        getPath(root,target,path);
        List<Integer> list=new LinkedList<Integer>();
        generate(list,root,path,k,path.size());
        return list;
    }

    public boolean getPath(TreeNode root, TreeNode target,LinkedList<Character> path){
        if(root==null)return false;
        if(root==target)return true;
        path.add('L');
        boolean found =getPath(root.left,target,path);
        if(found)return true;
        path.removeLast();

        path.add('R');
        found =getPath(root.right,target,path);
        if(found)return true;
        path.removeLast();

        return false;
    }

    public void generate(List<Integer> list,TreeNode root,LinkedList<Character> path,int k,int far){
        if(root==null)return;
        if(far==k){
            list.add(root.val);
        }
        if(path==null || path.size()==0){
            if(far<k){
                generate(list,root.left,path,k,far+1);
                generate(list,root.right,path,k,far+1);
            }
            return;
        }
        char direction=path.remove();
        if(direction=='R'){
            generate(list,root.right,path,k,far-1);
            generate(list,root.left,null,k,far+1);
        }else{
            generate(list,root.left,path,k,far-1);
            generate(list,root.right,null,k,far+1);
        }

    }

    public static void main(String[] args) {
        NodeDistanceK n=new NodeDistanceK();
        TreeNode root=new TreeNode(0);
        TreeNode n1=new TreeNode(1);root.left=n1;
        TreeNode n3=new TreeNode(3);n1.left=n3;
        TreeNode n4=new TreeNode(2);n1.right=n4;

        System.out.println(n.distanceK(root,n4,1).toString());

    }

}
