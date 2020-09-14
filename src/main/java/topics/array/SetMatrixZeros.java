package topics.array;

import java.util.Arrays;

//leetCode #73
public class SetMatrixZeros {

    public static void main(String[] args) {
        int[][] array = {{1, 0}};
        setZeroes(array);
        System.out.println(Arrays.deepToString(array));
    }

    /*
    -   A simple solution to this problem is to create a duplicate matrix and set the row/col to zero there, then do an overwrite
    -   This solution would take O(N^2) time and O(N) space

    -   A more space efficient solution uses the first row and first column as marker columns which can later be traversed to set values
    -   firstRow and firstColumn booleans are used to determine if the entire first row or column should be zeros
     */

    public static void setZeroes(int[][] matrix) {
        boolean firstRow = false;
        boolean firstColumn = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        firstRow = true;
                    }
                    if (j == 0) {
                        firstColumn = true;
                    }

                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstRow) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        if (firstColumn) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

}
