package topics.array;

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
