package leetCode;

public class RotateImage {
    public void rotate(int[][] matrix) {
        flipDiagonal(matrix);
        flipHorizontal(matrix);
    }

    public void flipDiagonal(int[][] matrix) {
        int diagonal = matrix[0].length - 1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < diagonal; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - 1 - j][matrix.length - 1 - i];
                matrix[matrix.length - 1 - j][matrix.length - 1 - i] = temp;
            }
            diagonal--;
        }
    }

    public void flipHorizontal(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - 1 - i][j];
                matrix[matrix.length - 1 - i][j] = temp;
            }
        }
    }
}
