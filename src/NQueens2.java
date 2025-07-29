package src;

import java.util.Arrays;

public class NQueens2 {

    private int count = 0;

    private void recFun(int row, int n, char[][] board){
        if(row == n){
            count++;
            return;
        }
        // Try to place a queen in every column
        for(int i = 0 ; i < n ; i++){
            if(isSafe(row, i, board)){
                board[row][i] = 'Q';
                recFun(row + 1, n, board);
                board[row][i] = '.';
            }
        }
    }

    private boolean isSafe(int row, int col, char[][] board){
        // check straight up
        for(int i = 0 ; i < row; i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        // check left diagonal
        for(int i = row-1, j = col-1 ; i >= 0 && j >= 0 ; i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        // check right diagonal
        for(int i = row-1,j=col+1 ; i >= 0 && j < board.length ; i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }

    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(board[i], '.');
        }
        recFun(0, n, board);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new NQueens2().totalNQueens(4));
    }
}
