package Leetcode;

import java.util.Stack;

public class SimplifyPath {

        //  "/a/./b/"  ,, "/a/b"
        ///  "///",,,"/"
        ///   "/a/../" ,, "/"
        public String simplifyPath(String path) {
            Stack<String> s =new Stack<>();
            StringBuilder res= new StringBuilder();

            String[] absolutePath = path.split("/");

            loop:for(int i =0;i<absolutePath.length;i++){
                String file = absolutePath[i];
                switch(file){
                    case"":case".":continue loop;
                    case "..":if(!s.isEmpty())s.pop();continue loop;
                    default:s.push(file);
                }
            }


            for(String st :s){
                res.append("/").append(st);
            }

            return res.length()==0?"/": res.toString();
        }

    public static void main(String[] args) {
        SimplifyPath s = new SimplifyPath();
        System.out.println(s.simplifyPath("/home/"));
    }
}
