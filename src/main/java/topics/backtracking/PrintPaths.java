package topics.backtracking;

import java.util.ArrayList;

/*
You're given a 2D board which contains an m x n matrix of chars - char[][] board.
Write a method - printPaths that prints all possible paths from the top left cell to the bottom right cell.
Your method should return an ArrayList of Strings, where each String represents a path with characters appended in
the order of movement. You're only allowed to move down and right on the board. The order of String insertion in
the ArrayList does not matter.

Example:

Input Board :
{
    {A, X},
    {D, E}
}
Output: ["ADE", "AXE"]
 */

//fireCode
public class PrintPaths {

    public ArrayList<String> printPaths(char[][] board){
        ArrayList<String> myList = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();

        return printPathsHelper(board, myList, sb, 0, 0);
    }

    public ArrayList<String> printPathsHelper(char[][] board, ArrayList<String> currentList, StringBuilder sb, int x, int y) {


        if (x <= (board.length - 1) && y <= (board[0].length - 1)) {
            sb.append(board[x][y]);

            if (x == (board.length - 1) && y == board[0].length - 1) {
                currentList.add(sb.toString());
                sb.deleteCharAt(sb.length() - 1);
            } else {
                if (x < (board.length - 1)) {
                    printPathsHelper(board, currentList, sb, x + 1, y);
                }
                if (y < (board[0].length - 1)) {
                    printPathsHelper(board, currentList, sb, x, y + 1);
                }
                sb.deleteCharAt(sb.length() - 1);
            }
        }



        return currentList;
    }

}
