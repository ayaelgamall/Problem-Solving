package Leetcode;

public class SerializeDeserialize {
    public String serialize(TreeNode root) {
        StringBuilder sb =new StringBuilder();
        treeToStr(root,sb);
        return sb.toString();
    }
    public void treeToStr(TreeNode root,StringBuilder res){
        if(root==null)return;
        res.append(root.val);
        if(root.left!=null || root.right!=null){
            res.append('(');
            treeToStr(root.left,res);
            res.append(')');
        }
        if(root.right!=null){
            res.append('(');
            treeToStr(root.right,res);
            res.append(')');
        }
    }

    // Decodes your encoded data to tree.

    public TreeNode deserialize(String s){
        int [] start={0};
        return deserializeHelper(s,start);
    }
    public TreeNode deserializeHelper(String s,int[] idx){
        if(idx[0]>=s.length())return null;

        if(s.charAt(idx[0])==')'){
            idx[0]++;return null;
        }

        StringBuilder num = new StringBuilder();
        if(idx[0]<s.length() && s.charAt(idx[0])=='-'){num.append('-');
            idx[0]++;}
        while (idx[0]<s.length() && Character.isDigit(s.charAt(idx[0]))){
            num.append(s.charAt(idx[0]));
            idx[0]++;
        }

        TreeNode root = new TreeNode(Integer.parseInt(num.toString()));
        if(idx[0]<s.length() && s.charAt(idx[0])=='('){
            idx[0]++; root.left=deserializeHelper(s, idx);
        }

        if (idx[0]<s.length() && s.charAt(idx[0])=='('){
            idx[0]++; root.right=deserializeHelper(s, idx); /// 6(4(9))(5)
        }

        if(idx[0]<s.length() && s.charAt(idx[0])==')'){
            idx[0]++;
        }

        return root;
    }

    public static void main(String[] args) {
        // [4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2]
        SerializeDeserialize ser = new SerializeDeserialize();
        SerializeDeserialize deser = new SerializeDeserialize();
        TreeNode root=new TreeNode(4);
        TreeNode n1=new TreeNode(-7);root.left=n1;
        TreeNode n2=new TreeNode(-3);root.right=n2;
        TreeNode n3=new TreeNode(-9);n2.left=n3;
        TreeNode n4=new TreeNode(-3);n2.right=n4;
        TreeNode n5=new TreeNode(9);n3.left=n5;
        TreeNode n6=new TreeNode(-7);n3.right=n6;
        TreeNode n7=new TreeNode(-4);n4.left=n7;
        TreeNode n8=new TreeNode(6);n5.left=n8;
        TreeNode n9=new TreeNode(-6);n6.left=n9;
        TreeNode n10=new TreeNode(-6);n6.right=n10;
        TreeNode n11=new TreeNode(0);n8.left=n11;
        TreeNode n12=new TreeNode(6);n8.right=n12;
        TreeNode n13=new TreeNode(5);n9.left=n13;
        TreeNode n14=new TreeNode(9);n10.left=n14;
        TreeNode n15=new TreeNode(-1);n11.right=n15;
        TreeNode n16=new TreeNode(-4);n12.left=n16;
        TreeNode n17=new TreeNode(-2);n14.left=n17;
         TreeNode ans = deser.deserialize(ser.serialize(root));
        System.out.println(ans.val);
    }
}
