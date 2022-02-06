package Leetcode;
import java.util.*;

class LRUCache {

    HashMap<Integer,Integer> map;
    Stack<Integer> stack;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        map = new HashMap<>();
        stack= new Stack();

    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        int value = map.get(key);
        stack.push(value);
        return value;
    }

    public void put(int key, int value) {
        if(!map.containsKey(key) && capacity==map.size()){
            int removed= stack.pop();
            while(!map.containsKey(removed))removed= stack.pop();
            //  System.out.println(removed);
            map.remove(removed);
        }

        map.put(key,value);
        stack.push(key);
    }

    public static void main(String[] args) {
         LRUCache obj = new LRUCache(2);

     obj.put(1,1);
     obj.put(2,2);
        System.out.println(obj.get(1));
        obj.put(3,3);
        System.out.println(obj.get(2));
        obj.put(4,4);
        System.out.println(obj.get(1));
        System.out.println(obj.get(3));
        System.out.println(obj.get(4));
    }
}
