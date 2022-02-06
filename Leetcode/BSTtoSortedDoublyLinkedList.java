package Leetcode;


import java.util.LinkedList;

public class BSTtoSortedDoublyLinkedList {

    /*
    *    4
    *  2   5
    * 1 3
    *
    * 1 2 3 4 5
    *1.right 2
    *
    * */
    public Node treeToDoublyList(Node root) {
        LinkedList<Node> sorted =new LinkedList<>();
        construct(root,sorted);
        Node head=sorted.poll();
        Node pre=head;
        while(!sorted.isEmpty()){
            Node curr=sorted.poll();
            pre.right=curr;
            curr.left=pre;
            pre=curr;
        }
        return head;
    }
    public void construct(Node root,LinkedList<Node> sorted){
        if(root==null)return ;
        construct(root.left,sorted);
        sorted.add(root);
        construct(root.left,sorted);
    }


    class Node {
        public int val;public Node left;public Node right;
        public Node() {}
      public Node(int _val) {
             val = _val;
         }

     public Node(int _val,Node _left,Node _right) {
             val = _val;
             left = _left;
             right = _right;
         }
    }

}
