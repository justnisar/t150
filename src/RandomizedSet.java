package src;

import java.util.*;

public class RandomizedSet {

    private Random random;
    private List<Integer> list;
    private Map<Integer, Integer> map;

    public RandomizedSet() {
        random = new Random();
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        if(!map.containsKey(val)){
            // insert
            map.put(val, map.size());
            list.addLast(val);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        // remove
        int lastElement = list.get(list.size() - 1);
        int idx = map.get(val);
        list.set(idx, lastElement);
        map.put(lastElement, idx);
        // delete the last element
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(map.size());
        return list.get(randomIndex);
    }
}
