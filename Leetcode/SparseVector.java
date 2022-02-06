package Leetcode;
import java.util.*;
 class SparseVector {
//     ArrayList<Pair> arr;
     ArrayList<Pair2> arr;
    SparseVector(int [] nums){
        arr=new ArrayList<>();
        int count=0;
//        for(int i=0;i<nums.length;i++){
//            if(nums[i]==0)count++;
//            else{
//                if(count!=0){
//                    arr.add(new Pair(0,count));
//                    count=0;
//                }
//                arr.add(new Pair(nums[i],1));
//            }
//        }
//        if(count!=0)
//            arr.add(new Pair(0,count));
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0)arr.add(new Pair2(i,nums[i]));

        }
    }
    //return dot product of 2 sparse vectors
     /*
     * 1,0000,2
     * 2,3,00,4
     * */
    public int dotProduct(SparseVector vec){

        ArrayList<Pair2> v1 =this.arr;
        ArrayList<Pair2> v2 =vec.arr;
        int i=0,j=0,ans=0;
        while(j<v2.size() && i<v1.size()){
           if(v1.get(i).idx==v2.get(j).idx){
               ans+=v1.get(i).val* v2.get(j).val;i++;j++;
           }
           else{
               if(v1.get(i).idx<v2.get(j).idx)i++;
               else j++;
           }

        }
//        while(j<v2.size() && i<v1.size()){
//            if(c1==0)c1=v1.get(i).count;
//            if(c2==0)c2=v2.get(j).count;
//            if(c1==c2){
//                ans+=v1.get(i).val*v2.get(j).val;
//                c1=c2=0;
//                i++;j++;
//            }else{
//                if(c1>c2){
//                    c1-=c2;j++;c2=0;
//                }else{
//                    c2-=c1;i++;c1=0;
//                }
//            }
//        }
        return ans;
    }

     public static void main(String[] args) {
        int [] nums1= new int[]{0,1,0,0,2,0,0};
        int[]nums2=new int[]{1,0,0,0,3,0,4};
         SparseVector v1 = new SparseVector(nums1);
         SparseVector v2 = new SparseVector(nums2);
         int ans = v1.dotProduct(v2);
         System.out.println(ans);
     }
//     class Pair{
//        int val;
//        int count;
//        public Pair(int val,int count){
//            this.val=val;
//            this.count=count;
//        }
//     }
     class Pair2{
        int idx;
        int val;
        public Pair2(int idx,int val){
            this.val=val;
            this.idx=idx;
        }
     }
}

