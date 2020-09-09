package topics.dynamicProgramming;

//leetCode #
public class PerfectSquares {

    public static void main(String[] args) {
        System.out.println(numSquares(10));
    }

    //Originally set record[i] to i
    //At each step i, we cache the most efficient way to make i
    //When we take another step i + 1, we check the most efficient way to make i + 1  using cached values

    public static int numSquares(int n) {
        int[] record = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            record[i] = i;

            // To get the value of record[n], we should choose the min
            // value from:
            //     record[n - 1] + 1,
            //     record[n - 4] + 1,
            //     record[n - 9] + 1,
            //     record[n - 16] + 1
            //     and so on...
            for (int j = 1; j*j <= i; j++) {
                int diff = i - (j * j);
                int previousSquare = record[diff] + 1;
                int currentBest = record[i];

                record[i] = Math.min(previousSquare, currentBest);
            }
        }

        return record[n];
    }
}
