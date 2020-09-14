package topics.array;

/*
You are given a square 2D image matrix where each integer represents a pixel.
Write a method transposeMatrix to transform the matrix into its Transpose - in-place.

Example:Input image :
1 0
1 0
Modified to :
1 1
0 0
 */

//fireCode
public class TransposeSquareMatrix {

    public static void transposeMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <= (i - 1); j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

    }

}
