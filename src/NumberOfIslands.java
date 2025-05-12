package src;

public class NumberOfIslands {

    private void recFun(char[][] grid, boolean[][] visited, int i, int j,int rowCount, int columnCount){
        visited[i][j] = true;
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int[] direction : directions){
            int nextI = i + direction[0];
            int nextJ = j + direction[1];
            if(nextI >= 0 && nextI < rowCount && nextJ >= 0 && nextJ < columnCount && grid[nextI][nextJ] == '1' && !visited[nextI][nextJ]){
                recFun(grid, visited, nextI, nextJ, rowCount, columnCount);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int rowCount = grid.length;
        int columnCount = grid[0].length;
        boolean[][] visited = new boolean[rowCount][columnCount];
        int islandCount = 0;
        for(int i = 0; i < rowCount ; i++){
            for(int j = 0; j < columnCount ; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    islandCount++;
                    recFun(grid, visited, i , j, rowCount, columnCount);
                }
            }
        }
        return islandCount;
    }

}
