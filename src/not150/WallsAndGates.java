package src.not150;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {

    private Queue<int[]> getQueue(int[][] rooms){
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0 ; i < rooms.length ; i++){
            for(int j = 0 ; j < rooms[0].length ; j++){
                if(rooms[i][j] == 0){
                    queue.add(new int[]{i,j});
                }
            }
        }
        return queue;
    }

    public void wallsAndGates(int[][] rooms) {

        Queue<int[]> queue = getQueue(rooms);
        int rows = rooms.length;
        int cols = rooms[0].length;
        int[][] directions = {{-1,0},{0,-1},{0,1},{1,0}};
        while(!queue.isEmpty()){

            int[] current = queue.remove();
            int currentX = current[0];
            int currentY = current[1];
            for(int[] direction : directions){
                int nextX = currentX + direction[0];
                int nextY = currentY + direction[1];

                if(nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols && rooms[nextX][nextY] != -1){
                    rooms[nextX][nextY] = rooms[currentX][currentY] + 1;
                    queue.add(new int[]{nextX,nextY});
                }

            }

        }

    }

}
