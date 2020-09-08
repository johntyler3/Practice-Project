package topics.hashTable;

import java.util.HashMap;
import java.util.HashSet;

//leetCode #36
public class ValidSoduku {

    public static void main(String[] args) {
        char[][] board  = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
            };

        isValidSudoku(board);
    }

    public static boolean isValidSudoku(char[][] board) {
        HashMap<String, HashSet<Character>> map = new HashMap();

        for (int i = 0; i < board.length; i++) {
            String boardRow = "i" + i;
            map.put(boardRow, new HashSet<>());
            for (int j = 0; j  < board[0].length; j++) {

                String boardCol = "j" + j;
                if (i == 0) {
                    map.put(boardCol, new HashSet<>());
                }

                //if we have entered a new sub-square
                if (i % 3 == 0 && j % 3 == 0) {
                    map.put("ij" + i + j, new HashSet<>());
                }

                //check all three possibilities
                char ch = board[i][j];
                if (ch != '.') {
                    if (!map.get(boardRow).add(ch) ||
                            !map.get(boardCol).add(ch) ||
                            !map.get(getSubSquare(i, j)).add(ch)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private static String getSubSquare(int i, int j) {
        while (i % 3 != 0) {
            i--;
        }
        while (j % 3 != 0) {
            j--;
        }
        return "ij" + i + j;
    }

}
