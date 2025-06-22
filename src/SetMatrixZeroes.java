package src;

public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }

            }
        }

        for(int i = 0 ; i < matrix.length; i++){
            for(int j = 0 ;j < matrix[0].length; j++){

                if(matrix[i][j] == 0){

                    for(int k = 0 ; k < matrix[0].length; k++){
                        matrix[i][k] = 0;
                    }
                    for(int k = 0; k < matrix.length ; i++){
                        matrix[k][j] = 0;
                    }

                }

            }
        }

    }
}
