package src;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MinimumGeneticMutation {

    private boolean doesDifferByOneChar(String str1, String str2){
        int diffCount = 0;
        for(int i = 0 ; i < 8; i++){
            if(str1.charAt(i) != str2.charAt(i)){
                diffCount++;
            }
            if(diffCount == 2){
                return false;
            }
        }
        return diffCount == 1;
    }

    public int minMutation(String startGene, String endGene, String[] bank) {

        Map<String, Integer> geneNodeMap = new HashMap<>();
        int i = 1 ;
        geneNodeMap.put(startGene, 0);
        for(String gene : bank){
            geneNodeMap.put(gene, i);
            i++;
        }
        geneNodeMap.put(endGene, i);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        return 0;
    }
}
