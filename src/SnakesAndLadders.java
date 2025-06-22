package src;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders {

    private int[] flatten2DTo1D(int[][] board){
        // Iterate through the board from the bottom row upwards.
        int n = board.length;
        boolean leftToRight = true;
        int[] flatBoard = new int[n*n + 1];
        int squareNum = 1;
        for (int row = n - 1; row >= 0; row--) {
            if (leftToRight) {
                // For rows moving left-to-right.
                for (int col = 0; col < n; col++) {
                    flatBoard[squareNum++] = board[row][col];
                }
            } else {
                // For rows moving right-to-left.
                for (int col = n - 1; col >= 0; col--) {
                    flatBoard[squareNum++] = board[row][col];
                }
            }
            // Flip the direction for the next row up.
            leftToRight = !leftToRight;
        }
        return flatBoard;
    }

    public int snakesAndLadders(int[][] board) {
        int[] flatBoard = flatten2DTo1D(board);
        int moves = 0;
        int target = board.length * board.length;
        boolean[] visited = new boolean[target + 1];
        Queue<Integer> queue = new LinkedList<>();
        visited[1] = true;
        queue.add(1);
        while(!queue.isEmpty()){
            int nodesAtLevel = queue.size();
            // Do this for all nodes at this level
            while(nodesAtLevel-- > 0){

                int current = queue.remove();
                if(current == target){
                    return moves;
                }
                // Roll die from 1 to 6
                for(int i = 1 ; i <= 6 ; i++){
                    int next = current + i;
                    if(next > target){
                        break;
                    }
                    int landingNode = flatBoard[next] == -1 ? next  : flatBoard[next];
                    if(!visited[landingNode]){
                        visited[landingNode] = true;
                        queue.add(landingNode);
                    }
                }

            }
            moves++;

        }
        return -1;
    }
}
