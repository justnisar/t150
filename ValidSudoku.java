import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidSudoku {

    private boolean doDuplicatesExist(List<Character> list){
        Set<Character> set = new HashSet<>();
        for(char ch: list){
                if(set.contains(ch)){
                    return true;
                }
                set.add(ch);
        }
        return false;
    }

    private boolean rowCheck(char[][] board){

        for(int i = 0 ; i < 9 ; i++){
            List<Character> list = new ArrayList<>();
            for(int j = 0 ; j < 9; j++){
                if(board[i][j] != '.'){
                    list.add(board[i][j]);
                }
            }
            if(doDuplicatesExist(list)){
                return false;
            }
        }
        return true;
    }

    private boolean columnCheck(char[][] board){

        for(int i = 0 ; i < 9 ; i++){
            List<Character> list = new ArrayList<>();
            for(int j = 0 ; j < 9; j++){
                if(board[j][i] != '.'){
                    list.add(board[j][i]);
                }
            }
            if(doDuplicatesExist(list)){
                return false;
            }
        }
        return true;
    }

    private boolean boxCheck(char[][] board){

        for(int x = 0 ; x < 3 ; x++){
            for(int y = 0 ; y < 3 ; y++){
                List<Character> list = new ArrayList<>();
                for(int i = 3 * x ; i < 3 * x + 3; i++){
                    for(int j = 3 * y; j < 3 * y + 3; j++){
                        if(board[i][j] != '.'){
                            list.add(board[i][j]);
                        }
                    }
                }

                if(doDuplicatesExist(list)){
                    return false;
                }

            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        return rowCheck(board) && columnCheck(board) && boxCheck(board);
    }

    public static void main(String[] args) {
        char[][] board = {
                {'.', '.', '4', '.', '.', '.', '6', '3', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '9', '.'},
                {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
                {'4', '.', '3', '.', '.', '.', '.', '.', '1'},
                {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
        };
        new ValidSudoku().isValidSudoku(board);

    }


}
