package src;

public class RotateImage {

    public void transpose(int[][] matrix){
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = i + 1 ; j < matrix[0].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private void flip(int[][] matrix){
        for(int i = 0 ; i < matrix.length ;i++){
            int j = 0, k = matrix[0].length - 1;
            while(j < k){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
                j++;
                k--;
            }
        }
    }

    public void rotate(int[][] matrix) {
        transpose(matrix);
        flip(matrix);
    }
}
