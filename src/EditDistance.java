package src;

public class EditDistance {

    public int minDistance(String word1, String word2) {

        int[][] table = new int[word1.length() + 1][word2.length() + 1];

        for(int i = 0 ; i < word1.length() + 1; i++){
            table[i][0] = i;
        }

        for(int i = 0 ; i < word2.length() + 1 ; i++){
            table[0][i] = i;
        }

        for(int i = 1 ; i < word1.length() + 1 ; i++){
            for(int j = 1 ; j < word2.length() + 1 ; j++){

                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    table[i][j] = table[i-1][j-1];
                }
                else{
                    table[i][j] = 1 + Math.min(table[i-1][j], Math.min(table[i-1][j-1], table[i][j-1]));
                }

            }
        }


        return table[word1.length()][word2.length()];
    }
}
