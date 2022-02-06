package Leetcode;
import java.util.*;

class RandomizedCollection {
    HashMap<Integer,HashSet<Integer>> map;
    ArrayList<Integer> array;
    Random random;
    public RandomizedCollection() {
        map = new HashMap<>();
        array= new ArrayList<>();
        random = new Random();

    }

    public boolean insert(int val) {
        boolean contains = map.containsKey(val);

        HashSet<Integer> set = map.getOrDefault(val,new HashSet());
        set.add(array.size());
        array.add(val);
        map.put(val,set);

        return !contains;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val))return false;

        HashSet<Integer> set = map.get(val);

        int idx=0 ;
        for(int i :set){
            idx=i;break;
        }


        int n=array.size()-1;

        int temp = array.get(n);

        if(temp==val){
            array.remove(n);
            set.remove(n);
        }
        else {
            array.set(idx, temp);
            array.remove(n);

            HashSet<Integer> tempSet = map.get(temp);
            tempSet.remove(n);
            tempSet.add(idx);

            map.put(temp, tempSet);
            set.remove(idx);
        }
        if(set.size()<1)map.remove(val);
        else{

            map.put(val,set);
        }

        return true;

    }

    public int getRandom() {
        return array.get(random.nextInt(array.size()));
    }

    public static void main(String[] args) {
        RandomizedCollection r=new RandomizedCollection();
        r.insert(1);
        r.insert(1);
        r.insert(2);
        r.insert(1);
        r.insert(2);
        r.insert(2);
        r.remove(1);
        r.remove(2);
        r.remove(2);
        System.out.println(r.remove(2));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
