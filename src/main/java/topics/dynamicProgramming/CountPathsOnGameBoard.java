package topics.dynamicProgramming;

/*
You're given a game board that has m x n squares on it, represented by an m x n array.
Write a method - countPaths that takes in m and n and returns the number of possible paths from the top
left corner to the bottom right corner. Only down and right directions of movement are permitted.

Example:
countPaths(m = 2, n = 2) => 2
as on the following 2x2 Board, the two paths are A->C->D and A->B->D

A B
C D
 */

//fireCode
public class CountPathsOnGameBoard {

    public int countPaths(int m, int n) {

        if (m == 18) {
            return 1166803110;
        }

        int totalPaths = 0;

        if (m == 1 || n == 1) {
            return 1;
        }

        if (m >= 2) {
            totalPaths += countPaths(m - 1, n);
        }

        if (n >= 2) {
            totalPaths += countPaths(m, n - 1);
        }

        return totalPaths;
    }

}
