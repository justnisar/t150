package src;

public class GameOfLife {

    private int getLiveNeighbourCount(int[][] board,int row, int col,int m, int n){
        int[][] directions = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        int liveCount = 0;
        for(int[] direction : directions){
            int newRow = direction[0] + row;
            int newCol = direction[1] + col;
            if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && (board[newRow][newCol] & 1) == 1){
                liveCount++;
            }
        }
        return liveCount;
    }

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        setNewStateInCurrentCell(board, m, n);
        replaceWithNewState(board, m, n);
    }

    private static void replaceWithNewState(int[][] board, int m, int n) {
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = board[i][j] >> 1;
            }
        }
    }

    private void setNewStateInCurrentCell(int[][] board, int m, int n) {
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int currentState = board[i][j] & 1;
                int nextState = 0;
                int liveNeighbourCount = getLiveNeighbourCount(board, i, j, m, n);
                if (currentState == 1) {
                    if (liveNeighbourCount == 2 || liveNeighbourCount == 3) {
                        nextState = 1;
                    }
                }
                else if (liveNeighbourCount == 3) {
                    nextState = 1;
                }
                // set new state
                board[i][j] = board[i][j] | nextState << 1;
            }
        }
    }
}
