package topics.search;

//leetCode #200
public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        char[][] grid2 = {
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}
        };

        System.out.println(numIslands(grid2));
    }

    public static int numIslands(char[][] grid) {
        int islandCount = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    checkLand(grid, i, j);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    private static void checkLand(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j <  0 || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }

        //Mark land as visited
        grid[i][j] = '0';

        checkLand(grid, i - 1, j);
        checkLand(grid, i + 1, j);
        checkLand(grid, i, j - 1);
        checkLand(grid, i, j + 1);
    }

}
