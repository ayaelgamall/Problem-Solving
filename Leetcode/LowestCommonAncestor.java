package Leetcode;

public class LowestCommonAncestor {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int val, Node left, Node right, Node parent) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }
    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        int heightp=getHeight(root,p);
        int heightq=getHeight(root,q);
        while(heightq>heightp){
            heightq--;q=q.parent;
        }
        while(heightp>heightq){
            heightp--;p=p.parent;
        }
        while(p!=q){
            p=p.parent;q=q.parent;
        }
        return p;
    }

    private int getHeight(Node root, Node p) {
        if(root==p)return 0;
        return 1+getHeight(root,p.parent);
    }

}
