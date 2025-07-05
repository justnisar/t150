package src.not150;
/*
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
 */

public class ConstructQuadTree {
/*
    private int allSame(int rowStart, int colStart, int[][] grid, int size){
        int start = grid[rowStart][colStart];
        for(int i = rowStart ; i < rowStart + size ; i++){
            for(int j = colStart ; j < colStart + size ; j++){
                if(grid[i][j] != start){
                    return -1;
                }
            }
        }
        return start == 1 ? 1 : 0;
    }

    public Node construct(int[][] grid) {
        return helper(0, 0, grid.length, grid);
    }

    private Node helper(int rowStart, int colStart, int size, int[][] grid){

        int gridVal = allSame(rowStart, colStart, grid, size);
        Node node = null;

        if(gridVal != -1){
            node = new Node(gridVal == 1 ? true : false, true);
            return node;
        }

        node = new Node();

        node.topLeft = helper(rowStart, colStart, size/2, grid);
        node.topRight = helper(rowStart, colStart + size/2, size/2, grid);
        node.bottomLeft = helper(rowStart + size/2, colStart, size/2, grid);
        node.bottomRight = helper(rowStart + size/2,colStart + size/2, size/2, grid);

        return node;
    }

 */
}
