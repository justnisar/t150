package src;

public class WordSearch {

    private boolean recFun(char[][] board, String word, int x, int y, int wordPos, boolean[][] visited){

        if (word.charAt(wordPos) != board[x][y]){
            return false;
        }

        if(wordPos == word.length() - 1) {
            return true;
        }

        visited[x][y] = true;

        int[][] directions = {{-1,0}, {0,1}, {1,0}, {0,-1}};
        boolean result = false;

        for(int[] direction : directions){
            int newX = x + direction[0];
            int newY = y + direction[1];
            // Make sure new point is within the grid and not visited
            if(newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length && !visited[newX][newY]){
                result = result || recFun(board, word, newX, newY, wordPos + 1, visited);
            }
        }
        visited[x][y] = false;
        return result;
    }

    public boolean exist(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0 ; i < board.length; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                if(recFun(board, word, i , j, 0, visited)){
                    return true;
                }
            }
        }
        return false;
    }

}
