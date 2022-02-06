package Leetcode;
import java.util.*;
public class Copy_List_Random_Pointer {

// Definition for a Node.
static class Node {
    int val;
    public Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    @Override
    public String toString() {
        return "{" +val +
                ", next=" + next +
                ", random=" + random +
                '}';
    }
}


        public Node copyRandomList(Node head) {
                    if(head==null)return null;

                    HashMap<Node,Node> oldToCopy=new HashMap();
                    oldToCopy.put(null,null);

                    Node curr= head;
                    while(curr!=null){
                        Node copy = new Node(curr.val);
                        oldToCopy.put(curr,copy);
                        curr=curr.next;
                    }

                    curr=head;
                    while(curr!=null){
                        Node copy =oldToCopy.get(curr);
                        copy.next=oldToCopy.get(curr.next);
                        copy.random=oldToCopy.get(curr.random);
                        curr=curr.next;
                    }

                    return oldToCopy.get(head);



    //O(n) mine
//            if(head==null)return null;
//            Node curr=head;
//            HashMap<Node,Integer> idx=new HashMap<>();int i =0;
//            while(curr!=null){
//                idx.put(curr,i++);curr=curr.next;
//            }
//            ArrayList<Node> arr= new ArrayList<>();
//            Node resHead=new Node(head.val);
//            curr=head;
//            Node resCurr=resHead;
//            arr.add(resHead);
//            curr=curr.next;
//            while(curr!=null){
//                resCurr.next=new Node(curr.val);
//                resCurr=resCurr.next;
//                arr.add(resCurr);
//                curr=curr.next;
//            }
//            curr=head;resCurr=resHead;
//            while(curr!=null){
//                if(curr.random!=null){
//                    int randomIdx= idx.get(curr.random);
//                    resCurr.random=arr.get(randomIdx);
//                }
//                curr=curr.next;resCurr=resCurr.next;
//            }
//            return resHead;

//O(n^2)

//            if(head==null)return null;
//            Node curr=head;
//            ArrayList<int []> arr= new ArrayList<>();
//            while(curr!=null){
//                if(curr.random==null){
//                    arr.add(new int[]{curr.val,-1});curr=curr.next;
//                    continue;
//                }
//                int random=0;
//                Node idxRandom=head;
//                while(idxRandom!=curr.random){
//                    idxRandom=idxRandom.next;random++;
//                }
//                arr.add(new int[]{curr.val,random});
//                curr=curr.next;
//            }
//            Node resHead=new Node(arr.get(0)[0]);
//            curr=resHead;
//            for(int[] element :arr){
//                curr.next=new Node(element[0]);
//                curr=curr.next;
//            }
//            curr=resHead;int idx=0;
//            while(curr!=null){
//                int randomIdx = arr.get(idx)[1];idx++;
//                Node random=resHead;
//                if(randomIdx==-1)random=null;
//                while(randomIdx-->0){
//                    random=random.next;
//                }
//                curr.random=random;
//                curr=curr.next;
//            }
//            return resHead;
        }

    public static void main(String[] args) {
        Copy_List_Random_Pointer c= new Copy_List_Random_Pointer();
        //head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
        Node a0= new Node(7);
        Node a1= new Node(13);
        Node a2= new Node(11);
        Node a3= new Node(10);
        Node a4= new Node(1);
        a0.next=a1;a1.next=a2;a2.next=a3;a3.next=a4;
        a1.random=a0;a2.random=a4;a3.random=a2;a4.random=a0;
        System.out.println(c.copyRandomList(a0).toString());
    }

}
