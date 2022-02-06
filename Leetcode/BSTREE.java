package Leetcode;


public class BSTREE {
//    static Node str2tree(String s){
//        if(s.length()==0)
//            return null;
//        StringBuilder sb = new StringBuilder();
//        int i;
//        for(i=0;i<s.length();i++){
//            if(Character.isDigit(s.charAt(i)))
//                sb.append(s.charAt(i));
//            else
//            {
//                i++;
//                break;
//            }
//        }
//        String n = sb.toString();
//        int num=Integer.parseInt(n);
//        Node root=new Node(num);
//        int c=0;
//        sb = new StringBuilder();
//        for(;i<s.length();i++)
//        {
//            char chr = s.charAt(i);
//            if(chr=='(')
//                c++;
//            else if(chr==')')
//            {
//                if(c>0)
//                    c--;
//                else{
//                    i+=2;
//                    break;
//                }
//            }
//            sb.append(chr);
//        }
//
//        String left=sb.toString();
//        root.left=str2tree(left);
//        c=0;
//        sb = new StringBuilder();
//        for(;i<s.length();i++)
//        {
//            char chr = s.charAt(i);
//            if(chr=='(')
//                c++;
//            else if(chr==')')
//            {
//                if(c>0)
//                    c--;
//                else{
//                    i++;
//                    break;
//                }
//            }
//            sb.append(chr);
//        }
//        String right = sb.toString();
//        root.right=(str2tree(right));
//        return root;
//    }

   static int start=0;
   public TreeNode stringToTree(String s){
       if(start>=s.length())return null;
       if(s.charAt(start)==')'){
           start++;return null;
       }
       StringBuilder num = new StringBuilder();
       while (Character.isDigit(s.charAt(start))){num.append(s.charAt(start));start++;}
       TreeNode root = new TreeNode(Integer.parseInt(num.toString()));
       if(s.charAt(start)=='('){
           start++; root.left=stringToTree(s);
       }
       if (s.charAt(start)=='('){
           start++; root.right=stringToTree(s); /// 6(4(9))(5)
       }
       if(s.charAt(start)==')'){
           start++;
       }
       return root;
   }

}
