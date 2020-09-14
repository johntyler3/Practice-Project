package topics.array;

/*
You are given an m x n 2D image matrix where each integer represents a pixel.
Flip it in-place along its horizontal axis.
 */

//fireCode
public class HorizontalFlip {

    public static void flipHorizontalAxis(int[][] matrix) {

        for (int row = 0; row < (matrix.length / 2); row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[(matrix.length - 1) - row][col];
                matrix[(matrix.length - 1) - row][col] = temp;
            }
        }

    }

}
