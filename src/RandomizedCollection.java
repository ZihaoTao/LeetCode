import java.util.*;

class RandomizedCollection {
    Map<Integer, List<Integer>> map;
    List<Integer> list;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean res = false;
        if(!map.containsKey(val)) {
            res = true;
            map.put(val, new ArrayList<Integer>());
        }
        map.get(val).add(list.size());
        list.add(val);
        return res;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        List<Integer> indices = map.get(val);
        int count = 1;
        for(int index : indices) {
            if(index < list.size() - count++) {
                int n = list.get(list.size() - 1);
                List<Integer> nList = map.get(n);
                for (int i = nList.size() - 1; i >= 0; i--) {
                    if (nList.get(i) == list.size() - 1) {
                        nList.remove(i);
                    }
                }
                nList.add(index);
            }
            list.remove(list.size() - 1);
        }
        map.remove(val);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        Random random = new Random();
        return list.get(random.nextInt() * list.size());
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */