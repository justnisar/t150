package src;

public class SurroundedRegions {

    private void dfs(char[][] board, int rows, int cols, int x, int y){
        int[][] directions = {{-1,0}, {1,0}, {0,1}, {0,-1}};
        board[x][y] = 'T';
        for(int[] direction: directions){
            int newX = x + direction[0];
            int newY = y + direction[1];
            if(newX >= 0 && newX < rows && newY >= 0 && newY < cols && board[newX][newY] == 'O'){
                dfs(board, rows, cols, newX, newY);
            }
        }
    }

    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        markBorders(board, rows, cols);
        remarkCells(board, rows, cols);
    }

    private void remarkCells(char[][] board, int rows, int cols){
        for(int i = 0 ; i < rows; i++){
            for(int j = 0 ; j < cols; j++){
                if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }
                else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void markBorders(char[][] board, int rows, int cols) {
        // perform dfs only for border cells
        for(int i = 0 ; i < rows; i++){
            for(int j = 0 ; j < cols; j++){
                if((i == 0 || j == 0 || i == rows - 1 || j == cols - 1) && board[i][j] == 'O'){
                    dfs(board, rows, cols, i , j);
                }
            }
        }
    }

}
