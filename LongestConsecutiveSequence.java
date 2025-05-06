import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        int longestSequence = 0;
        for(int num : nums){
            if(!set.contains(num - 1)) {
                int currentSequence = 1;
                while(set.contains(num + 1)) {
                    currentSequence++;
                    num++;
                }
                longestSequence = Math.max(longestSequence, currentSequence);
            }
        }
        return longestSequence;
    }
}
