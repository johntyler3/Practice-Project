package topics.array;

/*
You are given an m x n 2D image matrix where each integer represents a pixel.
Flip it in-place along its vertical axis.
 */

//fireCode
public class VerticalFlip {

    public static void flipItVerticalAxis(int[][] matrix) {

        int halfWidth = matrix[0].length / 2;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < halfWidth; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[row][(matrix[0].length - 1) - col];
                matrix[row][(matrix[0].length - 1) - col] = temp;
            }
        }

    }

}
