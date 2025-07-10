package src.not150;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class FirstUnique {

    private LinkedHashSet<Integer> linkedSet;
    private Set<Integer> repeatedSet;

    public FirstUnique(int[] nums) {
        repeatedSet = new HashSet<>();
        linkedSet = new LinkedHashSet<>();
        for(int num : nums){
            add(num);
        }
    }

    public int showFirstUnique() {
        if(linkedSet.size() == 0){
            return -1;
        }
        return linkedSet.getFirst();
    }

    public void add(int value) {
        if(repeatedSet.contains(value)){
            return;
        }
        if(linkedSet.contains(value)){
            linkedSet.remove(value);
            repeatedSet.add(value);
        }
        else{
            linkedSet.add(value);
        }
    }
}
