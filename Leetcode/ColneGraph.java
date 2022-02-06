package Leetcode;
import java.util.*;


// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class ColneGraph {

        public Node cloneGraph(Node node) {
            if(node ==null)return null;
            HashMap<Node,Node> oldToCopy =new HashMap();

            LinkedList<Node> nodes=new LinkedList();
            HashSet<Node> visited = new HashSet();
            nodes.add(node);

            while(!nodes.isEmpty()){
                Node curr= nodes.remove();

                oldToCopy.put(curr,new Node(curr.val));

                for(Node i: curr.neighbors){
                    if(!visited.contains(i))nodes.add(i);
                }


                visited.add(curr);
            }

            visited = new HashSet();
            nodes=new LinkedList();
            nodes.add(node);
            while(!nodes.isEmpty()){
                Node curr= nodes.remove();

                Node copy = oldToCopy.get(curr);
                for(Node i: curr.neighbors){
                    if(!visited.contains(i))nodes.add(i);
                    copy.neighbors.add(oldToCopy.get(i));
                }
                visited.add(curr);
            }

            return oldToCopy.get(node);

        }

    public static void main(String[] args) {

        ColneGraph c = new ColneGraph();
        Node a1= new Node(1);Node a2= new Node(2);Node a3= new Node(3);Node a4= new Node(4);
        a1.neighbors.add(a2);a1.neighbors.add(a4);
        a2.neighbors.add(a1);a2.neighbors.add(a3);
        a3.neighbors.add(a2);a3.neighbors.add(a4);
        a4.neighbors.add(a1);a4.neighbors.add(a3);
        System.out.println(c.cloneGraph(a1));

    }
}
