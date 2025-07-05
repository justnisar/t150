package src;

import java.util.*;

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


        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);

        Set<String> visited = new HashSet<>();
        visited.add(startGene);

        int level = 0;

        while(!queue.isEmpty()){

            int levelSize = queue.size();

            for(int i = 0 ; i < levelSize ; i++){
                String current = queue.remove();
                if(current.equals(endGene)){
                    return level;
                }

                for(String node : bank){
                    if(!visited.contains(node) && doesDifferByOneChar(current, node)){
                        visited.add(node);
                        queue.add(node);
                    }
                }

            }
            level++;

        }

        return -1;
    }
}
