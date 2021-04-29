package topics.array;

/*
According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised
 by the British mathematician John Horton Conway in 1970."

The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1)
or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal)
using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state is created by applying the above rules simultaneously to every cell in the current state,
where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.


Example 1:
Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]

Example 2:
Input: board = [[1,1],[1,0]]
Output: [[1,1],[1,1]]
 */

//leetCode #289
public class GameOfLife {
    public void gameOfLife(int[][] board) {

        int[][] newBoard = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int neighbors = countNeighbors(board, i, j);
                if ((board[i][j] == 1 && neighbors == 2) || neighbors == 3) {
                    newBoard[i][j] = 1;
                }
            }
        }
        copyBoard(board, newBoard);
    }

    public void copyBoard(int[][] oldBoard, int[][] newBoard) {
        for(int i = 0; i < oldBoard.length; i++) {
            for (int j = 0; j < oldBoard[0].length; j++) {
                oldBoard[i][j] = newBoard[i][j];
            }
        }
    }

    public int countNeighbors(int[][] board, int row, int col) {
        int count = 0;

        if (row - 1 >= 0) {
            if (col - 1 >= 0) {
                count += board[row - 1][col - 1];
            }
            count += board[row - 1][col];
            if ((col + 1) < board[0].length) {
                count += board[row - 1][col + 1];
            }
        }

        if (row + 1 < board.length) {
            if (col + 1 < board[0].length) {
                count +=  board[row + 1][col + 1];
            }
            count += board[row + 1][col];
            if (col - 1 >= 0) {
                count += board[row + 1][col - 1];
            }
        }

        if (col - 1 >= 0) {
            count += board[row][col - 1];
        }

        if (col + 1 < board[0].length) {
            count += board[row][col + 1];
        }

        return count;

    }
}
