package src.not150;

import java.util.*;

public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return intersection(nums2, nums1);
        }

        Set<Integer> set = new HashSet<>();

        for(int number : nums1){
            set.add(number);
        }

        List<Integer> result = new ArrayList<>();
        for(int number : nums2){
            if(set.contains(number)){
                result.add(number);
                set.remove(number);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
